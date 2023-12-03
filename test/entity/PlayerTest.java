package entity;

import junit.framework.TestCase;

import java.util.Map;


// TODO: Rewrite tests with new player stats
public class PlayerTest extends TestCase {
    private Player player;

    public void setUp() throws Exception {
        super.setUp();
        player = new Player(
                1,
                "A",
                "B",
                "2000-01-01",
                "Canada",
                2.01,
                85.6,
                "New York Knicks",
                "G",
                0,
                true,
                1,
                2,
                3,
                60,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17
        );

    }

    public void testTestToString() {
        assertEquals( "Player{id=1, firstName='A', lastName='B', birthDate='2000-01-01', country='Canada', height=2.01, weight=85.6, team='New York Knicks', position='G', jerseyNumber=0, active=true, gamesPlayed=1, points=2, assists=3, timePlayed=60, fieldGoalsMade=5, fieldGoalsAttempted=6, freeThrowsMade=7, freeThrowsAttempted=8, threePointsMade=9, threePointsAttempted=10, offensiveRebounds=11, defensiveRebounds=12, personalFouls=13, steals=14, turnovers=15, blocks=16, plusMinus=17}", player.toString());
    }

    public void testGetDiff() {
        Player other = new Player(
                1,
                "A",
                "B",
                "2000-01-01",
                "Canada",
                2.01,
                85.6,
                "New York Knicks",
                "G",
                0,
                true,
                1,
                2,
                3,
                60,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17
        );
        Map<String, Object> diff = player.getDiff(other);
        // Check whether all diffs are 0
        for (Map.Entry<String, Object> entry : diff.entrySet()) {
            if (entry.getValue() instanceof Double){
                assertEquals(entry.getValue(), 0.0);
            } else {
                assertEquals(entry.getValue(), 0);
            }
        }
    }

    public void testToMap() {
        Map<String, Object> map = player.toMap();
        assertEquals(map.get("id"),  player.getId());
        assertEquals(map.get("firstName"), player.getFirstName());
        assertEquals(map.get("lastName"), player.getLastName());
        assertEquals(map.get("birthDate"), player.getBirthDate());
        assertEquals(map.get("country"), player.getCountry());
        assertEquals(map.get("height"), player.getHeight());
        assertEquals(map.get("weight"), player.getWeight());
        assertEquals(map.get("team"), player.getTeam());
        assertEquals(map.get("position"), player.getPosition());
        assertEquals(map.get("jerseyNumber"), player.getJerseyNumber());
        assertEquals(map.get("active"), player.isActive());

        // Statistics
        assertEquals(map.get("gamesPlayed"), player.getGamesPlayed());
        assertEquals(map.get("points"), player.getPoints());
        assertEquals(map.get("assists"), player.getAssists());
        assertEquals(map.get("timePlayed"), player.getTimePlayed());
        assertEquals(map.get("fieldGoalsMade"), player.getFieldGoalsMade());
        assertEquals(map.get("fieldGoalsAttempted"), player.getFieldGoalsAttempted());
        assertEquals(map.get("freeThrowsMade"), player.getFreeThrowsMade());
        assertEquals(map.get("freeThrowsAttempted"), player.getFreeThrowsAttempted());
        assertEquals(map.get("threePointsMade"), player.getThreePointsMade());
        assertEquals(map.get("threePointsAttempted"), player.getThreePointsAttempted());
        assertEquals(map.get("offensiveRebounds"), player.getOffensiveRebounds());
        assertEquals(map.get("defensiveRebounds"), player.getDefensiveRebounds());
        assertEquals(map.get("personalFouls"), player.getPersonalFouls());
        assertEquals(map.get("steals"), player.getSteals());
        assertEquals(map.get("turnovers"), player.getTurnovers());
        assertEquals(map.get("blocks"), player.getBlocks());
        assertEquals(map.get("plusMinus"), player.getPlusMinus());

        // Per game metrics
        assertEquals(map.get("pointsPerGame"), player.pointsPerGame());
        assertEquals(map.get("assistsPerGame"), player.assistsPerGame());
        assertEquals(map.get("fieldGoalsMadePerGame"), player.fieldGoalsMadePerGame());
        assertEquals(map.get("fieldGoalsAttemptedPerGame"), player.fieldGoalsAttemptedPerGame());
        assertEquals(map.get("freeThrowsMadePerGame"), player.freeThrowsMadePerGame());
        assertEquals(map.get("freeThrowsAttemptedPerGame"), player.freeThrowsAttemptedPerGame());
        assertEquals(map.get("threePointsMadePerGame"), player.threePointsMadePerGame());
        assertEquals(map.get("threePointsAttemptedPerGame"), player.threePointsAttemptedPerGame());
        assertEquals(map.get("defensiveReboundsPerGame"), player.defensiveReboundsPerGame());
        assertEquals(map.get("offensiveReboundsPerGame"), player.offensiveReboundsPerGame());
        assertEquals(map.get("reboundsPerGame"), player.reboundsPerGame());
        assertEquals(map.get("personalFoulsPerGame"), player.personalFoulsPerGame());
        assertEquals(map.get("stealsPerGame"), player.stealsPerGame());
        assertEquals(map.get("turnoversPerGame"), player.turnoversPerGame());
        assertEquals(map.get("blocksPerGame"), player.blocksPerGame());
        assertEquals(map.get("timePlayedPerGame"), player.timePlayedPerGame());

        // Percentages
        assertEquals(map.get("fieldGoalPercentage"), player.fieldGoalPercentage());
        assertEquals(map.get("threePointPercentage"), player.threePointPercentage());
        assertEquals(map.get("freeThrowPercentage"), player.freeThrowPercentage());
    }

    public void testAddStat() {
        PlayerStats newStat = new PlayerStats(
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1
        );
        Player other = new Player(
                1,
                "A",
                "B",
                "2000-01-01",
                "Canada",
                2.01,
                85.6,
                "New York Knicks",
                "G",
                0,
                true,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
        other.addStat(newStat);
        assertEquals(other.getGamesPlayed(), 1);
        assertEquals(other.getPoints(), 1);
        assertEquals(other.getAssists(), 1);
        assertEquals(other.getTimePlayed(), 1);
        assertEquals(other.getFieldGoalsMade(), 1);
        assertEquals(other.getFieldGoalsAttempted(), 1);
        assertEquals(other.getFreeThrowsMade(), 1);
        assertEquals(other.getFreeThrowsAttempted(), 1);
        assertEquals(other.getThreePointsMade(), 1);
        assertEquals(other.getThreePointsAttempted(), 1);
        assertEquals(other.getOffensiveRebounds(), 1);
        assertEquals(other.getDefensiveRebounds(), 1);
        assertEquals(other.getPersonalFouls(), 1);
        assertEquals(other.getSteals(), 1);
        assertEquals(other.getTurnovers(), 1);
        assertEquals(other.getBlocks(), 1);
        assertEquals(other.getPlusMinus(), 1);
    }

    public void testMinutesPerGame() {
        assertEquals(player.minutesPerGame(), 1.0);
    }

    public void testMinutesPlayed() {
        assertEquals(player.minutesPlayed(), 1.0);
    }

    public void testPointsPerGame() {
        assertEquals(player.pointsPerGame(), 2.0);
    }

    public void testAssistsPerGame() {
        assertEquals(player.assistsPerGame(), 3.0);
    }

    public void testFieldGoalsMadePerGame() {
        assertEquals(player.fieldGoalsMadePerGame(), 5.0);
    }

    public void testFieldGoalsAttemptedPerGame() {
        assertEquals(player.fieldGoalsAttemptedPerGame(), 6.0);
    }

    public void testFreeThrowsMadePerGame() {
        assertEquals(player.freeThrowsMadePerGame(), 7.0);
    }

    public void testFreeThrowsAttemptedPerGame() {
        assertEquals(player.freeThrowsAttemptedPerGame(), 8.0);
    }

    public void testThreePointsMadePerGame() {
        assertEquals(player.threePointsMadePerGame(), 9.0);
    }

    public void testThreePointsAttemptedPerGame() {
        assertEquals(player.threePointsAttemptedPerGame(), 10.0);
    }

    public void testDefensiveReboundsPerGame() {
        assertEquals(player.defensiveReboundsPerGame(), 12.0);
    }

    public void testOffensiveReboundsPerGame() {
        assertEquals(player.offensiveReboundsPerGame(), 11.0);
    }

    public void testReboundsPerGame() {
        assertEquals(player.reboundsPerGame(), 23.0);
    }

    public void testPersonalFoulsPerGame() {
        assertEquals(player.personalFoulsPerGame(), 13.0);
    }

    public void testStealsPerGame() {
        assertEquals(player.stealsPerGame(), 14.0);
    }

    public void testTurnoversPerGame() {
        assertEquals(player.turnoversPerGame(), 15.0);
    }

    public void testBlocksPerGame() {
        assertEquals(player.blocksPerGame(), 16.0);
    }

    public void testTimePlayedPerGame() {
        assertEquals(player.timePlayedPerGame(), 60.0);
    }

    public void testFieldGoalPercentage() {
        assertEquals(player.fieldGoalPercentage(), (double)5/6*100, 0.01);
    }

    public void testFreeThrowPercentage() {
        assertEquals(player.freeThrowPercentage(), (double)7/8*100);
    }

    public void testId() {
        assertEquals(player.getId(), 1);
    }

    public void testGetAssists() {
        assertEquals(player.getAssists(), 3);
    }

    public void testSetAssists() {
        player.setAssists(5);
        assertEquals(player.getAssists(), 5);
    }

    public void testThreePointPercentage() {
        assertEquals(player.threePointPercentage(), (double)9/10*100);
    }

    public void testTotalRebounds() {
        assertEquals(player.totalRebounds(), 23);
    }

    public void testGetFirstName() {
        assertEquals(player.getFirstName(), "A");
    }

    public void testSetFirstName() {
        player.setFirstName("B");
        assertEquals(player.getFirstName(), "B");
    }

    public void testGetLastName() {
        assertEquals(player.getLastName(), "B");
    }

    public void testSetLastName() {
        player.setLastName("BB");
        assertEquals(player.getLastName(), "BB");
    }

    public void testGetBirthDate() {
        assertEquals(player.getBirthDate(), "2000-01-01");
    }

    public void testSetBirthDate() {
        player.setBirthDate("2001-09-09");
        assertEquals(player.getBirthDate(), "2001-09-09");
    }

    public void testGetCountry() {
        assertEquals(player.getCountry(), "Canada");
    }

    public void testSetCountry() {
        player.setCountry("USA");
        assertEquals(player.getCountry(), "USA");
    }

    public void testGetHeight() {
        assertEquals(player.getHeight(), 2.01);
    }

    public void testSetHeight() {
        player.setHeight(1.95);
        assertEquals(player.getHeight(), 1.95);
    }

    public void testGetWeight() {
        assertEquals(player.getWeight(), 85.6);
    }

    public void testSetWeight() {
        player.setWeight(90.0);
        assertEquals(player.getWeight(), 90.0);
    }

    public void testGetTeam() {
        assertEquals(player.getTeam(), "New York Knicks");
    }

    public void testSetTeam() {
        player.setTeam("Toronto Raptors");
        assertEquals(player.getTeam(), "Toronto Raptors");
    }

    public void testGetPosition() {
        assertEquals(player.getPosition(), "G");
    }

    public void testSetPosition() {
        player.setPosition("C");
        assertEquals(player.getPosition(), "C");
    }

    public void testGetJerseyNumber() {
        assertEquals(player.getJerseyNumber(), 0);
    }

    public void testSetJerseyNumber() {
        player.setJerseyNumber(99);
        assertEquals(player.getJerseyNumber(), 99);
    }

    public void testIsActive() {
        assertEquals(player.isActive(), true);
    }

    public void testSetActive() {
        player.setActive(false);
        assertEquals(player.isActive(), false);
    }

    public void testGetGamesPlayed() {
        assertEquals(player.getGamesPlayed(), 1);
    }

    public void testSetGamesPlayed() {
        player.setGamesPlayed(5);
        assertEquals(player.getGamesPlayed(), 5);
    }

    public void testGetPoints() {
        assertEquals(player.getPoints(), 2);
    }

    public void testSetPoints() {
        player.setPoints(10);
        assertEquals(player.getPoints(), 10);
    }

    public void testGetTimePlayed() {
        assertEquals(player.getTimePlayed(), 60);
    }

    public void testSetTimePlayed() {
        player.setTimePlayed(30);
        assertEquals(player.getTimePlayed(), 30);
    }

    public void testGetFieldGoalsMade() {
        assertEquals(player.getFieldGoalsMade(), 5);
    }

    public void testSetFieldGoalsMade() {
        player.setFieldGoalsMade(20);
        assertEquals(player.getFieldGoalsMade(), 20);
    }

    public void testGetFieldGoalsAttempted() {
        assertEquals(player.getFieldGoalsAttempted(), 6);
    }

    public void testSetFieldGoalsAttempted() {
        player.setFieldGoalsAttempted(50);
        assertEquals(player.getFieldGoalsAttempted(), 50);
    }

    public void testGetFreeThrowsMade() {
        assertEquals(player.getFreeThrowsMade(), 7);
    }

    public void testSetFreeThrowsMade() {
        player.setFreeThrowsMade(17);
        assertEquals(player.getFreeThrowsMade(), 17);
    }

    public void testGetFreeThrowsAttempted() {
        assertEquals(player.getFreeThrowsAttempted(), 8);
    }

    public void testSetFreeThrowsAttempted() {
        player.setFreeThrowsAttempted(18);
        assertEquals(player.getFreeThrowsAttempted(), 18);
    }

    public void testGetThreePointsMade() {
        assertEquals(player.getThreePointsMade(), 9);
    }

    public void testSetThreePointsMade() {
        player.setThreePointsMade(19);
        assertEquals(player.getThreePointsMade(), 19);

    }

    public void testGetThreePointsAttempted() {
        assertEquals(player.getThreePointsAttempted(), 10);
    }

    public void testSetThreePointsAttempted() {
        player.setThreePointsAttempted(101);
        assertEquals(player.getThreePointsAttempted(), 101);
    }

    public void testGetOffensiveRebounds() {
        assertEquals(player.getOffensiveRebounds(), 11);
    }

    public void testSetOffensiveRebounds() {
        player.setOffensiveRebounds(111);
        assertEquals(player.getOffensiveRebounds(), 111);
    }

    public void testGetDefensiveRebounds() {
        assertEquals(player.getDefensiveRebounds(), 12);
    }

    public void testSetDefensiveRebounds() {
        player.setDefensiveRebounds(121);
        assertEquals(player.getDefensiveRebounds(), 121);
    }

    public void testGetPersonalFouls() {
        assertEquals(player.getPersonalFouls(), 13);
    }

    public void testSetPersonalFouls() {
        player.setPersonalFouls(131);
        assertEquals(player.getPersonalFouls(), 131);
    }

    public void testGetSteals() {
        assertEquals(player.getSteals(), 14);
    }

    public void testSetSteals() {
        player.setSteals(141);
        assertEquals(player.getSteals(), 141);
    }

    public void testGetTurnovers() {
        assertEquals(player.getTurnovers(), 15);
    }

    public void testSetTurnovers() {
        player.setTurnovers(151);
        assertEquals(player.getTurnovers(), 151);
    }

    public void testGetBlocks() {
        assertEquals(player.getBlocks(), 16);
    }

    public void testSetBlocks() {
        player.setBlocks(161);
        assertEquals(player.getBlocks(), 161);
    }

    public void testGetPlusMinus() {
        assertEquals(player.getPlusMinus(), 17);
    }

    public void testSetPlusMinus() {
        player.setPlusMinus(171);
        assertEquals(player.getPlusMinus(), 171);
    }

    public void testIntPerGameMetricZeroGames(){
        player.setGamesPlayed(0);
        assertEquals(player.personalFoulsPerGame(), 0.0);
    }

    public void testDoublePerGameMetricZeroGames(){
        player.setGamesPlayed(0);
        assertEquals(player.minutesPerGame(), 0.0);
    }

    public void testFreeThrowPercentageZeroAttempts(){
        player.setFreeThrowsAttempted(0);
        assertEquals(player.freeThrowPercentage(), 0.0);
    }

    public void testFieldGoalPercentageZeroAttempts(){
        player.setFieldGoalsAttempted(0);
        assertEquals(player.fieldGoalPercentage(), 0.0);
    }

    public void testThreePointPercentageZeroAttempts(){
        player.setThreePointsAttempted(0);
        assertEquals(player.threePointPercentage(), 0.0);
    }
}