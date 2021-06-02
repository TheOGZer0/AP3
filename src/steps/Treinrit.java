package steps;

import places.Plek;
import steps.Stap;

public class Treinrit extends Stap {
    private final double journeyTime; //In minutes
    private double currentDelay; //In minutes

    public Treinrit(Plek a, Plek b, double journeyTime, double currentDelay){
        super(a, b);
        this.journeyTime = journeyTime;
        this.currentDelay = currentDelay;
    }

    public Treinrit(Plek a, Plek b, double journeyTime){
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
