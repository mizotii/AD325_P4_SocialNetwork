import java.util.ArrayList;

public class Profile {
    private String name;
    private String avatar;
    private String status;
    private ArrayList<Profile> friendList;

    Profile(String name, String pictureFileName, String status) {
        this.name = name;
        this.avatar = pictureFileName;
        this.status = status;
        this.friendList = new ArrayList<>();
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addFriend(Profile friend) {
        friendList.add(friend);
    }

    public void removeFriend(Profile friend) {
        friendList.remove(friend);
    }

    public ArrayList<Profile> getFriends() {
        return friendList;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Picture: " + avatar);
        System.out.println("Status: " + status);
        System.out.println();
        System.out.println("Friends: ");
        for (Profile friend : friendList) {
            System.out.println(friend.getUsername());
        }
    }
}
