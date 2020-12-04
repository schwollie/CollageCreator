import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(int w, int h) {
        this.setSize(new Dimension(w, h));
        this.setTitle("Collage Creator");
        this.setFocusable(true);
        this.setVisible(true);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }


}

