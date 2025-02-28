package Student;

import ExamCentre.OracleDataBase;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.Scanner;

public class GenerateResult {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Result ID: ");
        String resultID = sc.nextLine().trim();

        int Result=0 ;
        String Name,Place,Email;

        try(Connection conn= DriverManager.getConnection(OracleDataBase.ORACLE_URL,OracleDataBase.ORACLE_USERNAME,OracleDataBase.ORACLE_PASSWORD);
            CallableStatement cst = conn.prepareCall("{?= call GET_RESULT(?) }");
        ){
            cst.setString(2,resultID);
            cst.registerOutParameter(1, Types.INTEGER);
            cst.execute();
            Result = cst.getInt(1);
        }
        catch (SQLException se){
            se.printStackTrace();
        }


        try(Connection conn= DriverManager.getConnection(OracleDataBase.ORACLE_URL,OracleDataBase.ORACLE_USERNAME,OracleDataBase.ORACLE_PASSWORD);
            CallableStatement cst = conn.prepareCall("{call GET_DETAILS(?,?) }");
        ){
            cst.setString(1,resultID);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(2);
            if(!rs.next()){
                System.out.println("No Records Found Yet");
            }
            else{
                System.out.println("-- NAME --\n" +rs.getString("STUDENT_NAME") +"\n");
                System.out.println("-- PLACE --\n" +rs.getString("STUDENT_PLACE") +"\n");
                System.out.println("-- EMAIL --\n" +rs.getString("STUDENT_EMAIL") +"\n");
                System.out.println("--SCORE-- \n"+Result +"/10");
            }

        }
        catch (SQLException se){
            se.printStackTrace();
        }




    }
}
