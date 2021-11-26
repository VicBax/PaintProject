import java.awt.Color;
import java.awt.*;

/* La classe Circle hérite de Ellipse, elle récupère donc ses attributs et donc ceux de Figure aussi. Elle recupère
 * aussi ses constructeurs et ses méthodes.
 * J'ai ajouté des règles sur la construction de la BoundingBox afin d'obtenir deux axes égaux et interdire le glissement
 * de la figure  lorsque nous essayons de tracer dans les sens qui ne sont pas naturels pour la méthode draw. */

public class Circle extends Ellipse {
    public Circle(int px, int py, Color c) {
        super(px, py, c);
        setBoundingBox(0, 0);
    }


    @Override
    public String toString() {
        return "Circle{semiAxisX=" + semiAxisX + " semiAxisY= " + semiAxisY + " Color:" + c + "origin" + origin + "}";
    }


    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        super.setBoundingBox(heightBB, widthBB);

        if (heightBB < widthBB) {
            semiAxisX = heightBB / 2;
            semiAxisY = heightBB / 2;
        } else {
            semiAxisX = widthBB / 2;
            semiAxisY = widthBB / 2;
        }
    }


    @Override
    protected void setBoundingBox(Point origin, Point second) {
        super.setBoundingBox(origin, second);
        if (semiAxisX < semiAxisY) {
            semiAxisY = semiAxisX;

            if (origin.getX() < second.getX() & second.getY() < origin.getY()) { // tire en haut à droite
                super.origin.setY(origin.getY() - semiAxisY * 2);

            } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                super.origin.setY(origin.getY() - semiAxisY * 2);
            }
        } else {
            semiAxisX = semiAxisY;

            if (second.getX() < origin.getX() & origin.getY() < second.getY()) { // Tire en bas a à gauche
                super.origin.setX(origin.getX() - semiAxisX * 2);
            } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                super.origin.setX(origin.getX() - semiAxisX * 2);
            }
        }
    }
}