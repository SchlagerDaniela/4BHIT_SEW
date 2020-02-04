public class Dividieren extends Calculation{

    public Dividieren() {
        super((int) ((Math.random()*1000)-1000), (int)((Math.random()*1000)+1), 20);
    }

    @Override
    public int calculate() {
        return (a/b);
    }
}
