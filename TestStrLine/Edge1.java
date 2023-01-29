package TestStrLine;

/**
 * The Edge class holds an Edge object, which will store the weight of the edge and the two vertices that
 * connect it.
 * @ author iva
 * @version 12 01 2023
 */

public class Edge1 implements Comparable<Edge1> {
    private Vertex1 v1;
    private Vertex1 v2;
    public double weight;

    /**
     * Class constructor specifying number of objects to create.
     */
    public Edge1(Vertex1 vert1, Vertex1 vert2, double weight) {
        this.v1 = vert1;
        this.v2 = vert2;
        this.weight = weight;
    }

    /**
     * Returns whatever vertex isn't given that shares the same edge.
     *
     * @param v the initial vertex
     * @return the other vertex
     */
    public Vertex1 getOther(Vertex1 v) {
        if (v.city.equals(v1.city)) {
            return v2;
        } else if (v.city.equals(v2.city)) {
            return v1;
        } else {
            return null;
        }
    }

    /**
     * The compareTo method compares the weight of the current edge to the weight of another edge.
     * If the current edge is bigger, it returns 1.
     * If the current edge is smaller, it returns -1.
     * If the edges are the same weight, it returns 0.
     */
    @Override
    public int compareTo(Edge1 other) {
        double temp = weight - other.weight;
        if (temp > 0) {
            temp = 1;
        } else if (temp < 0) {
            temp = -1;
        }
        return (int) temp;
    }

    /**
     * The toString() method prints general information about the edge
     *
     * @return a string containing the two vertices and the weight
     */
    public String toString() {
        String s = "v1 = " + v1.city + ", v2 = " + v2.city + ", weight = " + weight;
        return s;
    }
}
