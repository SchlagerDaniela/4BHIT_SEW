package model;

import javafx.concurrent.Task;

public class MyTask extends Task<Integer> {

    private final int max;

    public MyTask(int max){
        this.max = max;
        updateMessage("Ready to count");
    }

    @Override
    protected Integer call() throws Exception {
        updateMessage("Counting...");
        for (int i = 0; i < max ; i++) {
            Thread.sleep(10);
            updateProgress(i, max);
        }
        updateMessage("Ready");
        return max;
    }
}
