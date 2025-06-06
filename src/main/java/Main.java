import ADTPackage.ListWithIteratorInterface;

import java.util.ArrayList;
import java.util.Scanner;

// Joel Yang: created the UML diagram
//Eric Norman did the entirety of this class

public class Main {
    public static void main(String[] args) {
        //set up existing network
        ProfileManager network = setUpNetwork();
        Scanner sc = new Scanner(System.in);
        //get new user information
        String username, avatar;
        while (true) {
            System.out.println("Enter your username: ");
            username = sc.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty");
            }
            else if (network.containsProfile(username)) {
                System.out.println("Username is already in use");
            }
            else {
                break;
            }
        }
        //I could have, and probably should have, extracted these while loops into their own methods
        while (true) {
            System.out.println("Choose an element: \nEarth: earth \nWind: wind \nFire: fire \nWater: water");
            String input = sc.nextLine();
            if (!input.equals("earth") && !input.equals("wind") && !input.equals("fire") && !input.equals("water")) {
                System.out.println("Invalid input");
            }
            else {
                avatar = "src/avatars/" + input + ".png";
                break;
            }
        }
        Profile user = new Profile(username, avatar, "Online");
        network.addProfile(user);
        Profile currentUser = user; //keep track of current user

        String actionList = "Select an action: \nModify Current Profile: m \nView All Profiles: v " +
                "\nAdd Friend: af \nView Friend List: vfl \nView Friend's Friend List: vffl " +
                "\nDelete Profile: d \nAdd Profile: a \nSwitch Current User: s \nEnd Session: end";
        System.out.println(actionList);
        //menu (could have been a switch statement, but I don't want to mess with it)
        while (true) {
            String action = sc.nextLine();
            if (action.equals("m")) {
                currentUser = modify(currentUser, network, sc);
            } else if (action.equals("v")) {
                viewAll(network);
            } else if (action.equals("af")) {
                network = addFriend(currentUser, network, sc);
            } else if (action.equals("vfl")) {
                viewFriendList(currentUser);
            } else if (action.equals("vffl")) {
                viewFriendsFriendList(user, network, sc);
            } else if (action.equals("d")) {
                network = deleteProfile(currentUser, network, sc);
            } else if (action.equals("a")) {
                network = addProfile(network, sc);
            } else if (action.equals("s")) {
                currentUser = switchUser(currentUser, network, sc);
            } else if (action.equals("end")) {
                break;
            } else if (action.equals("c")) {
                System.out.println(actionList);
            } else {
                System.out.println("Invalid action");
            }
            if (!action.equals("c")) {
                System.out.println("\nSelect a new action: (type 'c' to pull up actions list)");
            }
        }
    }

    //Create initial network
    public static ProfileManager setUpNetwork() {
        ProfileManager network = new ProfileManager();
        Profile ejnorman = new Profile("ejnorman", "src/avatars/earth.png", "Online");
        Profile mztii = new Profile("mztii", "src/avatars/water.png", "Online");
        Profile seiyaroo = new Profile("seiyaroo", "src/avatars/wind.png", "Online");
        Profile pbriant = new Profile("pbriant", "src/avatars/fire.png", "Online");
        network.addProfile(ejnorman);
        network.addProfile(mztii);
        network.addProfile(seiyaroo);
        network.addProfile(pbriant);
        network.addFriendship(mztii, ejnorman);
        network.addFriendship(seiyaroo, ejnorman);
        network.addFriendship(mztii, seiyaroo);
        network.addFriendship(seiyaroo, pbriant);
        return network;
    }

    //modify a user profile
    public static Profile modify(Profile user, ProfileManager network, Scanner sc) {
        while (true) {
            System.out.println("Modify: \nUsername: u \nAvatar: a \nStatus: s \nExit: e");
            String action = sc.nextLine();
            if (action.equals("u")) {
                while (true) {
                    System.out.println("Enter new username: ");
                    String newUsername = sc.nextLine();
                    if (network.containsProfile(newUsername)) {
                        System.out.println("Username is taken");
                    }
                    else if (newUsername.isEmpty()) {
                        System.out.println("Username cannot be empty");
                    }
                    else {
                        user.setUsername(newUsername);
                        break;
                    }
                }
            }
            else if (action.equals("a")) {
                while (true) {
                    System.out.println("Choose an element: \nEarth: earth \nWind: wind \nFire: fire \nWater: water");
                    String input = sc.nextLine();
                    if (!input.equals("earth") && !input.equals("wind") && !input.equals("fire") && !input.equals("water")) {
                        System.out.println("Invalid input");
                    }
                    else {
                        user.setAvatar("src/avatars/" + input + ".png");
                        break;
                    }
                }
            }
            else if (action.equals("s")) {
                System.out.println("Change status: \nOnline: online \nAway: away " +
                        "\nBusy: busy \nOffline: offline");
                user.setStatus(sc.nextLine());
            }
            else if (action.equals("e")) {
                break;
            }
            else {
                System.out.println("Invalid action");
            }
        }
        return user;
    }

    //view all profiles in the network
    public static void viewAll(ProfileManager network) {
        network.displayProfiles();
    }

    //add a friend to current user
    public static ProfileManager addFriend(Profile user, ProfileManager network, Scanner sc) {
        System.out.println("Add a friend ");
        System.out.println("Friend username: ");
        String friendUsername = sc.nextLine();
        if (network.containsProfile(friendUsername)) {
            Profile friend = network.retrieveProfile(friendUsername);
            network.addFriendship(user, friend);
        } else {
                System.out.println("User not found");
        }
        return network;
    }

    //view your friends list
    public static void viewFriendList(Profile user) {
        ArrayList<Profile> friends = user.getFriends();
        System.out.println(user.getUsername() + " friends list:");
        for (Profile friend : friends) {
            System.out.println(friend.getUsername() + ": " + friend.getStatus());
        }
    }

    //view your friends friend list (if you have any)
    public static void viewFriendsFriendList(Profile user, ProfileManager network, Scanner sc) {
        ArrayList<Profile> friends = user.getFriends();
        System.out.println("Enter your friend's name: ");
        String friendName = sc.nextLine();
        if (!network.containsProfile(friendName)) {
            System.out.println("User not found");
            return;
        }
        for (Profile friend : friends) {
            if (friend.getUsername().equals(friendName)) {
                viewFriendList(friend);
                return;
            }
        }
        System.out.println("User is not your friend");
    }

    //delete profile from network
    public static ProfileManager deleteProfile(Profile user, ProfileManager network, Scanner sc) {
        System.out.println("Username of profile to be deleted: ");
        String profileName = sc.nextLine();
        if (profileName.equals(user.getUsername())) {
            System.out.println("You cannot delete the current user");
        }
        else if (!network.containsProfile(profileName)) {
            System.out.println("User not found");
        }
        else {
            Profile deleted = network.retrieveProfile(profileName);
            network.removeProfile(deleted);
        }
        return network;
    }

    //add profile to the network
    public static ProfileManager addProfile(ProfileManager network, Scanner sc) {
        System.out.println("New profile ");
        String profileName, avatar;
        while (true) {
            System.out.println("Username: ");
            profileName = sc.nextLine();
            if (network.containsProfile(profileName)) {
                System.out.println("Username already exists");
            }
            else if (profileName.isEmpty()) {
                System.out.println("Username cannot be empty ");
            }
            else {
                while (true) {
                    System.out.println("Choose an element: \nEarth: earth \nWind: wind \nFire: fire \nWater: water");
                    String input = sc.nextLine();
                    if (!input.equals("earth") && !input.equals("wind") && !input.equals("fire") && !input.equals("water")) {
                        System.out.println("Invalid input");
                    }
                    else {
                        avatar = "src/avatars/" + input + ".png";
                        break;
                    }
                }
                break;
            }
        }
        Profile newUser = new Profile(profileName, "src/avatars/" + avatar + ".png", "Online");
        network.addProfile(newUser);
        return network;
    }

    //switch to another user in the network (or even yourself I guess)
    public static Profile switchUser(Profile user, ProfileManager network, Scanner sc) {
        System.out.println("What user would you like to switch to? ");
        String profileName = sc.nextLine();
        if (network.containsProfile(profileName)) {
            return network.retrieveProfile(profileName);
        }
        else {
            System.out.println("User not found");
        }
        return user;
    }
}
