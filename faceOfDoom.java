import java.awt.*;
import javax.swing.*;


public class faceOfDoom extends JPanel {

public void paintComponent(Graphics g){
super.paintComponent(g);


g.setColor(Color.MAGENTA);
g.fillOval(0, 0, 230, 200);
g.setColor(Color.BLACK);
g.fillOval(120, 50, 80, 80);
g.fillOval(20, 50, 80, 80);
g.fillRect(60, 150, 100, 30);
g.fillOval(60, 170, 100, 20);


}

public static void main (String[] args) {

        faceOfDoom face = new faceOfDoom();
        JFrame window = new JFrame();
        window.add(face);
        window.setSize(252,252);
        window.setVisible(true);
    
    }
}