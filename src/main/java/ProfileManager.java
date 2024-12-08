import ADTPackage.LinkedListWithIterator;
import ADTPackage.LinkedQueue;
import ADTPackage.ListWithIteratorInterface;
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
     */
    public void addProfile(Profile user) {
        network.addVertex(user);
    }

    /**
     * Removes a user from the network. If other users
     * had that user added as a friend, also removes the original
     * user from the friends lists of the other users.
     * @param user The user being removed from the network.
     */
    public void removeProfile(Profile user) {
        network.removeVertex(user);
    }

    /**
     * Adds a user to another user's friend list.
     * @param user The original user.
     * @param friend The user being added to the original user's friend list.
     * @return True if the friend was successfully added to the user's
     * friend list. False if either user doesn't exist.
     */
    public boolean addFriendship(Profile user, Profile friend) {
        return network.addEdge(user, friend);
    }

    /**
     * Displays every profile in the network.
     */
    public void displayProfiles() {
        ListWithIteratorInterface<Profile> profiles = getProfiles();
        for (Profile p : profiles) {
            p.display();
        }
    }

    public void displayProfilesAndFriends(Profile user) {
        ListWithIteratorInterface<Profile> profiles = getProfiles();
    }

    private ListWithIteratorInterface<Profile> getProfiles() {
        return network.getVertexLabels();
    }
}
