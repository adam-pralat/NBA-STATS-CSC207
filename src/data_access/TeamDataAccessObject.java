package data_access;

import entity.Team;
import entity.TeamRecord;
import entity.TeamStats;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TeamDataAccessObject {
    private Object jsonNull = JSONObject.NULL;// JSON value for null
    private final String apiKey;
    public TeamDataAccessObject(String apiKey){
        this.apiKey = apiKey;
    }
    public boolean existsById(int teamID) throws JSONException {
        // Return whether TeamID is in predetermined list of ID's corresponding to NBA teams
        int[] possibleTeamIDs = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 38, 41};
        return Arrays.asList(possibleTeamIDs).contains(teamID);
    }

    public Team getTeamInfo(int teamID) throws JSONException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/teams?id=" + teamID)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject responseJSON = new JSONObject(response.body().string());
            JSONObject teamInfoJSON = (JSONObject) responseJSON.getJSONArray("response").get(0);
            return new Team(
                    teamID,
                    (teamInfoJSON.get("name") != jsonNull) ? (teamInfoJSON.getString("name")) : (""),
                    (teamInfoJSON.get("nickname") != jsonNull) ? (teamInfoJSON.getString("nickname")) : (""),
                    (teamInfoJSON.get("code") != jsonNull) ? (teamInfoJSON.getString("code")) : (""),
                    (teamInfoJSON.get("city") != jsonNull) ? (teamInfoJSON.getString("city")) : (""),
                    (teamInfoJSON.get("logo") != jsonNull) ? (teamInfoJSON.getString("logo")) : (""),
                    (teamInfoJSON.get("leagues") != jsonNull && teamInfoJSON.getJSONObject("leagues").get("standard") != jsonNull &&  teamInfoJSON.getJSONObject("leagues").getJSONObject("standard").get("conference") != jsonNull) ? (teamInfoJSON.getJSONObject("leagues").getJSONObject("standard").getString("conference")) : "",
                    new ArrayList<>(),
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

        } catch (Exception e) {
            throw new JSONException(e);
        }
    }

    public TeamRecord getYearlyRecord(int teamID, int season) throws JSONException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/standings?league=standard&season=" + season + "&team=" + teamID)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseJSON = new JSONObject(response.body().string());
            JSONObject teamRecordJSON = (JSONObject) responseJSON.getJSONArray("response").get(0);

            // TODO: Use teamBuilder to make team with addStat...?
            // Return a team with only the relevant fields filled (Makes easier to build team object from stats)
            return new TeamRecord(
                    (teamRecordJSON.get("win") != jsonNull &&  teamRecordJSON.getJSONObject("win").get("total") != jsonNull) ? (teamRecordJSON.getJSONObject("win").getInt("total")) : 0,
                    (teamRecordJSON.get("loss") != jsonNull &&  teamRecordJSON.getJSONObject("loss").get("total") != jsonNull) ? (teamRecordJSON.getJSONObject("loss").getInt("total")) : 0,
                    (teamRecordJSON.get("win") != jsonNull &&  teamRecordJSON.getJSONObject("win").get("lastTen") != jsonNull) ? (teamRecordJSON.getJSONObject("win").getInt("lastTen")) : 0,
                    (teamRecordJSON.get("loss") != jsonNull &&  teamRecordJSON.getJSONObject("win").get("lastTen") != jsonNull) ? (teamRecordJSON.getJSONObject("loss").getInt("lastTen")) : 0,
                    (teamRecordJSON.get("conference") != jsonNull &&  teamRecordJSON.getJSONObject("conference").get("rank") != jsonNull) ? (teamRecordJSON.getJSONObject("conference").getInt("rank")) : 0
            );
        } catch (Exception e) {
            throw new JSONException(e);
        }
    }

    public TeamStats getTeamYearlyStats(int teamID, int season) throws JSONException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-nba-v1.p.rapidapi.com/teams/statistics?id=" + teamID + "&season=" + season)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseJSON = new JSONObject(response.body().string());
            JSONObject teamStatsJSON = (JSONObject) responseJSON.getJSONArray("response").get(0);

            // TODO: Use teamBuilder to make team with addStat...?
            // Return a team with only the relevant fields filled (Makes easier to build team object from stats)
            return new TeamStats(
                    (teamStatsJSON.get("games") != jsonNull) ? (teamStatsJSON.getInt("games")) : 0,
                    (teamStatsJSON.get("fastBreakPoints") != jsonNull) ? (teamStatsJSON.getInt("fastBreakPoints")) : 0,
                    (teamStatsJSON.get("pointsInPaint") != jsonNull) ? (teamStatsJSON.getInt("pointsInPaint")) : 0,
                    (teamStatsJSON.get("secondChancePoints") != jsonNull) ? (teamStatsJSON.getInt("secondChancePoints")) : 0,
                    (teamStatsJSON.get("pointsOffTurnovers") != jsonNull) ? (teamStatsJSON.getInt("pointsOffTurnovers")) : 0,
                    (teamStatsJSON.get("points") != jsonNull) ? (teamStatsJSON.getInt("points")) : 0,
                    (teamStatsJSON.get("fgm") != jsonNull) ? (teamStatsJSON.getInt("fgm")) : 0,
                    (teamStatsJSON.get("fga") != jsonNull) ? (teamStatsJSON.getInt("fga")) : 0,
                    (teamStatsJSON.get("ftm") != jsonNull) ? (teamStatsJSON.getInt("ftm")) : 0,
                    (teamStatsJSON.get("fta") != jsonNull) ? (teamStatsJSON.getInt("fta")) : 0,
                    (teamStatsJSON.get("tpm") != jsonNull) ? (teamStatsJSON.getInt("tpm")) : 0,
                    (teamStatsJSON.get("tpa") != jsonNull) ? (teamStatsJSON.getInt("tpa")) : 0,
                    (teamStatsJSON.get("offReb") != jsonNull) ? (teamStatsJSON.getInt("offReb")) : 0,
                    (teamStatsJSON.get("defReb") != jsonNull) ? (teamStatsJSON.getInt("defReb")) : 0,
                    (teamStatsJSON.get("assists") != jsonNull) ? (teamStatsJSON.getInt("assists")) : 0,
                    (teamStatsJSON.get("pFouls") != jsonNull) ? (teamStatsJSON.getInt("pFouls")): 0,
                    (teamStatsJSON.get("steals") != jsonNull) ? (teamStatsJSON.getInt("steals")): 0,
                    (teamStatsJSON.get("turnovers") != jsonNull) ? (teamStatsJSON.getInt("turnovers")): 0,
                    (teamStatsJSON.get("blocks") != jsonNull) ? (teamStatsJSON.getInt("blocks")): 0,
                    (teamStatsJSON.get("plusMinus") != jsonNull) ? (teamStatsJSON.getInt("plusMinus")): 0
            );
        } catch (Exception e) {
            throw new JSONException(e);
        }
    }
}
