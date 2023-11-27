package data_access;

import entity.Game;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.schedule.ScheduleDataAccessInterface;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GameDataAccessObject implements ScheduleDataAccessInterface {

    public Map<Integer, Game> getGames(LocalDate date) {

        OkHttpClient client = new OkHttpClient();

        Map<Integer, Game> games = new HashMap<>();

        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/games?date=" + date.toString())
                .get()
                .addHeader("X-RapidAPI-Key", "5be2241ec5msh71075c7c767ae11p1e2467jsn09115d400b91")
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject responseGameInfoJSON = new JSONObject(response.body().string());
            JSONArray gamesJSON = responseGameInfoJSON.getJSONArray("response");

            for (Object game : gamesJSON) {
                JSONObject gameJSON = (JSONObject) game;

                Integer gameID =  gameJSON.getInt("id");
                String gameDate = gameJSON.getJSONObject("date").getString("start").substring(0, 10);
                String status = gameJSON.getJSONObject("status").getString("long");
                JSONObject arenaInfo = gameJSON.getJSONObject("arena");
                String location = arenaInfo.getString("name") + ", " + arenaInfo.getString("city") +
                        ", " + arenaInfo.getString("state");

                JSONObject homeTeam = gameJSON.getJSONObject("teams").getJSONObject("home");
                JSONObject homeScores = gameJSON.getJSONObject("scores").getJSONObject("home");
                String homeTeamName = homeTeam.getString("name");
                String homeTeamCode = homeTeam.getString("code");
                String homeTeamLogo = homeTeam.getString("logo");
                Integer homeTeamWins = homeScores.getInt("win");
                Integer homeTeamLosses = homeScores.getInt("loss");
                Integer homeTeamPoints = homeScores.getInt("points");

                JSONObject awayTeam = gameJSON.getJSONObject("teams").getJSONObject("visitors");
                JSONObject awayScores = gameJSON.getJSONObject("scores").getJSONObject("visitors");
                String awayTeamName = awayTeam.getString("name");
                String awayTeamCode = awayTeam.getString("code");
                String awayTeamLogo = awayTeam.getString("logo");
                Integer awayTeamWins = awayScores.getInt("win");
                Integer awayTeamLosses = awayScores.getInt("loss");
                Integer awayTeamPoints = awayScores.getInt("points");

                Game currGame = new Game(gameID,
                        gameDate,
                        status,
                        location,
                        homeTeamName,
                        homeTeamCode,
                        homeTeamLogo,
                        homeTeamWins,
                        homeTeamLosses,
                        homeTeamPoints,
                        awayTeamName,
                        awayTeamCode,
                        awayTeamLogo,
                        awayTeamWins,
                        awayTeamLosses,
                        awayTeamPoints);

                games.put(gameID, currGame);
            }
            return games;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
