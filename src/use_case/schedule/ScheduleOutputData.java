package use_case.schedule;

import entity.Game;

import java.time.LocalDate;
import java.util.Map;

public class ScheduleOutputData {
    private final Map<Integer, Game> games;
    private final LocalDate date;
    private boolean useCaseFailed;

    public ScheduleOutputData(LocalDate date, Map<Integer, Game> games, boolean useCaseFailed) {
        this.date = date;
        this.games = games;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<Integer, Game> getGames() {
        return games;
    }
    public LocalDate getDate() {
        return date;
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
