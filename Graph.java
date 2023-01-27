import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Graph {
    private int numVertices; //counts the number of vertices added to the array list
    private int numEdges; //counts the number of edges added to the graph
    private Vertex[] vertices; //an array that holds every vertex in the graph

    /* in this hash map, the key is the city name, and the value is its location in the vertex array */
    private HashMap<String, Integer> cities;

    /**
     * Class constructor specifying number of objects to create.
     */
    public Graph(int size){
        this.vertices = new Vertex[size]; //set the array to be the size of the number of edges
        this.cities = new HashMap<>();
        this.numVertices = 0;
        this.numEdges = 0;
    }


    /**
     * The addVertex method adds a vertex to the graph.
     *
     * @param v1    name of the city
     * @param lat   latitude
     * @param long   longitude
     */
    public void addVertex(String v1, double latitude, double longitude){
        cities.put(v1,numVertices); //put into the hashmap to store its index in the vertices array
        Vertex vert = new Vertex(v1, latitude, longitude); //create a new vertex
        vertices[numVertices] = vert; //store it in the array
        numVertices++;
    }

    /**
     * Returns the number of vertices, which is incremented every time a vertex is added.
     *
     * @return numVertices
     */
    public int countVertices(){
        return numVertices;
    }

    /**
     * Returns the number of edges, which is incremented every time an edge is added.
     *
     * @return numEdges
     */
    public int countEdges(){
        return numEdges;
    }

    /**
     * The addEdge method calls another method that adds an edge between two vertices.
     *
     * @param v1        first vertex
     * @param v2        second vertex
     * @param weight    edge weight
     */
    public void addEdge(String v1, String v2, double weight){
        //gets the position of the vertices in the array
        int ve1 = cities.get(v1);
        int ve2 = cities.get(v2);
        //calls the method on two vertices instead of two strings
        addEdge(vertices[ve1],vertices[ve2],weight);
        //increments
        numEdges++;
    }

    /**
     * The addEdge mathod adds an edge between two vertices.
     *
     * @param v1        first vertex
     * @param v2        second vertex
     * @param weight    edge weight
     */
    private void addEdge(Vertex v1, Vertex v2, double weight){
        //creates a new edge
        Edge edge = new Edge(v1, v2, weight);
        //adds the new edge to the list of edges that each vertex stores
        v1.edges.add(edge);
        v2.edges.add(edge);
    }

    /**
     * The getScore method returns the score of a vertex in a search.
     *
     * @param v1    vertex to search
     * @return score
     */
    public double getScore(String v1) {
        int v = cities.get(v1);
        return vertices[v].score;
    }

    /**
     * The areAdjacent method returns whether two vertices share an edge.
     *
     * @param v1,v2 the two vertices
     * @return  true if they share an edge, false if otherwise
     */
    private boolean areAdjacent(Vertex v1, Vertex v2){
        for(int i = 0; i < v1.edges.size(); i++){
            if(v1.edges.get(i).getOther(v1).city.equals(v2.city)){
                return true;
            }
        }
        return false;
    }

    /**
     * The getAdjacencyList returns a list of all the vertices that are adjacent to a vertex.
     *
     * @param v1    vertex to explore
     * @return      array of adjacent vertices
     */
    public Vertex[] getAdjacencyList(Vertex v1) {

        Vertex[] adj = new Vertex[v1.edges.size()];

        /* loops through all the edges connected to the vertex
        and adds the vertex at the other end of the edge to the array */
        for(int i = 0; i < v1.edges.size(); i++){
            adj[i] = v1.edges.get(i).getOther(v1);
        }
        return adj;
    }

    /**
     * The heuristic method takes in two city names and calculates the heuristic between the first and the second.
     *
     * @param v1    initial vertex
     * @param v2    goal vertex
     * @return      heuristic distance
     */
    public double heuristicStrategy(String v1, String v2){
        int ve1 = cities.get(v1);
        int ve2 = cities.get(v2);
        return heuristicCalculation(vertices[ve1],vertices[ve2]);
    }

    /**
     * The heuristic method takes in two vertices and calculates the heuristic between the first and the second.
     *
     * @param v1    initial vertex
     * @param v2    goal vertex
     * @return      heuristic distance
     */
    private double heuristicCalculation(Vertex v1, Vertex v2){
        return v1.heuristicCalculationGeo(v2);
    }

    /**
     * A star method takes in two city names and calculates the shortest path between them.
     *
     * @param v1    start vertex name
     * @param v2    goal vertex name
     * @return      An arraylist of the path taken to connect the vertices
     */
    public ArrayList<Vertex> aStarConnection(String v1, String v2){
        //gets the vertices from the list and calls a helper method
        int ve1 = cities.get(v1);
        int ve2 = cities.get(v2);
        return aStarSearch(vertices[ve1],vertices[ve2]);
    }

    /**
     * A star method takes in two city names and calculates the shortest path between them using the distance
     * travelled and a heuristic.
     *
     * @param v1    start vertex
     * @param v2    goal vertex
     * @return      An arraylist of the path taken to connect the vertices
     */
    private ArrayList<Vertex> aStarSearch(Vertex start, Vertex end){

        PriorityQueue<Vertex> next = new PriorityQueue<Vertex>(); //open list of vertices to explore

        //The hashtable stores vertices already explored as the key, with the value being the vertex that led to
        //that key
        Hashtable<Vertex,Vertex> closed = new Hashtable<Vertex,Vertex>();
        boolean reachGoal = false;
        Vertex curr = start;

        //loops through all vertices connected to the start vertex
        for(int i = 0; i < start.edges.size(); i++){
            Edge e = start.edges.get(i);
            Vertex v = e.getOther(start);
            v.recalcScore(end); //calculates score
            v.setPrev(start);  //sets previous vertex
            next.add(v); //adds to priority queue
        }

        closed.put(start,start); //puts the first vertex into the closed list

        while(next.size()>0 && !reachGoal){ //while the priority queue isn't empty and the goal hasn't been reached
            curr = next.poll();  //take the next item from the priority queue
            if(curr.city.equals(end.city)){ //if you've reached the goal
                reachGoal = true;
                closed.put(curr,curr.prev); //put on closed list in order to correctly trace back the path
                curr.recalcScore(end); //get the final score
                break;
            }

            //for every vertex connected to the current vertex
            for(int i = 0; i < curr.edges.size(); i++){
                Edge e = curr.edges.get(i);
                Vertex v = e.getOther(curr);
                v.recalcScore(end);
                //if it is not already in the pq and it hasn't been explored yet
                if(!next.contains(v) && !closed.containsKey(v)){
                    v.setPrev(curr);
                    next.add(v);
                }
            }

            //put current on the closed list
            closed.put(curr,curr.prev);
        }

        //if you haven't met your goal and the priority queue is empty, there is no path to connect the two.
        if(!reachGoal){
            return null;
        }
        return returnPath(closed,start,end);
    }


    /**
     * The returnPath method retraces the path taken by a search and returns the final path. This method will
     * never be called if there is not a guaranteed path
     *
     * @param finder    hashtable storing a list of vertices and where those vertices came from
     * @param start     the initial vertex given in the search
     * @param end       the goal vertex of the search
     * @return path     an arraylist of the path taken from the start node to the goal node
     */
    private ArrayList<Vertex> returnPath(Hashtable<Vertex,Vertex> finder, Vertex start, Vertex end){
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        Vertex curr = end;
        Vertex from;
        while(!curr.city.equals(start.city)){ //while the start isn't reached, retrace
            from = finder.get(curr);
            path.add(0,curr);
            curr=from;
        }
        //add the first step onto the path
        path.add(0,curr);
        return path;
    }

    /**
     * The reset method resets values in the vertices between searches.
     *
     */
    public void reset(){
        //loops through every vertex
        for(int i = 0; i<numVertices; i++){
            vertices[i].score = 0;
            vertices[i].gx = 0;
            vertices[i].prev=null;
        }
    }

    /**
     * The print method prints a graph by vertex, along with the edges for each vertex.
     */
    public void print(){
        for(int i = 0; i < numVertices; i++){
            System.out.println(vertices[i].toString());
            for(int j = 0; j< vertices[i].edges.size(); j++){
                System.out.println(vertices[i].edges.get(j).toString());
            }
        }
    }
}
