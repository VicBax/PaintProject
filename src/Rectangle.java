import java.awt.*;

public class Rectangle extends Shape {

    protected int length;
    protected int width;
//Constructeurs


    public Rectangle(int px, int py, Color color) {
        super(color, new Point(px, py));
        setBoundingBox(0, 0);
    }


    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        width = widthBB;
        length = heightBB;
    }

    @Override
    protected void setBoundingBox(Point origin, Point second) {
        if (origin.getX() < second.getX() & origin.getY() < second.getY()) { //tire vers en bas à droite
            width = (second.getX() - origin.getX());
            length = (second.getY() - origin.getY());
        } else if (origin.getX() < second.getX() & second.getY() < origin.getY()) { // tire en haut à droite
            Point originBis = new Point(origin.getX(), second.getY());
            Point secondBis = new Point(second.getX(), origin.getY());
            super.origin = originBis;
            width = (secondBis.getX() - originBis.getX());
            length = (secondBis.getY() - originBis.getY());
        } else if (second.getX() < origin.getX() & origin.getY() < second.getY()) { // Tire en bas a à gauche
            Point originBis = new Point(second.getX(), origin.getY());
            Point secondBis = new Point(origin.getX(), second.getY());
            super.origin = originBis;
            width = (secondBis.getX() - originBis.getX());
            length = (secondBis.getY() - originBis.getY());
        } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
            Point originBis = new Point(second.getX(), second.getY());
            Point secondBis = new Point(origin.getX(), origin.getY());
            super.origin = originBis;
            width = (secondBis.getX() - originBis.getX());
            length = (secondBis.getY() - originBis.getY());
        }
    }


    @Override
    protected void draw(Graphics g) {


        g.setColor(c);
        g.fillRect(origin.getX(), origin.getY(), width, length);

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color=" + c +
                ", origin= " + origin +
                ", length=" + length +
                ", width=" + width +
                '}';
    }

    //Getter

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public Point getOrigin() {
        return super.getOrigin();
    }

    @Override
    public void setOrigin(Point origin) {
        super.setOrigin(origin);
    }

    //Setter

    @Override
    public Color getC() {
        return super.getC();
    }

    @Override
    public void setC(Color c) {
        super.setC(c);
    }
}