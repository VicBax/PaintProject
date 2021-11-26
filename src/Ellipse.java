import java.awt.*;


public class Ellipse extends Shape {
    protected int semiAxisX;
    protected int semiAxisY;


    public Ellipse(int px, int py, Color color) {
        super(color, new Point(px, py));
        setBoundingBox(0, 0);
    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        semiAxisX = widthBB / 2;
        semiAxisY = heightBB / 2;
    }

    @Override
    protected void setBoundingBox(Point origin, Point second) {
        if (origin.getX() < second.getX() & origin.getY() < second.getY()) {
            semiAxisX = (second.getX() - origin.getX()) / 2;
            semiAxisY = (second.getY() - origin.getY()) / 2;
        } else if (origin.getX() < second.getX() & second.getY() < origin.getX()) {
            Point originBis = new Point(origin.getX(), second.getY());
            Point secondBis = new Point(second.getX(), origin.getY());
            super.origin = originBis;
            semiAxisX = (secondBis.getX() - originBis.getX()) / 2;
            semiAxisY = (secondBis.getY() - originBis.getY()) / 2;
        } else if (second.getX() < origin.getX() & origin.getY() < second.getY()) {
            Point originBis = new Point(second.getX(), origin.getY());
            Point secondBis = new Point(origin.getX(), second.getY());
            super.origin = originBis;
            semiAxisX = (secondBis.getX() - originBis.getX()) / 2;
            semiAxisY = (secondBis.getY() - originBis.getY()) / 2;
        } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) {
            Point originBis = new Point(second.getX(), second.getY());
            Point secondBis = new Point(origin.getX(), origin.getY());
            super.origin = originBis;
            semiAxisX = (secondBis.getX() - originBis.getX()) / 2;
            semiAxisY = (secondBis.getY() - originBis.getY()) / 2;
        }
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origin.getX(), origin.getY(), semiAxisX * 2, semiAxisY * 2);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxisX=" + semiAxisX +
                ", semiAxisY=" + semiAxisY +
                ", c=" + c +
                ", origin=" + origin +
                '}';
    }

    @Override
    public Color getC() {
        return super.getC();
    }

    @Override
    public void setC(Color c) {
        super.setC(c);
    }

    @Override
    public Point getOrigin() {
        return super.getOrigin();
    }

    @Override
    public void setOrigin(Point origin) {
        super.setOrigin(origin);
    }
}