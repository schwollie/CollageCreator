import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlWindow implements ActionListener {

    private final Window w;
    private CollageHandler collageHandler;
    private JMenuItem openImages, exportImage, createImage, settingsMenu;

    public ControlWindow(CollageHandler c) {
        w = new Window(1500, 1000);
        this.collageHandler = c;

        createUI();

        w.setVisible(true);
        w.repaint();
    }

    private void createUI() {
        createMenu();
    }

    private void createMenu() {
        JMenuBar menuBar;

        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription(
                "Import all the images");

        // openImage
        openImages = new JMenuItem("Open Images");
        openImages.addActionListener(this::actionPerformed);
        fileMenu.add(openImages);

        // export Image
        exportImage = new JMenuItem("Export Image");
        exportImage.addActionListener(this::actionPerformed);
        fileMenu.add(exportImage);

        menuBar.add(fileMenu);


        JMenu runMenu = new JMenu("Run");
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription(
                "Import all the images");

        // openImage
        settingsMenu = new JMenuItem("Collage Settings");
        settingsMenu.addActionListener(this::actionPerformed);
        runMenu.add(settingsMenu);

        createImage = new JMenuItem("Create Collage from Images");
        createImage.addActionListener(this::actionPerformed);
        runMenu.add(createImage);

        menuBar.add(runMenu);

        this.w.setJMenuBar(menuBar);
    }

    private void paintImage(BufferedImage img) {
        w.setLayout(new BorderLayout());
        System.out.println("in");

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }
        };

        w.add(pane);
        w.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(openImages)) {
            collageHandler.openImages();
        } else if (e.getSource().equals(exportImage)) {
            collageHandler.exportImage();
        } else if (e.getSource().equals(createImage)) {
            collageHandler.createImage();
            paintImage(collageHandler.getResult());
        } else if (e.getSource().equals(settingsMenu)) {
            new SettingsWindow(this.collageHandler);
        }
    }
}
