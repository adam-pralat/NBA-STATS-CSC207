package interface_adapter.team_stats;

import entity.Team;
import entity.TeamStats;
import interface_adapter.ViewManagerModel;
import interface_adapter.player_stats.PlayerStatsPresenter;
import interface_adapter.player_stats.PlayerStatsState;
import interface_adapter.player_stats.PlayerStatsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.team_stats.TeamStatsOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamStatsPresenterTest {
    private TeamStatsViewModel viewModel;
    private ViewManagerModel viewManagerModel;
    private TeamStatsPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new TeamStatsViewModel();
        viewManagerModel = new ViewManagerModel();
        presenter = new TeamStatsPresenter(viewModel, viewManagerModel);
    }

    @Test
    void prepareSuccessView() {

        Team team = new Team(1, "TeamName", "TeamNickname", "TMC", "TeamCity", "team_logo.png", "TeamConference", new ArrayList<>(), 50, 20, 7, 3, 1, 70, 15, 40, 8, 12, 110, 40, 80, 20, 25, 10, 20, 12, 30, 25, 18, 8, 15, 5, 150);
        TeamStatsOutputData output = new TeamStatsOutputData(team.toMap(), false);
        presenter.prepareSuccessView(output);
        TeamStatsState state = new TeamStatsState(viewModel.getState()); // Test Copy constructor
        
        assertEquals(team.getName(), state.getName());
        assertEquals(team.getNickname(), state.getNickname());
        assertEquals(team.getCode(), state.getCode());
        assertEquals(team.getCity(), state.getCity());
        assertEquals(team.getLogo(), state.getLogo());
        assertEquals(team.getConference(), state.getConference());
        assertEquals(Integer.toString(team.getWins()), state.getWins());
        assertEquals(Integer.toString(team.getLosses()), state.getLosses());
        assertEquals(Integer.toString(team.getWinsPastTen()), state.getWinsPastTen());
        assertEquals(Integer.toString(team.getLossesPastTen()), state.getLossesPastTen());
        assertEquals(Integer.toString(team.getConferencePlace()), state.getConferencePlace());
        assertEquals(Integer.toString(team.getGames()), state.getGames());
        assertEquals(Integer.toString(team.getFastBreakPoints()), state.getFastBreakPoints());
        assertEquals(Integer.toString(team.getPointsInPaint()), state.getPointsInPaint());
        assertEquals(Integer.toString(team.getSecondChancePoints()), state.getSecondChancePoints());
        assertEquals(Integer.toString(team.getPointsOffTurnovers()), state.getPointsOffTurnovers());
        assertEquals(Integer.toString(team.getPoints()), state.getPoints());
        assertEquals(Integer.toString(team.getFieldGoalsMade()), state.getFieldGoalsMade());
        assertEquals(Integer.toString(team.getFieldGoalsAttempted()), state.getFieldGoalsAttempted());
        assertEquals(Integer.toString(team.getFreeThrowsMade()), state.getFreeThrowsMade());
        assertEquals(Integer.toString(team.getFreeThrowsAttempted()), state.getFreeThrowsAttempted());
        assertEquals(Integer.toString(team.getThreePointsMade()), state.getThreePointsMade());
        assertEquals(Integer.toString(team.getThreePointsAttempted()), state.getThreePointsAttempted());
        assertEquals(Integer.toString(team.getOffReb()), state.getOffReb());
        assertEquals(Integer.toString(team.getDefReb()), state.getDefReb());
        assertEquals(Integer.toString(team.getAssists()), state.getAssists());
        assertEquals(Integer.toString(team.getpFouls()), state.getpFouls());
        assertEquals(Integer.toString(team.getSteals()), state.getSteals());
        assertEquals(Integer.toString(team.getTurnovers()), state.getTurnovers());
        assertEquals(Integer.toString(team.getBlocks()), state.getBlocks());
        assertEquals(Integer.toString(team.getPlusMinus()), state.getPlusMinus());

        assertEquals(Double.toString(team.fieldGoalPercentage()), state.getFieldGoalPercentage());
        assertEquals(Double.toString(team.freeThrowPercentage()), state.getFreeThrowPercentage());
        assertEquals(Double.toString(team.threePointPercentage()), state.getThreePointPercentage());

    }

    @Test
    void prepareFailView() {
        presenter.prepareFailView("Sorry, we could not get the stats for the team you requested. Please try again.");
        TeamStatsState state = viewModel.getState();
        assertEquals("Sorry, we could not get the stats for the team you requested. Please try again.", state.getTeamStatsError());
    }
}