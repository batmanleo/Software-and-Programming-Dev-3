public class wrapper{

    public static void main (){
        student student1 = new student(01234, 2010, 01, 12, "borb", 2);
        System.out.println(student1.getAge());
        student1.addvanceGrade(3);
        System.out.println(student1.getGrade());
    }
    
}