import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Konsument extends Thread {

    Lock lock;
    Condition condition;
    Calculation calc;
    Queue queue;

    public Konsument(Lock lock, Condition condition, Calculation calc, Queue queue) {
        this.lock = lock;
        this.condition = condition;
        this.calc = calc;
        this.queue = queue;
    }

    @Override
    public void run(){
        while(true){

            lock.lock();
            while(queue.size() == 0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Rechnung holen
            Calculation rm = (Calculation) queue.poll();
            int ergebnis = rm.calculate();
            System.out.println("Berechnet: "+ rm.getA() + rm.getB() +  "Ergebnis: " + ergebnis );

            //Berechnungsdauer
                try {
                Thread.sleep(calc.getBerechnungsdauer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            lock.unlock();

        }
    }
}
