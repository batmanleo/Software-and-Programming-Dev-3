import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
/*
code by Leo
This program is a servey with a graphical interface
It is supposed to save the answers to a file but I couldn't get that part to work
*/
public class serveyOfDoom extends JPanel {

    public static void servey (){

        //this for the checkboxs
    JLabel textFoodAllergies = new JLabel("Cannot eat list");
    JCheckBox dairy = new JCheckBox("dairy");
    JCheckBox gluten = new JCheckBox("gluten");
    JCheckBox sugar = new JCheckBox("sugar");
    JCheckBox peanuts = new JCheckBox("peanuts");
        
        //this is the submitbutton
    JButton submitButton = new JButton("Submit");

        //this is for the radiobuttons
    ButtonGroup gender = new ButtonGroup();
    JRadioButton radioMale = new JRadioButton("Male");
    JRadioButton radioFemale = new JRadioButton("Female");
    JRadioButton radioOther = new JRadioButton("Other");
    JRadioButton radioNo = new JRadioButton("Prefer not to say");
        
        //this is for the textboxes
    JLabel textName = new JLabel("enter name");
    JTextField textBoxName = new JTextField(15);
    JLabel textAddress = new JLabel("enter address");
    JTextField textBoxAddress = new JTextField(15);
        
        //this is the window that everything will be added to
    JFrame window = new JFrame();


        //this adds every thing that was set up obove to the window
    window.add(textName);
    window.add(textBoxName);
    window.add(textAddress);
    window.add(textBoxAddress);

        gender.add(radioFemale);
        gender.add(radioMale);
        gender.add(radioOther);
        gender.add(radioNo);
    window.add(radioFemale);
    window.add(radioMale);
    window.add(radioOther);
    window.add(radioNo);
    
    window.add(textFoodAllergies);
    window.add(dairy);
    window.add(gluten);
    window.add(peanuts);
    window.add(sugar);

    window.add(submitButton);
    

        //this sets up the window itself
    window.setSize(300, 400);
    window.setVisible(true);
    window.setLocation(400, 250);
    window.setLayout(new FlowLayout());


        //this is what the submit button does
ActionListener submitButtonPress = new ActionListener() {

        //this sets up a everything to be added to a new window
    JFrame confirmationWindow = new JFrame("Confirm?");
    JLabel areYouSure = new JLabel("Are you sure?");
    JButton sureYes = new JButton("Yes");
    JButton sureNo = new JButton("No");
    
            @Override 
            public void actionPerformed(ActionEvent e){

                    //this is setting up the new window
                confirmationWindow.setVisible(true);
                confirmationWindow.setSize(250,150);
                confirmationWindow.setLocation(425,300);
                confirmationWindow.setLayout(new FlowLayout());
                
                    //this is adding everything to the new window
                confirmationWindow.add(areYouSure);
                confirmationWindow.add(sureNo);
                confirmationWindow.add(sureYes);
                
                //this what pressing the yes button does
    ActionListener sureYesPress = new ActionListener() {
        FileWriter filemaker = null;
                @Override 
                public void actionPerformed(ActionEvent e){
                    FileWriter filemaker= null;

                    try {
                        /*this should make a new file called servey.txt
                        then add every the results of the servey to the text file
                        then close the FileWriter
                        it doesn't work though*/ 
                    filemaker = new FileWriter("servey.txt");
                    
                    filemaker.append("name = " + textBoxName.getText()+"\n");
                    filemaker.append("address = " + textBoxAddress.getText()+"\n");
                    filemaker.append("Female? "+radioFemale.isSelected()+"\n");
                    filemaker.append("Male? "+radioMale.isSelected()+"\n");
                    filemaker.append("Other? "+radioOther.isSelected()+"\n");
                    filemaker.append("Prefered not to say? "+radioNo.isSelected()+"\n");
                    filemaker.append("no Dairy = " + dairy.isSelected()+"\n");
                    filemaker.append("no Gluten = " + gluten.isSelected()+"\n");
                    filemaker.append("no Peanuts = " + peanuts.isSelected()+"\n");
                    filemaker.append("no Sugar = " + sugar.isSelected()+"\n");
                    
                        /*this is to test if the varibles work
                        because the FileWriter isn't working*/
                    System.out.println("name = " + textBoxName.getText()+"\n");
                    System.out.println("address = " + textBoxAddress.getText()+"\n");
                    System.out.println("Female? "+radioFemale.isSelected()+"\n");
                    System.out.println("Male? "+radioMale.isSelected()+"\n");
                    System.out.println("Other? "+radioOther.isSelected()+"\n");
                    System.out.println("Prefered not to say? "+radioNo.isSelected()+"\n");
                    System.out.println("no Dairy = " + dairy.isSelected()+"\n");
                    System.out.println("no Gluten = " + gluten.isSelected()+"\n");
                    System.out.println("no Peanuts = " + peanuts.isSelected()+"\n");
                    System.out.println("no Sugar = " + sugar.isSelected()+"\n");
                    

                    filemaker.close();
                    }catch (IOException ex) {   
        System.getLogger(serveyOfDoom.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    } finally {

        try {
            filemaker.close();
        } catch (IOException ex) {
            System.getLogger(serveyOfDoom.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    //this closes both windows after it writes the file
    confirmationWindow.dispose();
    window.dispose();
                }
            };

            //this is what pressing no does
    ActionListener sureNoPress = new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                        //this closes the new window
                    confirmationWindow.dispose();

                }
            };
            //this makes it so the buttons do the code when they are pressed
sureYes.addActionListener(sureYesPress);
sureNo.addActionListener(sureNoPress);
            //this is so it closes when it closes instead of staying open but invisible
confirmationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };


        //this makes the submit button run the code when it is pressed
submitButton.addActionListener(submitButtonPress);
        //this is so it closes when it closes instead of staying open but invisible
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
 public static void main (String[] args) {   
        //this runs the all of the code above when the program is ran
    servey(); 

}
}