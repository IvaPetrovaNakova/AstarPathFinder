package TestStrLine;

import dataStructure.MyArrayList;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Graph1 {
    private int numVertices; //counts the number of vertices added to the array list
    private int numEdges; //counts the number of edges added to the graph
    private Vertex1[] graph; //an array that holds every vertex in the graph

    /* in this hash map, the key is the city name, and the value is its location in the vertex array */
    private HashMap<String, Integer> cities; //store the start and end destination only

    /**
     * Class constructor specifying number of objects to create.
     */
    public Graph1(int size) {
        this.graph = new Vertex1[size]; //set the array to be the size of the number of edges
        this.cities = new HashMap<>();
        this.numVertices = 0;
        this.numEdges = 0;
    }

    /**
     * The addVertex method adds a vertex to the graph.
     *
     * @param v1   name of the city
     * @param lat  latitude
     * @param long longitude
     * @param s
     */
    public void addVertex(String cityNameFrom, String cityNameTo, double straightLine) {
        cities.put(cityNameFrom, numVertices); //put into the hashmap to store its index in the vertices array
        Vertex1 vert = new Vertex1(cityNameFrom, straightLine); //create a new vertex
        graph[numVertices] = vert; //store it in the array
        numVertices++;
    }

    /**
     * Returns the number of vertices, which is incremented every time a vertex is added.
     *
     * @return numVertices
     */
    public int countVertices() {
        return numVertices;
    }

    /**
     * Returns the number of edges, which is incremented every time an edge is added.
     *
     * @return numEdges
     */
    public int countEdges() {
        return numEdges;
    }

    /**
     * The addEdge method calls another method that adds an edge between two vertices.
     *
     * @param v1     first vertex
     * @param v2     second vertex
     * @param weight edge weight
     */
    public void addEdge(String v1, String v2, double weight) {
        //gets the position of the vertices in the array
        int ve1 = cities.get(v1);
        int ve2 = cities.get(v2);
        //calls the method on two vertices instead of two strings
        addEdgeHelper(graph[ve1], graph[ve2], weight);
        //increments
        numEdges++;
    }

    /**
     * The addEdge method adds an edge between two vertices.
     *
     * @param v1     first vertex
     * @param v2     second vertex
     * @param weight edge weight
     */
    private void addEdgeHelper(Vertex1 v1, Vertex1 v2, double weight) {
        //creates a new edge
        Edge1 edge = new Edge1(v1, v2, weight);
        //adds the new edge to the list of edges that each vertex stores
        v1.edges.add(edge);
        v2.edges.add(edge);
    }

    /**
     * The getScore method returns the score of a vertex in a search.
     *
     * @param v1 vertex to search
     * @return score
     */
    public double getTotalDistanceInKm(String v1) {
        int endCityIndex = cities.get(v1);
        return graph[endCityIndex].fCost;
    }

    /**
     * The areAdjacent method returns whether two vertices share an edge.
     *
     * @param v1,v2 the two vertices
     * @return true if they share an edge, false if otherwise
     */
    private boolean areAdjacent(Vertex1 v1, Vertex1 v2) {
        for (int i = 0; i < v1.edges.size(); i++) {
            if (v1.edges.get(i).getOther(v1).city.equals(v2.city)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The getAdjacencyList returns a list of all the vertices that are adjacent to a vertex.
     *
     * @param v1 vertex to explore
     * @return array of adjacent vertices
     */
    public Vertex1[] getAdjacencyList(Vertex1 v1) {

        Vertex1[] adj = new Vertex1[v1.edges.size()];

        /* loops through all the edges connected to the vertex
        and adds the vertex at the other end of the edge to the array */
        for (int i = 0; i < v1.edges.size(); i++) {
            adj[i] = v1.edges.get(i).getOther(v1);
        }
        return adj;
    }

    /**
     * The heuristic method takes in two city names and calculates the heuristic between the first and the second.
     *
     * @param v1 initial vertex
     * @param v2 goal vertex
     * @return heuristic distance
     */
    //TODO - check usages, why nothing
    public double heuristicStrategy(String v1, String v2) {
        int startCityIndex = cities.get(v1);
        int endCityIndex = cities.get(v2);
        return heuristicCalculation(graph[startCityIndex], graph[endCityIndex]);
    }

    /**
     * The heuristic method takes in two vertices and calculates the heuristic between the first and the second.
     *
     * @param v1 initial vertex
     * @param v2 goal vertex
     * @return heuristic distance
     */
    private double heuristicCalculation(Vertex1 v1, Vertex1 v2) {
        return v1.getStraightLineDistance(v2);
    }

    /**
     * A star method takes in two city names and calculates the shortest path between them.
     *
     * @param v1 start vertex name get the index from graph
     * @param v2 goal vertex name get the index from graph
     * @return An arraylist of the path taken to connect the vertices
     */
    public MyArrayList<Vertex1> aStarConnection(String v1, String v2) {
        //gets the vertices from the list and calls a search method
        int startCityIndex = cities.get(v1);
        int endCityIndex = cities.get(v2);
        return aStarSearch(graph[startCityIndex], graph[endCityIndex]);//montana - burgas -> burgas-burgas
    }

    /**
     * A star method takes in two city names and calculates the shortest path between them using the distance
     * travelled and a heuristic.
     *
     * @param v1 start vertex
     * @param v2 goal vertex
     * @return An arraylist of the path taken to connect the vertices
     */
    private MyArrayList<Vertex1> aStarSearch(Vertex1 startCity, Vertex1 endCity) {

        //The OPEN list keeps track of those nodes that need to be examined
        PriorityQueue<Vertex1> openList = new PriorityQueue<Vertex1>();

        //The hashtable stores vertices already visited as the key, with the value being the vertex that led to
        //that key
        //TODO - check can I set ArrayList<Vertex> against this Hashtable
        Hashtable<Vertex1, Vertex1> closedList = new Hashtable<Vertex1, Vertex1>();
        boolean reachGoal = false;
        Vertex1 currentPosition = startCity;

        //loops through all vertices connected to the start vertex
        for (int i = 0; i < startCity.edges.size(); i++) {
            Edge1 e = startCity.edges.get(i);
            Vertex1 v = e.getOther(startCity);
            v.criteriaFunction(endCity); //calculates score
            v.setGCost(startCity);  //sets previous vertex
            openList.add(v); //adds to priority queue
        }

        closedList.put(startCity, startCity); //puts the first vertex into the closed list

        while (openList.size() > 0 && !reachGoal) { //while the priority queue isn't empty and the goal hasn't been reached
            currentPosition = openList.poll();  //take the next item from the priority queue
            if (currentPosition.city.equals(endCity.city)) { //if you've reached the goal
                reachGoal = true;
                closedList.put(currentPosition, currentPosition.parent); //put on closed list in order to correctly trace back the path
                currentPosition.criteriaFunction(endCity); //get the final score
                break;
            }

            //for every vertex connected to the current vertex
            for (int i = 0; i < currentPosition.edges.size(); i++) {
                Edge1 e = currentPosition.edges.get(i);
                Vertex1 v = e.getOther(currentPosition);
                v.criteriaFunction(endCity);
                //if it is not already in the priority queue and it hasn't been visited yet

                if (!openList.contains(v) && !closedList.containsKey(v)) {
                    v.setGCost(currentPosition);
                    openList.add(v);
                }
            }

            //put current on the closed list
            closedList.put(currentPosition, currentPosition.parent);
        }

        //if you haven't met your goal and the priority queue is empty, there is no path to connect the two.
        if (!reachGoal) {
            return null;
        }
        return findPath(closedList, startCity, endCity);
    }

    /**
     * The returnPath method retraces the path taken by a search and returns the final path. This method will
     * never be called if there is not a guaranteed path
     *
     * @param finder hashtable storing a list of vertices and where those vertices came from
     * @param start  the initial vertex given in the search
     * @param end    the goal vertex of the search
     * @return path     an arraylist of the path taken from the start node to the goal node
     */
    private MyArrayList<Vertex1> findPath(Hashtable<Vertex1, Vertex1> finder, Vertex1 start, Vertex1 end) {
        MyArrayList<Vertex1> path = new MyArrayList<Vertex1>();
        Vertex1 curr = end;
        Vertex1 from;
        while (!curr.city.equals(start.city)) { //while the start isn't reached, retrace
            from = finder.get(curr);
            path.add(0, curr);
            curr = from;
        }
        //add the first step onto the path
        path.add(0, curr);
        return path;
    }

    /**
     * This method resets values in the vertices between searches. By new input from console
     */
    public void reset() {
        //loops through every vertex
        for (int i = 0; i < numVertices; i++) {
            graph[i].fCost = 0;
            graph[i].gCost = 0;
            graph[i].parent = null;
        }
    }

    /**
     * The print method prints a graph by vertex, along with the edges for each vertex.
     */
    public void printOptimalPath() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println(graph[i].toString());
            for (int j = 0; j < graph[i].edges.size(); j++) {
                System.out.println(graph[i].edges.get(j).toString());
            }
        }
    }
}
