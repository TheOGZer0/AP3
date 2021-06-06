package steps;

import misc.DijkstraError;
import places.Plek;

/**
 * Abstract "Stap", that's meant as edge in a graph to be traversed using Dijkstra's algorithm.
 */
public abstract class Stap{
    protected final Plek a;
    protected final Plek b;

    /**
     * Constructor, that also calls .connect() on a and b, with itself as parameter.
     *
     * @param a node at end of edge.
     * @param b node at end of edge.
     * @throws DijkstraError thrown by subclass constructors.
     */
    public Stap(Plek a, Plek b) throws DijkstraError{
        this.a = a;
        this.b = b;
        a.connect(this);
        b.connect(this);
    }

    /**
     * Given Node at 1 end of edge, return other.
     *
     * @param origin node, of which node on other side should be returned.
     * @return other node.
     */
    public Plek getOther(Plek origin){
        if(origin == this.a){
            return this.b;
        }else{
            return this.a;
        }
    }

    public abstract String toString();
    public abstract double getWeight();

    /**
     * Verify that edge doesn't have negative weight.
     * Used by subclasses.
     *
     * @throws DijkstraError if weight is negative.
     */
    protected void verifyWeight() throws DijkstraError{
        if(this.getWeight() < 0){
            throw new DijkstraError(this);
        }
    }
}
