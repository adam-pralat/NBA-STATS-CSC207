package data_access;

import entity.Player;
import entity.PlayerStats;
import junit.framework.TestCase;

public class PlayerDataAccessObjectTest extends TestCase {
    private PlayerDataAccessObject playerDAO;
    private PlayerDataAccessObject playerDAOError;

    public void setUp() throws Exception {
        super.setUp();
        playerDAO = new PlayerDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
    }

    public void testExistsById() {
        assertTrue(playerDAO.existsById(265));
    }

    public void testGetPlayerInfo() {
        Player output = playerDAO.getPlayerInfo(265);
        assertEquals(output.getId(), 265);
        assertEquals(output.getFirstName(), "LeBron");
        assertEquals(output.getLastName(), "James");
        assertEquals(output.getBirthDate(), "1984-12-30");
        assertEquals(output.getCountry(), "USA");
        assertEquals(output.getHeight(), 2.06);
        assertEquals(output.getWeight(), 113.4);
        assertEquals(output.getPosition(), "F");
        assertEquals(output.getJerseyNumber(), 6);
        assertEquals(output.isActive(), true);
    }

    public void testGetPlayerYearlyStats() {
        PlayerStats output = playerDAO.getPlayerYearlyStats(265, 2023);
        assertEquals(output.gamesPlayed, 23);
        assertEquals(output.points, 529);
        assertEquals(output.assists, 140);
        assertEquals(output.timePlayed, 43680);
        assertEquals(output.fieldGoalsMade, 196);
        assertEquals(output.fieldGoalsAttempted, 360);
        assertEquals(output.freeThrowsMade, 88);
        assertEquals(output.freeThrowsAttempted, 128);
        assertEquals(output.threePointsMade, 49);
        assertEquals(output.threePointsAttempted, 127);
        assertEquals(output.offensiveRebounds, 16);
        assertEquals(output.defensiveRebounds, 147);
        assertEquals(output.personalFouls, 25);
        assertEquals(output.steals, 28);
        assertEquals(output.turnovers, 79);
        assertEquals(output.blocks, 16);
        assertEquals(output.plusMinus, 78);
        assertEquals(output.team, "Los Angeles Lakers");
        assertEquals(output.position, "SF");
    }
}