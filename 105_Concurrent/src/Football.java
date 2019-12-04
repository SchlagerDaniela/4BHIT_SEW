import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/*
        Author: Schlager Daniela
        Date: 10.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 10.10.2019
 */
public class Football {

    //Attribute
    BlockingQueue<Integer> fliessband = new LinkedBlockingQueue<>(); //Fließband in Form einer BlockingQueue
    int kapazitaet = 10; //So viele Footballs können auf das Fließband gelegt werden


    public void produziere() throws InterruptedException {

        if (fliessband.size() < kapazitaet) { //Solange das Fließband nicht voll ist werden Footballs produziert
            int wert = (int) (Math.random() * 10);
            fliessband.add(wert);
            System.out.println("Produzent produzierte " + fliessband.size() + "/10 footballs"); //Ausgabe
            Thread.sleep((int) (Math.random() * 1000)); //Lässt den Thread schlafen
        }
    }


    public void konsumiere() throws InterruptedException {

        if (fliessband.size() == 0) { //Wenn das Fließband voll ist wird der Thread schlafen geschickt
            Thread.sleep(1000);
        }
        if (fliessband.size() != 0) { //Solange das Fließband nicht leer ist werden Footballs entfernt
            int wert = fliessband.remove(); //hier wird der Football entfernt
            System.out.println("Consumer hat Football " + fliessband.size() + "/10 vom Fließband entfernt."); //Ausgabe
            Thread.sleep((int) (Math.random() * 1000)); //Lässt den Thread schlafen
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Football fb = new Football();

        //Threads erzeugen
        Thread p = new Thread(new Producer(fb));
        Thread c = new Thread(new Consumer(fb));

        //Threads starten
        p.start();
        c.start();
    }
}
