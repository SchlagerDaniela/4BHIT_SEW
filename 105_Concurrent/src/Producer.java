import java.util.concurrent.BlockingQueue;

/*
        Author: Schlager Daniela
        Date: 10.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 10.10.2019
 */
public class Producer implements Runnable{

   //Attribute
    Football fb = new Football();

    //Constructor
    public Producer(Football fb) {
        this.fb = fb;
    }

    //Hier wird die Methode produziere aufgerufen
    @Override
    public void run() {
        try{
            while(true){
                fb.produziere();
            }

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}

