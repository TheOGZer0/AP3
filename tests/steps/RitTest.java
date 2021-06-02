package steps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import places.Plek;

import static org.junit.jupiter.api.Assertions.*;

class RitTest {
    private Plek plek1 = new Plek("plek1");
    private Plek plek2 = new Plek("plek2");
    private Rit rit1 = new Rit(plek1, plek2, 10);

    @Test
    void testConstructor(){
        assertEquals(1, plek1.getEdges().size(), "Rit constructor should automatically call" +
                ".connect() on plek instances being connected to.");
    }

    @Test
    void getOther(){
        assertEquals(plek2, rit1.getOther(plek1), "Rit should be able to get Plek connected to other side, " +
                "both ways.");
        assertEquals(plek1, rit1.getOther(plek2), "Rit should be able to get Plek connected to other side, " +
                "both ways.");
    }

    @Test
    void getWeight(){
        assertEquals(rit1.getWeight(), 10, "Rit should be able to fetch associated weight.");
    }
}