import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Automat {
    private final int MAX = 50;

    //private List<Produkt> produkte = new ArrayList<>();
    //private Queue<Pepsi> pepsi = new LinkedList<>();
    //private Queue<CornyBig> cornyBig = new LinkedList<>();

    private Queue produkte = new LinkedList();
    public Automat() {

    }

    public boolean isFull() {
        return !(produkte.size() < MAX);
    }

    public boolean isEmpty(){
        return produkte.size() == 0;
    }

    public void addProdukt(Produkt produkt) {
        produkte.add(new Produkt(produkt.getProduktname(), produkt.getProduktionszeit()));
        System.out.println("Added:" + produkt.getProduktname() + "\t" + produkte.size());
    }

    public boolean getProdukt(Produkt produkt) {
        boolean rm = produkte.remove(produkt);
        if (rm) {
            System.out.println("Removed:" + produkt.getProduktname() + "\t" + produkte.size());
        }
        return rm;
    }

}
