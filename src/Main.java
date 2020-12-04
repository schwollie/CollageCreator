import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CollageHandler c = new CollageHandler();
        ControlWindow controlWindow = new ControlWindow(c);


        /*File[] files = ImageLoader.chooseImages();
        BufferedImage[] imgs = new BufferedImage[files.length];

        //for (int i = 0; i < files.length; i++) {
        //    File f = files[i];
        //    imgs[i] = ImageIO.read(f);
        //}
        ImageCreator ic = new ImageCreator(files, 1);
        ic.createImage();
        ic.paintImage();
        ic.exportImage();*/

    }

}
