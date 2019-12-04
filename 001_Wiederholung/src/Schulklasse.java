import java.io.Serializable;

/*
        Author: Schlager Daniela
        Date: 21.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 21.09.2019
 */
public class Schulklasse implements Comparable<Schulklasse>, Serializable {

    //Attribute
    protected String klassennamen;   //Name der Klasse (z.B. 4BHIT)
    protected String schulform;     //Fachschule oder höhere Schule
    protected String klassenvorstand; //Name des Klassenvorstandes

    //Constructor
    public Schulklasse(String klassennamen, String schulform, String klassenvorstand) {
        this.klassennamen = klassennamen;
        this.schulform = schulform;
        this.klassenvorstand = klassenvorstand;
    }

    //Getter & Setter
    public String getKlassennamen() {
        return klassennamen;
    }

    public void setKlassennamen(String klassennamen) {
        this.klassennamen = klassennamen;
    }

    public String getSchulform() {
        return schulform;
    }

    public void setSchulform(String schulform) {
        this.schulform = schulform;
    }

    public String getKlassenvorstand() {
        return klassenvorstand;
    }

    public void setKlassenvorstand(String klassenvorstand) {
        this.klassenvorstand = klassenvorstand;
    }

    //Compare to
    public int compareTo(Schulklasse o){
        int klassenvergleich = this.getKlassennamen().compareTo(o.getKlassennamen());

        if(klassenvergleich == 0){
            return this.schulform.compareTo(o.schulform);
        }else{
            return klassenvergleich;
        }
    }

    //Ausgabe
    public String toString(){
        return "\nKlasse: " + this.getKlassennamen() +
                "\nSchulform " + this.getSchulform() +
                "\nKlassenvorstand " + this.getKlassenvorstand();
    }
}
