/*code by Leo
makes a window with 4 buttons
each button can be pressed and cycles through 4 colors
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class buttonOfDoom extends JPanel {



public static void main (String[] args) {
    
    //this sets up the window and buttons
    JFrame window = new JFrame("Buttons Of Doom");
    JButton button1 = new JButton("button1");
    JButton button2 = new JButton("button2");
    JButton button3 = new JButton("button3");
    JButton button4 = new JButton("button4");


        window.add(button1);
        window.add(button2);
        window.add(button3);
        window.add(button4);
        window.setSize(250, 150);
        window.setVisible(true);
        window.setLocation(0, 250);
        window.setLayout(new FlowLayout());


/*this is the button listener
it increments an int by 1 and uses if statements to set a color varible to different colors
there are 4 of theses one for each button  
*/ 
ActionListener buttonPress1 = new ActionListener() {
            int b1 = 0;
            @Override 
            public void actionPerformed(ActionEvent e){

                
                Color button1Color = null;
                b1++;
                if (b1 == 5){
                    b1 = 0;
                }

                if (b1 > 0) {
                    button1Color = Color.yellow;                 
                }
                if(b1 > 1){
                    button1Color = Color.green;
                }
                if(b1 > 2){
                    button1Color = Color.cyan;
                }
                if(b1 > 3){
                button1Color = Color.magenta;
                }
                if(b1 > 4){
                button1Color = Color.red;
                }

                button1.setBackground(button1Color);

            }
        };

ActionListener buttonPress2 = new ActionListener() {
            int b2 = 0;
            @Override 
            public void actionPerformed(ActionEvent e){

                
                Color button2Color = null;
                b2++;
                if (b2 == 5){
                    b2 = 0;
                }

                if (b2 > 0) {
                    button2Color = Color.yellow;                 
                }
                if(b2 > 1){
                    button2Color = Color.green;
                }
                if(b2 > 2){
                    button2Color = Color.cyan;
                }
                if(b2 > 3){
                button2Color = Color.magenta;
                }
                if(b2 > 4){
                button2Color = Color.red;
                }

                button2.setBackground(button2Color);

            }
        };

ActionListener buttonPress3 = new ActionListener() {
int b3 = 0;
            @Override 
            public void actionPerformed(ActionEvent e){

                
                Color button3Color = null;
                b3++;
                if (b3 == 5){
                    b3 = 0;
                }

                if (b3 > 0) {
                    button3Color = Color.yellow;                 
                }
                if(b3 > 1){
                    button3Color = Color.green;
                }
                if(b3 > 2){
                    button3Color = Color.cyan;
                }
                if(b3 > 3){
                button3Color = Color.magenta;
                }
                if(b3 > 4){
                button3Color = Color.red;
                }

                button3.setBackground(button3Color);

            }
        };

ActionListener buttonPress4 = new ActionListener() {
            int b4 = 0;
            @Override 
            public void actionPerformed(ActionEvent e){

                
                Color button4Color = null;
                b4++;
                if (b4 == 5){
                    b4 = 0;
                }

                if (b4 > 0) {
                    button4Color = Color.yellow;                 
                }
                if(b4 > 1){
                    button4Color = Color.green;
                }
                if(b4 > 2){
                    button4Color = Color.cyan;
                }
                if(b4 > 3){
                button4Color = Color.magenta;
                }
                if(b4 > 4){
                button4Color = Color.red;
                }

                button4.setBackground(button4Color);

            }
        };

        //this makes the buttons listen to the listeners
button1.addActionListener(buttonPress1);  
button2.addActionListener(buttonPress2);  
button3.addActionListener(buttonPress3);  
button4.addActionListener(buttonPress4);  



}
}