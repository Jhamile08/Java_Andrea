package DataBase;
import java.sql.*;
public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://bvfu1nlg9hbsefh8vwd3-mysql.services.clever-cloud.com/bvfu1nlg9hbsefh8vwd3";
            String user = "ubxedo8roggkjgfc";
            String password = "e2K8IMQsNuwk5lSdQFCr";
            objConnection =  (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecte perfectamente");

        }catch (ClassNotFoundException error){
            System.out.println("ERROR >> Driver no instalado" + error.getMessage());
        }catch (SQLException error){
            System.out.println("ERROR >> error al conectar la base de datos" + error.getMessage());
        }
        return objConnection;
    }
    public static void closeConnection(){
        try {
            // Si hay una conexion actica entonces la cierra
            if( objConnection != null) objConnection.close();
            System.out.println("Se finalizo la conexion con exito");
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }



}
