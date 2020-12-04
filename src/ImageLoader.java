import java.awt.FileDialog;
import java.io.File;

import javax.swing.JFrame;

public class ImageLoader {

    public static File[] chooseImages(){
        FileDialog fd = new FileDialog(new JFrame(), "Load", FileDialog.LOAD);
        fd.setMultipleMode(true);
        fd.setFile("*.jpg;*.png;*.jpeg");
        fd.setVisible(true);
        return fd.getFiles();
    }
    public static String chooseOutputImage(){
        FileDialog fd = new FileDialog(new JFrame(), "Save", FileDialog.SAVE);
        fd.setMultipleMode(false);
        fd.setFile("collection.png");
        fd.setVisible(true);
        return fd.getFiles()[0].getAbsolutePath();
    }

}
