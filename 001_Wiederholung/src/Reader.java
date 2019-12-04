import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/*
        Author: Schlager Daniela
        Date: 21.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 21.09.2019
 */
public class Reader {

    //CSV Reader
    public ListeKlasse readCSV (String filepath, char seperator){
        Path pathToFile = Paths.get(filepath);
        ListeKlasse list = new ListeKlasse();

        try(BufferedReader br = Files.newBufferedReader(pathToFile, Charset.defaultCharset())){
            br.readLine();
            String line = br.readLine();
            int line_count = 1;

            //Datei wird zerlegt
            while(line !=null){
                String[] splits = line.split(Pattern.quote(""+seperator));
                if(splits.length == 13) {
                    int id = Integer.parseInt(splits[0]);
                    int katalognummer = Integer.parseInt(splits[1]);
                    String nachname = splits[2];
                    String vorname = splits[3];
                    char geschlecht = splits[4].charAt(0);
                    String religion = splits[5];
                    String gebDate = splits[6];
                    String strasse = splits[7];
                    int plz = Integer.parseInt((splits[8]));
                    String ort = splits[9];
                    String schulform = splits[10];
                    String klassennamen = splits[11];
                    String klassenvorstand = splits[12];

                    //alle Werte werden in die Liste hinzugefügt
                    list.add(id, katalognummer, nachname, vorname, geschlecht, religion, gebDate, strasse, plz, ort, schulform, klassennamen, klassenvorstand);
                }else{
                    System.out.println("Falsche Anzahl an Werten in Zeile " + line_count + "bei " + pathToFile.getFileName() + ". Hat " + splits.length + "erwartet aber 13.");
                }
                line = br.readLine();
                line_count++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }


    //DST Reader
    public ListeKlasse readDST(String filepath){
        Path pathToFile =Paths.get(filepath);
        ListeKlasse list = new ListeKlasse();

        try{
            FileInputStream fis = new FileInputStream(pathToFile.toString());
            DataInputStream dis = new DataInputStream(fis);

            //Datei wird zerlegt
            while(dis.available()>12){
                int id = dis.readInt();
                int katalognummer = dis.readInt();
                String nachname = dis.readUTF();
                String vorname = dis.readUTF();
                char geschlecht = dis.readChar();
                String religion = dis.readUTF();
                String gebDate = dis.readUTF();
                String strasse = dis.readUTF();
                int plz = dis.readInt();
                String ort = dis.readUTF();
                String schulform = dis.readUTF();
                String klassennamen = dis.readUTF();
                String klassenvorstand = dis.readUTF();

                //Werte werden in die Liste hinzugefügt
                list.add(id, katalognummer, nachname, vorname, geschlecht, religion, gebDate, strasse, plz, ort, schulform, klassennamen, klassenvorstand);
            }
            //DataInputStream wird geschlossen/beendet
            dis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



    //OST Reader
    public ListeKlasse readObj(String filepath){
        Path pathToFile = Paths.get(filepath);
        ListeKlasse list = new ListeKlasse();

        try{
            FileInputStream fis = new FileInputStream(pathToFile.toString());
            ObjectInputStream ois = new ObjectInputStream(fis);

            list = (ListeKlasse) ois.readObject();

            //ObjectInputStream wird geschlossen/beendet
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}

