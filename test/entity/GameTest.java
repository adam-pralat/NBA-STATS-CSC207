package entity;

import junit.framework.TestCase;

public class GameTest extends TestCase {
    private Game game;

    public void setUp() throws Exception {
        super.setUp();
        game = new Game(
                1,
                "2023-01-01",
                "Finished",
                "Amway Center, Orlando, FL",
                "Orlando Magic",
                "ORL",
                "String for image URL",
                1,
                2,
                2,
                "Toronto Raptors",
                "TOR",
                "String for image URL",
                2,
                1,
                4
        );
    }

    public void testGetStatus() {
        assertEquals(game.getStatus(), "Finished");
    }

    public void testSetStatus() {
        game.setStatus("In Progress");
        assertEquals(game.getStatus(), "In Progress");
    }

    public void testGetHomeTeamWins() {
        assertEquals((int)game.getHomeTeamWins(), 1);
    }

    public void testSetHomeTeamWins() {
        game.setHomeTeamWins(5);
        assertEquals((int)game.getHomeTeamWins(), 5);
    }

    public void testGetHomeTeamLosses() {
        assertEquals((int)game.getHomeTeamLosses(), 2);
    }

    public void testSetHomeTeamLosses() {
        game.setHomeTeamLosses(10);
        assertEquals((int)game.getHomeTeamLosses(), 10);
    }

    public void testGetHomeTeamPoints() {
        assertEquals((int)game.getHomeTeamPoints(), 2);
    }

    public void testSetHomeTeamPoints() {
        game.setHomeTeamPoints(4);
        assertEquals((int)game.getHomeTeamPoints(), 4);
    }

    public void testGetAwayTeamWins() {
        assertEquals((int)game.getAwayTeamWins(), 2);
    }

    public void testSetAwayTeamWins() {
        game.setAwayTeamWins(10);
        assertEquals((int)game.getAwayTeamWins(), 10);
    }

    public void testGetAwayTeamLosses() {
        assertEquals((int)game.getAwayTeamLosses(), 1);
    }

    public void testSetAwayTeamLosses() {
        game.setAwayTeamLosses(5);
        assertEquals((int)game.getAwayTeamLosses(), 5);
    }

    public void testGetAwayTeamPoints() {
        assertEquals((int)game.getAwayTeamPoints(), 4);
    }

    public void testSetAwayTeamPoints() {
        game.setAwayTeamPoints(40);
        assertEquals((int)game.getAwayTeamPoints(), 40);
    }

    public void testTestToString() {
        assertEquals(game.toString(), "\n________________________________________________________\n" +
                "2023-01-01\n" +
                "Finished\n" +
                "Amway Center, Orlando, FL\n" +
                "ORL | Orlando Magic : 2 - 4 : Toronto Raptors | TOR\n" +
                "(1 - 2)\t\t(2 - 1)\n");
    }
}