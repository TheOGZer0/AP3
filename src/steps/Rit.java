package steps;

import misc.DijkstraError;
import places.Plek;

/**
 * Extension of {@link Stap}, that represent a car ride in kilometers.
 */
public class Rit extends Stap {
    private double distance; //In KiloMeter

    /**
     * Rit constructor.
     *
     * @param a used in {@link Stap#Stap(Plek, Plek)} call.
     * @param b used in {@link Stap#Stap(Plek, Plek)} call.
     * @param distance car ride distance in KiloMeter.
     * @throws DijkstraError thrown by {@link Stap#verifyWeight()}.
     */
    public Rit(Plek a, Plek b, double distance) throws DijkstraError{
        super(a, b);
        this.distance = distance;
        this.verifyWeight();
    }

    @Override
    public String toString() {
        return a.toString() + " <--car ride--> " + b.toString();
    }

    /**
     * Get weight for use in Dijkstra's algorithm.
     *
     * @return distance in Km.
     */
    @Override
    public double getWeight() {
        return this.distance;
    }
}
