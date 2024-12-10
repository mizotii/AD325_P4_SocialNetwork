import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProfileManager network = setUpNetwork();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        Profile user = new Profile(username, "src/avatars/U.png", "Online");
        Profile currentUser = user;
        System.out.println("Select an action: \nModify Profile: m \nView All Profiles: v " +
                "\nAdd Friend: af \nView Friend List: vfl \nView Friend's Friend List: vffl " +
                "\nDelete Profile: d \nAdd Profile: a \nSwitch Current User: s \nEnd Session: end");
        while (true) {
            String action = sc.nextLine();
            if (action.equals("m")) {modify(currentUser);}
            else if (action.equals("v")) {viewAll();}
            else if (action.equals("af")) {addFriend(currentUser);}
            else if (action.equals("vfl")) {viewFriendList(currentUser);}
            else if (action.equals("vffl")) {viewFriendsFriendList(user);}
            else if (action.equals("d")) {deleteProfile(network);}
            else if (action.equals("a")) {addProfile(network);}
            else if (action.equals("s")) {switchUser(network);}
            else if (action.equals("end")) {break;}
            else {
                System.out.println("Invalid action");
            }
        }
    }

    public static ProfileManager setUpNetwork() {
        ProfileManager network = new ProfileManager();
        Profile ejnorman = new Profile("ejnorman", "src/avatars/E.png", "Online");
        Profile mztii = new Profile("mztii", "src/avatars/M.png", "Online");
        Profile seiyaroo = new Profile("seiyaroo", "src/avatars/S.png", "Online");
        Profile pbriant = new Profile("pbriant", "src/avatars/P.png", "Online");
        network.addProfile(ejnorman);
        network.addProfile(mztii);
        network.addProfile(seiyaroo);
        network.addProfile(pbriant);
        ejnorman.addFriend(mztii);
        seiyaroo.addFriend(pbriant);
        ejnorman.addFriend(seiyaroo);
        seiyaroo.addFriend(mztii);
        return network;
    }
}
