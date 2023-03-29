package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class dbConection {
	public static Connection conectorDeDB()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion= DriverManager.getConnection("jdbc:mysql://192.168.4.66:3306","remote","P@ssw0rd_Remote");
			System.out.print("Server Connected");
			return conexion;
			
		}catch(SQLException | ClassNotFoundException ex)
		{
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
		return null;
	}
	public static void closeConnection(Connection conection)
	{
		try 
		{
			conection.close();
			System.out.println("Connection ended");
		}
		catch(SQLException ex)
		{
			System.out.println("Connection error on close");
			System.out.println(ex);
		}
	}
	

}
