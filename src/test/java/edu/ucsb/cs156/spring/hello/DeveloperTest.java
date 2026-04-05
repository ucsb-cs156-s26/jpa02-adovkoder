package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {

        assertEquals("Wilson", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubId_returns_correct_githubId() {

        assertEquals("adovkoder", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {

        Team  t = Developer.getTeam();
        assertEquals("s26-11", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {

        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("DANIIL"),"Team should contain DANIIL");
        assertTrue(t.getMembers().contains("ANISH"),"Team should contain ANISH");
        assertTrue(t.getMembers().contains("TIEN MINH"),"Team should contain TIEN MINH'");
        assertTrue(t.getMembers().contains("BRIAN JEREMY"),"Team should contain BRIAN JEREMY");
        assertTrue(t.getMembers().contains("WILSON ZHI SHENG"),"Team should contain WILSON ZHI SHENG");
        assertTrue(t.getMembers().contains("RUSHABH"),"Team should contain RUSHABH");
    }

}
