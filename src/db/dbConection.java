package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class dbConection {
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306?userTimezone=true&serverTimezone=UTC","remote","por.java12DABA");
			System.out.print("Server Connected");
			
		}catch(SQLException | ClassNotFoundException ex)
		{
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
	public void closeConnection()
	{
		try 
		{
			conexion.Close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
			
		}catch(SQLException ex)
		{
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE,null,ex);
		}
	}

}
