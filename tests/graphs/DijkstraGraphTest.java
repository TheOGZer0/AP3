package graphs;

import journeys.Reis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import places.Plek;
import steps.Rit;
import steps.Stap;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraGraphTest {
    private Plek start;
    private Plek end;
    private Plek p1;
    private Plek p2;
    private Plek p3;

    // Only really need to save the shortest path Stap instances
    // for testing purposes
    private Stap sp1;
    private Stap p1p2;
    private Stap p2p3;
    private Stap p3e;

    private DijkstraGraph graph;

    @BeforeEach
    void setup(){
        this.start = new Plek("Start");
        this.end = new Plek("End");
        this.p1 = new Plek("p1");
        this.p2 = new Plek("p2");
        this.p3 = new Plek("p3");

        this.sp1 = new Rit(start, p1, 2);
        new Rit(p1, p3, 10);
        this.p3e = new Rit(p3, end, 2);
        new Rit(start, p2, 10);
        new Rit(p2, end, 10);
        this.p1p2 = new Rit(p1, p2, 2);
        this.p2p3 = new Rit(p2, p3, 2);

        this.graph = new DijkstraGraph(start,
                end,
                p1,
                p2,
                p3);
    }

    @Test
    void shortestPath() {
        Reis expectedPath = new Reis();

        expectedPath.addEdge(sp1);
        expectedPath.addEdge(p1p2);
        expectedPath.addEdge(p2p3);
        expectedPath.addEdge(p3e);

        assertEquals(expectedPath, graph.shortestPath(start, end),
                "Must be able to find shortest path through graph.");

        assertEquals(expectedPath, graph.shortestPath(start, end),
                "Algorithm must reset Plek / Reis properties after finishing.");
    }
}