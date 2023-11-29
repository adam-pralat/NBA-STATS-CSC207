package use_case.schedule;

import java.time.LocalDate;

public class ScheduleInputData {
    final private LocalDate date;

    public ScheduleInputData(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
