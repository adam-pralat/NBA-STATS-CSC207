package data_access;

import entity.Player;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.player_stats.PlayerStatsDataAccessInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// TODO: Issue - API rate limit is hit + Get FG% and 3P% and FT%

public class PlayerDataAccessObject implements PlayerStatsDataAccessInterface {
    private Object jsonNull = JSONObject.NULL;// JSON value for null
    private final String apiKey;

    public PlayerDataAccessObject(String apiKey) {
        this.apiKey = apiKey;
    }

    public static void main(String args[]) {
        // System.out.println(existsById(100000));
    }

    public boolean existsById(int playerID) throws JSONException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/players?id=" + playerID)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject responseJSON = new JSONObject(response.body().string());
            return responseJSON.getInt("results") > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public Player getPlayerInfo(int playerID) throws JSONException {
        // Get a player's stats over a season
        // Returns player object with basic information (Does not vary season-to-season)

        OkHttpClient clientPlayerInfo = new OkHttpClient();

        Request playerInfoRequest = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/players?id=" + playerID)
                .get()
                .addHeader("X-RapidAPI-Key", "7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09")
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        try {
            Response playerInfoResponse = clientPlayerInfo.newCall(playerInfoRequest).execute();

            JSONObject responsePlayerInfoJSON = new JSONObject(playerInfoResponse.body().string());
            JSONObject playerInfoJSON = (JSONObject) responsePlayerInfoJSON.getJSONArray("response").get(0);


            // Check issue
            // Load player object with basic information
            // Default values:
            //  Strings are set to an empty string if the value is not found by the API
            //  Height and weight are both set to 0.0 if not found by the API
            //  Jersey number is set to -1 if not found by the API
            //  Active is set to false if not found by the api

            Player playerObject = new Player(
                    playerID,
                    (playerInfoJSON.get("firstname") != jsonNull) ? (playerInfoJSON.getString("firstname")) : (""),
                    (playerInfoJSON.get("lastname") != jsonNull) ? (playerInfoJSON.getString("lastname")) : (""),
                    (playerInfoJSON.get("birth") != jsonNull && playerInfoJSON.getJSONObject("birth").get("date") != jsonNull) ? (playerInfoJSON.getJSONObject("birth").getString("date")) : (""),
                    (playerInfoJSON.get("birth") != jsonNull && playerInfoJSON.getJSONObject("birth").get("country") != jsonNull) ? (playerInfoJSON.getJSONObject("birth").getString("country")) : (""),
                    (playerInfoJSON.get("height") != jsonNull && playerInfoJSON.getJSONObject("height").get("meters") != jsonNull) ? (playerInfoJSON.getJSONObject("height").getDouble("meters")) : (0.0),
                    (playerInfoJSON.get("weight") != jsonNull && playerInfoJSON.getJSONObject("weight").get("kilograms") != jsonNull) ? (playerInfoJSON.getJSONObject("weight").getDouble("kilograms")) : (0.0),
                    "", // Team name - Figure this one out
                    (playerInfoJSON.get("leagues") != jsonNull && playerInfoJSON.getJSONObject("leagues").get("standard") != jsonNull &&  playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").get("pos") != jsonNull) ? ( playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").getString("pos")) : (""),
                    (playerInfoJSON.get("leagues") != jsonNull && playerInfoJSON.getJSONObject("leagues").get("standard") != jsonNull &&  playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").get("jersey") != jsonNull) ? (playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").getInt("jersey")) : (-1),
                    (playerInfoJSON.get("leagues") != jsonNull && playerInfoJSON.getJSONObject("leagues").get("standard") != jsonNull &&  playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").get("active") != jsonNull) ? (playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").getBoolean("active")) : (false),
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
            return playerObject;
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Object> getPlayerYearlyStats(int playerID, int season) {
        Map<String, Object> playerStats = new HashMap<String, Object>();
        OkHttpClient playerStatsClient = new OkHttpClient();

        Request playerStatsRequest = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/players/statistics?id=" + playerID + "&season=" + season)
                .get()
                .addHeader("X-RapidAPI-Key", "7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09")
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        // Get Player game stats
        try {
            Response playerStatsResponse = playerStatsClient.newCall(playerStatsRequest).execute();

            // Display API response
            // System.out.println(response);

            JSONObject playerStatsResponseJSON = new JSONObject(playerStatsResponse.body().string());
            System.out.println(playerStatsResponseJSON);
            JSONArray gameStatsJSON = playerStatsResponseJSON.getJSONArray("response");

            // Add player stats to existing player object
            int gamesPlayed = 0;
            int points = 0;
            int assists = 0;
            int timePlayed = 0;
            int fieldGoalsMade = 0;
            int fieldGoalsAttempted = 0;
            int freeThrowsMade = 0;
            int freeThrowsAttempted = 0;
            int threePointsMade = 0;
            int threePointsAttempted = 0;
            int offensiveRebounds = 0;
            int defensiveRebounds = 0;
            int personalFouls = 0;
            int steals = 0;
            int turnovers = 0;
            int blocks = 0;
            int plusMinus = 0;
            for (Object game: gameStatsJSON) {
                // Check error where null messes it up - Convert to hashmap??
                // Check if null - If not proceed as normal, otherwise don't change stat
                JSONObject gameJSONObject = (JSONObject) game;
                // If any of the metrics are null - Omit this record
                if (
                        gameJSONObject.get("points").equals(jsonNull) |
                                gameJSONObject.get("assists").equals(jsonNull) |
                                gameJSONObject.get("min").equals(jsonNull) |
                                gameJSONObject.get("fgm").equals(jsonNull) |
                                gameJSONObject.get("fga").equals(jsonNull) |
                                gameJSONObject.get("ftm").equals(jsonNull) |
                                gameJSONObject.get("fta").equals(jsonNull) |
                                gameJSONObject.get("tpm").equals(jsonNull) |
                                gameJSONObject.get("tpa").equals(jsonNull) |
                                gameJSONObject.get("offReb").equals(jsonNull) |
                                gameJSONObject.get("defReb").equals(jsonNull) |
                                gameJSONObject.get("pFouls").equals(jsonNull) |
                                gameJSONObject.get("steals").equals(jsonNull) |
                                gameJSONObject.get("turnovers").equals(jsonNull) |
                                gameJSONObject.get("blocks").equals(jsonNull) |
                                gameJSONObject.get("plusMinus").equals(jsonNull)
                )
                    continue;
                gamesPlayed += 1;
                points += gameJSONObject.getInt("points");
                assists += gameJSONObject.getInt("assists");
                timePlayed += convertMinutesStringToSeconds(gameJSONObject.getString("min"));
                fieldGoalsMade += gameJSONObject.getInt("fgm");
                fieldGoalsAttempted += gameJSONObject.getInt("fga");
                freeThrowsMade += gameJSONObject.getInt("ftm");
                freeThrowsAttempted += gameJSONObject.getInt("fta");
                threePointsMade += gameJSONObject.getInt("tpm");
                threePointsAttempted += gameJSONObject.getInt("tpa");
                offensiveRebounds += gameJSONObject.getInt("offReb");
                defensiveRebounds += gameJSONObject.getInt("defReb");
                personalFouls += gameJSONObject.getInt("pFouls");
                steals += gameJSONObject.getInt("steals");
                turnovers += gameJSONObject.getInt("turnovers");
                blocks += gameJSONObject.getInt("blocks");
                plusMinus += Integer.parseInt(gameJSONObject.getString("plusMinus"));
            }

            // Set player attributes
            playerStats.put("gamesPlayed", gamesPlayed);
            playerStats.put("points", points);
            playerStats.put("assists", assists);
            playerStats.put("timePlayed", timePlayed);
            playerStats.put("fieldGoalsMade", fieldGoalsMade);
            playerStats.put("fieldGoalsAttempted", fieldGoalsAttempted);
            playerStats.put("freeThrowsMade", freeThrowsMade);
            playerStats.put("freeThrowsAttempted", freeThrowsAttempted);
            playerStats.put("threePointsMade", threePointsMade);
            playerStats.put("threePointsAttempted", threePointsAttempted);
            playerStats.put("offensiveRebounds", offensiveRebounds);
            playerStats.put("defensiveRebounds", defensiveRebounds);
            playerStats.put("personalFouls", personalFouls);
            playerStats.put("steals", steals);
            playerStats.put("turnovers", turnovers);
            playerStats.put("blocks", blocks);
            playerStats.put("plusMinus", plusMinus);
            return playerStats;
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: Put in different file??
    private int convertMinutesStringToSeconds(String minutesString) {
        String[] parts = minutesString.split(":"); // Split string into minutes and seconds
        if (parts.length == 2) {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return 60 * minutes + seconds;
        } else {
            return 60 * Integer.parseInt(parts[0]);
        }
    }
}
