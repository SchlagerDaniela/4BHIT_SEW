/*
        Author: Schlager Daniela
        Date: 03.10.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 10.10.2019
 */
public class Consumer implements Runnable {

    //Attribute
    Football fb = new Football();

    //Constructor
    public Consumer(Football fb) {
        this.fb = fb;
    }

    //Hier wird die Methode konsumiere aufgerufen
    @Override
    public void run() {
        try{
            while(true){
                fb.konsumiere();
            }

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



}
