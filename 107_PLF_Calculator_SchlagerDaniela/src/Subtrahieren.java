public class Subtrahieren extends Calculation{


    public Subtrahieren() {
        super((int)((Math.random()*1000)-1000),  (int) ((Math.random()*1000)-1000), 10);
    }

    @Override
    public int calculate() {

        return (a-b);
    }
}
