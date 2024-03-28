package Aims;
import javax.swing.*;
import java.awt.*;

public class mainWindow {
    public static void createWindow(){
        JFrame jframe=new JFrame();
        JLabel label=new JLabel("Aims");
        jframe.getContentPane().add(label, BorderLayout.CENTER);
        label.setPreferredSize(new Dimension(300,100));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
    }
}
