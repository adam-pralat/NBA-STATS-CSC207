package data_access;

import entity.Game;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class GameDataAccessObjectTest extends TestCase {
    private GameDataAccessObject gameDAO;

    public void setUp() throws Exception {
        super.setUp();
        gameDAO = new GameDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
    }

    public void testGetGames() {
        Map<Integer, Game> out = gameDAO.getGames(LocalDate.of(2023, 12, 1));
        Game game1 = out.get(12824);
        assertEquals(game1.getId(), 12824);
        assertEquals(game1.getDateTime(), LocalDateTime.of(2023, 12, 1, 19, 30));
        assertEquals(game1.getStatus(), "Finished");
        assertEquals(game1.getLocation(), "Scotiabank Arena, Toronto, ON");
        assertEquals(game1.getHomeTeamID(), 38);
        assertEquals(game1.getHomeTeamName(), "Toronto Raptors");
        assertEquals(game1.getHomeTeamCode(), "TOR");
        assertEquals(game1.getHomeTeamLogo(), "https://upload.wikimedia.org/wikipedia/fr/8/89/Raptors2015.png");
        assertEquals(game1.getHomeTeamPoints(), 106);
        assertEquals(game1.getAwayTeamID(), 24);
        assertEquals(game1.getAwayTeamName(), "New York Knicks");
        assertEquals(game1.getAwayTeamCode(), "NYK");
        assertEquals(game1.getAwayTeamLogo(), "https://upload.wikimedia.org/wikipedia/fr/3/34/Knicks_de_NY.png");
        assertEquals(game1.getAwayTeamPoints(), 119);
    }
}