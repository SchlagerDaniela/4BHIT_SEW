import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Konsument extends Thread{
    private Lock lock;
    private Condition condition;
    private Produkt produkt;
    private Automat automat;

    public Konsument(Lock lock, Condition condition, Produkt produkt, Automat automat){
        this.lock = lock;
        this.condition = condition;
        this.produkt = produkt;
        this.automat = automat;
    }

    @Override
    public void run(){
        while(true){
             int sleeptime = (int) (Math.round(Math.random()*20)+5);

             //Ueberlegen
            try {
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            //Wenn Automat leer, warte!
            while(automat.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean getPro = automat.getProdukt(produkt);

            while(!getPro){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getPro = automat.getProdukt(produkt);
            }
            condition.signalAll();
            lock.unlock();

            /*try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
