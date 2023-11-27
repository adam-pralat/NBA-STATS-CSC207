package interface_adapter.schedule;

import entity.Game;
import interface_adapter.ViewManagerModel;
import use_case.schedule.ScheduleOutputBoundary;
import use_case.schedule.ScheduleOutputData;

import java.util.Map;

public class SchedulePresenter implements ScheduleOutputBoundary {

    private final ScheduleViewModel scheduleViewModel;
    private ViewManagerModel viewManagerModel;

    public SchedulePresenter(ScheduleViewModel scheduleViewModel, ViewManagerModel viewManagerModel) {
        this.scheduleViewModel = scheduleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ScheduleOutputData games) {
        ScheduleState scheduleState = scheduleViewModel.getState();
        scheduleState.setDate(games.getDate());

    }

    @Override
    public void prepareFailView(String error) {
        ScheduleState scheduleState = scheduleViewModel.getState();
        scheduleViewModel.firePropertyChanged();
    }
}
