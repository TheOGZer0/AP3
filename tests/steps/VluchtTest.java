package steps;

import misc.DijkstraError;
import org.junit.jupiter.api.Test;
import places.Plek;

import static org.junit.jupiter.api.Assertions.*;

class VluchtTest{
    private Plek plek1 = new Plek("plek1");
    private Plek plek2 = new Plek("plek2");
    private Vlucht vlucht1 = new Vlucht(plek1, plek2, 100);
    private Vlucht vlucht2 = new Vlucht(plek1, plek2, 100, 200, 10);

    VluchtTest() throws DijkstraError {
    }

    @Test
    void testConstructor(){
        assertEquals(2, plek1.getEdges().size(), "Rit constructor should automatically call" +
                ".connect() on plek instances being connected to.");
    }

    @Test
    void getOther() {
        assertEquals(plek2, vlucht1.getOther(plek1), "Vlucht should be able to get Plek connected to other side, " +
                "both ways.");
        assertEquals(plek1, vlucht1.getOther(plek2), "Vlucht should be able to get Plek connected to other side, " +
                "both ways.");
    }

    @Test
    void getWeight() {
        assertEquals(100, vlucht1.getWeight(), "Vlucht weight should be able to work without" +
                "associated baggage Price / LossChance.");
        assertEquals(120, vlucht2.getWeight(), "Vlucht weight should be able to incorporate" +
                "baggage Price / LossChance.");
    }
}