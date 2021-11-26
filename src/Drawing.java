import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener, Serializable {
    private final int x;
    private final int y;
    Shape shape;
    private ArrayList<Shape> list;
    private Color c;
    private String nameFigure;
    private Point firstMouseEvent;
    private Point secondMouseEvent;



    public Drawing() {
        super();
        this.setBackground(Color.white);
        list = new ArrayList<>();
        nameFigure = null;
        x = 0;
        y = 0;
        c = Color.white;
        addMouseListener(this);
        addMouseMotionListener(this);
    }



    public void undoList() {
        list.remove(list.size() - 1);
    }

    public void setC(Color c) {
        this.c = c;
    }

    public ArrayList<Shape> getList() {
        return list;
    }

    public void setList(ArrayList<Shape> list) {
        this.list = list;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (c != Color.white) {
            firstMouseEvent = new Point(e.getX(), e.getY());
            switch (nameFigure) {
                case "Rectangle":
                    list.add(shape = new Rectangle(firstMouseEvent.getX(), firstMouseEvent.getY(), c));
                    break;
                case "Ellipse":
                    list.add(shape = new Ellipse(firstMouseEvent.getX(), firstMouseEvent.getY(), c));
                    break;
                case "Square":
                    list.add(shape = new Square(firstMouseEvent.getX(), firstMouseEvent.getY(), c));

                    break;
                case "Circle":
                    list.add(shape = new Circle(firstMouseEvent.getX(), firstMouseEvent.getY(), c));
                    break;
            }

        }
        System.out.println(list);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        secondMouseEvent.setX(e.getX());
        secondMouseEvent.setY(e.getY());
        shape.setBoundingBox(firstMouseEvent, secondMouseEvent);
        System.out.println(list);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        secondMouseEvent = new Point(e.getX(), e.getY());

        shape.setBoundingBox(firstMouseEvent, secondMouseEvent);

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public String toString() {
        return "Drawing{" +
                "list=" + list +
                "}";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        for (Shape f : list) {
            f.draw(g);
            this.repaint();
        }
    }




    public void save(String nameFile) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nameFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            System.out.println("\nSauvegardé avec succès...\n");
        } catch (Exception e) {
            System.out.println("Problème");
            e.printStackTrace();

        }
    }




    public void read(String nameFile) {
        try {
            FileInputStream fileIn = new FileInputStream(nameFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Shape>) in.readObject();
            System.out.println("Ouvert avec succès");
            in.close();
            fileIn.close();
            repaint();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}