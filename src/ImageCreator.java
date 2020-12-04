import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCreator {

    private int cols, rows;
    private Dimension resolution;

    private CollageSettings settings;
    private File[] files;
    private BufferedImage result;

    private Graphics2D graphics;

    public ImageCreator(CollageSettings settings, File[] files) {
        this.settings = settings;
        this.files = files;
        applySettings();
        createImage();
    }

    private void applySettings() {
        if (settings.isAutoComplete()) {

            if (settings.getRows()==0) {
                rows = (int)Math.ceil(files.length / (double)settings.getCols());
                cols = settings.getCols();
            } else if (settings.getCols()==0) {
                cols = (int)Math.ceil(files.length / (double)settings.getRows());
                rows = settings.getRows();
            } else {
                cols = 1;
                rows = files.length;
            }

        } else {
            rows = settings.getRows();
            cols = settings.getCols();
        }

        System.out.println("Rows::"+rows+ " COls::" +cols);
        resolution = new Dimension(1000, 1000);
    }

    public synchronized void drawCollage() throws IOException {
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int index = c*rows + r;
                if (index > files.length) {return;}
                BufferedImage img = ImageIO.read(files[index].getAbsoluteFile());
                if (img == null) { continue; }
                img = ImageOperations.rescaleImage(img, (int)resolution.getWidth());

                System.out.println("drawing::"+index);
                int y = (int)(c * resolution.getHeight());
                int x = (int)(r * resolution.getWidth());
                this.graphics.drawImage(img, x, y, img.getWidth(), img.getHeight(), null);
            }
        }

    }

    public BufferedImage createImage() {
        BufferedImage image = new BufferedImage((int) resolution.getWidth() * rows,
                (int) resolution.getHeight() * cols, BufferedImage.TYPE_INT_RGB);

        this.graphics = (Graphics2D) image.getGraphics();
        this.result = image;
        return image;
    }

    public BufferedImage getResult() {
        return result;
    }

    public void exportImage() {
        // export Image
        String path = ImageLoader.chooseOutputImage();
        String fileType = path.substring(path.length()-3, path.length());
        System.out.println("Saving::"+fileType+" to::"+path);
        File location = new File(path);
        try {
            ImageIO.write(result, fileType.toUpperCase(), location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("EXPORTET!");
    }
}
