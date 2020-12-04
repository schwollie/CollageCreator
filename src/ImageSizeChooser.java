import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImageSizeChooser extends JPanel{
    private Dimension format;
    private BufferedImage image;

    public ImageSizeChooser(BufferedImage image, Dimension format) {
        super();
        this.format = format;
        this.image = image;
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.drawRect(0, 0, 100, 100);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(),null);
        repaint();
    }
}
