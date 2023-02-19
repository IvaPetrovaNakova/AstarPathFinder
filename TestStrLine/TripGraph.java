package TestStrLine;
import java.util.*;

/**
* The class contains several methods helping to collect
* all cities and existing paths between them in the map
**/

public class TripGraph {
    private final HashMap<String, Integer> listOfCities; //collect all cities
    private final City[] tripGraph; //collect cities and existing path between them
    private int countCityAirConnections;
    private int countPathConnections;

    /**
     * Class constructor specifying number of objects to create.
     *
     * @param size show the number of city in the graph
     */
    public TripGraph(int size) {
        this.tripGraph = new City[size];
        this.listOfCities = new HashMap<>();
    }

    /**
     * Method adds the city in the map listOfCities
     *
     * @param city1         reading from file and saving in map
     * @param city2         reading from file and saving in map
     * @param heuristicCost takes the air distance
     **/
    public void addCity(
            String city1,
            String city2,
            int heuristicCost
    ) {
        listOfCities.put(city1, countCityAirConnections); //store in map
        City newCity = new City(city1, city2, heuristicCost); //create new city
        tripGraph[countCityAirConnections] = newCity; //store in the graph
        countCityAirConnections++; //increments
    }

    /**
     * Adds existing paths between all possible city in the map
     *
     * @param city1          starting point
     * @param city2          ending point
     * @param travelDistance existing distance in kilometer
     */
    public void addLink(
            String city1,
            String city2,
            int travelDistance
    ) {
        //gets the position of the city from the map
        int c1 = listOfCities.get(city1);
        int c2 = listOfCities.get(city2);
        connectBothDirections(tripGraph[c1], tripGraph[c2], travelDistance);
        countPathConnections++;
    }

    /**
     * Helper method create paths in both direction
     * Two direct connection between given cities
     *
     * @param city1          starting point
     * @param city2          ending point
     * @param travelDistance existing path in kilometers
     */
    private void connectBothDirections(
            City city1,
            City city2,
            int travelDistance
    ) {
        //creates trips form-to and opposite
        Trip c1ToC2 = new Trip(city1, city2, travelDistance);
        Trip c2ToC1 = new Trip(city2, city1, travelDistance);
        //adds the path between two cities in neighbour list
        city1.getListOfNeighbours().add(c1ToC2);
        city2.getListOfNeighbours().add(c2ToC1);

//        Trip newTrip = new Trip(city1, city1, travelDistance);
//        city1.getListOfNeighbours().add(newTrip);
//        city2.getListOfNeighbours().add(newTrip);
    }

    /**
     * The method calculate the total travel distance
     * Print the result in the console
     *
     * @param city1 searching city
     * @return score in kilometers
     */
    public int getTotalTravelDistance(String city1) {
        int endCityIndex = listOfCities.get(city1);
        return tripGraph[endCityIndex].gCost;
    }

    /**
     * A star method takes two city names
     * Gets the index from the cities list
     * Calls the method search
     *
     * @param fromCity start city name get the index in graph
     * @param toCity   goal name get the index from graph
     * @return An arraylist of the path taken to connect cities
     */
    public ArrayList<City> aStarConnection(
            String fromCity,
            String toCity
    ) {
        int fromIndex = listOfCities.get(fromCity);
        int toIndex = listOfCities.get(toCity);
        return aStarSearch(
                tripGraph[fromIndex],
                tripGraph[toIndex]
        );
    }

    /**
     * A star search method takes to cities name
     * Iterating through they neighbour, collect them
     * Call criteria function to calculate the distance
     * representing the shortest path between them
     * using distance travelled and heuristic.
     *
     * @param fromCity input the starting point
     * @param toCity   input the ending point
     * @return An arraylist of the path taken to connect the cities
     */
    private ArrayList<City> aStarSearch(City fromCity, City toCity) {
        //OpenList keeps track of those neighbours that need to be examined
        PriorityQueue<City> openList = new PriorityQueue<City>();
        //ClosedList stores cities already visited
        Hashtable<City, City> closedList = new Hashtable<City, City>();
        boolean reachGoal = false;
        City currentPosition = fromCity;

        //loops the neighbours of starting city
        //adds the neighbour in to the open list with comparing the fCost
        for (int i = 0; i < fromCity.getListOfNeighbours().size(); i++) {
            Trip t = fromCity.getListOfNeighbours().get(i);
            City c = t.sameCity(fromCity);//sure the root state
            c.setGCost(fromCity);//sets previous city
            c.criteriaFunction(toCity);//calculates score to goal
            //TODO
            //before adding we have to compare - think about how to use comparator here
            openList.add(c); //adds the neighbours possible links in order to sort them
        }

        closedList.put(fromCity, fromCity);

        //while the priority queue isn't empty and the goal hasn't been reached
        while (openList.size() > 0 && !reachGoal) {

            //take the item with min fCost from the top of priority queue
            currentPosition = openList.poll();

            //if you've reached the goal
            if (currentPosition.getCityName().equals(toCity.getCityName())) {
                reachGoal = true;
                //put on closed list in order to correctly trace back the path
                closedList.put(currentPosition, currentPosition.previuslyCity);
                currentPosition.criteriaFunction(toCity); //get the final score
                break;
            }

            //loops the neighbours city from PQ
            for (int i = 0; i < currentPosition.getListOfNeighbours().size(); i++) {
                Trip t = currentPosition.getListOfNeighbours().get(i);
                City c = t.sameCity(currentPosition);
                c.criteriaFunction(toCity);

                //if it is not already in the priority queue it hasn't been visited yet
                if (!openList.contains(c) && !closedList.containsKey(c)) {
                    c.setGCost(currentPosition);
                    openList.add(c);
                }
            }
            //put current on the closed list
            closedList.put(currentPosition, currentPosition.previuslyCity);
        }

        //if you haven't met your goal and the priority queue is empty,
        // there is no path to connect the searching
        if (!reachGoal) {
            return null;
        }
        return findPath(closedList, fromCity, toCity);
    }

    /**
     * The returnPath method retraces the path taken by
     * a search and returns the final path. This method will
     * never be called if there is not a guaranteed path
     *
     * @param finder storing a list of cities and where those cities came from
     * @param fromCity starting point given in the search
     * @param toCity the goal of the search
     * @return path     an arraylist of the path
     */
    private ArrayList<City> findPath(
            Hashtable<City, City> finder,
            City fromCity,
            City toCity
    ) {
        ArrayList<City> path = new ArrayList<City>();
        City curr = toCity;
        City departed;
        //while the start isn't reached, retrace
        while (!curr.cityName.equals(fromCity.cityName)) {
            departed = finder.get(curr);
            path.add(0, curr);
            curr = departed;
        }
        //add the first step onto the path
        path.add(0, curr);
        return path;
    }

}