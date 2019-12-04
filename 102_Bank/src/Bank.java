import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
        Author: Schlager Daniela
        Date: 26.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 30.09.2019
 */
public class Bank {
    public static void main(String[] args) {
        SimpleBank bank = new SimpleBank();
        System.out.println("Vor der Transaktion: ");
        bank.kontostand();

        //Angestellte werden erstellt
        Angestellter ang1 = new Angestellter(bank, 0, 1, 50);
        Angestellter ang2 = new Angestellter(bank, 1, 2, 50);
        Angestellter ang3 = new Angestellter(bank, 2, 3, 50);
        Angestellter ang4 = new Angestellter(bank, 3, 0, 50);

        ExecutorService execuSer = Executors.newCachedThreadPool();

        execuSer.execute(ang1);
        execuSer.execute(ang2);
        execuSer.execute(ang3);
        execuSer.execute(ang4);

        System.out.println("Nach der Transaktion: ");
        bank.kontostand();
        execuSer.shutdown();
    }
}
