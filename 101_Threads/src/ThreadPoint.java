import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
        Author: Schlager Daniela
        Date: 27.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 27.09.2019
 */
public class ThreadPoint{
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Point p = new Point();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                int x = (int)(Math.random() *1000), y=x;

                while (true){
                    lock.lock();
                    p.x= x; p.y=y;
                    int xc = p.x, yc = p.y;
                    lock.unlock();
                    if(xc != yc){
                        System.out.println("Aha: x=" + xc + ", y=" + yc);
                    }
                }
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }
}
