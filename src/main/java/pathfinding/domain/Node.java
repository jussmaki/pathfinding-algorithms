package pathfinding.domain;

public class Node implements Comparable<Node> {
    Point location;
    float distance;

    /**
     *
     * @param locationX
     * @param locationY
     */
    public Node(int locationX, int locationY) {
        this.location = new Point(locationX, locationY);
        this.distance = Integer.MAX_VALUE;
    }

    /**
     *
     * @param locationX
     * @param locationY
     * @param distance
     */
    public Node(int locationX, int locationY, float distance) {
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
    
    /**
     *
     * @param n
     * @return
     */
    @Override
    public int compareTo(Node n) {
        return (int) (this.distance - n.distance);
    }
    
}