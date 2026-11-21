import java.time.LocalDate;
import java.time.Period;

public class student implements java.io.Serializable{

int StudentID;
LocalDate studentBirthday;
int studentBYear;
int studentBMonth;
int studentBDay;
String studentName;
String parentName;
String address;
int parentPhone;
String parentEmail;
int studentGrade;
boolean graduate = false;
boolean withdrawn = false;
boolean disabilitiesAccomodations;
int studentPhone;

public student(int StudentID, int studentBYear, int studentBMonth, int studentBDay, String studentName, int studentGrade){
    this.StudentID = StudentID;
    this.studentBYear = studentBYear;
    this.studentBMonth = studentBMonth;
    this.studentBDay = studentBDay;
    this.studentName = studentName;
    this.studentGrade = studentGrade;  
    studentBirthday = LocalDate.of(studentBYear, studentBMonth, studentBDay);
}

public void addvanceGrade(int gradeAvance){
studentGrade = studentGrade + gradeAvance;
if (studentGrade > 12) {
graduate = true;
}
}

public void withdraw(boolean withdraw){
withdrawn = withdraw;
}

public int getAge(){
LocalDate currentTime = LocalDate.now();

return Period.between(studentBirthday,currentTime).getYears();
}

public int getGrade(){

return studentGrade;
}

}

