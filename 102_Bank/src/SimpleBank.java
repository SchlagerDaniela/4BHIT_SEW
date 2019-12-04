/*
        Author: Schlager Daniela
        Date: 26.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 30.09.2019
 */
public class SimpleBank {
    private int[] konten = {30,50,100, 150};

    //Betrag wird vom konto abgezogen und beim Empfänger Konto hinzugefügt
    public void ueberweisung(int von, int nach, int betrag){
        konten[von] -= betrag;
        konten[nach] += betrag;
    }

    //Ausgabe
    public void kontostand(){
        for(int i = 0; i<konten.length; i++){
            System.out.println("Der Kontostand beträgt " + konten[i] + "€");
        }
    }
}
