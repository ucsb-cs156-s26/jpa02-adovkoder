package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_same_object() {

        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_different_types() {

        int team2 = 1;

        assertEquals(false, team.equals(team2));
        
    }

    @Test
    public void equals_returns_matching() {

        Team team2 = new Team("test-team");

        assertEquals(true, team.equals(team2));
        
    }

    @Test
    public void equals_returns_unmatching_members() {

        Team team2 = new Team("test-team");
        team2.addMember("Wilson");

        assertEquals(false, team.equals(team2));
        
    }

    @Test
    public void equals_returns_unmatching_team() {

        Team team2 = new Team("test-team2");

        assertEquals(false, team.equals(team2));
        
    }

    @Test
    public void equals_returns_unmatching() {

        Team team2 = new Team("test-team2");
        team2.addMember("Wilson");

        assertEquals(false, team.equals(team2));
        
    }

    @Test
    public void hashCode_returns_same_hash_value() {

        Team team2 = new Team("test-team");

        assertEquals(team.hashCode(), team2.hashCode());
    }

    @Test
    public void hashCode_returns_correct_value() {

        int result = team.hashCode();
        assertEquals(-1226298695, result);

    }
}
