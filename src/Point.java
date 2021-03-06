import java.io.Serializable;

public class Point implements Serializable {
    // Variables
    private int x;
    private int y;

    //Constructeur
    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    // Methods

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point { X=" + x + "; Y=" + y + "}";
    }
}