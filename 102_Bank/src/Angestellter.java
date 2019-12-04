/*
        Author: Schlager Daniela
        Date: 26.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 30.09.2019
 */
public class Angestellter implements Runnable{

    //Attribute
    SimpleBank bank;
    private int von;
    private int nach;
    private int betrag;

    //Construktor
    public Angestellter(SimpleBank bank, int von, int nach, int betrag) {
        this.bank = bank;
        this.von = von;
        this.nach = nach;
        this.betrag = betrag;
    }


    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random()*1000));
            bank.ueberweisung(this.von, this.nach, this.betrag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
