package model;

import javafx.concurrent.Task;

import java.io.*;
import java.util.Random;

public class MyTask extends Task<Integer> {

    File file;
    int keylength;

    int aktWert = 0;
    int data = -1;

    public MyTask(File file, int keylength) {
        this.file = file;
        this.keylength = keylength;

    }

    @Override
    protected Integer call() throws Exception {


        try (OutputStream os = new FileOutputStream(file);) { // HELT: Textdatei!
            updateMessage("Generating Key No. 30"); // HELT: es soll gezählt werden!

            int rand;
            while (data != 0) {

                for (int i = 0; i < keylength; i++) {
                    Random random = new Random();
                    rand = random.nextInt(90);
                    os.write(rand);
                    aktWert++;
                    updateProgress(aktWert, keylength); // HELT: aktWert ist falsch -> i verwenden!
                    Thread.sleep(10);
                }

            }
            updateMessage("Finished");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return keylength;
    }
}

