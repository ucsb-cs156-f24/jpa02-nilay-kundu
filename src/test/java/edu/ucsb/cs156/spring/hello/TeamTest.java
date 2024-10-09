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

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_compares_objects_correctly() {
        // Case 1: Same object
        assertEquals(true, team.equals(team));

        // Case 2: Diff class
        String test = "test";
        assertEquals(false, team.equals(test));

        // Case 3: Diff Team objects --> 4 sub-cases
        Team test_same_name = new Team("test-team");
        Team test_wrong_name = new Team("test-wrong-team");

        // Compares same name and same members: true
        assertEquals(true, team.equals(test_same_name));

        // Compares same name but diff members: false
        test_same_name.addMember("Mary Jane");
        assertEquals(false, team.equals(test_same_name));
        
        // Compares diff name but same members: false
        assertEquals(false, team.equals(test_wrong_name));

        // Compares diff name and diff members: false
        test_wrong_name.addMember("Mary Jane");
        assertEquals(false, team.equals(test_wrong_name));
    }

    @Test
    public void hashCode_returns_correct_code() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        Team t = new Team("test");
        int result = t.hashCode();
        int expectedResult = 3556499;
        assertEquals(expectedResult, result);
    }
}
