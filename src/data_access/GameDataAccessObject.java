package data_access;

import entity.Game;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.schedule.ScheduleDataAccessInterface;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class GameDataAccessObject implements ScheduleDataAccessInterface {
    private final String apiKey;

    public GameDataAccessObject(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Map<Integer, Game> getGames(LocalDate date) {
        // Because the API uses GMT instead of local time, we have to look at two different dates for the API Call
        Map<Integer, Game> allGames = new HashMap<>();
        allGames.putAll(getSomeGames(date, date));
        allGames.putAll(getSomeGames(date, date.plusDays(1)));
        return allGames;
    }

    public Map<Integer, Game> getSomeGames(LocalDate dateWanted, LocalDate dateGiven) {
        OkHttpClient client = new OkHttpClient();
        Map<Integer, Game> games = new HashMap<>();

        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/games?date=" + dateGiven.toString())
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            JSONObject responseGameInfoJSON = new JSONObject(response.body().string());
            JSONArray gamesJSON = responseGameInfoJSON.getJSONArray("response");

            // Iterates through each game, adding them to the
            for (Object game : gamesJSON) {
                JSONObject gameJSON = (JSONObject) game;

                // Converts GMT DateTime to LocalDateTime
                LocalDateTime gameDateTime = LocalDateTime.ofInstant(Instant.parse(gameJSON.getJSONObject("date").getString("start")), ZoneId.systemDefault());
                // Confirms that LocalDateTime is of desired date
                if (!gameDateTime.toLocalDate().isEqual(dateWanted)) {
                    continue;
                }

                // Gets all relevant game info
                int gameID = gameJSON.getInt("id");
                String status = gameJSON.getJSONObject("status").getString("long");
                JSONObject arenaInfo = gameJSON.getJSONObject("arena");
                String location = arenaInfo.getString("name") + ", " + arenaInfo.getString("city") + ", " + arenaInfo.getString("state");

                // Home Team info
                JSONObject homeTeam = gameJSON.getJSONObject("teams").getJSONObject("home");
                JSONObject homeScores = gameJSON.getJSONObject("scores").getJSONObject("home");
                int homeTeamID = homeTeam.getInt("id");
                String homeTeamName = homeTeam.getString("name");
                String homeTeamCode = homeTeam.getString("code");
                String homeTeamLogo = homeTeam.getString("logo");
                // If the game has not started, the points are set to 0
                int homeTeamPoints = 0;
                if(!homeScores.isNull("points")) {
                    homeTeamPoints = homeScores.getInt("points");
                }


                // Away Team info
                JSONObject awayTeam = gameJSON.getJSONObject("teams").getJSONObject("visitors");
                JSONObject awayScores = gameJSON.getJSONObject("scores").getJSONObject("visitors");
                int awayTeamID = awayTeam.getInt("id");
                String awayTeamName = awayTeam.getString("name");
                String awayTeamCode = awayTeam.getString("code");
                String awayTeamLogo = awayTeam.getString("logo");
                // If the game has not started, the points are set to 0
                int awayTeamPoints = 0;
                if(!awayScores.isNull("points")) {
                    awayTeamPoints = awayScores.getInt("points");
                }


                // Creates Game object
                Game currGame = new Game(gameID,
                        gameDateTime,
                        status,
                        location,
                        homeTeamID,
                        homeTeamName,
                        homeTeamCode,
                        homeTeamLogo,
                        homeTeamPoints,
                        awayTeamID,
                        awayTeamName,
                        awayTeamCode,
                        awayTeamLogo,
                        awayTeamPoints);

                games.put(gameID, currGame);
            }
            return games;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
