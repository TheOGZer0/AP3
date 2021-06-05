package steps;

import misc.DijkstraError;
import places.Plek;
import steps.Stap;

public class Vlucht extends Stap {
    private int price;
    private double baggageLossChance;
    private int baggagePrice;

    public Vlucht(Plek a, Plek b, int price, int baggagePrice, double baggageLossChance) throws DijkstraError {
        super(a, b);
        this.price = price;
        this.baggagePrice = baggagePrice;
        this.baggageLossChance = baggageLossChance;
    }

    public Vlucht(Plek a, Plek b, int price) throws DijkstraError{
        this(a, b, price, 0, 0.0);
    }

    @Override
    public String toString() {
        return a.toString() + " <--flight--> " + b.toString();
    }

    @Override
    public double getWeight() {
        return this.price + (this.baggagePrice * (this.baggageLossChance / 100));
    }
}
