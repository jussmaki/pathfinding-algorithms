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

}