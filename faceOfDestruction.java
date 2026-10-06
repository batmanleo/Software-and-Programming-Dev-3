import java.awt.*;
import javax.swing.*;

public class  faceOfDestruction extends JPanel {

public void paintComponent(Graphics g){
super.paintComponent(g);


g.setColor(Color.BLUE);
g.fillOval(0, 0, 230, 200);
g.setColor(Color.BLACK);
g.fillOval(120, 50, 80, 80);
g.fillOval(20, 50, 80, 80);
g.fillRect(60, 150, 100, 30);
g.fillOval(60, 170, 100, 20);


}
}