import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Queue queue = new LinkedList<>();

        Subtrahieren subtrahieren = new Subtrahieren();
        Multiplizieren multiplizieren = new Multiplizieren();
        Dividieren dividieren = new Dividieren();
        Addieren addieren = new Addieren();



        new Produzent(lock, condition, subtrahieren, queue).start();
        new Produzent(lock, condition, multiplizieren, queue).start();

        new Konsument(lock, condition, subtrahieren, queue).start();
        new Konsument(lock, condition, multiplizieren, queue).start();

    }
}
