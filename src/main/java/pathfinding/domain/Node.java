package pathfinding.domain;

public abstract class Node {
    Point location;
    double distance;

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