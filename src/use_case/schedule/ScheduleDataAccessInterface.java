package use_case.schedule;

import entity.Game;

import java.time.LocalDate;
import java.util.Map;

public interface ScheduleDataAccessInterface {

    Map<Integer, Game> getGames(LocalDate date);
}
