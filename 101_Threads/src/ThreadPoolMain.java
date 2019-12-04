import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
        Author: Schlager Daniela
        Date: 26.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 26.09.2019
 */
public class ThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {

        //Lambda Expression
        Runnable r1=() -> {
            System.out.println("A1"+Thread.currentThread());
            System.out.println("A2"+Thread.currentThread());
        };

        //Anonyme innere Klasse
        Runnable r2=new Runnable() {
            @Override
            public void run() {
                System.out.println("B1"+Thread.currentThread());
                System.out.println("B2"+Thread.currentThread());
            }
        };

        //Alternativ
        //-Eigene Klasse, die Runnable implementiert
        //-Objekt dieser Klasse erzeugen und execute übergeben

        ExecutorService executor= Executors.newCachedThreadPool();

        executor.execute(r1);
        executor.execute(r2);

        Thread.sleep(500);

        executor.execute(r1);
        executor.execute(r2);

        executor.shutdown();
    }
}
