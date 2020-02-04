import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Produzent extends Thread{

    Lock lock;
    Condition condition;
    Calculation calc;
    Queue queue;

    public Produzent(Lock lock, Condition condition, Calculation calc, Queue queue) {
        this.lock = lock;
        this.condition = condition;
        this.calc = calc;
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){


            lock.lock();
            //hinzufügen
            queue.add(new Calculation(calc.getA(), calc.getB(),calc.getBerechnungsdauer()));
            System.out.println("Added: " + calc.getA() + calc.getB());

            //Produktionszeit
            int produktionszeit = (int)(Math.round(Math.random()*10) + 10);
            try {
                Thread.sleep(produktionszeit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();

            lock.unlock();



            /*try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        }
    }
}
