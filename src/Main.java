import graphs.DijkstraGraph;
import journeys.Reis;
import misc.DijkstraError;
import places.Plek;
import steps.Treinrit;
import steps.Vlucht;

public class Main{
    public static void main(String[] args) throws DijkstraError {

        // Demonstration 1
        Plek haarlem = new Plek("Haarlem");
        Plek leiden = new Plek("Leiden");
        Plek utrecht = new Plek("Utrecht Centraal");
        Plek amsterdam = new Plek("Amsterdam Centraal");
        Plek castricum = new Plek("Castricum");
        Plek beverwijk = new Plek("Beverwijk");

        // Only Amsterdam - Utrecht needs to be saved for demonstration purposes.
        Treinrit trainAdamUtrecht = new Treinrit(utrecht, amsterdam, 26);
        new Treinrit(utrecht, leiden, 42);
        new Treinrit(leiden, haarlem, 20);
        new Treinrit(amsterdam, haarlem, 15);
        new Treinrit(amsterdam, castricum, 26);
        new Treinrit(haarlem, beverwijk, 16);
        new Treinrit(castricum, beverwijk, 13);

        DijkstraGraph treinGraph = new DijkstraGraph(utrecht,
                amsterdam, leiden, haarlem, castricum, beverwijk);

        Reis trainJourney = treinGraph.shortestPath(utrecht, beverwijk);

        System.out.println("Kortste reis van Utrecht naar Beverwijk normaal:");
        System.out.println(trainJourney + "\n");

        // Demonstration 2: there's a delay between Amsterdam and Utrecht.
        trainAdamUtrecht.setCurrentDelay(30);

        trainJourney = treinGraph.shortestPath(utrecht, beverwijk);

        System.out.println("Kortste reis van Utrecht naar Beverwijk met 30min vertraging tussen Utrecht en Amsterdam:");
        System.out.println(trainJourney);

        // Demonstration 3: planes
        Plek schiphol = new Plek("Schiphol");
        Plek moscow = new Plek("Moscow");
        Plek bakoe = new Plek ("Bakoe");
        Plek berlin = new Plek("Berlin");
        Plek helsinki = new Plek("Helsinki");

        // Long distance flights with reputable airlines
        new Vlucht(schiphol, moscow, 180);
        new Vlucht(schiphol, helsinki, 159, 900, 0.1);

        // Budget short-distance flights
        new Vlucht(schiphol, berlin, 25, 900, 1);
        new Vlucht(berlin, helsinki, 30, 900, 1);
        new Vlucht(helsinki, moscow, 50, 900, 1.5);

        new Vlucht(berlin, bakoe, 70, 900, 2);
        new Vlucht(bakoe, moscow, 9, 900, 2);

        DijkstraGraph airplaneGraph = new DijkstraGraph(schiphol, moscow, bakoe, helsinki, berlin);

        Reis airplaneJourney = airplaneGraph.shortestPath(schiphol, moscow);

        System.out.println("Goedkoopste manier om van Schiphol naar Moskau te gaan:");
        System.out.println(airplaneJourney);
    }
}
