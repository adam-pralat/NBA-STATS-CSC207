package use_case.schedule;

import entity.Game;

import java.time.LocalDate;
import java.util.Map;

public class ScheduleInteractor implements ScheduleInputBoundary {
    final ScheduleDataAccessInterface dataAccessObject;
    final ScheduleOutputBoundary schedulePresenter;

    public ScheduleInteractor(ScheduleDataAccessInterface dataAccessObject, ScheduleOutputBoundary schedulePresenter) {
        this.dataAccessObject = dataAccessObject;
        this.schedulePresenter = schedulePresenter;
    }

    @Override
    public void execute(ScheduleInputData scheduleInputData) {
        LocalDate date = scheduleInputData.getDate();

        try {
            Map<Integer, Game> games = dataAccessObject.getGames(date);
            schedulePresenter.prepareSuccessView(new ScheduleOutputData(date, games, false));
        } catch (Exception e) {
            schedulePresenter.prepareFailView(e.toString());
        }
    }
}
