package pathfinding.domain;

import java.util.Objects;

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
    
    /**
     *
     * @param locationX
     * @param locationY
     * @param distance
     * @param endPoint
     */
    public Node(int locationX, int locationY, double distance, Point endPoint) {
        this(locationX, locationY, distance);
        this.endPoint = endPoint;
    }

    /**
     *
     * @param n
     * @return
     */
    public int compare(Node n) {
        if (endPoint == null) {
            return compareDistance(n);
        }
        return compareDistancePlusHeuristics(n);
    }    
    
    private int compareDistance(Node n) {
        double diff = this.distance - n.distance;
        if (diff > 0) {
            return 1;
        }
        if (diff < 0) {
            return -1;
        }
        return 0;
    }

    private int compareDistancePlusHeuristics(Node n) {
        double heur = this.heuristics() - n.heuristics();
        double diff = this.distance - n.distance;
        if (heur + diff > 0) {
            return 1;
        }
        if (heur + diff < 0) {
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

    /**
     *
     * @return
     */
    public double getDistance() {
        return distance;
    }

    /*public Point getLocation() {
        return location;
    }*/

    /**
     *
     * @param obj
     * @return
     */


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(other.distance)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.endPoint, other.endPoint)) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Node{" + "location=" + location + ", distance=" + distance + '}';
    }
    
}