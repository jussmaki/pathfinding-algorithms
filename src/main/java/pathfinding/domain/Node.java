package pathfinding.domain;

public class Node implements Comparable<Node> {
    int number;
    int distance;

    /**
     *
     * @param number
     * @param distance
     */
    public Node(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    /**
     *
     * @param n
     * @return
     */
    @Override
    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}
