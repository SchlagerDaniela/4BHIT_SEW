import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class main {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Pepsi pe = new Pepsi();
        CornyBig cb = new CornyBig();
        Cola co = new Cola();

        Automat automat = new Automat();

        new Produzent(lock, condition, pe, automat).start();
        new Produzent(lock, condition, cb, automat).start();
        new Produzent(lock, condition, co, automat).start();


        new Konsument(lock, condition, pe, automat).start();
        new Konsument(lock, condition, pe, automat).start();

        new Konsument(lock, condition, cb, automat).start();
        new Konsument(lock, condition, cb, automat).start();

        new Konsument(lock, condition, co, automat).start();
        new Konsument(lock, condition, co, automat).start();


    }


}
