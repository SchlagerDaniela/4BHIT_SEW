import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Produzent extends Thread{

    private Lock l;
    private Condition condition;
    private Produkt produkt;
    private Automat automat;

    public Produzent(Lock l, Condition condition, Produkt produkt, Automat automat){
        this.l = l;
        this.condition = condition;
        this.produkt = produkt;
        this.automat = automat;

    }

    @Override
    public void run(){
        while (true){
            l.lock();

            //Warten wenn Automat voll
            while(automat.isFull()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Produkt hinzufügen
            automat.addProdukt(produkt);
            condition.signalAll();
            l.unlock();

            //Produktionszeit
            try {
                Thread.sleep(produkt.getProduktionszeit());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
