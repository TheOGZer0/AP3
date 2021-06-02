package steps;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import places.Plek;

import static org.junit.jupiter.api.Assertions.*;

class TreinritTest {
    private Plek plek1 = new Plek("plek1");
    private Plek plek2 = new Plek("plek2");
    private Treinrit treinRit1 = new Treinrit(plek1, plek2, 10);

    @Test
    @Order(1)
    void testConstructor(){
        assertEquals(1, plek1.getEdges().size(), "Treinrit constructor should automatically call" +
                ".connect() on plek instances being connected to.");
    }

    @Test
    @Order(2)
    void getOther() {
        assertEquals(plek2, treinRit1.getOther(plek1), "Treinrit should be able to get Plek connected to other side, " +
                "both ways.");
        assertEquals(plek1, treinRit1.getOther(plek2), "Treinrit should be able to get Plek connected to other side, " +
                "both ways.");
    }

    @Test
    @Order(3)
    void getWeight() {
        assertEquals(10, treinRit1.getWeight(), "Treinrit should be able to fetch associated weight.");

        treinRit1.setCurrentDelay(5);

        assertEquals(15, treinRit1.getWeight(), "Treinrit weight should incorporate delays," +
                " and be able to change it.");
    }
}