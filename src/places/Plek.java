package places;

import journeys.Reis;
import steps.Stap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plek implements Comparable<Plek>{
    private final String name;
    private List<Stap> edges = new ArrayList<>();
    private Reis shortestPath = new Reis(true);
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

    @Override
    public int compareTo(Plek o) {
        return this.shortestPath.compareTo(o.getShortestPath());
    }

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
