package places;

import journeys.Reis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlekTest {


    @Test
    void compareTo() {
        Reis shortReis = new Reis(false);
        Reis longReis = new Reis(true);

        Plek plekShortReis = new Plek("plekShort");
        Plek plekLongReis = new Plek("plekLong");

        plekShortReis.setShortestPath(shortReis);
        plekLongReis.setShortestPath(longReis);

        assertEquals(shortReis.compareTo(longReis),
                plekShortReis.compareTo(plekLongReis),
                "Plek.compareTo should pass comparison onto own shortestJourney.compareTo.");
    }

    @Test
    void testEquals() {
        assertEquals(new Plek("abcde"),
                new Plek("abcde"),
                "Plek equals should be based on unique name.");

        assertFalse(new Plek("abcde") == new Plek("edcba"),
                "Plek instances with different names should not be equal.");
    }
}