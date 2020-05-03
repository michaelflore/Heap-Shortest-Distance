public class ShortestDistance {
    public static void main(String[] args) {
        //The order of distances to each node
        //First line is 0's distances to each connected node (0, 1, 2, 3... etc)
        //Second line is 1's distances to each connected node, and so forth
        int[][] graph ={   {0, 3, 15, 4, 0, 0},
                {0, 0, 5, 0, 8, 12},
                {0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 8},
                {0, 0, 0, 7, 0, 0}	};

        shortestPath(graph, 0);
    }

    //Number of nodes in graph, use in all methods
    public static final int NUM_OF_NODES = 6;

    //Calculate shortest path using shortest path algorithm
    public static void shortestPath(int[][] graph, int start) {
        //Parallel arrays
        int[] shortestDistance = new int[NUM_OF_NODES];
        boolean[] distanceFound = new boolean[NUM_OF_NODES];

        for(int i = 0; i < NUM_OF_NODES; i++) {
            shortestDistance[i] = Integer.MAX_VALUE;
            distanceFound[i] = false;
        }

        shortestDistance[start] = 0;

        for(int c = 0; c < NUM_OF_NODES - 1; c++) {
            int index = minDistance(shortestDistance, distanceFound);
            distanceFound[index] = true;

            for(int i = 0; i < NUM_OF_NODES; i++) {
                if (distanceFound[i] == false && graph[index][i] > 0 &&
                        shortestDistance[index] < Integer.MAX_VALUE &&
                        shortestDistance[index] + graph[index][i] < shortestDistance[i]) {
                    shortestDistance[i] = shortestDistance[index] + graph[index][i];
                }
            }
        }

        //Print the solution
        printShortestDistance(shortestDistance);
    }

    //Finds min distance
    public static int minDistance(int[] shortestDistance, boolean distanceFound[]) {
        int min = Integer.MAX_VALUE;
        int indexOfMin = 0;

        for(int i = 0; i < NUM_OF_NODES; i++) {
            if(distanceFound[i] == false && shortestDistance[i] <= min) {
                min = shortestDistance[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    //Prints shortest distances
    public static void printShortestDistance(int[] shortestDistance) {
        for (int i = 1; i < NUM_OF_NODES; i++) {
            System.out.println("Shortest distance from 0 to " + i
                    + ": " + shortestDistance[i]);
        }
    }
}
