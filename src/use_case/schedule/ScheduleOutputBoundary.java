package use_case.schedule;

public interface ScheduleOutputBoundary {
    void prepareSuccessView(ScheduleOutputData scheduleOutputData);

    void prepareFailView(String error);
}
