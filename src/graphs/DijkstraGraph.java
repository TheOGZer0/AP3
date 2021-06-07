package graphs;

import journeys.Reis;
import misc.DijkstraError;
import places.Plek;
import steps.Stap;

import java.util.PriorityQueue;

import java.util.HashSet;
import java.util.Set;

/**
 * Graph for shortest-path finding purposes using Dijkstra's algorithm.
 */
public class DijkstraGraph{
    /** All nodes to be traversed by the algorithm. */
    private Set<Plek> nodes = new HashSet<>();

    /**
     * Reset the shortestPath and completed attributes back to their original values
     * ,after {@link DijkstraGraph#shortestPath(Plek, Plek)} has changed them.
     */
    private void reset(){
        for(Plek node: this.nodes){
            node.setShortestPath(new Reis(true));
            node.setCompleted(false);
        }
    }

    /**
     * @param node add to {@link DijkstraGraph#nodes}.
     */
    public void addToNodes(Plek node){
        this.nodes.add(node);
    }

    public DijkstraGraph(){};

    /**
     * DijkstraGraph Constructor.
     *
     * @param nodes calls {@link DijkstraGraph#addToNodes(Plek)} with all Plek instances that are parameters.
     */
    public DijkstraGraph(Plek... nodes){
        for(Plek node: nodes){
            this.addToNodes(node);
        }
    }

    /**
     * Find the shortest path through all nodes/Plek instances, from a given start to a given end.
     *
     * @param start Node from which path should be searched.
     * @param end Node to which path should be searched.
     * @return The shortest path as Reis instance.
     * @throws DijkstraError thrown by {@link Reis#addEdge(Stap)}.
     */
    public Reis shortestPath(Plek start, Plek end) throws DijkstraError {
        // Initialize everything for Dijkstra
        start.setShortestPath(new Reis());
        PriorityQueue<Plek> priorityQueue = new PriorityQueue<>();
        for(Plek node: this.nodes){
            priorityQueue.add(node);
        }
        //Run the algorhitm
        Plek currentNode;
        while((currentNode = priorityQueue.poll()) != null){
            for(Stap edge: currentNode.getEdges()){
                Plek node = edge.getOther(currentNode);
                if(!node.getCompleted()){
                    Reis newPossiblePath = new Reis(currentNode.getShortestPath());
                    newPossiblePath.addEdge(edge);
                    if(newPossiblePath.compareTo(node.getShortestPath()) < 0){
                        priorityQueue.remove(node);
                        node.setShortestPath(newPossiblePath);
                        priorityQueue.add(node);
                    }
                }
            }
            currentNode.setCompleted(true);
        }
        Reis result = end.getShortestPath();
        this.reset();
        return result;
    }
}
