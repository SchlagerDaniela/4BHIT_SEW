package model;

import java.io.*;
import java.util.List;

public class ReaderWriter {
    public void serialisieren(List<Entry> entry, String fileName) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(entry);
        }
    }

    public List<Entry> deserialisieren(String fileName) throws IOException, ClassNotFoundException {
        List<Entry> c;
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            c = (List<Entry>) ois.readObject();
        }
        return c;
    }
}
