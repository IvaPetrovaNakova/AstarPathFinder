package dataStructure;

public class Test {
    public static void main(String[] args) {
        String[] vertices = {"Vidin", "Montana", "Vratza",
                "Pleven", "Veliko Tarnovo", "Ruse", "Shumen", "Dobrich",
                "Varna", "Sofia", "Pernik", "Bansko", "BLagoevgrad", "Pazardzik",
                "Plovdiv", "Haskovo", "Sliven", "Burgas"};
        int[][] edges = {
                {0, 1, 88}, {0, 5, 406}, {0, 12, 240},
                {1, 0, 88}, {1, 2, 37}, {1, 3, 106}, {1, 9, 117},
                {2, 1, 37}, {2, 3, 86}, {2, 4, 199}, {2, 9, 92}, {2, 13, 174},
                {3, 1, 106}, {3, 2, 86}, {3, 4, 99}, {3, 5, 111}, {3, 6, 173}, {3, 9, 125}, {3, 13, 210}, {3, 14, 198}, {3, 15, 229},
                {4, 2, 199}, {4, 3, 99}, {4, 5, 86}, {4, 6, 111}, {4, 9, 164}, {4, 14, 158}, {4, 15, 143}, {4, 16, 92},
                {5, 0, 406}, {5, 3, 111}, {5, 4, 86}, {5, 6, 88}, {5, 7, 149}, {5, 16, 224},
                {6, 3, 173}, {6, 4, 111}, {6, 5, 88}, {6, 7, 97}, {6, 8, 61}, {6, 14, 204}, {6, 15, 189}, {6, 16, 120}, {6, 17, 115},
                {7, 5, 149}, {7, 6, 97}, {7, 8, 50},
                {8, 6, 61}, {8, 7, 50}, {8, 17, 118},
                {9, 1, 117}, {9, 2, 92}, {9, 3, 125}, {9, 4, 164}, {9, 10, 44}, {9, 11, 211}, {9, 12, 71}, {9, 13, 76}, {9, 16, 230},
                {10, 9, 44}, {10, 11, 93}, {10, 12, 49},
                {11, 9, 211}, {11, 10, 93}, {11, 12, 53}, {11, 13, 114},
                {12, 0, 240}, {12, 9, 71}, {12, 10, 49}, {12, 11, 53}, {12, 13, 1530},
                {13, 2, 174}, {13, 3, 210}, {13, 9, 76}, {13, 11, 114}, {13, 12, 153}, {13, 14, 40},
                {14, 3, 198}, {14, 4, 158}, {14, 6, 204}, {14, 13, 40}, {14, 15, 67}, {14, 16, 108}, {14, 17, 143},
                {15, 3, 229}, {15, 4, 143}, {15, 6, 189}, {15, 14, 67}, {15, 16, 92}, {15, 17, 160},
                {16, 4, 92}, {16, 5, 224}, {16, 6, 120}, {16, 9, 230}, {16, 14, 108}, {16, 15, 92}, {16, 17, 72},
                {17, 6, 115}, {17, 8, 118}, {17, 14, 143}, {17, 15, 160}, {17, 16, 72}
        };

        WeightedGraph<String> graph1 = new WeightedGraph<>(vertices, edges);
        WeightedGraph<String>.ShortestPathTree tree1 =
                graph1.getShortestPath(graph1.getIndex("Burgas")); //startNode
        tree1.printAllPaths();

        // Display shortest paths from Montana to Burgas
        System.out.print("Shortest path from Montana to Burgas: ");
        java.util.List<String> path = tree1.getPath(graph1.getIndex("Montana")); //goal
        for (String s: path) {
            System.out.print(s + " ");
        }
    }
}
