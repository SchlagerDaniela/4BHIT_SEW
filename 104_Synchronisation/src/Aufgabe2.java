import java.util.concurrent.Semaphore;

/*
        Author: Schlager Daniela
        Date: 09.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 10.10.2019

        Aufgabe:
        löse die selbe Aufgabe mit Semaphoren
 */
public class Aufgabe2 extends Thread {

    static Semaphore sp = new Semaphore(1, true); //Semaphore erstellen, es wird nur ein Thread zugelassen

    public static class MyThreads extends Thread {

        //Constructor
        public MyThreads(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    sp.acquire(); //Semaphore betreten
                    Thread.sleep(1000); //Thread für 1000 Millisekunden schlafen lassen
                    System.out.println(Thread.currentThread().getName()); //Namen vom Thread ausgeben
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    sp.release(); //Semaphore verlassen
                }
            }
        }
    }

    public static void main(String[] args) {

        //Threads erzeugen
        Thread t1 = new MyThreads("tick");
        Thread t2 = new MyThreads("tack");

        //Threads starten
        t1.start();
        t2.start();
    }
}
