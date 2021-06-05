package journeys;

import misc.DijkstraError;
import org.junit.jupiter.api.Test;
import places.Plek;
import steps.Rit;
import steps.Stap;
import steps.Treinrit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReisTest {

    @Test
    void testConstructor(){
        assertEquals(0, new Reis().getLength(), "Empty reis should be initialized at length 0" +
                " when no parameter is specified.");

        assertEquals(Double.POSITIVE_INFINITY, new Reis(true).getLength(), "Empty reis should be" +
                " initialized at length infinity when constructor is called with parameter initAtInfinity = true.");
    }

    @Test
    void addEdge() throws DijkstraError {
        Plek plek1 = new Plek("Plek1");
        Plek plek2 = new Plek("Plek2");

        Stap rit = new Rit(plek1, plek2, 15);

        Reis reis = new Reis();

        reis.addEdge(rit);

        List<Stap> edgeList = new ArrayList<>();
        edgeList.add(rit);

        assertEquals(reis.getTraversedEdges(), edgeList, "addEdge(Stap) should add Stap parameter to" +
                " this.traversedEdges.");

        assertEquals(reis.getLength(), 15, "addEdge(Stap) should increment Reis.length with Stap.weight.");
    }

    @Test
    void testCopyConstructor() throws DijkstraError {
        Plek plek1 = new Plek("Plek1");
        Plek plek2 = new Plek("Plek2");
        Plek plek3 = new Plek("Plek3");

        Stap rit1 = new Rit(plek1, plek2, 57);
        Stap rit2 = new Rit(plek2, plek3, 157);

        Reis reis1 = new Reis();

        reis1.addEdge(rit1);
        reis1.addEdge(rit2);

        Reis reis2 = new Reis(reis1);

        assertEquals(reis1.getTraversedEdges(), reis2.getTraversedEdges(), "Reis created using" +
                " copy constructor should return same List containing Stap objects as original Reis.");

        assertEquals(reis1.getLength(), reis2.getLength(), "Reis created using copy constructor" +
                " should have same length as original Reis.");
    }

    @Test
    void compareTo() throws DijkstraError {
        Plek plek1 = new Plek("Plek1");
        Plek plek2 = new Plek("Plek2");

        Stap ritLength5 = new Rit(plek1, plek2, 5);
        Stap ritLength10 = new Rit(plek1, plek2, 10);

        Reis reisWithRitLength5Rits = new Reis();
        Reis reisWithRitLength10Rits = new Reis();

        reisWithRitLength5Rits.addEdge(ritLength5);
        reisWithRitLength10Rits.addEdge(ritLength10);

        assertTrue(reisWithRitLength5Rits.compareTo(reisWithRitLength10Rits) < 0,
                "compareTo should return int smaller then 0 when instance method is called on" +
                        " has less total length (based on stored steps) then instance that was passed as" +
                        " parameter.");

        reisWithRitLength5Rits.addEdge(ritLength5);

        assertTrue(reisWithRitLength5Rits.compareTo(reisWithRitLength10Rits) == 0,
                "compareTo should not be based on amount of Stap instances stored in Reis instances being" +
                        " compared, but on the Stap lengths.");
    }

    @Test
    void equals() throws DijkstraError {
        Plek plek1 = new Plek("Plek1");
        Plek plek2 = new Plek("Plek2");

        Stap ritLength5 = new Rit(plek1, plek2, 5);
        Stap ritLength10 = new Rit(plek1, plek2, 10);

        Reis reis1TestCase1 = new Reis();
        Reis reis2TestCase1 = new Reis();

        reis1TestCase1.addEdge(ritLength5);
        reis2TestCase1.addEdge(ritLength5);

        reis1TestCase1.addEdge(ritLength10);
        reis2TestCase1.addEdge(ritLength10);

        assertEquals(reis2TestCase1, reis1TestCase1, "Reis instances with identical traversedEdges" +
                " should be equal.");

        Reis reis1TestCase2 = new Reis();
        Reis reis2TestCase2 = new Reis();

        reis1TestCase2.addEdge(ritLength5);
        reis1TestCase2.addEdge(ritLength10);

        reis2TestCase2.addEdge(ritLength10);
        reis2TestCase2.addEdge(ritLength5);

        assertNotEquals(reis2TestCase2, reis2TestCase1, "Reis equality should" +
                " include traversed edge order.");

        Reis reis1TestCase3 = new Reis();
        Reis reis2TestCase3 = new Reis();

        Treinrit treinRitVariableLength = new Treinrit(plek1, plek2, 10);

        reis1TestCase3.addEdge(treinRitVariableLength);

        treinRitVariableLength.setCurrentDelay(10);

        reis2TestCase3.addEdge(treinRitVariableLength);

        assertEquals(reis2TestCase3, reis1TestCase3, "Reis equality should not be based on length," +
                "but solely on contained Stap instances.");
    }
}