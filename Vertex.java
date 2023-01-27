import java.util.ArrayList;

/**
 * The Vertex class holds a vertex object, which will hold the latitude and longitude of the vertex
 * along with the name of the city itself.
 *
 * @param lat   the latitude
 * @param llong the longitude
 * @param name  the city name
 */
public class Vertex implements Comparable<Vertex> {
    private double latitude;
    private double longitude;
    protected String city; //city name

    //stores an arraylist of all the edges connected to this vertex
    protected ArrayList<Edge> edges;

    //holds the score of the vertex when come across in a search
    protected double score;
    protected double gx; //holds the distance travelled to this vertex when come across in a search
    protected Vertex prev; //the vertex that led to this vertex in a search
    private final int R = 6371; //radius of earth

    /**
     * Class constructor specifying number of objects to create.
     */
    public Vertex(String name, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.edges = new ArrayList<Edge>();
        this.score = 0;
        this.gx = 0;
        this.city = name;
        this.prev = null;
    }

    /**
     * Returns a list of the edges connected to this vertex.
     *
     * @return edge ArrayList
     */
    public ArrayList<Edge> getEdges() {
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
     * @return the crow-flies distance between current vertex and the other vertex
     */
    public double heuristicEuclideanDistance(Vertex v) {

        //convert all the values from degrees to radians
        double lata = this.latitude * (Math.PI / 180);
        double latb = v.latitude * (Math.PI / 180);
        double lona = this.longitude * (Math.PI / 180);
        double lonb = v.longitude * (Math.PI / 180);

        //uses distance formula to calculate the distance
        double distance = Math.acos(Math.sin(lata) * Math.sin(latb) +
                Math.cos(lata) * Math.cos(latb) * Math.cos(lona - lonb)) * R;

        return distance;
    }

    /**
     * The recalcScore method calculates the score that the current vertex has in a search by adding its
     * distance to the heuristic.
     *
     * @param goal the end goal for the search
     */
    public void recalcScore(Vertex goal) {
        score = setDistance() + heuristicEuclideanDistance(goal);
    }

    /**
     * setPrev sets the current vertex's prev value
     *
     * @param v the vertex's previous value
     */
    public void setPrev(Vertex v) {
        prev = v;
    }

    /**
     * The setDist method calculates the distance travelled in a search to reach the current vertex.
     *
     * @return distance travelled
     */
    public double setDistance() {
        if (prev == null) {
            gx = 0;
        } else {
            gx = prev.gx + sharedEdge(prev).w;
        }
        return gx;
    }

    /**
     * the compareTo method compares two vertices based on their current scores, with the smaller score receiving
     * a value of 1.
     *
     * @param v the other vertex
     * @return the position of the current vertex in comparison to the other vertex
     */
    @Override
    public int compareTo(Vertex v) {
        if (this.score > v.score) {
            return -1;
        } else if (this.score < v.score) {
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
    public Edge sharedEdge(Vertex v) {
        Edge edge = null;
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
