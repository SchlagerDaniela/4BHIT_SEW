import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
        Author: Schlager Daniela
        Date: 21.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 24.09.2019
 */
public class Writer {

    //CSV Writer
    public int writeCSV(String filepath, ListeKlasse list, char seperator){
        Path pathToFile = Paths.get(filepath);
        String seperator_str = "" + seperator;

        try(BufferedWriter bw = Files.newBufferedWriter(pathToFile)){
            String str = "";
            str += "id" + seperator_str;
            str += "katalognummer" + seperator_str;
            str += "nachname" + seperator_str;
            str += "vorname" + seperator_str;
            str += "geschlecht" + seperator_str;
            str += "religion" + seperator_str;
            str += "gebDatum" + seperator_str;
            str += "str" + seperator_str;
            str += "plz" + seperator_str;
            str += "ort" + seperator_str;
            str += "klassenname" + seperator_str;
            str += "schulform" + seperator_str;
            str += "klassenvorstand" + seperator_str;

            bw.write(str);
            bw.newLine();
            bw.flush();

            for(Schulklasse klasse: list.klassen.keySet()){
                for(Schueler schueler: list.klassen.get(klasse)){
                    str = "";

                    str += schueler.getId() + seperator_str;
                    str += schueler.getKatalognummer() + seperator_str;
                    str += schueler.getNachname() + seperator_str;
                    str += schueler.getVorname() + seperator_str;
                    str += schueler.getGeschlecht() + seperator_str;
                    str += schueler.getReligion() + seperator_str;
                    str += schueler.getGebDate() + seperator_str;
                    str += schueler.getStrasse() + seperator_str;
                    str += schueler.getPlz() + seperator_str;
                    str += schueler.getOrt() + seperator_str;
                    str += klasse.getKlassennamen() + seperator_str;
                    str += klasse.getSchulform() + seperator_str;
                    str += klasse.getKlassenvorstand();

                    bw.write(str);
                    bw.newLine();
                    bw.flush();
                }
            }
            }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //DST Writer
    public int writeDST(String filepath, ListeKlasse list){
        try{
            FileOutputStream fos = new FileOutputStream(filepath);
            DataOutputStream dos = new DataOutputStream(fos);

            for(Schulklasse klasse: list.klassen.keySet()){
                for(Schueler schueler: list.klassen.get(klasse)){
                    dos.writeInt(schueler.getId());
                    dos.writeInt(schueler.getKatalognummer());
                    dos.writeUTF(schueler.getNachname());
                    dos.writeUTF(schueler.getVorname());
                    dos.writeChar(schueler.getGeschlecht());
                    dos.writeUTF(schueler.getReligion());
                    dos.writeUTF(schueler.getGebDate());
                    dos.writeUTF(schueler.getStrasse());
                    dos.writeInt(schueler.getPlz());
                    dos.writeUTF(schueler.getOrt());
                    dos.writeUTF(klasse.getKlassennamen());
                    dos.writeUTF(klasse.getSchulform());
                    dos.writeUTF(klasse.getKlassenvorstand());
                }
            }
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    //OST Writer
    public int writeObj(String filepath, ListeKlasse liste){

        try{
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(liste);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
