package Week12.Challenge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Siddharth Sancheti, Section 33
 * @version November 13, 2023
 */
public class Paint extends JComponent implements Runnable {
    private Image image; // the canvas
    private Graphics2D graphics2D; // this will enable drawing
    private int curX; // current mouse x coordinate
    private int curY; // current mouse y coordinate
    private int oldX; // previous mouse x coordinate
    private int oldY; // previous mouse y coordinate

    // Variables for RGB and Hexadecimal color values
    private String hex;
    private String rText;
    private String gText;
    private String bText;

    // Buttons needed for the GUI (Top)
    JButton clearButton;
    JButton fillButton;
    JButton eraseButton;
    JButton randomButton;

    // Buttons and fields need for the GUI (Bottom)
    JTextField hexField;
    JButton hexButton;
    JTextField rField;
    JTextField gField;
    JTextField bField;
    JButton rgbButton;

    // TODO: Remove these buttons
    JButton yellowButton; // a button to change paint color
    JButton blueButton; // a button to change paint color
    JButton redButton; // a button to change paint color
    JButton greenButton; // a button to change paint color

    Paint paint; // variable of the type Paint

    /* action listener for buttons */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == yellowButton) {
                paint.yellow();
            }
            if (e.getSource() == blueButton) {
                paint.blue();
            }
            if (e.getSource() == redButton) {
                paint.red();
            }
            if (e.getSource() == greenButton) {
                paint.green();
            }

        }
    };

    /* set up paint colors */
    public void yellow() {
        graphics2D.setPaint(Color.yellow);
    }

    public void blue() {
        graphics2D.setPaint(Color.blue);
    }

    public void red() {
        graphics2D.setPaint(Color.red);
    }

    public void green() {
        graphics2D.setPaint(Color.green);
    }

    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press */
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where mouse is being dragged */
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());
    }

    public void run() {
        /* set up JFrame */
        JFrame frame = new JFrame("Debugging Exercise");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        yellowButton = new JButton("Yellow");
        yellowButton.addActionListener(actionListener);
        blueButton = new JButton("Blue");
        blueButton.addActionListener(actionListener);
        redButton = new JButton("Red");
        redButton.addActionListener(actionListener);
        greenButton = new JButton("Green");
        greenButton.addActionListener(actionListener);

        // Add the buttons to the layout.
        JPanel northPanel = new JPanel();
        northPanel.add(clearButton);
        northPanel.add(fillButton);
        northPanel.add(eraseButton);
        northPanel.add(randomButton);

        content.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.add(hexField);
        southPanel.add(hexButton);
        southPanel.add(rField);
        southPanel.add(gField);
        southPanel.add(bField);

        content.add(southPanel, BorderLayout.SOUTH);


        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            /* this lets us draw on the image (ie. the canvas) */
            graphics2D = (Graphics2D) image.getGraphics();
            /* gives us better rendering quality for the drawing lines */
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            /* set canvas to white with default paint color */
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);

    }
}
