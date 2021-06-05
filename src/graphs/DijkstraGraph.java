package graphs;

import journeys.Reis;
import places.Plek;
import steps.Stap;

import java.util.PriorityQueue;

import java.util.HashSet;
import java.util.Set;

//TODO: Add exception for negative weights.
public class DijkstraGraph{
    private Set<Plek> nodes = new HashSet<>();

    private void reset(){
        for(Plek node: this.nodes){
            node.setShortestPath(new Reis());
            node.setCompleted(false);
        }
    }

    public void addToNodes(Plek node){
        this.nodes.add(node);
    }

    public DijkstraGraph(){};
    public DijkstraGraph(Plek... nodes){
        for(Plek node: nodes){
            this.addToNodes(node);
        }
    }

    public Reis shortestPath(Plek start, Plek end){
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
        return end.getShortestPath();
    }
}
