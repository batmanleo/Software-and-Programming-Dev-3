import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
public class serveyOfDoom extends JPanel {

    public static void servey (){

    JLabel textFoodAllergies = new JLabel("Cannot eat list");
    JCheckBox dairy = new JCheckBox("dairy");
    JCheckBox gluten = new JCheckBox("gluten");
    JCheckBox sugar = new JCheckBox("sugar");
    JCheckBox peanuts = new JCheckBox("peanuts");
    
    JButton submitButton = new JButton("Submit");

    ButtonGroup gender = new ButtonGroup();
    JRadioButton radioMale = new JRadioButton("Male");
    JRadioButton radioFemale = new JRadioButton("Female");
    JRadioButton radioOther = new JRadioButton("Other");
    JRadioButton radioNo = new JRadioButton("Prefer not to say");
    
    JLabel textName = new JLabel("enter name");
    JTextField textBoxName = new JTextField(15);
    JLabel textAddress = new JLabel("enter address");
    JTextField textBoxAddress = new JTextField(15);
    JFrame window = new JFrame();


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
    

    window.setSize(300, 400);
    window.setVisible(true);
    window.setLocation(400, 250);
    window.setLayout(new FlowLayout());



ActionListener submitButtonPress = new ActionListener() {

    JFrame confirmationWindow = new JFrame("Confirm?");
    JLabel areYouSure = new JLabel("Are you sure?");
    JButton sureYes = new JButton("Yes");
    JButton sureNo = new JButton("No");
    
            @Override 
            public void actionPerformed(ActionEvent e){

                confirmationWindow.setVisible(true);
                confirmationWindow.setSize(250,150);
                confirmationWindow.setLocation(425,300);
                confirmationWindow.setLayout(new FlowLayout());
                
                confirmationWindow.add(areYouSure);
                confirmationWindow.add(sureNo);
                confirmationWindow.add(sureYes);
                
    ActionListener sureYesPress = new ActionListener() {
        FileWriter filemaker = null;
                @Override 
                public void actionPerformed(ActionEvent e){
                    String name = new String("name = " + textBoxName.getText()+"\n");
                    String address = new String("address = " + textBoxAddress.getText()+"\n");
                    String genderString = new String("gender selected ="+gender.getSelection()+"\n");
                    String noDairy = new String("no Dairy = " + dairy.isSelected()+"\n");
                    String noGluten = new String("no Gluten = " + gluten.isSelected()+"\n");
                    String noPeanuts = new String("no Peanuts = " + peanuts.isSelected()+"\n");
                    String noSugar = new String("no Sugar = " + sugar.isSelected()+"\n");

                    String pleaseWriteThis = new String(name+address+genderString+noDairy+noGluten+noPeanuts+noSugar);

                    try {
                    filemaker = new FileWriter("servey.txt");

                    filemaker.append(pleaseWriteThis);

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
    confirmationWindow.dispose();
    window.dispose();
                }
            };

    ActionListener sureNoPress = new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){

                    confirmationWindow.dispose();

                }
            };
sureYes.addActionListener(sureYesPress);
sureNo.addActionListener(sureNoPress);
confirmationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };



submitButton.addActionListener(submitButtonPress);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
 public static void main (String[] args) {   

    servey(); 

}
}