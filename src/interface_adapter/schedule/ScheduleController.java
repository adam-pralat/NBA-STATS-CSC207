package interface_adapter.schedule;

import use_case.schedule.ScheduleInputBoundary;
import use_case.schedule.ScheduleInputData;

import java.time.LocalDate;

public class ScheduleController {

    final ScheduleInputBoundary scheduleUseCaseInteractor;

    public ScheduleController(ScheduleInputBoundary scheduleUseCaseInteractor) {
        this.scheduleUseCaseInteractor = scheduleUseCaseInteractor;
    }

    public void execute(LocalDate date) {
        ScheduleInputData scheduleInputData = new ScheduleInputData(date);
        scheduleUseCaseInteractor.execute(scheduleInputData);
    }
}
