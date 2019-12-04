import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
        Author: Schlager Daniela
        Date: 03.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 10.10.2019
 */
public class Football {

    /*LinkedList<Integer> fliessband = new LinkedList<>(); //Fließband in Form einer LinkedList
    int kapazitaet = 10; //So viele Footballs können auf das Fließband gelegt werden


    //Methode für das produzieren bzw hinlegen von Footballs auf das Fließband
    public void produziere()  throws InterruptedException{
        int wert = 0;
        while(true){
            synchronized (this){
                //Producer wartet wenn die Kapazität vom Fließband voll ist
                while(fliessband.size() == kapazitaet){
                    wait();
                }
                System.out.println("Produzent produzierte " + wert + " footballs");
                fliessband.add(wert++);
                notifyAll(); //hier wird der Consumer informiert, das etwas am Fließband liegt
                Thread.sleep(1000); //Lässt den Thread 1sek schlafen
            }
        }
    }

    //Methode für das wegnehmen des Footballs vom Fließband
    public void konsumiere() throws InterruptedException{
        while(true){
            synchronized (this){
                //Es soll gewartet werden mit dem Football wegnehmen wenn keines auf dem Fließband liegt
                while(fliessband.size()==0){
                    wait();
                }
                int wert = fliessband.removeFirst(); //hier wird der Football entfernt
                System.out.println("Consumer hat einen Football vom Fließband entfernt.");
                notifyAll();//Weckt den Producer Thread auf
                Thread.sleep(1000); //Lässt den Thread 1sek schlafen
            }
        }
    }*/

    //Attribute
    Queue<Integer> fliessband = new LinkedList<>(); //Fließband
    int kapazitaet = 10; //So viele Footballs können auf das Fließband gelegt werden

    Lock lock = new ReentrantLock(); //Lock Objekt erzeugen

    //Conditions erstellen, damit man signal() und await() verwenden kann
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public void produziere() throws InterruptedException {
        int wert = (int) (Math.random() * 10);
        lock.lock();

        //Producer wartet wenn die Kapazität vom Fließband voll ist
        if (fliessband.size() == kapazitaet) {
            c1.await();
        }

        fliessband.add(wert);
        System.out.println("Produzent produzierte " + fliessband.size() + "/10 footballs");
        c2.signal(); //hier wird der Consumer informiert, das etwas am Fließband liegt
        lock.unlock();
        Thread.sleep((int) (Math.random() * 1000)); //Lässt den Thread schlafen
    }

    public void konsumiere() throws InterruptedException {
        lock.lock();
        //Es soll gewartet werden mit dem Football wegnehmen wenn keines auf dem Fließband liegt
        if (fliessband.size() != kapazitaet) {
            c2.await();
        }
        int wert = fliessband.remove(); //hier wird der Football entfernt
        System.out.println("Consumer hat Football " + fliessband.size() + "/10 vom Fließband entfernt.");
        c1.signal(); //Weckt den Producer Thread auf
        lock.unlock();
        Thread.sleep((int) (Math.random() * 1000)); //Lässt den Thread schlafen
    }

    public static void main(String[] args) throws InterruptedException {

        Football fb = new Football();

        //Threads erzeugen
        Thread p = new Thread(new Producer(fb));
        Thread c = new Thread(new Consumer(fb));

        //Threads starten
        p.start();
        c.start();
    }
}
