package TestStrLine;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Navigator {

    public static void main(String[] args) {

        try {
            //The first scanner goes through the file and counts the number
            // of cities connections in the map will have.
            Scanner fileReader = new Scanner(new File(
                    "C:\\Users\\User\\Desktop\\untitled\\src\\First\\new.txt"));
            Scanner temp = new Scanner(new File(
                    "C:\\Users\\User\\Desktop\\untitled\\src\\First\\new.txt"));

            int size = 0;

            while (temp.hasNextLine()) {
                String line = temp.nextLine();
                if (line.equals("")) {
                    break;
                }
                size++; //all points connections in the map
            }
            TripGraph tripMap = new TripGraph(size);
            //create list of cities with possible paths between
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.equals("")) {
                    break;
                } else {
                    String[] tokens = line.split("\t");
                    tripMap.addCity(tokens[0].toLowerCase(),
                            tokens[1].toLowerCase(),
                            Integer.parseInt(tokens[2]
                            ));
                }
            }
            //create a list with neighbours with existing paths
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.equals("")) {
                    break;
                } else {
                    String[] tokens = line.split("\t");
                    tripMap.addLink(
                            tokens[0].toLowerCase(),
                            tokens[1].toLowerCase(),
                            Integer.parseInt(tokens[2]
                            ));
                }
            }
            //once the graph is complete, head to userInteraction
            // to start searching the graph
            userInteraction(tripMap);
        } catch (Exception FileNotFoundException) {
            System.out.println("file not found :(");
        }
    }
        public static void userInteraction (TripGraph graph){
            System.out.println("Welcome to navigator! " +
                    "Enter two cities you would like to see the shortest path.\n" +
                    "Press \"Enter\" to leave.");
            Scanner scan = new Scanner(System.in);
            //initial (unimportant) value for userInput
            String userInput = "meawmeaw";
            while (!userInput.equals("")) {
                userInput = scan.nextLine();
                //when the user hits enter, break out of the while loop
                if (userInput.equals("")) {
                    break;
                }

                try {
                    //break up the user input, making sure it is the correct form
                    String[] cities = userInput.split("-");
                    String fromCity = cities[0].toLowerCase();
                    String toCity = cities[1].toLowerCase();
                    //searches the graph, returning the path found
                    ArrayList<City> path = graph.aStarConnection(fromCity, toCity);
                    if (path == null) {
                        System.out.println("Sorry, no path exists between "
                                + fromCity + " and " + toCity + ".");
                    } else {
                        String pathFoundResult = "path found: ";
                        for (int i = 0; i < path.size() - 1; i++) {
                            pathFoundResult += path.get(i) + "->";
                        }
                        pathFoundResult += path.get(path.size() - 1)
                                + " (" + graph.getTotalTravelDistance(toCity) + "km )";
                        System.out.println(pathFoundResult); //prints result path
                    }
             //   graph.reset(); //resets the vertex values for the next search
                } catch (
                    //catches any user input that is not the correct form,
                    // or any cities not on the map
                        Exception e) {
                    System.out.println("please enter your input as: \"city1-city2\". Thanks!");
                    continue;
                }
            }
            System.out.println("Have a great day!");
        }
    }