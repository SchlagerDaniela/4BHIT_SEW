public class Calculation {

    int a;
    int b;
    int berechnungsdauer;

    public Calculation(int a, int b, int berechnungsdauer) {
        this.a = a;
        this.b = b;
        this.berechnungsdauer = berechnungsdauer;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getBerechnungsdauer() {
        return berechnungsdauer;
    }

    public void setBerechnungsdauer(int berechnungsdauer) {
        this.berechnungsdauer = berechnungsdauer;
    }

    public int calculate(){
        return 0;
    }
}
