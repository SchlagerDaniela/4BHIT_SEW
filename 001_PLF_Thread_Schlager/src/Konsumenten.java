import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Konsumenten implements Runnable{
    private Lock lock;
    private Condition c1;
    private Condition c2;
    private Queue<Integer> tresen;
    private String produkt;

    public Konsumenten( Lock lock, Condition c1, Condition c2, Queue<Integer> tresen,  String produkt) {

        this.lock = lock;
        this.c1 = c1;
        this.c2 = c2;
        this.tresen = tresen;

        this.produkt = produkt;
    }

    //Hier werden die Bosna konsumiert
    public void konsumentBosna() throws InterruptedException {
        lock.lock();

        if(tresen == 0){
            c2.await();
        }
        tresen.remove();
        System.out.println("Eine Bosna wurde konsumiert");
        c1.signalAll();
        lock.unlock();
        Thread.sleep(50);
    }

    //Hier werden die Leberkaese konsumiert
    public void konsumentLeberkaese() throws InterruptedException {
        lock.lock();

        if(tresen == 0){
            c2.await();
        }
        tresen.remove();
        System.out.println("Leberkaese wurde konsumiert");
        c1.signalAll();
        lock.unlock();
        Thread.sleep(50);
    }
    @Override
    public void run() {
        try{
            while(true){
                if(produkt =="Bosna"){
                    konsumentBosna();
                }
                if(produkt =="Leberkaese")
                {
                    konsumentLeberkaese();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
