package entity;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Map;

public class TeamTest extends TestCase {
    private Team team;
    private ArrayList<Player> players;

    public void setUp() throws Exception {
        super.setUp();
        players = new ArrayList<>();
        players.add(new Player(
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
        ));

        team = new Team(
                1, // id
                "New York Knicks", // name
                "Knicks", // nickname
                "NYK", // code
                "New York", // city
                "knicks_logo_url", // logo
                "Eastern", // conference
                players, // players list
                10, // wins
                5, // losses
                7, // wins past ten
                3, // losses past ten
                4, // conference place
                15, // games
                120, // fast break points
                200, // points in paint
                150, // second chance points
                100, // points off turnovers
                1024, // total points
                400, // field goals made
                800, // field goals attempted
                300, // free throws made
                400, // free throws attempted
                150, // three points made
                400, // three points attempted
                200, // offensive rebounds
                300, // defensive rebounds
                250, // assists
                100, // personal fouls
                150, // steals
                120, // turnovers
                80, // blocks
                100 // plus-minus
        );


    }

    public void testToString() {
        String expectedString = "Team{" +
                "id=1, name='New York Knicks', nickname='Knicks', code='NYK', city='New York', logo='knicks_logo_url', conference='Eastern', players=" + players.toString() +
                ", wins=10, losses=5, winsPastTen=7, lossesPastTen=3, conferencePlace=4, games=15, fastBreakPoints=120, pointsInPaint=200, secondChancePoints=150, pointsOffTurnovers=100, points=1024, fieldGoalsMade=400, fieldGoalsAttempted=800, freeThrowsMade=300, freeThrowsAttempted=400, threePointsMade=150, threePointsAttempted=400, offReb=200, defReb=300, assists=250, pFouls=100, steals=150, turnovers=120, blocks=80, plusMinus=100" +
                '}';
        assertEquals(expectedString, team.toString());
    }

    public void testToMap() {
        Map<String, Object> map = team.toMap();

        // General Info
        assertEquals(map.get("id"), team.getId());
        assertEquals(map.get("name"), team.getName());
        assertEquals(map.get("nickname"), team.getNickname());
        assertEquals(map.get("code"), team.getCode());
        assertEquals(map.get("city"), team.getCity());
        assertEquals(map.get("logo"), team.getLogo());
        assertEquals(map.get("conference"), team.getConference());
        assertEquals(map.get("players"), team.getPlayers());

        // Wins/Losses
        assertEquals(map.get("wins"), team.getWins());
        assertEquals(map.get("losses"), team.getLosses());
        assertEquals(map.get("winsPastTen"), team.getWinsPastTen());
        assertEquals(map.get("lossesPastTen"), team.getLossesPastTen());
        assertEquals(map.get("conferencePlace"), team.getConferencePlace());

        // Team Statistics
        assertEquals(map.get("games"), team.getGames());
        assertEquals(map.get("fastBreakPoints"), team.getFastBreakPoints());
        assertEquals(map.get("pointsInPaint"), team.getPointsInPaint());
        assertEquals(map.get("secondChancePoints"), team.getSecondChancePoints());
        assertEquals(map.get("pointsOffTurnovers"), team.getPointsOffTurnovers());
        assertEquals(map.get("points"), team.getPoints());
        assertEquals(map.get("fieldGoalsMade"), team.getFieldGoalsMade());
        assertEquals(map.get("fieldGoalsAttempted"), team.getFieldGoalsAttempted());
        assertEquals(map.get("freeThrowsMade"), team.getFreeThrowsMade());
        assertEquals(map.get("freeThrowsAttempted"), team.getFreeThrowsAttempted());
        assertEquals(map.get("threePointsMade"), team.getThreePointsMade());
        assertEquals(map.get("threePointsAttempted"), team.getThreePointsAttempted());
        assertEquals(map.get("offReb"), team.getOffReb());
        assertEquals(map.get("defReb"), team.getDefReb());
        assertEquals(map.get("assists"), team.getAssists());
        assertEquals(map.get("pFouls"), team.getpFouls());
        assertEquals(map.get("steals"), team.getSteals());
        assertEquals(map.get("turnovers"), team.getTurnovers());
        assertEquals(map.get("blocks"), team.getBlocks());
        assertEquals(map.get("plusMinus"), team.getPlusMinus());

        // Per game metrics
        assertEquals(map.get("pointsPerGame"), team.pointsPerGame());
        assertEquals(map.get("assistsPerGame"), team.assistsPerGame());
        assertEquals(map.get("fieldGoalsMadePerGame"), team.fieldGoalsMadePerGame());
        assertEquals(map.get("fieldGoalsAttemptedPerGame"), team.fieldGoalsAttemptedPerGame());
        assertEquals(map.get("freeThrowsMadePerGame"), team.freeThrowsMadePerGame());
        assertEquals(map.get("freeThrowsAttemptedPerGame"), team.freeThrowsAttemptedPerGame());
        assertEquals(map.get("threePointsMadePerGame"), team.threePointsMadePerGame());
        assertEquals(map.get("threePointsAttemptedPerGame"), team.threePointsAttemptedPerGame());
        assertEquals(map.get("defensiveReboundsPerGame"), team.defensiveReboundsPerGame());
        assertEquals(map.get("offensiveReboundsPerGame"), team.offensiveReboundsPerGame());
        assertEquals(map.get("reboundsPerGame"), team.reboundsPerGame());
        assertEquals(map.get("personalFoulsPerGame"), team.personalFoulsPerGame());
        assertEquals(map.get("stealsPerGame"), team.stealsPerGame());
        assertEquals(map.get("turnoversPerGame"), team.turnoversPerGame());
        assertEquals(map.get("blocksPerGame"), team.blocksPerGame());
        assertEquals(map.get("totalRebounds"), team.totalRebounds());

    }

    public void testAddStat() {
        Team team = new Team(
                1, // id
                "New York Knicks", // name
                "Knicks", // nickname
                "NYK", // code
                "New York", // city
                "knicks_logo_url", // logo
                "Eastern", // conference
                new ArrayList<>(), // players list
                10, // wins
                5, // losses
                7, // wins past ten
                3, // losses past ten
                4, // conference place
                15, // games
                120, // fast break points
                200, // points in paint
                150, // second chance points
                100, // points off turnovers
                1024, // total points
                400, // field goals made
                800, // field goals attempted
                300, // free throws made
                400, // free throws attempted
                150, // three points made
                400, // three points attempted
                200, // offensive rebounds
                300, // defensive rebounds
                250, // assists
                100, // personal fouls
                150, // steals
                120, // turnovers
                80, // blocks
                100 // plus-minus
        );

        TeamStats newStat = new TeamStats(
                1, // games
                1, // fastBreakPoints
                1, // pointsInPaint
                1, // secondChancePoints
                1, // pointsOffTurnovers
                1, // points
                1, // fieldGoalsMade
                1, // fieldGoalsAttempted
                1, // freeThrowsMade
                1, // freeThrowsAttempted
                1, // threePointsMade
                1, // threePointsAttempted
                1, // offReb
                1, // defReb
                1, // assists
                1, // pFouls
                1, // steals
                1, // turnovers
                1, // blocks
                1  // plusMinus
        );

        // Add the new stats to the team
        team.addStat(newStat);

        // Assert each statistic has been updated correctly
        assertEquals(16, team.getGames());
        assertEquals(121, team.getFastBreakPoints());
        assertEquals(201, team.getPointsInPaint());
        assertEquals(151, team.getSecondChancePoints());
        assertEquals(101, team.getPointsOffTurnovers());
        assertEquals(1025, team.getPoints());
        assertEquals(401, team.getFieldGoalsMade());
        assertEquals(801, team.getFieldGoalsAttempted());
        assertEquals(301, team.getFreeThrowsMade());
        assertEquals(401, team.getFreeThrowsAttempted());
        assertEquals(151, team.getThreePointsMade());
        assertEquals(401, team.getThreePointsAttempted());
        assertEquals(201, team.getOffReb());
        assertEquals(301, team.getDefReb());
        assertEquals(251, team.getAssists());
        assertEquals(101, team.getpFouls());
        assertEquals(151, team.getSteals());
        assertEquals(121, team.getTurnovers());
        assertEquals(81, team.getBlocks());
        assertEquals(101, team.getPlusMinus());
    }

    public void testAddRecord() {
        TeamRecord newRecord = new TeamRecord(
                2, // additional wins
                1, // additional losses
                1, // additional wins past ten
                0, // additional losses past ten
                3  // new conference place
        );

        team.addRecord(newRecord);

        assertEquals(12, team.getWins());
        assertEquals(6, team.getLosses());
        assertEquals(8, team.getWinsPastTen());
        assertEquals(3, team.getLossesPastTen());
        assertEquals(3, team.getConferencePlace());

    }

    public void testGetId() {
        assertEquals(1, team.getId());
    }

    public void testGetAndSetName() {
        team.setName("New York Knicks");
        assertEquals("New York Knicks", team.getName());
    }

    public void testGetAndSetNickname() {
        team.setNickname("Knicks");
        assertEquals("Knicks", team.getNickname());
    }

    public void testGetAndSetCode() {
        team.setCode("NYK");
        assertEquals("NYK", team.getCode());
    }

    public void testGetAndSetCity() {
        team.setCity("New York");
        assertEquals("New York", team.getCity());
    }

    public void testGetAndSetLogo() {
        team.setLogo("knicks_logo_url");
        assertEquals("knicks_logo_url", team.getLogo());
    }

    public void testGetAndSetConference() {
        team.setConference("Eastern");
        assertEquals("Eastern", team.getConference());
    }

    public void testGetAndSetWins() {
        team.setWins(10);
        assertEquals(10, team.getWins());
    }

    public void testGetAndSetLosses() {
        team.setLosses(5);
        assertEquals(5, team.getLosses());
    }

    public void testGetAndSetWinsPastTen() {
        team.setWinsPastTen(8);
        assertEquals(8, team.getWinsPastTen());
    }

    public void testGetAndSetLossesPastTen() {
        team.setLossesPastTen(4);
        assertEquals(4, team.getLossesPastTen());
    }

    public void testGetAndSetConferencePlace() {
        team.setConferencePlace(5);
        assertEquals(5, team.getConferencePlace());
    }

    public void testGetAndSetGames() {
        team.setGames(20);
        assertEquals(20, team.getGames());
    }

    public void testGetAndSetFastBreakPoints() {
        team.setFastBreakPoints(130);
        assertEquals(130, team.getFastBreakPoints());
    }

    public void testGetAndSetPointsInPaint() {
        team.setPointsInPaint(210);
        assertEquals(210, team.getPointsInPaint());
    }

    public void testGetAndSetPlusMinus() {
        team.setPlusMinus(110);
        assertEquals(110, team.getPlusMinus());
    }

}
