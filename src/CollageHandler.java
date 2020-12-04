import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CollageHandler {

    private File[] paths;
    private CollageSettings settings = new CollageSettings();
    private ImageCreator c;
    private BufferedImage result;

    public void openImages() {
        paths = ImageLoader.chooseImages();
    }

    public void createImage() {
        assert (paths!=null && paths.length != 0);

        c = new ImageCreator(settings, paths);
        try {
            c.drawCollage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = c.getResult();
    }

    public void exportImage() {
        assert (c!=null);
        c.exportImage();
    }

    public void setSettings(CollageSettings c) {
        this.settings = c;
    }

    public BufferedImage getResult() {
        return result;
    }
}
