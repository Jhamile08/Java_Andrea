package database;
import java.sql.*;
public class ConfigDB {
    // Este atributo tendra el estado de la conexion
    static Connection objConnection = null;
    public static Connection openConnection(){
        try {
            //Llamamos al driver
            Class.forName("com.mysql.cj.jdbc.Diver");
            //Creamos la variable de conexion
            String url = "jdbc:mysql://babfbe9aev5xoznwl32t-mysql.services.clever-cloud.com/babfbe9aev5xoznwl32t";
            String user = "uzpvojulutvz9kgj";
            String password = "onfZMtJ0MFdaPjR4BY7O";
            //Establecer condxion
            objConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Me conecte perfectamente!!");
        }catch (ClassNotFoundException e){
            System.out.println("ERROR >> Driver no instalado" + e.getMessage());
        }catch (SQLException e){
            System.out.println("ERROR >> error al conectar la base de datos" + e.getMessage());
        }
        return objConnection;
    }

}
