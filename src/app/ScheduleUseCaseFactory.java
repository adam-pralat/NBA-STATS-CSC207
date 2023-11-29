package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.SchedulePresenter;
import interface_adapter.schedule.ScheduleViewModel;
import use_case.schedule.ScheduleDataAccessInterface;
import use_case.schedule.ScheduleInputBoundary;
import use_case.schedule.ScheduleInteractor;
import use_case.schedule.ScheduleOutputBoundary;
import view.ScheduleView;

public class ScheduleUseCaseFactory {
    private ScheduleUseCaseFactory() {}

    public static ScheduleView create(
            ViewManagerModel viewManagerModel, ScheduleViewModel scheduleViewModel, ScheduleDataAccessInterface scheduleDAO) {

        ScheduleController scheduleController = createScheduleUseCase(viewManagerModel, scheduleViewModel, scheduleDAO);
        return new ScheduleView(scheduleController, scheduleViewModel);

    }

    private static ScheduleController createScheduleUseCase(ViewManagerModel viewManagerModel, ScheduleViewModel scheduleViewModel, ScheduleDataAccessInterface scheduleDataAccessObject) {

        ScheduleOutputBoundary scheduleOutputBoundary = new SchedulePresenter(scheduleViewModel, viewManagerModel);

        ScheduleInputBoundary scheduleInteractor = new ScheduleInteractor(
                scheduleDataAccessObject, scheduleOutputBoundary);

        return new ScheduleController(scheduleInteractor);
    }
}
