
// Import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Define the main class that extends JFrame
public class VectorPaint extends JFrame {

    // Declare the components as instance variables
    private JMenu fileMenu;
    private JMenu drawMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem quitItem;
    private JMenu figureMenu;
    private JMenuItem circleItem;
    private JMenuItem squareItem;
    private JMenuItem penItem;
    private JMenuItem colorItem;
    private JMenuItem clearItem;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private JToggleButton randomColors;
    private JLabel modeLabel;
    private JLabel statusLabel;
    private DrawPanel drawPanel;

    // Declare other variables such as file name, current mode, etc.
    private String fileName;
    private String mode;
    private String lastMode;
    private String status;
    private Color currentColor;
    // Declare a Timer object as a field
    Timer drawLine;

    // Define the constructor
    public VectorPaint() {
        // Initialize the components
        fileMenu = new JMenu("File");
        drawMenu = new JMenu("Draw");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As...");
        quitItem = new JMenuItem("Quit");
        figureMenu = new JMenu("Figure");
        circleItem = new JMenuItem("Circle");
        squareItem = new JMenuItem("Square");
        penItem = new JMenuItem("Pen");
        colorItem = new JMenuItem("Color");
        clearItem = new JMenuItem("Clear");
        menuBar = new JMenuBar();
        toolBar = new JToolBar();
        randomColors = new JToggleButton("Random colors");
        modeLabel = new JLabel("Mode: Pen");
        statusLabel = new JLabel("Status: New");
        drawPanel = new DrawPanel();

        // Set the mnemonics and accelerators for the menu items
        fileMenu.setMnemonic('F');
        drawMenu.setMnemonic('D');
        openItem.setMnemonic('O');
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        saveItem.setMnemonic('S');
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveAsItem.setMnemonic('A');
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        quitItem.setMnemonic('Q');
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        figureMenu.setMnemonic('F');
        circleItem.setMnemonic('C');
        circleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        squareItem.setMnemonic('S');
        squareItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        penItem.setMnemonic('P');
        penItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        colorItem.setMnemonic('C');
        colorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        clearItem.setMnemonic('L');
        clearItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));

        // Add the menu items to the menus and the menus to the menu bar
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(quitItem);

        figureMenu.add(circleItem);
        figureMenu.add(squareItem);

        drawMenu.add(figureMenu);
        drawMenu.add(penItem);
        drawMenu.add(colorItem);
        drawMenu.addSeparator();
        drawMenu.add(clearItem);

        // Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(drawMenu);

        // Add the labels to the tool bar
        toolBar.add(modeLabel);
        toolBar.addSeparator();
        toolBar.add(statusLabel);
        toolBar.addSeparator();
        toolBar.add(randomColors);

        // Set the layout and background color of the draw panel
        drawPanel.setLayout(null);
        drawPanel.setBackground(Color.WHITE);
        drawPanel.setFocusable(true);

        // Set the title, size, location, default close operation and layout of the
        // frame
        setTitle("Simple Draw");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add the menu bar and tool bar to the north of the frame
        add(menuBar, BorderLayout.NORTH);
        add(toolBar, BorderLayout.SOUTH);

        // Add the draw panel to the center of the frame
        add(drawPanel, BorderLayout.CENTER);

        // Set the frame visible
        setVisible(true);

        // Initialize other variables
        fileName = null;
        mode = "Pen";
        status = "New";

        // In the constructor, initialize the timer with a 100ms delay and an action
        // listener
        drawLine = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current mouse position relative to the draw panel
                Point p = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(p, drawPanel);
                // Get the current color
                Color color = currentColor;
                // Create a new Pen object with the mouse position and color
                Pen pen = new Pen(p.x, p.y, 10, color, null);
                // Add the pen to the draw panel
                drawPanel.add(pen);
                // Repaint the draw panel
                drawPanel.revalidate();
                drawPanel.repaint();
                // Set the status variable
                status = "Modified";
                // Update the status label
                statusLabel.setText("Status: " + status);
            }
        });
        drawPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'd') {
                    System.out.println("D");

                    if (mode.equals("Delete")) {
                        mode = lastMode;
                        modeLabel.setText("Mode: " + mode);
                        System.out.println(mode);

                    } else {

                        lastMode = mode;
                        mode = "Delete";
                        modeLabel.setText("Mode: " + mode);
                        System.out.println(mode);

                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        // Add a mouse listener to the draw panel
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.requestFocusInWindow();
                System.out.println("focused");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Check if the mode is Pen
                String mode = modeLabel.getText().substring(6);
                if (mode.equals("Delete")) {
                    for (MyShape shape : drawPanel.getShapes()) {
                        if (shape.contains(e.getPoint())) {
                            drawPanel.remove(shape);
                            drawPanel.repaint();
                            if (shape.getType().equals("Pen"))
                                continue;
                            else
                                break;
                        }
                    }
                    return;
                } else if (mode.equals("Pen")) {
                    drawLine.start();
                } else {
                    Point p = e.getPoint();
                    MyShape s;
                    if (mode.equals("Circle")) {
                        s = new Circle(p.x, p.y, 50, null);
                    } else if (mode.equals("Square")) {
                        s = new Square(p.x, p.y, 50, null);
                    } else {
                        return;
                    }
                    drawPanel.add(s);
                }
                drawPanel.revalidate();
                drawPanel.repaint();
                // Set the status variable
                status = "Modified";
                // Update the status label
                statusLabel.setText("Status: " + status);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("AAAA");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e1) {
                }
                // Check if the timer is running
                if (drawLine.isRunning()) {
                    // Stop the timer
                    drawLine.stop();
                }
            }
        });

        // Add action listeners to the menu items
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser dialog
                JFileChooser fileChooser = new JFileChooser();
                // Set the current directory to the user's home directory
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                // Show the open dialog and get the user's selection
                int result = fileChooser.showOpenDialog(VectorPaint.this);
                // If the user approved the selection, open the file and draw its content
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();
                    // Set the file name variable
                    fileName = selectedFile.getName();
                    // Set the status variable
                    status = "Saved";
                    // Update the title and status label
                    setTitle("Simple Draw - " + fileName);
                    statusLabel.setText("Status: " + status);
                    // Clear the draw panel
                    drawPanel.removeAll();
                    drawPanel.repaint();
                    // Create a buffered reader to read the file content
                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        // Read each line of the file
                        String line;
                        while ((line = br.readLine()) != null) {
                            // Split the line by commas
                            String[] tokens = line.split(" ");
                            // Get the shape, color and coordinates from the tokens
                            int id = Integer.parseInt(tokens[0]);
                            String type = tokens[1];
                            Color color = new Color(Integer.parseInt(tokens[2]), false);
                            int x = Integer.parseInt(tokens[3]);
                            int y = Integer.parseInt(tokens[4]);
                            int size = Integer.parseInt(tokens[5]);
                            // Create a new shape object based on the shape type
                            MyShape s;
                            if (type.equals("Circle")) {
                                s = new Circle(x, y, size, color);
                            } else if (type.equals("Square")) {
                                s = new Square(x, y, size, color);
                            } else if (type.equals("Pen")) {
                                s = new Pen(x, y, size, color, null);
                            } else {
                                System.out.println(id + " " + type);
                                continue;
                            }
                            // Add the shape to the draw panel
                            drawPanel.add(s);
                        }
                        // Repaint the draw panel
                        drawPanel.revalidate();
                        drawPanel.repaint();
                    } catch (IOException ex) {
                        // Handle any IO exception
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the save action
                // If there is no file name, invoke the save as action
                if (fileName == null) {
                    saveAsItem.doClick();
                } else {
                    // Otherwise, save the current content to the existing file
                    // Create a file object with the file name
                    File file = new File(fileName);
                    // Create a buffered writer to write the file content
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                        // Get all the components in the draw panel
                        Component[] components = drawPanel.getComponents();
                        // Loop through each component and write its information to the file
                        for (Component c : components) {
                            if (c instanceof MyShape) {
                                MyShape s = (MyShape) c;
                                bw.write(s.toString());
                                bw.newLine();
                            }
                        }
                        // Set the status variable
                        status = "Saved";
                        // Update the status label
                        statusLabel.setText("Status: " + status);
                    } catch (IOException ex) {
                        // Handle any IO exception
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the save as action
                // Create a file chooser dialog
                JFileChooser fileChooser = new JFileChooser();
                // Set the current directory to the user's home directory
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                // Show the save dialog and get the user's selection
                int result = fileChooser.showSaveDialog(VectorPaint.this);
                // If the user approved the selection, save the current content to the selected
                // file
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();
                    // Set the file name variable
                    fileName = selectedFile.getName();
                    // Set the status variable
                    status = "Saved";
                    // Update the title and status label
                    setTitle("Simple Draw - " + fileName);
                    statusLabel.setText("Status: " + status);
                    // Create a buffered writer to write the file content
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile))) {
                        // Get all the components in the draw panel
                        Component[] components = drawPanel.getComponents();
                        // Loop through each component and write its information to the file
                        for (Component c : components) {
                            if (c instanceof MyShape) {
                                MyShape s = (MyShape) c;
                                bw.write(s.toString());
                                bw.newLine();
                            }
                        }
                    } catch (IOException ex) {
                        // Handle any IO exception
                        ex.printStackTrace();
                    }
                }
            }
        });

        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the quit action
                // If the status is not saved, ask the user if they want to save before quitting
                if (!status.equals("Saved")) {
                    int option = JOptionPane.showConfirmDialog(VectorPaint.this, "Do you want to save before quitting?",
                            "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                    // If the user chooses yes, invoke the save action and then exit
                    if (option == JOptionPane.YES_OPTION) {
                        saveItem.doClick();
                        System.exit(0);
                    }
                    // If the user chooses no, exit without saving
                    else if (option == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                    // If the user chooses cancel, do nothing
                } else {
                    // Otherwise, exit normally
                    System.exit(0);
                }
            }
        });
        randomColors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean state = randomColors.isSelected();
                MyShape.randomColor = state;
            }
        });
        circleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the circle action
                // Set the mode variable
                mode = "Circle";
                // Update the mode label
                modeLabel.setText("Mode: " + mode);
            }
        });

        squareItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the square action
                // Set the mode variable
                mode = "Square";
                // Update the mode label
                modeLabel.setText("Mode: " + mode);
            }
        });

        penItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the pen action
                // Set the mode variable
                mode = "Pen";
                // Update the mode label
                modeLabel.setText("Mode: " + mode);
            }
        });

        colorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the color action
                // Create a color chooser dialog and get the user's selection
                Color color = JColorChooser.showDialog(VectorPaint.this, "Choose a color", Color.BLACK);
                // If the user did not cancel, set the current color to the selected color
                if (color != null) {
                    currentColor = color;
                }
            }
        });

        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implement the clear action
                // Remove all components from the draw panel and repaint it
                drawPanel.removeAll();
                drawPanel.repaint();
                // Set the status variable
                status = "Modified";
                // Update the status label
                statusLabel.setText("Status: " + status);
            }
        });

    }

    // Define a main method to create an instance of the class and run it
    public static void main(String[] args) {
        new VectorPaint();
    }

}
