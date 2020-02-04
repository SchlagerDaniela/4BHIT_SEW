package model;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.util.Duration;

public class MyService extends Service<Integer> /*ScheduledService<Integer>*/ {

    private final int max;

    public MyService(int max) {
        this.max = max;
        //setPeriod(Duration.seconds(2));
    }

    @Override
    protected Task<Integer> createTask() {
        return new MyTask(max);
    }
}
