package steps;

import misc.DijkstraError;
import places.Plek;

/**
 * Extension of {@link Stap}, that represent an (airplane) flight in kilometers.
 *
 * Can also be passed baggagePrice and baggageLossChance, which will be included in price.
 */
public class Vlucht extends Stap {
    private int price;
    private double baggageLossChance;
    private int baggagePrice;

    /**
     * Vlucht constructor.
     *
     * @param a used in {@link Stap#Stap(Plek, Plek)} call.
     * @param b used in {@link Stap#Stap(Plek, Plek)} call.
     * @param price flight price.
     * @param baggagePrice baggage price.
     * @param baggageLossChance chance that baggage is lost, as number from 0% too 100%.
     * @throws DijkstraError thrown by {@link Stap#verifyWeight()}.
     */
    public Vlucht(Plek a, Plek b, int price, int baggagePrice, double baggageLossChance) throws DijkstraError {
        super(a, b);
        this.price = price;
        this.baggagePrice = baggagePrice;
        this.baggageLossChance = baggageLossChance;
        this.verifyWeight();
    }

    /**
     * Vlucht constructor.
     *
     * Calls {@link Vlucht#Vlucht(Plek, Plek, int, int, double)} with:
     * baggagePrice = 0 and baggageLossChance = 0.0.
     */
    public Vlucht(Plek a, Plek b, int price) throws DijkstraError{
        this(a, b, price, 0, 0.0);
    }

    @Override
    public String toString() {
        return a.toString() + " <--flight--> " + b.toString();
    }


    /**
     * Get weight for use in Dijkstra's algorithm.
     *
     * @return (baggagePrice proportional to baggageLossChance) + price.
     */
    @Override
    public double getWeight() {
        return this.price + (this.baggagePrice * (this.baggageLossChance / 100));
    }
}
