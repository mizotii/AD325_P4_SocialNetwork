// Joel Yang: created all unit tests for this class unless marked otherwise.

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Profile p2 = new Profile("goose", "goose.png", "Online");
        Profile p3 = new Profile("DOG", "DOG.png", "Online");
        m.addProfile(p);
        m.addProfile(p2);
        m.addProfile(p3);
        m.addFriendship(p, p2);
        m.addFriendship(p2, p3);
        m.addFriendship(p, p3);
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
        Profile p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        m.addProfile(p);
        m.addProfile(p2);
        m.addFriendship(p, p2);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        m.displayProfiles();
        assertEquals(out.toString(),
                "Name: goose\r\n" +
                "Avatar: goose.png\r\n" +
                "Status: Online\r\n" +
                "Friends: \r\n" +
                "turtle \r\n" +
                "Name: turtle\r\nAvatar: turtle.png\r\nStatus: Online\r\nFriends: \r\ngoose \r\n");
        System.setOut(originalOut);
    }

    @Test
    void displayProfilesAndFriends() {
        m = new ProfileManager();
        Profile p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        m.addProfile(p);
        m.addProfile(p2);
        m.addFriendship(p, p2);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        m.displayProfilesAndFriends(p2);
        assertEquals(out.toString(),
                "Name: goose\r\n" +
                        "Avatar: goose.png\r\n" +
                        "Status: Online\r\n" +
                        "Friends: \r\n" +
                        "turtle \r\n" +
                        "Name: turtle\r\nAvatar: turtle.png\r\nStatus: Online\r\nFriends: \r\ngoose \r\n");
        System.setOut(originalOut);
    }

    //Eric Norman tested the two below methods
    @Test
    void containsProfile() {
        m = new ProfileManager();
        Profile p = new Profile("turtle", "turtle.png", "Online");
        m.addProfile(p);
        assertTrue(m.containsProfile("turtle"));
    }

    @Test
    void retrieveProfile() {
        m = new ProfileManager();
        Profile p = new Profile("turtle", "turtle.png", "Online");
        m.addProfile(p);
        assertEquals(p, m.retrieveProfile("turtle"));
    }
}
