import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Klassenhierarchie extends Thread{

    public static void main(String[] args) {

        String produkt1 = "Bosna";
        String produkt2 = "Leberkaese";
        Lock lock = new ReentrantLock();
        Queue<Integer> tresen= new LinkedList<>();

        int kapazitaet = 40;

        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        //Produzenten werden erzeugt
        Thread t1 = new Thread(new Produzenten(lock,c1,c2,tresen, kapazitaet,  "Bosna"));
        Thread t2 = new Thread(new Produzenten(lock,c1,c2,tresen, kapazitaet, "Leberkaese"));


        //Konsumenten werden erzeugt
        Thread t3 = new Thread(new Konsumenten(lock,c1,c2,tresen, "Bosna"));
        Thread t4 = new Thread(new Konsumenten(lock,c1,c2,tresen, "Bosna"));
        Thread t5 = new Thread(new Konsumenten(lock,c1,c2,tresen, "Leberkaese"));
        Thread t6 = new Thread(new Konsumenten(lock,c1,c2,tresen, "Leberkaese"));

        //Konsumenten und Produzenten werden gestartet
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
