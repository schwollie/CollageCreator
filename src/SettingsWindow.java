import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class SettingsWindow implements ActionListener {

    private final Window w;
    private CollageHandler collageHandler;

    //ui
    private JTextField cols, c;
    private JTextField rows, r;
    private JCheckBox autoColRow;
    private JTextField resolution, res;
    private JButton confirm;

    public SettingsWindow(CollageHandler c) {
        w = new Window(400, 400);
        this.collageHandler = c;

        createUI();
    }

    private void createUI() {
        cols = new JTextField("0");
        cols.setBounds(120, 10, 100, 40);
        cols.setVisible(true);
        cols.setBorder(BorderFactory.createEmptyBorder());
        cols.setForeground(Color.WHITE);
        cols.setBackground(Colors.uiElement);
        cols.setHorizontalAlignment(SwingConstants.CENTER);

        c = new JTextField("Anzahl der Reihen:");
        c.setBounds(10, 10, 100, 40);
        c.setVisible(true);
        c.setEditable(false);
        c.setBorder(BorderFactory.createEmptyBorder());
        c.setForeground(Color.WHITE);
        c.setBackground(Colors.uiElement);
        c.setHorizontalAlignment(SwingConstants.CENTER);

        w.add(c);
        w.add(cols);

        rows = new JTextField("0");
        rows.setBounds(120, 60, 100, 40);
        rows.setVisible(true);
        rows.setBorder(BorderFactory.createEmptyBorder());
        rows.setForeground(Color.WHITE);
        rows.setBackground(Colors.uiElement);
        rows.setHorizontalAlignment(SwingConstants.CENTER);

        r = new JTextField("Anzahl der Spalten:");
        r.setBounds(10, 60, 100, 40);
        r.setVisible(true);
        r.setEditable(false);
        r.setBorder(BorderFactory.createEmptyBorder());
        r.setForeground(Color.WHITE);
        r.setBackground(Colors.uiElement);
        r.setHorizontalAlignment(SwingConstants.CENTER);

        w.add(r);
        w.add(rows);

        autoColRow = new JCheckBox("Auto Spalt/Reihe");
        autoColRow.setToolTipText("Berechnet einen der Werte automatisch wenn einer der beiden Werte 0 ist.");
        autoColRow.setBounds(10, 110, 200, 40);
        autoColRow.setVisible(true);
        autoColRow.setBorder(BorderFactory.createEmptyBorder());
        autoColRow.setForeground(Color.WHITE);
        autoColRow.setBackground(Colors.uiElement);
        autoColRow.setHorizontalAlignment(SwingConstants.CENTER);

        w.add(autoColRow);

        resolution = new JTextField("1.0");
        resolution.setBounds(120, 160, 100, 40);
        resolution.setVisible(true);
        resolution.setBorder(BorderFactory.createEmptyBorder());
        resolution.setForeground(Color.WHITE);
        resolution.setBackground(Colors.uiElement);
        resolution.setHorizontalAlignment(SwingConstants.CENTER);

        res = new JTextField("Aufloesung: ");
        res.setBounds(10, 160, 100, 40);
        res.setVisible(true);
        res.setEditable(false);
        res.setBorder(BorderFactory.createEmptyBorder());
        res.setForeground(Color.WHITE);
        res.setBackground(Colors.uiElement);
        res.setHorizontalAlignment(SwingConstants.CENTER);

        w.add(resolution);
        w.add(res);

        confirm = new JButton("Apply Settings");
        confirm.setBounds(10, 210, 100, 40);
        confirm.setVisible(true);
        confirm.setBorder(BorderFactory.createEmptyBorder());
        confirm.setForeground(Color.WHITE);
        confirm.setBackground(Colors.uiElement);
        confirm.addActionListener(this);
        confirm.setFocusPainted(false);
        w.add(confirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(confirm)) {
            CollageSettings settings = new CollageSettings(toInt(cols.getText()), toInt(rows.getText()),
                    autoColRow.isSelected(), toDouble(resolution.getText()), new Format());
            w.dispose();
            collageHandler.setSettings(settings);
        }
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }

    private double toDouble(String s) {
        return Double.parseDouble(s);
    }
}
