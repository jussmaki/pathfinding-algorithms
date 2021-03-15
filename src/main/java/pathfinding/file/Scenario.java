package pathfinding.file;

public class Scenario {
    int startX;
    int startY;
    int endX;
    int endY;
    double shortestPath;

    public Scenario(int startX, int startY, int endX, int endY, double shortestPath) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.shortestPath = shortestPath;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public double getShortestPath() {
        return shortestPath;
    }

    @Override
    public String toString() {
        return "Scenario{" + "startX=" + startX + ", startY=" + startY +
                ", endX=" + endX + ", endY=" + endY + ", shortestPath=" + shortestPath + '}';
    }
    
    
    
}
