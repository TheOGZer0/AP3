package steps;

import misc.DijkstraError;
import places.Plek;


/**
 * Extension of {@link Stap}, that represent a train journey in minutes.
 * Train journey can also have a current delay, which will be added to the weight
 * returned by getWeight().
 */
public class Treinrit extends Stap {
    private final double journeyTime; //In minutes
    private double currentDelay; //In minutes

    /**
     * Treinrit constructor.
     * 
     * @param a used in {@link Stap#Stap(Plek, Plek)} call.
     * @param b used in {@link Stap#Stap(Plek, Plek)} call.
     * @param journeyTime amount of minutes this train journey takes.
     * @param currentDelay amount of minutes of delay currently on this train journey.
     * @throws DijkstraError thrown by {@link Stap#verifyWeight()}.
     */
    public Treinrit(Plek a, Plek b, double journeyTime, double currentDelay) throws DijkstraError {
        super(a, b);
        this.journeyTime = journeyTime;
        this.currentDelay = currentDelay;
        this.verifyWeight();
    }

    /**
     * Treinrit constructor.
     *
     * Calls {@link Treinrit#Treinrit(Plek, Plek, double, double)} with currentDelay = 0.0
     */
    public Treinrit(Plek a, Plek b, double journeyTime) throws DijkstraError{
        this(a, b, journeyTime, 0.0);
    }

    public void setCurrentDelay(double currentDelay){this.currentDelay = currentDelay;}

    @Override
    public String toString() {
        return a.toString() + " <--train Journey--> " + b.toString();
    }

    /**
     * Get weight for use in Dijkstra's algorithm.
     *
     * @return journeyTime + currentDelay.
     */
    @Override
    public double getWeight() {
        return this.journeyTime + this.currentDelay;
    }
}
