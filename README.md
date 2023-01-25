# AstarPathFinder
Write a program that finds the fastest road from a given starting town to a destination town in 
Bulgaria. As a database use the given csv file as a reference. Note that on a real system, this file 
could be a lot bigger. 
Think about reading the data only when it is needed. 
Also use good heuristic. 
Program gets 3 parameters: 
1. Name of the starting city - string 
2. Name of the destination city – string 
3. Name of the file csv with details. 
The csv file is structures as a table, where the first row and the first column contain the names of all 
the cities. Then inside each cell there is a composite value – split by pipe (|) 
 length of the road if it exists, or -1 if there is no direct road. 
 time for traveling if the road exists, or -1 if there is no direct road. 
 distance between the two cities in straight line in the air. 
The program should find the best road and print the names of all cities that should be visited. 
Use A* search strategy
