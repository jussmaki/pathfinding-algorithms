package pathfinding.domain;

public class ANode extends Node implements Comparable<ANode> {

    //private double heuristics;
    Point endPoint;
    
    public ANode(int locationX, int locationY, double distance, Point endPoint) {
        super(locationX, locationY, distance);
        //this.heuristics = heuristics;
        this.endPoint = endPoint;
    }
    
    private double heuristics() {
        int startPointX = this.getLocationX();
        int startPointY = this.getLocationY();
        int endPointX = endPoint.getLocationX();
        int endPointY = endPoint.getLocationY();
        return Math.sqrt((endPointY - startPointY) * (endPointY - startPointY) + (endPointX - startPointX) * (endPointX - startPointX));
    }

    @Override
    public int compareTo(ANode n) {
       /* double diff = this.distance - n.distance;
        if (diff > 0) {
            return 1;
        }
        if (diff < 0) {
            return -1;
        }
        double heur = this.heuristics() - n.heuristics();
        if (heur > 0) {
            return 1;
        }
        if (heur < 0) {
            return -1;
        }
        return 0;*/
        double heur = this.heuristics() - n.heuristics();
        if (heur > 0) {
            return 1;
        }
        if (heur < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "x: " + this.getLocationX() + ", " + this.getLocationY() + " heuristics: " + this.heuristics();
    }
}
