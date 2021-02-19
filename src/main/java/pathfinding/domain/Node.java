package pathfinding.domain;

public class Node {
    Point location;
    double distance;
    Point endPoint;

    /**
     *
     * @param locationX
     * @param locationY
     * @param distance
     */
    public Node(int locationX, int locationY, double distance) {
        this.location = new Point(locationX, locationY);
        this.distance = distance;
    }
    public Node(int locationX, int locationY, double distance, Point endPoint) {
        this(locationX, locationY, distance);
        this.endPoint = endPoint;
    }

    public int compare(Node n) {
        if (endPoint==null) {
            return compareDjikstra(n);
        }
        return compareAStar(n);
    }    
    
    private int compareDjikstra(Node n) {
        double diff = this.distance - n.distance;
        if (diff > 0) {
            return 1;
        }
        if (diff < 0) {
            return -1;
        }
        return 0;
    }

    private int compareAStar(Node n) {
        double heur = this.heuristics() - n.heuristics();
        double diff = this.distance - n.distance;
        if (heur+diff > 0) {
            return 1;
        }
        if (heur+diff < 0) {
            return -1;
        }
        return 0;
    }

    private double heuristics() {
        int startPointX = this.getLocationX();
        int startPointY = this.getLocationY();
        int endPointX = endPoint.getLocationX();
        int endPointY = endPoint.getLocationY();
        return Math.sqrt((endPointY - startPointY) * (endPointY - startPointY) + (endPointX - startPointX) * (endPointX - startPointX));
    }
    
    /**
     *
     * @return
     */
    public int getLocationX() {
        return this.location.getLocationX();
    }

    /**
     *
     * @return
     */
    public int getLocationY() {
        return this.location.getLocationY();
    }

    //public abstract int compareTo(Node n);

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }    

    @Override
    public String toString() {
        return "Node{" + "location=" + location + ", distance=" + distance + '}';
    }
    
}