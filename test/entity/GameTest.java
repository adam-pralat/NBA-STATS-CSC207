package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    @BeforeEach
    void setUp() {
        game = new Game(
                1,
                LocalDateTime.of(2015, 10, 2, 20, 30, 0, 0),
                "Finished",
                "Staples Center, Los Angeles, CA",
                16,
                "LA Clippers",
                "LAC",
                "https://upload.wikimedia.org/wikipedia/fr/d/d6/Los_Angeles_Clippers_logo_2010.png",
                103,
                9,
                "Denver Nuggets",
                "DEN",
                "https://upload.wikimedia.org/wikipedia/fr/thumb/3/35/Nuggets_de_Denver_2018.png/180px-Nuggets_de_Denver_2018.png",
                96
        );
    }

    @Test
    void getId() {
        assertEquals(game.getId(), 1);
    }

    @Test
    void getDateTime() {
        assertEquals(game.getDateTime(), LocalDateTime.of(2015, 10, 2, 20, 30, 0, 0));
    }

    @Test
    void getStatus() {
        assertEquals(game.getStatus(), "Finished");
    }

    @Test
    void getLocation() {
        assertEquals(game.getLocation(), "Staples Center, Los Angeles, CA");
    }

    @Test
    void getHomeTeamID() {
        assertEquals(game.getHomeTeamID(), 16);
    }

    @Test
    void getHomeTeamName() {
        assertEquals(game.getHomeTeamName(), "LA Clippers");
    }

    @Test
    void getHomeTeamCode() {
        assertEquals(game.getHomeTeamCode(), "LAC");
    }

    @Test
    void getHomeTeamLogo() {
        assertEquals(game.getHomeTeamLogo(), "https://upload.wikimedia.org/wikipedia/fr/d/d6/Los_Angeles_Clippers_logo_2010.png");
    }

    @Test
    void getHomeTeamPoints() {
        assertEquals(game.getHomeTeamPoints(), 103);
    }

    @Test
    void getAwayTeamID() {
        assertEquals(game.getAwayTeamID(), 9);
    }

    @Test
    void getAwayTeamName() {
        assertEquals(game.getAwayTeamName(), "Denver Nuggets");
    }

    @Test
    void getAwayTeamCode() {
        assertEquals(game.getAwayTeamCode(), "DEN");
    }

    @Test
    void getAwayTeamLogo() {
        assertEquals(game.getAwayTeamLogo(), "https://upload.wikimedia.org/wikipedia/fr/thumb/3/35/Nuggets_de_Denver_2018.png/180px-Nuggets_de_Denver_2018.png");
    }

    @Test
    void getAwayTeamPoints() {
        assertEquals(game.getAwayTeamPoints(), 96);
    }
}
