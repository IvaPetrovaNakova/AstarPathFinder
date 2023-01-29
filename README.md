# AstarPathFinder

NOTE TO MIRA:
Mira,
1. The version of the project I am currently working on is in the testStrLine folder.
As input use the text file I created instead of scv.file in folder inputData.  
Look at the UML diagram to easily navigate then in the code, it will change finally when I clear the concept
2. The algorithm finally gives me the shortest path.
3. I don't like the code either, I have wrote everything in only 3 classes. I welcome advice on how to develop it and if there is any point in making interfaces for the graph and the algorithm.
4. I am currently working on adding junit tests - for now I work to check the graph and the algorithms - adding vertexes, etc...



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
