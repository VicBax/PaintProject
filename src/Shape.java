import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable {

    protected Color c;
    protected Point origin;

    //Constructeur
    public Shape(Color color, Point point) {
        c = color;
        origin = point;
    }

    public Shape() {
        c = new Color(255, 255, 255);
        origin = new Point(0, 0);
    }


    protected abstract void setBoundingBox(int heightBB, int widthBB);

    protected abstract void setBoundingBox(Point a, Point b);

    protected abstract void draw(Graphics g);

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "Color=" + c +
                '}';
    }
}