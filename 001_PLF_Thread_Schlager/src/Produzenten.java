import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Produzenten implements Runnable {
    private Lock lock;
    private Condition c1;
    private Condition c2;
    private Queue<Integer> tresen;
    private int kapazitaet;
    private String produkt;

    public Produzenten( Lock lock, Condition c1, Condition c2, Queue<Integer> tresen, int kapazitaet, String produkt) {

        this.lock = lock;
        this.c1 = c1;
        this.c2 = c2;
        this.tresen = tresen;
        this.kapazitaet = kapazitaet;
        this.produkt = produkt;
    }

    public void produzentBosna() throws InterruptedException {
        lock.lock();

        int wert =(int) (Math.random()*40);
        //Wenn die Kapazität erreicht ist soll aufgehört werden zu produzieren bis wieder Platz ist
        if(tresen == kapazitaet){
            c1.await();
        }
        //Bosna wird auf den Tresen gelegt
        tresen.add(wert);
        System.out.println("Auf dem Tresen liegen" + tresen.size() + "/40 Produkte - Bosna wurde produziert");
        lock.unlock();
        //Kosument wird aufgeweckt
        c2.signalAll();
        Thread.sleep(20);
    }

    public void produzentLeberkaese() throws InterruptedException {
        lock.lock();

        int wert = (int)(Math.random()*40);
        //Wenn die Kapazität erreicht ist soll aufgehört werden zu produzieren bis wieder platz ist
        if(tresen == kapazitaet){
            c1.await();
        }
        //Leberkaese wird auf den tresen gelegt
        tresen.add(wert);
        System.out.println("Auf dem Tresen liegen" + tresen.size() + "/40 Produkte - Leberkaese wurde produziert");
        lock.unlock();
        //Kosument wird aufgeweckt
        c2.signalAll();
        Thread.sleep(10);
    }

    @Override
    public void run() {
        try{
            while(true){
                if(produkt =="Bosna"){
                    produzentBosna();
                }
                if(produkt =="Leberkaese")
                {
                    produzentLeberkaese();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
