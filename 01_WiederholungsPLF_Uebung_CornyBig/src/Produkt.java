import java.util.Objects;

public class Produkt {
    private String produktname;
    private int produktionszeit;

    public Produkt(String produktname, int produktionszeit) {
        this.produktname = produktname;
        this.produktionszeit = produktionszeit;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public int getProduktionszeit() {
        return produktionszeit;
    }

    public void setProduktionszeit(int produktionszeit) {
        this.produktionszeit = produktionszeit;
    }

    @Override
    public boolean equals(Object o) {
        return ((Produkt) o).produktname.equals(this.produktname);
    }

}
