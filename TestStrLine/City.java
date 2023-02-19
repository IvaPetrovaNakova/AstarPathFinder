package TestStrLine;

import java.util.ArrayList;

/**
 * This class represent the city from itself
 * The city has minimum one route connected him
 * to another city and back in the country.
 * List of neighbours content all possible paths.
 * The main methods make some basic calculation calling
 * it after in a AStar calculation and finding the short distance
 *
 */

public class City implements Comparable<City>{
    protected String cityName;
    protected String target;
    private final ArrayList<Trip> listOfNeighbours; //children
    protected City previuslyCity;//get previously city name
    private final int hCost; //hCost - distance to goal
    private int fCost; //g(n)+h(n)
    protected int gCost;//distance in km, if travel start here the value is zero

    /**
    * Class constructor specifying number of objects to create
     *
     * @param cityName string
     * @param heuristicCost distance in straight line
    **/
    public City(String cityName, String target, int heuristicCost) {
        this.cityName = cityName;
        this.target = target;
        listOfNeighbours = new ArrayList<>();
        this.previuslyCity = null;
        this.hCost = heuristicCost;
        this.fCost = 0;
        this.gCost = 0;
    }

    /**
     * Gives the city name
     *
     * @return String name of the city
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Gets the list of neighbors
     *
     * @return List of neighbors
     */
    public ArrayList<Trip> getListOfNeighbours() {
        return listOfNeighbours;
    }

    public int gethCost() {
        return hCost;
    }

    /**
     * Gives the straight line distance to goal
     *
     * @return int air distance
     */
    public int getHeuristicCost(City goal) {

      return goal.hCost;
    }

    /**
     *Sets the city that already take as previously
     * @param city current city
     */
    public void setGCost(City city) {
        previuslyCity = city;
    }

    /**
     * Try to find the neighbor city and connects both cities
     *
     * @param neighbour city, the city we are looking for
     * @return Neighbor city found
     */
    public Trip connects(City neighbour) {
        Trip neighbourFound = null;
        //TODO - make comment
        for (int i = 0; i < listOfNeighbours.size(); i++) {
            if (listOfNeighbours.get(i)
                    .sameCity(this).cityName
                    .equals(neighbour.cityName)) {
                neighbourFound = listOfNeighbours.get(i);
            }
        }
        return neighbourFound;
    }

    /**
     * The setDistance method adds previously cost
     * and travel distance into the current point
     * Set starting point is zero
     *
     * @return  travelled value
     */
    public int setDistance() {
        //the cost of getting from the initial node to n in km
        if (previuslyCity == null) {
            gCost = 0; //when city is the root
        } else {
            gCost = previuslyCity.gCost + connects(previuslyCity).getTravelDistance();
        }
        return gCost;
    }

    /**
     * Method calculateScore the score that
     * the current city has in a search by adding its
     * distance to the heuristic.
     * This is the result of criteria function
     *
     * @param goal the end goal for the search
     */
    public void criteriaFunction(City goal) {
        fCost = setDistance() + getHeuristicCost(goal);
    }

    /**
     * The method override heuristic comparator
     *
     * @param cityToCompare the object to be compared.
     * @return
     */
    @Override
    public int compareTo(City cityToCompare) {
        if (this.fCost < cityToCompare.fCost) {
            return -1;
        } else if (this.fCost > cityToCompare.fCost) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.cityName;
    }
}

