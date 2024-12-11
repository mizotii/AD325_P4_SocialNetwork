// Joel Yang: created all unit tests for this class.

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    Profile p;

    @Test
    void getUsername() {
        p = new Profile("turtle", "turtle.png", "Online");
        assertEquals(p.getUsername(), "turtle");
    }

    @Test
    void setUsername() {
        p = new Profile("turtle", "turtle.png", "Online");
        p.setUsername("matcha");
        assertEquals(p.getUsername(), "matcha");
    }

    @Test
    void getAvatar() {
        p = new Profile("turtle", "turtle.png", "Online");
        assertEquals(p.getAvatar(), "turtle.png");
    }

    @Test
    void setAvatar() {
        p = new Profile("turtle", "turtle.png", "Online");
        p.setAvatar("matcha.png");
        assertEquals(p.getAvatar(), "matcha.png");
    }

    @Test
    void getStatus() {
        p = new Profile("turtle", "turtle.png", "Online");
        assertEquals(p.getStatus(), "Online");
    }

    @Test
    void setStatus() {
        p = new Profile("turtle", "turtle.png", "Online");
        p.setStatus("Offline");
        assertEquals(p.getStatus(), "Offline");
    }

    @Test
    void addFriend() {
        p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        p.addFriend(p2);
        assertEquals(p.getFriends().get(0), p2);
    }

    @Test
    void removeFriend() {
        p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        p.addFriend(p2);
        p.removeFriend(p2);
        assertTrue(p.getFriends().isEmpty());
    }

    @Test
    void getFriends() {
        p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        p.addFriend(p2);
        assertEquals(p.getFriends().get(0), p2);
    }

    @Test
    void display() {
        p = new Profile("turtle", "turtle.png", "Online");
        Profile p2 = new Profile("goose", "goose.png", "Online");
        p.addFriend(p2);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        p.display();
        assertEquals(out.toString(), "Name: turtle\r\nAvatar: turtle.png\r\nStatus: Online\r\nFriends: \r\ngoose \r\n");
        System.setOut(originalOut);
    }
}
