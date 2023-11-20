package data_access;

import entity.Player;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlayerDataAccessObject {
    public static void main(String args[]) {
        System.out.println(existsById(100000));
    }

    public static boolean existsById(int playerID) throws JSONException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/players?id=" + playerID)
                .get()
                .addHeader("X-RapidAPI-Key", "7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09")
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
    public static Player getPlayerInfo(int playerID) throws JSONException {
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
            Player playerObject = new Player(
                    playerInfoJSON.getInt("id"),
                    playerInfoJSON.getString("firstname"),
                    playerInfoJSON.getString("lastname"),
                    playerInfoJSON.getJSONObject("birth").getString("date"),
                    playerInfoJSON.getJSONObject("birth").getString("country"),
                    playerInfoJSON.getJSONObject("height").getDouble("meters"),
                    playerInfoJSON.getJSONObject("weight").getDouble("kilograms"),
                    "",
                    playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").getString("pos"),
                    playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").getInt("jersey"),
                    playerInfoJSON.getJSONObject("leagues").getJSONObject("standard").getBoolean("active"),
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

    public static Map<String, Object> getPlayerYearlyStats(int playerID, int season) {
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
                        gameJSONObject.get("points").equals(null) |
                                gameJSONObject.get("assists").equals(null) |
                                gameJSONObject.get("min").equals(null) |
                                gameJSONObject.get("fgm").equals(null) |
                                gameJSONObject.get("fga").equals(null) |
                                gameJSONObject.get("ftm").equals(null) |
                                gameJSONObject.get("fta").equals(null) |
                                gameJSONObject.get("tpm").equals(null) |
                                gameJSONObject.get("tpa").equals(null) |
                                gameJSONObject.get("offReb").equals(null) |
                                gameJSONObject.get("defReb").equals(null) |
                                gameJSONObject.get("pFouls").equals(null) |
                                gameJSONObject.get("steals").equals(null) |
                                gameJSONObject.get("turnovers").equals(null) |
                                gameJSONObject.get("blocks").equals(null) |
                                gameJSONObject.get("plusMinus").equals(null)
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
    private static int convertMinutesStringToSeconds(String minutesString) {
        String[] parts = minutesString.split(":"); // Split string into minutes and seconds
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return 60 * minutes + seconds;
    }
}
