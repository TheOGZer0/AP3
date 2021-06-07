import graphs.DijkstraGraph;
import journeys.Reis;
import misc.DijkstraError;
import places.Plek;
import steps.Treinrit;

public class Main{
    public static void main(String[] args) throws DijkstraError {

        // Demonstration 1
        Plek haarlem = new Plek("Haarlem");
        Plek leiden = new Plek("Leiden");
        Plek utrechtCentraal = new Plek("Utrecht Centraal");
        Plek amsterdamCentraal = new Plek("Amsterdam Centraal");
        Plek castricum = new Plek("Castricum");
        Plek beverwijk = new Plek("Beverwijk");

        // Only Amsterdam - Utrecht needs to be saved for demonstration purposes.
        Treinrit trainAdamUtrecht = new Treinrit(utrechtCentraal, amsterdamCentraal, 26);
        new Treinrit(utrechtCentraal, leiden, 42);
        new Treinrit(leiden, haarlem, 20);
        new Treinrit(amsterdamCentraal, haarlem, 15);
        new Treinrit(amsterdamCentraal, castricum, 26);
        new Treinrit(haarlem, beverwijk, 16);
        new Treinrit(castricum, beverwijk, 13);

        DijkstraGraph treinGraph = new DijkstraGraph(utrechtCentraal,
                amsterdamCentraal, leiden, haarlem, castricum, beverwijk);

        Reis trainJourney = treinGraph.shortestPath(utrechtCentraal, beverwijk);

        System.out.println("Kortste reis van Utrecht naar Beverwijk normaal:");
        System.out.println(trainJourney + "\n");

        // Demonstration 2: there's a delay between Amsterdam and Utrecht.
        trainAdamUtrecht.setCurrentDelay(30);

        trainJourney = treinGraph.shortestPath(utrechtCentraal, beverwijk);

        System.out.println("Kortste reis van Utrecht naar Beverwijk met 30min vertraging tussen Utrecht en Amsterdam:");
        System.out.println(trainJourney);

    }
}
