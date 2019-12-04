/*
        Author: Schlager Daniela
        Date: 20.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 20.09.2019
 */
public class InterruptThread extends Thread {

    @Override
    public void run(){
        while(!isInterrupted()){
            System.out.println("Läuft");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
