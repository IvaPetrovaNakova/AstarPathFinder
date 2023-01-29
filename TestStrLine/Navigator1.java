package TestStrLine;

import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;

public class Navigator1 {
    public static void main(String[] args) {

        try {
            //The first scanner goes through the file and counts the number of vertices the graph
            // will have.
            Scanner fileReader = new Scanner(new File("C:\\Users\\User\\Desktop\\BulgarianRoads_ad.txt"));
            Scanner temp = new Scanner(new File("C:\\Users\\User\\Desktop\\BulgarianRoads_ad.txt"));

            int size = 0;

            while (temp.hasNextLine()) {
                String line = temp.nextLine();
                if (line.equals("")) {
                    break;
                }
                size++;
            }
            Graph1 graph = new Graph1(size);

            //the first section of the file reads in the different cities and adds them to the graph
            // as vertices
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.equals("")) {
                    break;
                } else {
                    String[] words = line.split("\t");
                    graph.addVertex(words[0].toLowerCase(), words[1].toLowerCase(),
                            Double.parseDouble(words[2]));
                }
            }

            //the next section of the file reads in the connections between the different US cities and adds those
            //edges to the graph
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] words = line.split("\t");
                graph.addEdge(words[0].toLowerCase(), words[1].toLowerCase(),
                        Double.parseDouble(words[2]));
            }
            //once the graph is complete, head to userInteraction to start searching the graph
            userInteraction(graph);
        } catch (Exception FileNotFoundException) {
            System.out.println("file not found :(");
        }
    }

    /**
     * The userInteraction method asks the user for two cities, then returns the shortest path (as calculated with A*)
     * between those two cities. If no path exists, it conveys that to the user.
     *
     * @param graph this is the graph created above.
     */
    public static void userInteraction(Graph1 graph) {
        System.out.println("Welcome to navigator! Enter two cities you would like to see the shortest path.\n" +
                "Press \"Enter\" to leave.");
        Scanner scan = new Scanner(System.in);
        String userInput = "beepboop"; //initial (unimportant) value for userInput
        while (!userInput.equals("")) {
            userInput = scan.nextLine();
            if (userInput.equals("")) { //when the user hits enter, break out of the while loop
                break;
            }

            try {
                String[] cities = userInput.split("-"); //break up the user input, making sure it is the correct form
                String startCity = cities[0].toLowerCase();
                String endCity = cities[1].toLowerCase();
                ArrayList<Vertex1> path = graph.aStarConnection(startCity, endCity); //searches the graph, returning the path found
                if (path == null) {
                    System.out.println("Sorry, no path exists between " + startCity + " and " + endCity + ".");
                } else {
                    String pathFoundResult = "path found: ";
                    for (int i = 0; i < path.size() - 1; i++) {
                        pathFoundResult += path.get(i) + "->";
                    }
                    pathFoundResult += path.get(path.size() - 1) + " (" + graph.getTotalDistanceInKm(endCity) + "km )";
                    System.out.println(pathFoundResult); //prints result path
                }

                graph.reset(); //resets the vertex values for the next search
            } catch (Exception e) { //catches any user input that is not the correct form, or any cities not on the map
                System.out.println("please enter your input as: \"city1-city2\". Thanks!");
                continue;
            }
        }
        System.out.println("Have a great day!");
    }
}
