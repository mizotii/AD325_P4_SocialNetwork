import ADTPackage.LinkedListWithIterator;
import ADTPackage.LinkedQueue;
import ADTPackage.ListWithIteratorInterface;
import ADTPackage.QueueInterface;
import GraphPackage.UndirectedGraph;

import java.util.LinkedList;

public class ProfileManager {
    private UndirectedGraph<Profile> network;

    public ProfileManager() {
        network = new UndirectedGraph<>();
    }

    /**
     * Adds a profile to the network.
     * @param user The user being added to the network.
     * @return True if user was successfully added, false otherwise
     */
    public boolean addProfile(Profile user) {
        return network.addVertex(user);
    }

    /**
     * Removes a user from the network. If other users
     * had that user added as a friend, also removes the original
     * user from the friends lists of the other users.
     * @param user The user being removed from the network.
     * @return True if user was successfully removed, false otherwise
     */
    public boolean removeProfile(Profile user) {
        return network.removeVertex(user);
    }

    /**
     * Adds a user to another user's friend list.
     * @param user The original user.
     * @param friend The user being added to the original user's friend list.
     * @return True if the friend was successfully added to the user's
     * friend list. False if either user doesn't exist.
     */
    public boolean addFriendship(Profile user, Profile friend) {
        user.addFriend(friend);
        friend.addFriend(user);
        return network.addEdge(user, friend);
    }

    /**
     * Displays every profile in the network.
     */
    public void displayProfiles() {
        ListWithIteratorInterface<Profile> profiles = network.getVertexLabels();
        for (Profile p : profiles) {
            p.display();
        }
    }

    /**
     * Displays every profile in the network of the current user.
     * @param currentUser The user being operated on in the menu
     */
    public void displayProfilesAndFriends(Profile currentUser) {
        QueueInterface<Profile> queue = network.getBreadthFirstTraversal(currentUser);
        while (!queue.isEmpty()) {
            queue.dequeue().display();
        }
    }
}