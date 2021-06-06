package places;

import journeys.Reis;
import steps.Stap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representation of a "Place", to be used as Node in a graph with the purpose of being
 * traversed by Dijkstra's algorithm.
 */
public class Plek implements Comparable<Plek>{
    private final String name;

    /** Edges (connecting to other Plek instances) connected to this instance.*/
    private List<Stap> edges = new ArrayList<>();

    /** Shortest path found from start (as specified in {@link graphs.DijkstraGraph#shortestPath(Plek, Plek)}).
    Initialized as non-specified {@link Reis}. Only supposed to be used by DijkstraGraph. */
    private Reis shortestPath = new Reis(true);

    /** Boolean wether all possible edges of this node have been explored by
     * {@link graphs.DijkstraGraph#shortestPath(Plek, Plek)}.
     * Initialized as false. Only supposed to be used by DijkstraGraph.*/
    private boolean completed = false;

    public Plek(String name){this.name = name;}
    public String toString(){return this.name;}

    public void connect(Stap edge){
        this.edges.add(edge);
    }

    public List<Stap> getEdges(){
        return this.edges;
    }

    public Reis getShortestPath(){return this.shortestPath;}
    public void setShortestPath(Reis path){
        this.shortestPath = path;
    }

    public boolean getCompleted(){return this.completed;}
    public void setCompleted(boolean completed){this.completed = completed;}

    /**
     * Compare plek instances by comparing their associated shortestJourney using {@link Reis#compareTo(Reis)}.
     *
     * @param o other Plek instance to compare to.
     * @return negative integer if instance method is called on is smaller the parameter instance,
     * positive integer if bigger, 0 if they are equal.
     */
    @Override
    public int compareTo(Plek o) {
        return this.shortestPath.compareTo(o.getShortestPath());
    }

    // Equals and hashCode based on name.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plek plek = (Plek) o;
        return name.equals(plek.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
