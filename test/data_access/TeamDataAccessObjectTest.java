package data_access;

import entity.*;
import junit.framework.TestCase;

public class TeamDataAccessObjectTest extends TestCase {
    private TeamDataAccessObject teamDAO;
    private TeamDataAccessObject teamDAOError;

    public void setUp() throws Exception {
        super.setUp();
        teamDAO = new TeamDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        teamDAOError = new TeamDataAccessObject(""); // No API Key
    }

    public void testExistsById() {
        assertTrue(teamDAO.existsById(1));
    }

    public void testGetTeamInfo() {
        Team output = teamDAO.getTeamInfo(1);
        assertEquals(output.getId(), 1);
        assertEquals(output.getName(), "Atlanta Hawks");
        assertEquals(output.getNickname(), "Hawks");
        assertEquals(output.getCode(), "ATL");
        assertEquals(output.getCity(), "Atlanta");
        assertEquals(output.getLogo(), "https://upload.wikimedia.org/wikipedia/fr/e/ee/Hawks_2016.png");
        assertEquals(output.getConference(), "East");
    }

    public void testGetTeamYearlyStats() {
        TeamStats output = teamDAO.getTeamYearlyStats(1, 2023);
        assertEquals(output.games, 24);
        assertEquals(output.points, 2879);
        assertEquals(output.assists, 611);
        assertEquals(output.fastBreakPoints, 0);
        assertEquals(output.pointsInPaint, 0);
        assertEquals(output.secondChancePoints, 0);
        assertEquals(output.fieldGoalsMade, 1031);
        assertEquals(output.fieldGoalsAttempted, 2198);
        assertEquals(output.freeThrowsMade, 491);
        assertEquals(output.freeThrowsAttempted, 603);
        assertEquals(output.threePointsMade, 326);
        assertEquals(output.threePointsAttempted, 898);
        assertEquals(output.offReb, 299);
        assertEquals(output.defReb, 767);
        assertEquals(output.pFouls, 440);
        assertEquals(output.steals, 234);
        assertEquals(output.turnovers, 377);
        assertEquals(output.blocks, 101);
        assertEquals(output.plusMinus, -4);
    }

    public void testGetTeamYearlyRecord() {
        TeamRecord output = teamDAO.getYearlyRecord(1, 2023);
        assertEquals(output.wins, 9);
        assertEquals(output.losses, 10);
        assertEquals(output.winsPastTen, 4);
        assertEquals(output.lossesPastTen, 6);
        assertEquals(output.conferencePlace, 10);
    }
}