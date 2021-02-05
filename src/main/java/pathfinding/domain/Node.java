package pathfinding.domain;

public class Node implements Comparable<Node> {
    int number;
    int locationX;
    int locationY;
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

    public Node(int number) {
        this.number = number;
    }

    
    public Node(int number, int locationX, int locationY) {
        this.number = number;
        this.locationX = locationX;
        this.locationY = locationY;
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
        if (this.number != other.number) {
            return false;
        }
        return true;
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.number;
        return hash;
    }
}
