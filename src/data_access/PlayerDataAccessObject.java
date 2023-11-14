package data_access;

import entity.Player;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class PlayerDataAccessObject {
    public static void main(String args[]) {
        Player result = getPlayerStats(236, 2017);
        System.out.println(result.pointsPerGame());
        System.out.println(result.assistsPerGame());
        System.out.println(result.reboundsPerGame());
        System.out.println(result.stealsPerGame());
    }
    public static Player getPlayerStats(int playerId, int season) throws JSONException {
        // Get a player's stats over a season
        OkHttpClient clientPlayerInfo = new OkHttpClient();

        Request playerInfoRequest = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/players?id=" + playerId)
                .get()
                .addHeader("X-RapidAPI-Key", "7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09")
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        try {
            Response playerInfoResponse = clientPlayerInfo.newCall(playerInfoRequest).execute();

            JSONObject responsePlayerInfoJSON = new JSONObject(playerInfoResponse.body().string());
            JSONObject playerInfoJSON = (JSONObject) responsePlayerInfoJSON.getJSONArray("response").get(0);
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

            OkHttpClient playerStatsClient = new OkHttpClient();

            Request playerStatsRequest = new Request.Builder()
                    .url("https://api-nba-v1.p.rapidapi.com/players/statistics?id=" + playerId + "&season=" + season)
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
                    System.out.println(gameJSONObject);
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
                playerObject.setGamesPlayed(gamesPlayed);
                playerObject.setPoints(points);
                playerObject.setAssists(assists);
                playerObject.setTimePlayed(timePlayed);
                playerObject.setFieldGoalsMade(fieldGoalsMade);
                playerObject.setFieldGoalsAttempted(fieldGoalsAttempted);
                playerObject.setFreeThrowsMade(freeThrowsMade);
                playerObject.setFreeThrowsAttempted(freeThrowsAttempted);
                playerObject.setThreePointsMade(threePointsMade);
                playerObject.setThreePointsAttempted(threePointsAttempted);
                playerObject.setOffensiveRebounds(offensiveRebounds);
                playerObject.setDefensiveRebounds(defensiveRebounds);
                playerObject.setPersonalFouls(personalFouls);
                playerObject.setSteals(steals);
                playerObject.setTurnovers(turnovers);
                playerObject.setBlocks(blocks);
                playerObject.setPlusMinus(plusMinus);
                return playerObject;
            }
            catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static int convertMinutesStringToSeconds(String minutesString) {
        String[] parts = minutesString.split(":"); // Split string into minutes and seconds
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return 60 * minutes + seconds;
    }
}
