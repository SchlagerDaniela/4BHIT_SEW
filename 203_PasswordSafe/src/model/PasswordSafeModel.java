package model;

/*
        Author: Schlager Daniela
        Date: 21.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 27.11.2019

 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PasswordSafeModel {
    private List<Entry> list = new ArrayList<Entry>(); //Liste in der alles gespeichert wird
    ReaderWriter rw = new ReaderWriter(); //Object für den ReaderWriter
    File file = new File("entry.bin"); //File erstellen
    String filename = "entry.bin"; //String mit dem filenamen als Inhalt

    int pos = -1;

    /*Wenn der PasswordSafe gestartet wird, wird abgefragt ob bereits ein File existiert, wenn ja dann wird der Inhalt vom
     * File in die Liste gespeichert, wenn nicht werden "Startwerte" eingefügt
     */
    public PasswordSafeModel() throws IOException, ClassNotFoundException {
        if (file.exists()) {
            list = rw.deserialisieren(filename);
        } else {
            list.add(new Entry("Mega", "Schlager", "4561", "www.mega.nz"));
            list.add(new Entry("HTL", "Schlager 2", "96314", "www.htl-wels.at"));
            list.add(new Entry("Instagram", "Schlager 3", "0987", "www.instagram.com"));
        }
    }

    /*Wenn die Position nicht bereits das Ende der Liste ist, wird der nächste Eintrag gezeigt, ist es aber bereits am Ende,
     * dann wird immer der letzte Eintrag gezeigt
     */
    public Entry getNext() {
        pos++;

        if (pos != list.size()) {
            return list.get(pos);
        } else {
            pos--;
            return list.get(pos);
        }
    }

    /* Wenn die Position nicht am ersten Eintrag der Liste befindet, dann wird der vorherige Eintrag gezeigt, falls es bereits
     * am Anfang der Liste ist, wird immer der erste Eintrag gezeigt.
     */
    public Entry getPrev() {
        pos--;

        if (pos != -1) {
            return list.get(pos);
        } else {
            pos++;
            return list.get(pos);
        }
    }

    /* Wenn die condition 2 ist wird der aktuelle Eintrag auf Editierbar gesetzt und man kann die Einträge ändern
     * Wenn die condition 0 ist werden die Felder auf Editierbar gesetzt und man kann einen neuen Eintrag hinzufügen.
     */
    public void editEntry(String website, String username, String password, String link, int condition) {
        if (condition == 2) {
            list.remove(pos);
            list.add(new Entry(website, username, password, link));
        } else if (condition == 0) {
            list.add(new Entry(website, username, password, link));
        }
        try {
            rw.serialisieren(list, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Der aktuelle Eintrag wird gelöscht
    public void deleteEntry(){
        list.remove(pos);
    }
}
