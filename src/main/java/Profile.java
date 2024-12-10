import java.util.ArrayList;

public class Profile {
    private String name;
    private String avatar;
    private String status;
    private ArrayList<Profile> friendList;

    /**
     * Create a profile with name, avatar, status and friends list
     * @param name of profile
     * @param pictureFileName file name of avatar
     * @param status status of user (online, offline, busy, away)
     */
    Profile(String name, String pictureFileName, String status) {
        this.name = name;
        this.avatar = pictureFileName;
        this.status = status;
        this.friendList = new ArrayList<>();
    }

    /**
     * Get the username of the profile
     * @return username of profile
     */
    public String getUsername() {
        return name;
    }

    /**
     * Set new username of profile
     * @param name new username
     */
    public void setUsername(String name) {
        this.name = name;
    }

    /**
     * Get file name of avatar
     * @return file name of avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Set new avatar with file name
     * @param avatar file name of new avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Get current status of profile
     * @return status of profile
     */
    public String getStatus() {
        return status;
    }

    /**
     * Change the status of the profile
     * @param status new status of profile
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Add friend to friend list of profile
     * @param friend profile of friend
     */
    public void addFriend(Profile friend) {
        friendList.add(friend);
    }

    /**
     * Remove friend from friend list of profile
     * @param friend friend of profile
     */
    public void removeFriend(Profile friend) {
        friendList.remove(friend);
    }

    /**
     * Get the list of friends of profile
     * @return ArrayList of friends' profiles
     */
    public ArrayList<Profile> getFriends() {
        return friendList;
    }

    /**
     * Display name, avatar, status and all friends on friend list of profile
     */
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Avatar: " + avatar);
        System.out.println("Status: " + status);
        System.out.println();
        System.out.println("Friends: ");
        for (Profile friend : friendList) {
            System.out.println(friend.getUsername());
        }
    }
}
