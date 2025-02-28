package Student;

import ExamCentre.Generate_ResultID;
import ExamCentre.OracleDataBase;

import java.sql.*;
import java.util.Scanner;

public class Student_Registration {
     public static String Name;
     public static String Email;
     public static String Place;
    public static String Country;
    public static String ResultID;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name:");
        Name = sc.nextLine();
        System.out.println("Enter Email:");
        Email = sc.nextLine();
        System.out.println("Enter Place:");
        Place = sc.nextLine();
        System.out.println("Enter Country:");
        Country = sc.nextLine();
        ResultID = Generate_ResultID.generateresultID.get();
        Student_Exam.ResultID=ResultID;

        try(Connection conn= DriverManager.getConnection(OracleDataBase.ORACLE_URL,OracleDataBase.ORACLE_USERNAME,OracleDataBase.ORACLE_PASSWORD);
            PreparedStatement pst = conn.prepareStatement("INSERT INTO STUDENTS_INFO (STUDENT_NAME, STUDENT_EMAIL, STUDENT_PLACE, STUDENT_COUNTRY, STUDENT_RESULTID) VALUES (?, ?, ?, ?, ?)")
        ){

            pst.setString(1,Name);
            pst.setString(2,Email);
            pst.setString(3,Place);
            pst.setString(4,Country);
            pst.setString(5,ResultID);

            pst.executeUpdate();

        }catch (SQLException se){
            System.out.println(se.getMessage());
        }

        System.out.println("Your result ID is -->" +ResultID);
        System.out.println("Exam Registration Successful !! Wait For Exam");



    }



}