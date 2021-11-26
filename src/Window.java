import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Window extends JFrame implements ActionListener {
    private final Drawing drawPanel = new Drawing();

    public Window(String title, int x, int y) {
        this.setTitle(title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = this.getContentPane();


        //Boutons
        JButton darkButton = new JButton("dark");
        darkButton.setBackground(Color.BLACK);
        darkButton.setForeground(Color.white);
        darkButton.addActionListener(this);

        JButton redButton = new JButton("red");
        redButton.setBackground(Color.red);
        redButton.addActionListener(this);

        JButton greenButton = new JButton("green");
        greenButton.setBackground(Color.green);
        greenButton.addActionListener(this);

        JButton blueButton = new JButton("blue");
        blueButton.setBackground(Color.blue);
        blueButton.setForeground(Color.white);
        blueButton.addActionListener(this);

        JButton yellowButton = new JButton("yellow");
        yellowButton.setBackground(Color.yellow);
        yellowButton.addActionListener(this);

        JButton pinkButton = new JButton("pink");
        pinkButton.setBackground(Color.pink);
        pinkButton.addActionListener(this);

        JButton magentaButton = new JButton("magenta");
        magentaButton.setBackground(Color.magenta);
        magentaButton.addActionListener(this);

        JButton orangeButton = new JButton("orange");
        orangeButton.setBackground(Color.orange);
        orangeButton.addActionListener(this);

        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.addActionListener(this);

        JButton circleButton = new JButton("Circle");
        circleButton.addActionListener(this);

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(this);

        JButton squareButton = new JButton("Square");
        squareButton.addActionListener(this);

        // menu
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu aPropos = new JMenu("A propos");


        JMenuItem creditsMenuItem = new JMenuItem("Crédits");
        aPropos.add(creditsMenuItem);
        creditsMenuItem.addActionListener(this);

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        newMenuItem.addActionListener(this);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        openMenuItem.addActionListener(this);

        JMenuItem undoMenuItem = new JMenuItem("Undo");
        undoMenuItem.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK)));
        undoMenuItem.addActionListener(this);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        saveMenuItem.addActionListener(this);

        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(this);


        file.add(newMenuItem);
        file.add(openMenuItem);
        file.add(saveMenuItem);
        file.add(undoMenuItem);
        file.add(quitMenuItem);

        menuBar.add(file);
        menuBar.add(aPropos);

        //Jpanel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 6));

        southPanel.add(darkButton);
        southPanel.add(redButton);
        southPanel.add(greenButton);
        southPanel.add(blueButton);
        southPanel.add(ellipseButton);
        southPanel.add(circleButton);
        southPanel.add(yellowButton);
        southPanel.add(pinkButton);
        southPanel.add(magentaButton);
        southPanel.add(orangeButton);
        southPanel.add(rectangleButton);
        southPanel.add(squareButton);


        contentPanel.add(southPanel, BorderLayout.SOUTH);
        contentPanel.add(drawPanel);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        //Interaction avec les boutons
        switch (cmd) {
            case "dark":
                System.out.println("dark has been selected");
                drawPanel.setC(Color.BLACK);
                break;
            case "red":
                System.out.println("red has been selected");
                drawPanel.setC(Color.red);
                break;
            case "blue":
                System.out.println("blue has been selected");
                drawPanel.setC(Color.blue);
                break;
            case "green":
                System.out.println("green has been selected");
                drawPanel.setC(Color.green);
                break;
            case "yellow":
                System.out.println("yellow has been selected");
                drawPanel.setC(Color.yellow);
                break;
            case "pink":
                System.out.println("pink has been selected");
                drawPanel.setC(Color.pink);
                break;
            case "magenta":
                System.out.println("magenta has been selected");
                drawPanel.setC(Color.magenta);
                break;
            case "orange":
                System.out.println("Orange has been selected");
                drawPanel.setC(Color.orange);
                break;
            case "Ellipse":
                System.out.println("Ellipse has been selected");
                drawPanel.setNameFigure("Ellipse");
                break;
            case "Circle":
                System.out.println("Circle has been selected");
                drawPanel.setNameFigure("Circle");
                break;
            case "Rectangle":
                System.out.println("Rectangle has been selected");
                drawPanel.setNameFigure("Rectangle");
                break;
            case "Square":
                System.out.println("Square has been selected");
                drawPanel.setNameFigure("Square");
                break;
            case "New":
                System.out.println("New has been selected");
                drawPanel.setList(new ArrayList<>());
                break;
            case "Open":
                JFileChooser chooser = new JFileChooser();
                int userSelection = chooser.showOpenDialog(this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String fileToOpen = chooser.getSelectedFile().getAbsolutePath();
                    drawPanel.read(fileToOpen);
                } else {
                    System.out.println("Save has been cancelled");
                }
                System.out.println("Open has been selected");
                break;
            case "Save":
                JFileChooser chooser2 = new JFileChooser();
                int userSelection2 = chooser2.showSaveDialog(this);
                if (userSelection2 == JFileChooser.APPROVE_OPTION) {
                    String fileToSave = chooser2.getSelectedFile().getAbsolutePath();
                    drawPanel.save(fileToSave);
                } else {
                    System.out.println("Save has been cancelled");
                }
                System.out.println("Save has been selected");
                break;
            case "Quit":
                System.out.println("Quit has been selected");
                System.exit(0);

                break;
            case "Crédits":
                System.out.println("Crédits has been selected");

                JDialog creditDialogBox = new JDialog(this, "Crédits");
                JLabel creditLabel1 = new JLabel("      Author: Victor Baxerres");
                creditDialogBox.add(creditLabel1);
                creditDialogBox.setSize(200, 100);

                creditDialogBox.setVisible(true);
                break;

            case "Undo":
                System.out.println("Undo has been selected");
                drawPanel.undoList();

        }

    }

}