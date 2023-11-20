package interface_adapter.player_stats;

import entity.Player;
import use_case.player_stats.PlayerStatsInputBoundary;
import use_case.player_stats.PlayerStatsOutputData;

public class PlayerStatsViewModel {
    // View Model here manages the data for view, and then it also will react to input from user.
    private final PlayerStatsInputBoundary playerStatsInputBoundary;
    private Player player;
    public PlayerStatsViewModel(PlayerStatsInputBoundary playerStatsInputBoundary) {
        this.playerStatsInputBoundary = playerStatsInputBoundary;
    }

    public void fetchPlayerStats(int playerId) {
        // Fetch stats for a specified Player
        // Assuming PlayerStatsInputBoundary will have an implementation of a method that fetches player through
        // player ID
        PlayerStatsOutputData statsData = playerStatsInputBoundary.getPlayerStats(playerId);
        this.player = statsData.getPlayer();
    }

    // create methods that is necessary for user to see. SO far we have names heights points age, more
    // will be decided.
    public String getPlayerName() {
        if (player != null) {
            return player.getFirstName() + " " + player.getLastName();
        }
        return "Unknown Player";
    }

    public String getHeight() {
        if (player != null) {
            return player.getHeight() + " m";
        }
        return "N/A";
    }

    public String getTeamName() {
        if (player != null) {
            return player.getTeam();
        }
        return "Unknown Team";
    }

    public String getPointsPerGame() {
        if (player != null && player.getGamesPlayed() > 0) {
            double avg = (double) player.getPoints() / player.getGamesPlayed();
            return String.format("%.2f", avg);
        }
        return "N/A";
    }

    public String getAssistsPerGame() {
        if (player != null && player.getGamesPlayed() > 0) {
            double avg = (double) player.getAssists() / player.getGamesPlayed();
            return String.format("%.2f", avg);
        }
        return "N/A";
    }

    public String getReboundsPerGame() {
        if (player != null && player.getGamesPlayed() > 0) {
            double avg = (double) (player.getOffensiveRebounds() + player.getDefensiveRebounds()) / player.getGamesPlayed();
            return String.format("%.2f", avg);
        }
        return "N/A";
    }
}
