package Week12.Challenge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

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
    private String hexText;
    private String rText;
    private String gText;
    private String bText;

    // Buttons needed for the GUI (Top)
    private JButton clearButton = new JButton("Clear");
    private JButton fillButton = new JButton("Fill");
    private JButton eraseButton = new JButton("Erase");
    private JButton randomButton = new JButton("Randomize");

    // Buttons and fields need for the GUI (Bottom)
    private JTextField hexField = new JTextField("#", 5);
    private JButton hexButton = new JButton("Hex");
    private JTextField rField = new JTextField(5);
    private JTextField gField = new JTextField(5);
    private JTextField bField = new JTextField(5);
    private JButton rgbButton = new JButton("RGB");

    // These values will store the pen's RGB and Hexadecimal color values
    // (Default: Black)
    int red;
    int green;
    int blue;
    String hex;

    // These values will store the background color.
    // (Default is white)
    int redBackground = 255;
    int greenBackground = 255;
    int blueBackground = 255;

    Paint paint; // variable of the type Paint

    /* action listener for buttons */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton) {
                paint.clear();
                hexField.setText("#");
                rField.setText("");
                gField.setText("");
                bField.setText("");
            }
            if (e.getSource() == fillButton) {
                paint.fill();

                hexField.setText("#");
                rField.setText("");
                gField.setText("");
                bField.setText("");
                repaint();

            }
            if (e.getSource() == eraseButton) {
                paint.erase(redBackground, greenBackground, blueBackground);
            }
            if (e.getSource() == randomButton) {
                int red = rng();
                int green = rng();
                int blue = rng();

                hexField.setText(
                        "#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue));
                // Shift the bits of rgb 16 bits to the right, then mask the first 8 bits
                rField.setText(Integer.toString(red));
                // Shift the bits of rgb 16 bits to the right, then mask the first 8 bits
                gField.setText(Integer.toString(green));
                // Mask the first 8 bits of rgb
                bField.setText(Integer.toString(blue));

                paint.setPenColor(red, green, blue);

                repaint();
            }
            if (e.getSource() == hexButton) {
                hexText = hexField.getText();
                // If the hex text field is empty, set the color of the pen to white
                if (hexText.substring(0, 1).equals("#")) {
                    // If the hex text field is not empty, set the color of the pen to the color
                    if (hexText.length() == 7) {
                        hex = hexText.substring(1);
                        try {
                            hexVerification(hex);
                            red = Integer.parseInt(hex.substring(0, 2), 16);
                            green = Integer.parseInt(hex.substring(2, 4), 16);
                            blue = Integer.parseInt(hex.substring(4, 6), 16);
                            paint.setPenColor(red, green, blue);
                            int rgb = Integer.parseInt(hex, 16);
                            // Shift the bits of rgb 16 bits to the right, then mask the first 8 bits
                            rField.setText(Integer.toString((rgb >> 16) & 0xFF));
                            // Shift the bits of rgb 16 bits to the right, then mask the first 8 bits
                            gField.setText(Integer.toString((rgb >> 8) & 0xFF));
                            // Mask the first 8 bits of rgb
                            bField.setText(Integer.toString(rgb & 0xFF));
                            repaint();
                        } catch (NumberFormatException ne) {
                            JOptionPane.showMessageDialog(null, "Not a valid hex value.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalValueException in) {
                            JOptionPane.showMessageDialog(null, "Not a valid hex value.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    // If the hex text field is not empty, set the color of the pen to the color
                    else {
                        JOptionPane.showMessageDialog(null, "Not a valid hex value.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a valid hex value.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == rgbButton) {
                rText = rField.getText();
                gText = gField.getText();
                bText = bField.getText();

                // If the RGB text fields are valid, set the color of the pen to the color
                if (rText.length() <= 3 && gText.length() <= 3 && bText.length() <= 3) {
                    // Convert the RGB values to an integer
                    try {
                        red = Integer.parseInt(rText);
                        green = Integer.parseInt(gText);
                        blue = Integer.parseInt(bText);
                        rgbVerification(red);
                        rgbVerification(green);
                        rgbVerification(blue);

                    } catch (NumberFormatException ne) {
                        JOptionPane.showMessageDialog(null, "Not a valid RGB value.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalValueException in) {
                        JOptionPane.showMessageDialog(null, "Not a valid RGB value.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    paint.setPenColor(red, green, blue);
                    hexField.setText(
                            "#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue));
                    repaint();
                }
                // Else, throw an error
                else {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB value.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    /* Button controls */
    // Reset the screen to white
    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        redBackground = 255;
        greenBackground = 255;
        blueBackground = 255;
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void fill() {
        Color backgroundColor = graphics2D.getColor();
        redBackground = backgroundColor.getRed();
        greenBackground = backgroundColor.getGreen();
        blueBackground = backgroundColor.getBlue();
        resetFields();

        repaint();
    }

    public void setPenColor(int red, int green, int blue) {
        graphics2D.setPaint(new Color(red, green, blue));
    }

    // Reset the pen color to black
    public void resetFields() {
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
    }

    // Set the color of the pen equal to the background color
    public void erase(int red, int green, int blue) {
        graphics2D.setPaint(new Color(redBackground, greenBackground, blueBackground));
        repaint();
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
        // Run the GUI codes on the Event-Dispatcher Thread for thread safety
        SwingUtilities.invokeLater(new Paint());
    }

    public void run() {
        /* set up JFrame */
        JFrame frame = new JFrame("Week 12 Challenge");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        clearButton.addActionListener(actionListener);
        fillButton.addActionListener(actionListener);
        eraseButton.addActionListener(actionListener);
        randomButton.addActionListener(actionListener);
        hexButton.addActionListener(actionListener);
        rgbButton.addActionListener(actionListener);

        rField.addActionListener(actionListener);
        gField.addActionListener(actionListener);
        bField.addActionListener(actionListener);
        hexField.addActionListener(actionListener);

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
        southPanel.add(rgbButton);

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
            graphics2D.setStroke(new BasicStroke(5));
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);

    }

    // Verify if the RGB value is valid
    public static void rgbVerification(int rgbValue) throws IllegalValueException {
        if (rgbValue < 0 || rgbValue > 255) {
            throw new IllegalValueException();
        }
    }

    // Verify if the Hexadecimal value is valid
    public static void hexVerification(String hex) throws IllegalValueException {
        if (hex == null || !hex.matches("^#([a-fA-F0-9]{6})$")) {
            throw new IllegalValueException();
        }
    }

    // Generate a random number between 0 and 255
    public static int rng() {
        Random rand = new Random();
        return rand.nextInt(256);
    }

    static class IllegalValueException extends Exception {
        public IllegalValueException() {
            super("Not a valid number.");
        }
    }
}
