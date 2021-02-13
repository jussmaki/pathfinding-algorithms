package pathfinding.domain;

public class DNode extends Node implements Comparable<DNode> {    

    public DNode(int locationX, int locationY, double distance) {
        super(locationX, locationY, distance);
    }

    /**
     *
     * @param n
     * @return
     */
    @Override
    public int compareTo(DNode n) {
        double diff = this.distance - n.distance;
        if (diff > 0) {
            return 1;
        }
        if (diff < 0) {
            return -1;
        }
        return 0;
    }
    
}

