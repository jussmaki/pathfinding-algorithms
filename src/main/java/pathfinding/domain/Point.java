package pathfinding.domain;

public class Point {
    private int locationX, locationY;

    public Point(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.locationX;
        hash = 43 * hash + this.locationY;
        return hash;
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
        final Point other = (Point) obj;
        if (this.locationX != other.locationX) {
            return false;
        }
        if (this.locationY != other.locationY) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point{" + "locationX=" + locationX + ", locationY=" + locationY + '}';
    }    
    
}
