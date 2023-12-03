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
        assertEquals(game.getHomeTeamWins(), 1);
    }

    public void testSetHomeTeamWins() {
        game.setHomeTeamWins(5);
        assertEquals(game.getHomeTeamWins(), 5);
    }

    public void testGetHomeTeamLosses() {
        assertEquals(game.getHomeTeamLosses(), 2);
    }

    public void testSetHomeTeamLosses() {
        game.setHomeTeamLosses(10);
        assertEquals(game.getHomeTeamLosses(), 10);
    }

    public void testGetHomeTeamPoints() {
        assertEquals(game.getHomeTeamPoints(), 2);
    }

    public void testSetHomeTeamPoints() {
        game.setHomeTeamPoints(4);
        assertEquals(game.getHomeTeamPoints(), 4);
    }

    public void testGetAwayTeamWins() {
        assertEquals(game.getAwayTeamWins(), 2);
    }

    public void testSetAwayTeamWins() {
        game.setAwayTeamWins(10);
        assertEquals(game.getAwayTeamWins(), 10);
    }

    public void testGetAwayTeamLosses() {
        assertEquals(game.getAwayTeamLosses(), 1);
    }

    public void testSetAwayTeamLosses() {
        game.setAwayTeamLosses(5);
        assertEquals(game.getAwayTeamLosses(), 5);
    }

    public void testGetAwayTeamPoints() {
        assertEquals(game.getAwayTeamPoints(), 4);
    }

    public void testSetAwayTeamPoints() {
        game.setAwayTeamPoints(40);
        assertEquals(game.getAwayTeamPoints(), 40);
    }
}
