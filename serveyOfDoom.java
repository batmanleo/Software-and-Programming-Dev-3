import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
/*
code by Leo
This program is a servey with a graphical interface
It saves the answers to a file
*/
public class serveyOfDoom extends JPanel {

    public static void servey (){

JFileChooser chooseMyFilesFileChooser = new JFileChooser(FileSystemView.getFileSystemView());
int loadSaveOption = JOptionPane.showConfirmDialog(null, "Do you want to load a file?", "Load or Save?", JOptionPane.YES_NO_OPTION);


            String[] LoadTextBoxName = null;
            String[] LoadTextBoxAddress = null;
            String[] LoadRadioFemale = null;
            String[] LoadRadioMale = null;
            String[] LoadRadioOther = null;
            String[] LoadRadioNo = null;
            String[] LoadDairy = null;
            String[] LoadGluten = null;
            String[] LoadPeanuts = null;
            String[] LoadSugar = null;


 if (loadSaveOption == JOptionPane.YES_OPTION) {
            chooseMyFilesFileChooser.showOpenDialog(chooseMyFilesFileChooser);

            //This reads the file selected and sets varibles to the answers in the file

            try {
            Scanner readMyFilesFileReader= new Scanner(chooseMyFilesFileChooser.getSelectedFile());

            LoadTextBoxName = readMyFilesFileReader.nextLine().split("name = ");
            LoadTextBoxAddress = readMyFilesFileReader.nextLine().split("address = ");
            LoadRadioFemale = readMyFilesFileReader.nextLine().split("Female = ");
            LoadRadioMale = readMyFilesFileReader.nextLine().split("Male = ");
            LoadRadioOther = readMyFilesFileReader.nextLine().split("Other = ");
            LoadRadioNo = readMyFilesFileReader.nextLine().split("Prefered not to say = ");
            LoadDairy = readMyFilesFileReader.nextLine().split("no Dairy = ");
            LoadGluten = readMyFilesFileReader.nextLine().split("no Gluten = ");
            LoadPeanuts = readMyFilesFileReader.nextLine().split("no Peanuts = ");
            LoadSugar = readMyFilesFileReader.nextLine().split("no Sugar = ");


                System.out.println(LoadTextBoxName[1]);
                System.out.println(LoadTextBoxAddress[1]);
                System.out.println(LoadRadioFemale[1]);
                System.out.println(LoadRadioMale[1]);
                System.out.println(LoadRadioOther[1]);
                System.out.println(LoadRadioNo[1]);
                System.out.println(LoadDairy[1]);
                System.out.println(LoadGluten[1]);
                System.out.println(LoadPeanuts[1]);
                System.out.println(LoadSugar[1]);


            readMyFilesFileReader.close();
            } catch (IOException ex) {   
        System.getLogger(serveyOfDoom.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
         }

        } else if (loadSaveOption == JOptionPane.NO_OPTION) {
        }

        /*
        I added if statements
        they are supposed to set everything to be the same as the file selected
        but I could only get the textfields to work
        */


        //this for the checkboxs
    JLabel textFoodAllergies = new JLabel("Cannot eat list");
    JCheckBox dairy = new JCheckBox("dairy");
    if (LoadDairy != null){
        if (LoadDairy[1] == "true"){
            dairy.setSelected(true);
        }else{
            if (LoadDairy[1] == "false"){
                dairy.setSelected(false);
            }
        }
    }
    JCheckBox gluten = new JCheckBox("gluten");
    if (LoadGluten != null){
        if (LoadGluten[1] == "true"){
            gluten.setSelected(true);
        }else{
            if (LoadGluten[1] == "false"){
                gluten.setSelected(false);
            }
        }
    }
    JCheckBox sugar = new JCheckBox("sugar");
    if (LoadSugar != null){
        if (LoadSugar[1] == "true"){
            sugar.setSelected(true);
        }else{
            if (LoadSugar[1] == "false"){
                sugar.setSelected(false);
            }
        }
    }
    JCheckBox peanuts = new JCheckBox("peanuts");
    if (LoadPeanuts != null){
        if (LoadPeanuts[1] == "true"){
            peanuts.setSelected(true);
        }else{
            if (LoadPeanuts[1] == "false"){
                peanuts.setSelected(false);
            }
        }
    }
        
        //this is the submitbutton
    JButton submitButton = new JButton("Submit");

        //this is for the radiobuttons
    ButtonGroup gender = new ButtonGroup();
    JRadioButton radioMale = new JRadioButton("Male");
        if (LoadRadioMale != null){
        if (LoadRadioMale[1] == "true"){
            radioMale.setSelected(true);
        }else{
            if (LoadRadioMale[1] == "false"){
                radioMale.setSelected(false);
            }
        }
    }
    JRadioButton radioFemale = new JRadioButton("Female");
        if (LoadRadioFemale != null){
        if (LoadRadioFemale[1] == "true"){
            radioFemale.setSelected(true);
        }else{
            if (LoadRadioFemale[1] == "false"){
                radioFemale.setSelected(false);
            }
        }
    }
    JRadioButton radioOther = new JRadioButton("Other");
        if (LoadRadioOther != null){
        if (LoadRadioOther[1] == "true"){
            radioOther.setSelected(true);
        }else{
            if (LoadRadioOther[1] == "false"){
                radioOther.setSelected(false);
            }
        }
    }
    JRadioButton radioNo = new JRadioButton("Prefer not to say");
        if (LoadRadioNo != null){
            if (LoadRadioNo[1] == "true"){
                radioNo.setSelected(true);
            }else{
                if (LoadRadioNo[1] == "false"){
                    radioNo.setSelected(false);
                }
            }
        }
        
        //this is for the textboxes
        JTextField textBoxName = new JTextField(15);
        JLabel textName = new JLabel("enter name");
        if (LoadTextBoxName != null){
            textBoxName.setText(""+LoadTextBoxName[1]);
        }        
    
        JTextField textBoxAddress = new JTextField(15);
        JLabel textAddress = new JLabel("enter address");
        if (LoadTextBoxAddress != null){
            textBoxAddress.setText(""+LoadTextBoxAddress[1]);
        }
            
        
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
                        
                    chooseMyFilesFileChooser.showSaveDialog(null);
                    
                        //filemaker = new FileWriter("servey.txt");
                    filemaker = new FileWriter(chooseMyFilesFileChooser.getSelectedFile());
                    
                    filemaker.append("name = " + textBoxName.getText()+"\n");
                    filemaker.append("address = " + textBoxAddress.getText()+"\n");
                    filemaker.append("Female = "+radioFemale.isSelected()+"\n");
                    filemaker.append("Male = "+radioMale.isSelected()+"\n");
                    filemaker.append("Other = "+radioOther.isSelected()+"\n");
                    filemaker.append("Prefered not to say = "+radioNo.isSelected()+"\n");
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