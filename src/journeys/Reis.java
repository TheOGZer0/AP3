package journeys;

import misc.DijkstraError;
import steps.Stap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A journey, consistant of several Stap objects, for use on a graph that's traversed by
 * Dijkstra's algorithm.
 */
public class Reis implements Comparable<Reis>{
    /** Sum of length of all Stap instances contained in traversedEdges. */
    private double length;
    /** Stap instances this journey consists of. */
    private List<Stap> traversedEdges = new ArrayList<>();

    /**
     * Reis constructor.
     *
     * Calls {@link Reis#Reis(boolean)} with initAtInfinity = false.
     */
    public Reis(){
        this(false);
    }

    /**
     * Reis constructor. Initializes a reis that doesn't contain any Stap instances.
     *
     * @param initAtInfinity initializes the empty reis with length infinity instead of 0 for Dijkstra's algorithm
     *                       if true.
     */
    public Reis(boolean initAtInfinity){
        this.length = initAtInfinity ? Double.POSITIVE_INFINITY : 0;
    }

    /**
     * Reis copy-constructor.
     *
     * @param reisToCopy Reis instance of which the values will be copied into new Reis instance.
     */
    public Reis(Reis reisToCopy){
        this.length = reisToCopy.getLength();
        this.traversedEdges = new ArrayList<>(reisToCopy.getTraversedEdges());
    }

    public double getLength() {
        return this.length;
    }

    /**
     * Add a stap instance to this Reis instance, and add it's length to this Reis's length.
     *
     * @param stap Stap instance to add.
     * @throws DijkstraError if Reis instance being added to has length infinity. This is considered an 'undiscovered'
     *                       journey, and adding a Stap to it doesn't make sense.
     */
    public void addEdge(Stap stap) throws DijkstraError{
        if(this.length == Double.POSITIVE_INFINITY){
            throw new DijkstraError("Adding Stap to undiscovered Reis with length infinity not allowed.");
        }
        this.traversedEdges.add(stap);
        this.length += stap.getWeight();
    }

    public List<Stap> getTraversedEdges(){
        return this.traversedEdges;
    }

    public String toString(){
        if(this.length == Double.POSITIVE_INFINITY){
            return "Undetermined journey";
        }else{
            String result = "Journey with length " + Double.toString(this.length) + " with path:" + "\n";
            for(Stap edge: this.traversedEdges){
                result += edge.toString() + "\n";
            }
            return result;
        }
    }

    /**
     * Compare Reis instance to other based on length.
     *
     * @param o other Reis instance to compare to.
     * @return negative int if this Reis instance is smaller, positive int if this Reis instance is bigger, 0 if equal.
     */
    @Override
    public int compareTo(Reis o){
        return Double.compare(this.length, o.getLength());
    }

    /**
     * Determine equality to other object. Objects are equal if they are both Reis instances and contain the same
     * traversed edges in the same order.
     * Equality is not based on length, because floating point maths could cause unexpected behavior here.
     *
     * @param o other object to determine equality to.
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reis reis = (Reis) o;
        return Objects.equals(traversedEdges, reis.traversedEdges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traversedEdges);
    }
}
