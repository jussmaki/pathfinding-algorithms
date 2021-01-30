package pathfinding.domain;

import java.util.ArrayList;

public class Maze {
    private int[][] maze;

    /**
     *
     * @param graph as array
     */
    public Maze(int[][] maze) {
        this.maze = maze;
    }

    /**
     *
     * @return graph as array
     */
    public int[][] getMaze() {
        return maze;
    }

    /**
     *
     * @param set maze array
     */
    public void setMaze(int[][] maze) {
        this.maze = maze;
    }
    
    /**
     *
     * @param x
     * @param y
     * @return node number
     */
    public int toNodeNumberFromCoordinate(int x, int y) {
        int nodeNumbers[][] = new int[this.maze.length][this.maze[0].length];
        int number = 1;
        for (int a=0; a<this.maze.length; a++) {
            for (int b=0; b<this.maze[0].length; b++) {
                nodeNumbers[a][b] = number;
                number++;
            }
        }
        return nodeNumbers[x][y];
    }

    /**
     *
     * @return graph as adjacencylist
     */
    public ArrayList<Integer>[] toAdjacencyList() {
        int n = maze.length*maze[0].length;
        ArrayList<Integer>[] adjacencyList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        
        //just for to avoid some calculations :D
        int nodeNumbers[][] = new int[this.maze.length][this.maze[0].length];
        int number = 1;

        for (int x=0; x<this.maze.length; x++) {
            for (int y=0; y<this.maze[0].length; y++) {
                nodeNumbers[x][y] = number;
                number++;
            }

        }
        
        //actually for making the adjacency list
        int nodeNo = 1;
        for (int x=0; x<this.maze.length; x++) {
            for (int y=0; y<this.maze[0].length; y++) {
                //System.out.println(nodeNo);
                if (canGoFromTo(x,y, x-1, y)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x-1][y]);
                }
                if (canGoFromTo(x,y, x-1, y-1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x-1][y-1]);
                }
                if (canGoFromTo(x,y, x+1, y)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x+1][y]);
                }
                if (canGoFromTo(x,y, x, y+1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x][y+1]);
                }
                if (canGoFromTo(x,y, x, y-1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x][y-1]);
                }
                if (canGoFromTo(x,y, x-1, y+1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x-1][y+1]);
                }
                if (canGoFromTo(x,y, x+1, y-1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x+1][y-1]);
                }
                if (canGoFromTo(x,y, x+1, y+1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x+1][y+1]);
                }
                if (canGoFromTo(x,y, x-1, y-1)) {
                    adjacencyList[nodeNo].add(nodeNumbers[x-1][y-1]);
                }
                nodeNo++;
            }

        }
        return adjacencyList;
    }    

    private boolean canGoFromTo(int x1, int y1, int x2, int y2) {
        if (this.maze[x1][y1] != 1) {
            return false;
        }
        if (x2<0 || x2>=this.maze.length || y2<0 || y2>=this.maze[0].length) {
            return false;
        }
        if (this.maze[x2][y2] != 1) {
            return false;
        }
        return true;
    }
}
