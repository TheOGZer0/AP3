package steps;

import misc.DijkstraError;
import places.Plek;

public class Treinrit extends Stap {
    private final double journeyTime; //In minutes
    private double currentDelay; //In minutes

    public Treinrit(Plek a, Plek b, double journeyTime, double currentDelay) throws DijkstraError {
        super(a, b);
        this.journeyTime = journeyTime;
        this.currentDelay = currentDelay;
        this.verifyWeight();
    }

    public Treinrit(Plek a, Plek b, double journeyTime) throws DijkstraError{
        this(a, b, journeyTime, 0.0);
    }

    public void setCurrentDelay(double currentDelay){this.currentDelay = currentDelay;}

    @Override
    public String toString() {
        return a.toString() + " <--train Journey--> " + b.toString();
    }

    @Override
    public double getWeight() {
        return this.journeyTime + this.currentDelay;
    }
}
