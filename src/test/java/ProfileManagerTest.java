import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProfileManagerTest {
    ProfileManager m;

    @Test
    void addProfile() {
        m = new ProfileManager();
        assertTrue(m.addProfile(new Profile("turtle", "turtle.png", "Online")));
    }

    @Test
    void removeProfile() {
        m = new ProfileManager();
        Profile p = new Profile("turtle", "turtle.png", "Online");
        m.addProfile(p);
        assertTrue(m.removeProfile(p));
    }

    @Test
    void addFriendship() {
        m = new ProfileManager();
        Profile p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        m.addProfile(p);
        m.addProfile(p2);
        assertTrue(m.addFriendship(p, p2));
    }

    @Test
    void displayProfiles() {
        m = new ProfileManager();
    }

    @Test
    void displayProfilesAndFriends() {
        m = new ProfileManager();
    }
}