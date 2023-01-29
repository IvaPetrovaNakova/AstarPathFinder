package TestStrLine;

import dataStructure.MyArrayList;

/**
 * The Vertex class holds a vertex object, which will hold the latitude and longitude of the vertex
 * along with the name of the city itself.
 *
 * @ a
 *
 * @param lat   the latitude
 * @param llong the longitude
 * @param name  the city name
 */
public class Vertex1 implements Comparable<Vertex1> {
    //private final double latitude;
    //private final double longitude;

    private final double straightLine;

    // getH() this is heuristic function(at here we just give a number,but maybe can use the straight-line distance to replace)
    private double hCost; //TODO - change it later ///the estimate, according to the heuristic function, of the cost of getting from n to the goal node.
    protected String city; //city name

    //stores an arraylist of all the edges connected to this vertex
    protected MyArrayList<Edge1> edges;

    //holds the score of the vertex when come across in a search
    protected double fCost; ////g(n)+h(n), intuitively, this is the estimate of the best solution that goes through n
    protected double gCost; //the cost of getting from the initial node to n
    protected Vertex1 parent; //the vertex that hold the previously cost

    /**
     * Class constructor specifying number of objects to create.
     */
    public Vertex1(String name, double straightLine) {
        this.straightLine = straightLine;
        this.edges = new MyArrayList<Edge1>();
        this.fCost = 0;
        this.gCost = 0;
        this.hCost = 0;
        this.city = name;
        this.parent = null;
    }

    /**
     * Returns a list of the edges connected to this vertex.
     *
     * @return edge ArrayList
     */
    public MyArrayList<Edge1> getEdges() {
        return edges;
    }

    /**
     * @return the city name
     */
    public String toString() {
        return this.city;
    }

    /**
     * The Heuristic method takes in a vertex and calculates the distance between it
     * and the current vertex using the formula for distance between two points on a sphere.
     *
     * @param v the other vertex
     * @return the straight line distance between current vertex and the other vertex
     */

    //TODO
    public double getStraightLineDistance(Vertex1 v) {

        hCost = straightLine + gCost;

        return hCost;
    }

    /**
     * Method calculateScore the score that the current vertex has in a search by adding its
     * distance to the heuristic. This is the result of criteria function
     *
     * @param goal the end goal for the search
     */
    public void criteriaFunction(Vertex1 goal) {
        fCost = setDistance() + getStraightLineDistance(goal); //fCost = g(n) + h(n)
    }

    /**
     * setPrev sets the current vertex's prev value
     *
     * @param v the vertex's previous value
     */
    public void setGCost(Vertex1 v) {
        parent = v;
    }

    /**
     * The setDistance method calculates the distance travelled in a search to reach the current vertex.
     *
     * @return distance travelled
     */
    //TODO - should I set the straight line - air distance in this calculation - to check
    //TODO - May I should add here the formula f(n) = h(n) + g(n) - criteria function
    public double setDistance() {
        if (parent == null) {
            gCost = 0; //when vertex is the starting point
        } else {
            gCost = parent.gCost + sharedEdge(parent).weight;
        }
        return gCost;
    }

    /**
     * the compareTo method compares two vertices based on their current scores, with the smaller score receiving
     * a value of 1.
     *
     * @param v the other vertex
     * @return the position of the current vertex in comparison to the other vertex
     */
    @Override
    public int compareTo(Vertex1 v) { //heuristic comparator
        if (this.fCost > v.fCost) {
            return -1;
        } else if (this.fCost < v.fCost) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * The sharedEdge method finds the edge shared between two vertices.
     *
     * @param v the other vertex
     * @return the shared edge
     */
    public Edge1 sharedEdge(Vertex1 v) {
        Edge1 edge = null;
        //loops through each edge connected to the current vertex, checking to see if the edge
        //connects the current vertex with the inputted vertex
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getOther(this).city.equals(v.city)) {
                edge = edges.get(i);
            }
        }
        return edge;
    }
}
