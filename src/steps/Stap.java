package steps;

import misc.DijkstraError;
import places.Plek;

public abstract class Stap{
    protected final Plek a;
    protected final Plek b;

    public Stap(Plek a, Plek b) throws DijkstraError{
        this.a = a;
        this.b = b;
        a.connect(this);
        b.connect(this);
    }

    public Plek getOther(Plek origin){
        if(origin == this.a){
            return this.b;
        }else{
            return this.a;
        }
    }

    public abstract String toString();
    public abstract double getWeight();

    protected void verifyWeight() throws DijkstraError{
        if(this.getWeight() < 0){
            throw new DijkstraError(this);
        }
    }
}
