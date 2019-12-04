import java.io.Serializable;

/*
        Author: Schlager Daniela
        Date: 21.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 21.09.2019
 */
public class Schueler implements Comparable<Schueler>, Serializable {

    //Attribute
    protected int id;               //Schuelerid
    protected int katalognummer;    //Katalognummer
    protected String nachname;      //Nachname der Schueler
    protected String vorname;       //Vorname des Schuelers
    protected char geschlecht;      //m oder w
    protected String religion;      //Religion des Schuelers
    protected String gebDate;       //Geburtsdatum
    protected String strasse;       //Strasse
    protected int plz;              //Postleitzahl
    protected String ort;           //Wohnort

    //Constructor
    public Schueler(int id, int katalognummer, String nachname, String vorname, char geschlecht, String religion, String gebDate, String strasse, int plz, String ort) {
        this.id = id;
        this.katalognummer = katalognummer;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geschlecht = geschlecht;
        this.religion = religion;
        this.gebDate = gebDate;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKatalognummer() {
        return katalognummer;
    }

    public void setKatalognummer(int katalognummer) {
        this.katalognummer = katalognummer;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGebDate() {
        return gebDate;
    }

    public void setGebDate(String gebDate) {
        this.gebDate = gebDate;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    //Compare to
    public int compareTo(Schueler o){
        if(this.getId() == o.getId()){
            return 0;
        }else{
            if(this.getKatalognummer() == o.getKatalognummer()) {
                if (this.getId() < o.getId()) {
                    return -1;
                } else {
                    return 1;
                }
            }else{
                    if(this.getKatalognummer() < o.getKatalognummer()){
                        return -1;
                    }else{
                        return 1;
                    }
                }
        }
    }

    //Ausgabe
    public String toString(){
        return "\nID:\n" + this.id +
                "\nKatalognummer:\t" + this.katalognummer +
                "\n Name:\t" + this.vorname + this.nachname;
    }
}
