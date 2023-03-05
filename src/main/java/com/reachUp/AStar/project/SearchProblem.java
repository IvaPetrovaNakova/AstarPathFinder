package com.reachUp.AStar.project;

import com.reachUp.AStar.project.entity.Path;
import com.reachUp.AStar.project.entity.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class SearchProblem, the start and end points are method arguments
 * with which we search for a path
 * Reads from two data sources, br1.txt contains the information
 * about the children in the map /all existing route between the
 * cities as a connection/
 * The second text file contains information value for the heuristic
 * the straight line destination between all cities in the map
 * Straight-line heuristic function has been employed for fast
 * convergence in A* search.
 */
public class SearchProblem {
    City startState;
    City goalState;

    /**
     * Class constructor specifying number of objects to create
     * @param start starting point
     * @param goal ending point
     */
    public SearchProblem(String start, String goal) {
        startState = new City(start);
        goalState = new City(goal);
    }

    /**
     * Second constructor use to validate the repo
     * @param startState starting point
     * @param goalState ending point
     */
    public SearchProblem(City startState, City goalState) {
        this.startState = startState;
        this.goalState = goalState;
    }

    /**
     * Gives the city name
     *
     * @return starting point
     */
    public City getStartState() {
        return startState;
    }

    /**
     * Method comparing if the current city is equals
     * to the goal city
     *
     * @param st current city
     * @return true if the goal is reached
     * otherwise false
     */
    public boolean reachGoal(City st) {
        if (st.city.equals(this.goalState.city)) {
            return true;
        }
        return false;
    }

    /**
     * Method reads the information from file
     * and gives the children of the current cities
     *
     * @param st current city child
     * @return list of children
     */
    public ArrayList<Path> getChildren(City st) {

        ArrayList<Path> children = new ArrayList<Path>();

        Scanner sc = null;

        try {
            sc = new Scanner(new File("C:\\Users\\User\\Desktop\\untitled\\src\\first\\br1.txt"));

            String firstSpace = "";

            while (sc.hasNext()) {
                firstSpace = sc.next();
                if (firstSpace.equals("Vidin")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Vidin")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Montana")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Montana")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Vratsa")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Vratsa")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Pleven")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Pleven")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("VelikoTarnovo")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("VelikoTarnovo")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Ruse")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Ruse")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Shumen")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Shumen")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Dobrich")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Dobrich")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Varna")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Varna")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Sofia")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Sofia")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Pernik")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Pernik")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Bansko")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Bansko")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Blagoevgrad")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Blagoevgrad")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Pazardzhik")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Pazardzhik")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Plovdiv")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Plovdiv")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Haskovo")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Haskovo")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Sliven")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Sliven")) {
                        children.add(new Path(new City(city), cost));
                    }
                } else if (firstSpace.equals("Burgas")) {
                    String city = sc.next();
                    int cost = Integer.parseInt(sc.next());
                    if(st.city.equals("Burgas")) {
                        children.add(new Path(new City(city), cost));
                    }
                }
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (sc != null) sc.close();
        }
        return children;
    }

    /**
     * Method reads from file br2.txt
     * the information about heuristic cost
     *
     * @param st gets the children node
     * @return heuristic value
     */
    public int heuristic(City st) { // gets a child value - Vratsa, Pleven, Sofia

        int heuristic = 0;

//        Scanner sc = null;
//
//        try {
//            sc = new Scanner (new File("C:\\Users\\User\\Desktop\\untitled\\src\\first\\br2.txt"));
//
//           //TODO
//        } catch (FileNotFoundException e) {}
//        finally {
//            if (sc != null) sc.close();
//        }

        if (st.city.equals("Vidin")) {
            heuristic = 4073;
        } else if (st.city.equals("Montana")) {
            heuristic = 3590;
        } else if (st.city.equals("Vratsa")) {
            heuristic = 3281;
        } else if (st.city.equals("Pleven")) {
            heuristic = 2553;
        } else if (st.city.equals("VelikoTarnovo")) {
            heuristic = 1634;
        } else if (st.city.equals("Ruse")) {
            heuristic = 1914;
        } else if (st.city.equals("Dobrich")) {
            heuristic = 1224;
        } else if (st.city.equals("Varna")) {
            heuristic = 87;
        } else if (st.city.equals("Sofia")) {
            heuristic = 3396;
        } else if (st.city.equals("Pernik")) {
            heuristic = 3626;
        } else if (st.city.equals("Bansko")) {
            heuristic = 3359;
        } else if (st.city.equals("Blagoevgrad")) {
            heuristic = 3634;
        } else if (st.city.equals("Pazardzhik")) {
            heuristic = 2594;
        } else if (st.city.equals("Plovdiv")) {
            heuristic = 2271;
        } else if (st.city.equals("Haskovo")) {
            heuristic = 1694;
        } else if (st.city.equals("Shumen")) {
            heuristic = 954;
        } else if (st.city.equals("Sliven")) {
            heuristic = 953;
        } else if (st.city.equals("Burgas")) {
            heuristic = 0;
        }
        return heuristic;
    }
}
