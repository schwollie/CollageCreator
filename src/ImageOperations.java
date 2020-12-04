import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ImageOperations {

    public static BufferedImage rescaleImage(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_FAST);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    public static BufferedImage rescaleImage(BufferedImage img, int width) {
        int height = (int)((double)width / img.getWidth() * img.getHeight());
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_FAST);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    public BufferedImage getSlice(BufferedImage img, int x, int y, int width, int height) {
        BufferedImage slice = img.getSubimage(x, y, width, height);
        return slice;
    }

}
