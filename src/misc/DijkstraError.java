package misc;

import graphs.DijkstraGraph;
import steps.Stap;

public class DijkstraError extends Exception{
    public DijkstraError(String message){
        super(message);
    }

    public DijkstraError(Stap edge){
        this("Edge " + edge.toString() + " can't have negative weight.");
    }
}
