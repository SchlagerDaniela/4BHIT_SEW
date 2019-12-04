/*
        Author: Schlager Daniela
        Date: 13.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 20.09.2019
 */
public class ThreadMain {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadCount(), "Count 1");
        Thread t2 = new Thread(new ThreadData(), "Date 1");

        t1.start();
        t2.start();

        new Thread(new ThreadCount(), "Count 2").start();

        Thread it = new InterruptThread();
        it.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        it.interrupt();
    }
}
