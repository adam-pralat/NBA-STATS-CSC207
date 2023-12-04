package interface_adapter.home_page;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageStateTest {

    private HomePageState homePageState;

    @BeforeEach
    public void setUp() {
        // Initialize a sample HomePageState object with filler data
        homePageState = new HomePageState();
        homePageState.setPlayerFirstName("John");
        homePageState.setPlayerLastName("Doe");
        homePageState.setPlayerBirthDate("1990-05-15");
        homePageState.setPlayerCountry("USA");
        homePageState.setPlayerTeam("Sample Team");
        homePageState.setPlayerPointsPerGame(25.5);
        homePageState.setPlayerAssistsPerGame(5.0);
        homePageState.setPlayerFreeThrowPercentage(80.0);
        homePageState.setPlayerFieldGoalPercentage(45.0);
        homePageState.setPlayerThreePointPercentage(35.0);
        homePageState.setPlayerMinutesPlayedPerGame(30.0);
        homePageState.setPlayerStealsPerGame(2.0);
        homePageState.setPlayerTurnoversPerGame(3.0);
        homePageState.setPlayerBlocksPerGame(1.5);
        homePageState.setTeamName("Sample Team");
        homePageState.setTeamNickname("Team Nickname");
        homePageState.setTeamCode("ABC");
        homePageState.setConference("Western Conference");
        homePageState.setTeamWins(50);
        homePageState.setTeamLosses(20);
        homePageState.setTeamsWinsLastTen(8);
        homePageState.setTeamsLossesLastTen(2);
        homePageState.setConferencePlace(3);
        homePageState.setTeamPointsPerGame(110.5);
        homePageState.setTeamFreeThrowPercentage(78.0);
        homePageState.setTeamFieldGoalPercentage(47.0);
        homePageState.setTeamThreePointPercentage(40.0);
        homePageState.setUseCaseFailed(false);
        homePageState.setError("No Error");
    }

    @Test
    public void testGetPlayerFirstName() {
        assertEquals("John", homePageState.getPlayerFirstName());
    }

    @Test
    public void testSetPlayerFirstName() {
        homePageState.setPlayerFirstName("Jane");
        assertEquals("Jane", homePageState.getPlayerFirstName());
    }

    @Test
    public void testGetPlayerLastName() {
        assertEquals("Doe", homePageState.getPlayerLastName());
    }

    @Test
    public void testSetPlayerLastName() {
        homePageState.setPlayerLastName("Smith");
        assertEquals("Smith", homePageState.getPlayerLastName());
    }

    @Test
    public void testGetPlayerBirthDate() {
        assertEquals("1990-05-15", homePageState.getPlayerBirthDate());
    }

    @Test
    public void testSetPlayerBirthDate() {
        homePageState.setPlayerBirthDate("1995-08-22");
        assertEquals("1995-08-22", homePageState.getPlayerBirthDate());
    }

    @Test
    public void testGetPlayerCountry() {
        assertEquals("USA", homePageState.getPlayerCountry());
    }

    @Test
    public void testSetPlayerCountry() {
        homePageState.setPlayerCountry("Canada");
        assertEquals("Canada", homePageState.getPlayerCountry());
    }

    @Test
    public void testGetPlayerTeam() {
        assertEquals("Sample Team", homePageState.getPlayerTeam());
    }

    @Test
    public void testSetPlayerTeam() {
        homePageState.setPlayerTeam("New Team");
        assertEquals("New Team", homePageState.getPlayerTeam());
    }

    @Test
    public void testGetPlayerPointsPerGame() {
        assertEquals(25.5, homePageState.getPlayerPointsPerGame(), 0.001);
    }

    @Test
    public void testSetPlayerPointsPerGame() {
        homePageState.setPlayerPointsPerGame(30.0);
        assertEquals(30.0, homePageState.getPlayerPointsPerGame(), 0.001);
    }

    @Test
    public void testGetPlayerAssistsPerGame() {
        assertEquals(5.0, homePageState.getPlayerAssistsPerGame(), 0.001);
    }

    @Test
    public void testSetPlayerAssistsPerGame() {
        homePageState.setPlayerAssistsPerGame(7.0);
        assertEquals(7.0, homePageState.getPlayerAssistsPerGame(), 0.001);
    }

    @Test
    public void testGetPlayerFreeThrowPercentage() {
        assertEquals(80.0, homePageState.getPlayerFreeThrowPercentage(), 0.001);
    }

    @Test
    public void testSetPlayerFreeThrowPercentage() {
        homePageState.setPlayerFreeThrowPercentage(85.0);
        assertEquals(85.0, homePageState.getPlayerFreeThrowPercentage(), 0.001);
    }

    @Test
    public void testGetPlayerFieldGoalPercentage() {
        assertEquals(45.0, homePageState.getPlayerFieldGoalPercentage(), 0.001);
    }

    @Test
    public void testSetPlayerFieldGoalPercentage() {
        homePageState.setPlayerFieldGoalPercentage(50.0);
        assertEquals(50.0, homePageState.getPlayerFieldGoalPercentage(), 0.001);
    }

    @Test
    public void testGetPlayerThreePointPercentage() {
        assertEquals(35.0, homePageState.getPlayerThreePointPercentage(), 0.001);
    }

    @Test
    public void testSetPlayerThreePointPercentage() {
        homePageState.setPlayerThreePointPercentage(40.0);
        assertEquals(40.0, homePageState.getPlayerThreePointPercentage(), 0.001);
    }

    @Test
    public void testGetPlayerMinutesPlayedPerGame() {
        assertEquals(30.0, homePageState.getPlayerMinutesPlayedPerGame(), 0.001);
    }

    @Test
    public void testSetPlayerMinutesPlayedPerGame() {
        homePageState.setPlayerMinutesPlayedPerGame(32.5);
        assertEquals(32.5, homePageState.getPlayerMinutesPlayedPerGame(), 0.001);
    }

    @Test
    public void testGetPlayerStealsPerGame() {
        assertEquals(2.0, homePageState.getPlayerStealsPerGame(), 0.001);
    }

    @Test
    public void testSetPlayerStealsPerGame() {
        homePageState.setPlayerStealsPerGame(3.0);
        assertEquals(3.0, homePageState.getPlayerStealsPerGame(), 0.001);
    }

    @Test
    public void testGetPlayerTurnoversPerGame() {
        assertEquals(3.0, homePageState.getPlayerTurnoversPerGame(), 0.001);
    }

    @Test
    public void testSetPlayerTurnoversPerGame() {
        homePageState.setPlayerTurnoversPerGame(2.5);
        assertEquals(2.5, homePageState.getPlayerTurnoversPerGame(), 0.001);
    }

    @Test
    public void testGetPlayerBlocksPerGame() {
        assertEquals(1.5, homePageState.getPlayerBlocksPerGame(), 0.001);
    }

    @Test
    public void testSetPlayerBlocksPerGame() {
        homePageState.setPlayerBlocksPerGame(2.0);
        assertEquals(2.0, homePageState.getPlayerBlocksPerGame(), 0.001);
    }

    @Test
    public void testGetTeamName() {
        assertEquals("Sample Team", homePageState.getTeamName());
    }

    @Test
    public void testSetTeamName() {
        homePageState.setTeamName("New Team");
        assertEquals("New Team", homePageState.getTeamName());
    }

    @Test
    public void testGetTeamNickname() {
        assertEquals("Team Nickname", homePageState.getTeamNickname());
    }

    @Test
    public void testSetTeamNickname() {
        homePageState.setTeamNickname("New Nickname");
        assertEquals("New Nickname", homePageState.getTeamNickname());
    }

    @Test
    public void testGetTeamCode() {
        assertEquals("ABC", homePageState.getTeamCode());
    }

    @Test
    public void testSetTeamCode() {
        homePageState.setTeamCode("XYZ");
        assertEquals("XYZ", homePageState.getTeamCode());
    }

    @Test
    public void testGetConference() {
        assertEquals("Western Conference", homePageState.getConference());
    }

    @Test
    public void testSetConference() {
        homePageState.setConference("Eastern Conference");
        assertEquals("Eastern Conference", homePageState.getConference());
    }

    @Test
    public void testGetTeamWins() {
        assertEquals(50, homePageState.getTeamWins());
    }

    @Test
    public void testSetTeamWins() {
        homePageState.setTeamWins(60);
        assertEquals(60, homePageState.getTeamWins());
    }

    @Test
    public void testGetTeamLosses() {
        assertEquals(20, homePageState.getTeamLosses());
    }

    @Test
    public void testSetTeamLosses() {
        homePageState.setTeamLosses(25);
        assertEquals(25, homePageState.getTeamLosses());
    }

    @Test
    public void testGetTeamsWinsLastTen() {
        assertEquals(8, homePageState.getTeamsWinsLastTen());
    }

    @Test
    public void testSetTeamsWinsLastTen() {
        homePageState.setTeamsWinsLastTen(10);
        assertEquals(10, homePageState.getTeamsWinsLastTen());
    }

    @Test
    public void testGetTeamsLossesLastTen() {
        assertEquals(2, homePageState.getTeamsLossesLastTen());
    }

    @Test
    public void testSetTeamsLossesLastTen() {
        homePageState.setTeamsLossesLastTen(3);
        assertEquals(3, homePageState.getTeamsLossesLastTen());
    }

    @Test
    public void testGetConferencePlace() {
        assertEquals(3, homePageState.getConferencePlace());
    }

    @Test
    public void testSetConferencePlace() {
        homePageState.setConferencePlace(2);
        assertEquals(2, homePageState.getConferencePlace());
    }

    @Test
    public void testGetTeamPointsPerGame() {
        assertEquals(110.5, homePageState.getTeamPointsPerGame(), 0.001);
    }

    @Test
    public void testSetTeamPointsPerGame() {
        homePageState.setTeamPointsPerGame(112.0);
        assertEquals(112.0, homePageState.getTeamPointsPerGame(), 0.001);
    }

    @Test
    public void testGetTeamFreeThrowPercentage() {
        assertEquals(78.0, homePageState.getTeamFreeThrowPercentage(), 0.001);
    }

    @Test
    public void testSetTeamFreeThrowPercentage() {
        homePageState.setTeamFreeThrowPercentage(75.5);
        assertEquals(75.5, homePageState.getTeamFreeThrowPercentage(), 0.001);
    }

    @Test
    public void testGetTeamFieldGoalPercentage() {
        assertEquals(47.0, homePageState.getTeamFieldGoalPercentage(), 0.001);
    }

    @Test
    public void testSetTeamFieldGoalPercentage() {
        homePageState.setTeamFieldGoalPercentage(48.5);
        assertEquals(48.5, homePageState.getTeamFieldGoalPercentage(), 0.001);
    }

    @Test
    public void testGetTeamThreePointPercentage() {
        assertEquals(40.0, homePageState.getTeamThreePointPercentage(), 0.001);
    }

    @Test
    public void testSetTeamThreePointPercentage() {
        homePageState.setTeamThreePointPercentage(42.0);
        assertEquals(42.0, homePageState.getTeamThreePointPercentage(), 0.001);
    }

    @Test
    public void testIsUseCaseFailed() {
        assertEquals(false, homePageState.isUseCaseFailed());
    }

    @Test
    public void testSetUseCaseFailed() {
        homePageState.setUseCaseFailed(true);
        assertEquals(true, homePageState.isUseCaseFailed());
    }

    @Test
    public void testGetError() {
        assertEquals("No Error", homePageState.getError());
    }

    @Test
    public void testSetError() {
        homePageState.setError("New Error");
        assertEquals("New Error", homePageState.getError());
    }
}
