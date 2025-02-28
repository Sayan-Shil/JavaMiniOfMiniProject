import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExamCentre {
    public static void questions(String resultID) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Student Result ID: " + resultID);
        System.out.println("Answer the following questions (Type A, B, C, or D):");

        // Question 1
        System.out.println("1. Encapsulation is part of -->");
        System.out.println("   A) Inheritance\n   B) Polymorphism\n   C) Abstraction\n   D) OOP");
        String answer1 = scanner.next().toUpperCase();
        if (answer1.equals("D")) score++;

        // Question 2
        System.out.println("2. Which keyword is used to create a subclass?");
        System.out.println("   A) extend\n   B) extends\n   C) implement\n   D) inherits");
        String answer2 = scanner.next().toUpperCase();
        if (answer2.equals("B")) score++;

        // Question 3
        System.out.println("3. What is the default value of an int in Java?");
        System.out.println("   A) 0\n   B) 1\n   C) null\n   D) Undefined");
        String answer3 = scanner.next().toUpperCase();
        if (answer3.equals("A")) score++;

        // Question 4
        System.out.println("4. What does JVM stand for?");
        System.out.println("   A) Java Virtual Machine\n   B) Java Verified Module\n   C) Just Virtual Machine\n   D) Java Variable Manager");
        String answer4 = scanner.next().toUpperCase();
        if (answer4.equals("A")) score++;

        // Question 5
        System.out.println("5. Which of these is not a primitive data type in Java?");
        System.out.println("   A) float\n   B) boolean\n   C) string\n   D) int");
        String answer5 = scanner.next().toUpperCase();
        if (answer5.equals("C")) score++;

        // Question 6
        System.out.println("6. What is used to read user input in Java?");
        System.out.println("   A) Scanner\n   B) InputReader\n   C) Console\n   D) Readline");
        String answer6 = scanner.next().toUpperCase();
        if (answer6.equals("A")) score++;

        // Question 7
        System.out.println("7. What is the size of a `double` in Java?");
        System.out.println("   A) 4 bytes\n   B) 8 bytes\n   C) 16 bytes\n   D) Platform dependent");
        String answer7 = scanner.next().toUpperCase();
        if (answer7.equals("B")) score++;

        // Question 8
        System.out.println("8. What does `static` mean in Java?");
        System.out.println("   A) Variable is constant\n   B) Method can be overridden\n   C) Belongs to class, not instance\n   D) None of the above");
        String answer8 = scanner.next().toUpperCase();
        if (answer8.equals("C")) score++;

        // Question 9
        System.out.println("9. How do you start a thread in Java?");
        System.out.println("   A) start()\n   B) run()\n   C) begin()\n   D) execute()");
        String answer9 = scanner.next().toUpperCase();
        if (answer9.equals("A")) score++;

        // Question 10
        System.out.println("10. What is the parent class of all Java classes?");
        System.out.println("   A) Main\n   B) Object\n   C) Class\n   D) Root");
        String answer10 = scanner.next().toUpperCase();
        if (answer10.equals("B")) score++;


        scanner.close();

        try(Connection conn= DriverManager.getConnection(OracleDataBase.ORACLE_URL,OracleDataBase.ORACLE_USERNAME,OracleDataBase.ORACLE_PASSWORD );
            PreparedStatement pst = conn.prepareStatement("UPDATE STUDENTS_INFO SET STUDENT_RESULT = ? WHERE STUDENT_RESULTID = ?");

        ){

            pst.setInt(1,score);
            pst.setString(2,resultID);
            pst.executeUpdate();

        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }
}
