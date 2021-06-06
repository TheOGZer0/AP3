package misc;

import graphs.DijkstraGraph;
import steps.Stap;

/**
 * Custom exception to help with Dijkstra-specific problems.
 */
public class DijkstraError extends Exception{
    public DijkstraError(String message){
        super(message);
    }

    /**
     * Constructor for when an edge (Stap) has a negative weight.
     *
     * @param edge Stap instance with negative weight.
     */
    public DijkstraError(Stap edge){
        this("Edge " + edge.toString() + " can't have negative weight.");
    }
}
