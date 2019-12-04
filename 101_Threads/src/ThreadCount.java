/*
        Author: Schlager Daniela
        Date: 13.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 13.09.2019
 */
public class ThreadCount implements Runnable {
    public void run() {
        try{
            for(int i=0; i<20;i++){
                System.out.println(Thread.currentThread() + " " + i);
                Thread.sleep(5);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
