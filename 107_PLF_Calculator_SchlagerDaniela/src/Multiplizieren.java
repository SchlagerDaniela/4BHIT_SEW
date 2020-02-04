public class Multiplizieren extends Calculation{


    public Multiplizieren() {
        super((int)((Math.random()*1000)-1000), (int) ((Math.random()*1000)-1000),20);
    }

    @Override
    public int calculate() {
        return (a*b);
    }
}
