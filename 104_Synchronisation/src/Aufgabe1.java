import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
        Author: Schlager Daniela
        Date: 09.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 10.10.2019

        Aufgabe:
        2 Threads bekommen einen Namen
        die Threads sollen abwechselnd laufen und ihren Namen ausgeben
        die Aufgabe soll mit Wartung und Benachrichtigen gelöscht werden
        BSP; Thread 1 heißt "tick", Thread 2 heißt "tack"
 */
public class Aufgabe1 extends Thread {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock(); //Lock Objekt erstellen

        //Conditions erstellen, damit man signal() und await() verwenden kann
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        //Thread1 erzugen
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock(); //damit beide Threads nicht gleichzeitig schreiben
                    System.out.println(Thread.currentThread().getName()); //Namen vom Thread ausgeben
                    c2.signal(); //Thread2 wird ein Signal gegeben
                    c1.await(); //Thread1 soll warten
                    lock.unlock(); //wieder freigeben
                    Thread.sleep(1500); //Thread für 1500 Millisekunden schlafen lassen
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Tick"); //Thread den Namen Tick geben

        //Thread2 erzeugen
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock(); //damit beide Threads nicht gleichzeitig schreiben
                    System.out.println(Thread.currentThread().getName()); //Namen vom Thread ausgeben
                    c1.signal(); //Thread1 wird ein Signal gegeben
                    c2.await(); //Thread2 soll warten
                    lock.unlock(); //wieder freigeben
                    Thread.sleep(1050);//Thread für 1050 Millisekunden schlafen lassen

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "Tack"); //Thread den Namen Tack geben

        //Threads starten
        t1.start();
        t2.start();
    }
}
