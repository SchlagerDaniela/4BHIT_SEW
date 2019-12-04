import java.io.Serializable;
import java.util.TreeMap;
import java.util.TreeSet;

/*
        Author: Schlager Daniela
        Date: 21.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 21.09.2019
 */
public class ListeKlasse implements Serializable {

    //Collection wird erstellt (Tree weil es sortiert ausgegeben werden soll)
    TreeMap<Schulklasse, TreeSet<Schueler>> klassen = new TreeMap();

    //Constructor
    public ListeKlasse(TreeMap<Schulklasse, TreeSet<Schueler>> klassen) {
        this.klassen = klassen;
    }

    public ListeKlasse(){

    }

    public void add(int id, int katalognummer, String nachname, String vorname, char geschlecht, String religion, String gebDate, String strasse, int plz, String ort,String klassennamen, String schulform, String klassenvorstand){

        //Objekte für Schulklasse und Schueler werden erstellt
        Schulklasse klassen_objekt = new Schulklasse(klassennamen, schulform, klassenvorstand);
        Schueler schueler_objekt = new Schueler(id, katalognummer, nachname, vorname, geschlecht, religion, gebDate, strasse, plz, ort);

        //Wenn in der Collection die Schulklasse ist, dann fügt es die Schueler hinzu, sonst erstellt er eine neue Schulklasse
        if(klassen.containsKey(klassen_objekt)){
            klassen.get(klassen_objekt).add(schueler_objekt); //fügt den Schueler zur Klasse hinzu
        }else{
            TreeSet<Schueler> schueler_set = new TreeSet<>();
            schueler_set.add(schueler_objekt);
            klassen.put(klassen_objekt, schueler_set);
        }
    }

    //Ausgabe mit for-each Schleifen
    public String toString(){
        String str = " ";
        for(Schulklasse klasse: klassen.keySet()){
            str += klasse;
            for(Schueler schueler: klassen.get(klasse)){
                str += schueler;
            }
        }
        return str;
    }
}
