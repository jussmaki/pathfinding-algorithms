package pathfinding.domain;

public class Point {
    private int locationX, locationY;
    
    /**
     * Creates new Point-object
     * @param locationX
     * @param locationY
     */
    public Point(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    /**
     *
     * @return
     */
    public int getLocationX() {
        return locationX;
    }

    /**
     *
     * @return
     */
    public int getLocationY() {
        return locationY;
    }

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
        final Point other = (Point) obj;
        if (this.locationX != other.locationX) {
            return false;
        }
        if (this.locationY != other.locationY) {
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
        return locationX + "," + locationY;
    }    
    
}
