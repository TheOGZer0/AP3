import java.util.ArrayList;
import java.util.List;

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

    public void addEdge(Stap stap){
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


}
