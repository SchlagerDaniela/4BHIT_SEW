package model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.File;

public class MyService extends Service<Integer> {

    File file;
    int keylength;

    public MyService() {
    }

    public MyService(File file, int keylength) {
        this.file = file;
        this.keylength = keylength;
    }

    @Override
    protected Task<Integer> createTask() {
        return new MyTask(file, keylength);
    }
}
