import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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
}


class faceOfEvil extends JPanel {

public void paintComponent(Graphics g){
super.paintComponent(g);


g.setColor(Color.YELLOW);
g.fillOval(0, 0, 230, 200);
g.setColor(Color.BLACK);
g.fillOval(120, 50, 80, 80);
g.fillOval(20, 50, 80, 80);
g.fillRect(60, 150, 100, 30);
g.fillOval(60, 170, 100, 20);

}


public static void main (String[] args) {

    Random rand = new Random();
        JButton button = new JButton("button");
        faceOfDoom face = new faceOfDoom();
        faceOfEvil face2 = new faceOfEvil();
        faceOfDestruction face3 = new faceOfDestruction();
        JLabel buttonText = new JLabel("displaybox text");
        JFrame window = new JFrame("Face Of Doom");
        JFrame window2 = new JFrame("Face Of Evil");
        JFrame window3 = new JFrame("Face Of Destruction");
        JFrame buttonWindow = new JFrame("Button");
        window.add(face);
        window.setSize(252,282);
        window.setVisible(false);
        window.setLocation(0, 250);

         window2.add(face2);
        window2.setSize(252,282);
        window2.setVisible(false);
        window2.setLocation(250, 250);

         window3.add(face3);
        window3.setSize(252,282);
        window3.setVisible(false);
        window3.setLocation(250, 0);


        buttonWindow.setLayout(new FlowLayout());
        buttonWindow.add(button);
        buttonWindow.add(buttonText);
        buttonWindow.setSize(252,282);
        buttonWindow.setVisible(true);


        ActionListener buttonPress = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){

                int b = rand.nextInt(9);
                
                if (b == 1){
                
                window3.setVisible(false);
                window2.setVisible(false);
                window.setVisible(true);
                }
                if (b == 2){
                
                window3.setVisible(false);
                window2.setVisible(true);
                window.setVisible(false);
                }
                if (b == 3){
                
                window3.setVisible(true);
                window2.setVisible(false);
                window.setVisible(false);
                }
                
                if (b == 4){
                buttonText.setText("Java is a object oriented language");

                }
                if (b == 5){
                buttonText.setText("The 's' in String is capitalized");

                }
                if (b == 6){
                buttonText.setText("Don't forget the semicolon!");

                }
                if (b == 7){
                buttonText.setText("Remember to leave comments");

                }
                if (b == 8){
                buttonText.setText("Indenting can increase readablity");

                }
                if (b == 9){
                buttonText.setText("AWT allows you to make windows and graphics");

                }
             
            }

        };
    
        button.addActionListener(buttonPress);

    }
}