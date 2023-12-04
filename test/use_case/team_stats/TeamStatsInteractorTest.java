package use_case.team_stats;

import data_access.TestDAO;
import data_access.TestDAOErrors;
import entity.Team;
import junit.framework.TestCase;
import org.junit.Test;
import use_case.player_stats.*;

import java.util.Map;


// TODO: Finish tests
public class TeamStatsInteractorTest extends TestCase {
    public void testExecuteSuccess() {
        TeamStatsInputData inputData = new TeamStatsInputData(1);
        TeamStatsDataAccessInterface teamDAO = new TestDAO();
        TeamStatsOutputBoundary outputBoundary = new TeamStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(TeamStatsOutputData response) {
                Map<String, Object> teamData = response.getTeamStats();
                assertEquals(teamData.get("name"), "Name");
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected fail");
            }
        };
        TeamStatsInteractor interactor = new TeamStatsInteractor(teamDAO, outputBoundary);
        interactor.execute(inputData);
    }

    @Test
    public void testExecuteFail() {
        TeamStatsInputData inputData = new TeamStatsInputData(1);
        TeamStatsDataAccessInterface teamDAO = new TestDAOErrors();
        TeamStatsOutputBoundary outputBoundary = new TeamStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(TeamStatsOutputData response) {
                fail("Unexpected success");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Error in getting data.", error);
            }
        };
        TeamStatsInteractor interactor = new TeamStatsInteractor(teamDAO, outputBoundary);
        interactor.execute(inputData);
    }

}