package journeys;

import misc.DijkstraError;
import steps.Stap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reis implements Comparable<Reis>{
    private double length;
    private List<Stap> traversedEdges = new ArrayList<>();

    public Reis(){
        this(false);
    }

    public Reis(boolean initAtInfinity){
        this.length = initAtInfinity ? Double.POSITIVE_INFINITY : 0;
    }

    //Copy constructor
    public Reis(Reis reisToCopy){
        this.length = reisToCopy.getLength();
        this.traversedEdges = new ArrayList<>(reisToCopy.getTraversedEdges());
    }

    public double getLength() {
        return this.length;
    }

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

    @Override
    public int compareTo(Reis o){
        return Double.compare(this.length, o.getLength());
    }

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
