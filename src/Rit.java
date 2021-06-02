public class Rit extends Stap{
    private double distance; //In KiloMeter
    private double speedLimit; //In Kilometer per Hour

    public Rit(Plek a, Plek b, double distance){
        super(a, b);
        this.distance = distance;
    }

    @Override
    public String toString() {
        return a.toString() + " <--car ride--> " + b.toString();
    }

    @Override
    public double getWeight() {
        return this.distance;
    }
}
