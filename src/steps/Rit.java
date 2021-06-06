package steps;

import misc.DijkstraError;
import places.Plek;

public class Rit extends Stap {
    private double distance; //In KiloMeter

    public Rit(Plek a, Plek b, double distance) throws DijkstraError{
        super(a, b);
        this.distance = distance;
        this.verifyWeight();
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
