package db;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class dbConection {
    private Connection conexion;

    public static void main(String[] args) {
        dbConection dbc = new dbConection();
<<<<<<< HEAD
        dbc.connect("192.168.4.105:3306");
=======
        dbc.connect("192.168.1.128:3306","remote","por.java12DABA");
        dbc.createDB("Pedro_pintame");
>>>>>>> 1fe00ceefc30a1834eaaa418cc2b3a20b6dbbb63
        dbc.closeConnection();
    }

    public void connect(String IP,String user,String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
            conexion = DriverManager.getConnection("jdbc:mysql://"+IP+" ", "remote", "P@ssw0rd_Remote");
=======
            conexion = DriverManager.getConnection("jdbc:mysql://"+IP+" ",user ,password );
>>>>>>> 1fe00ceefc30a1834eaaa418cc2b3a20b6dbbb63
            System.out.print("Server Connected");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.print("No se ha podido conectar con mi base de datos");
            System.out.print(ex);
        }
   
    }

    public void closeConnection() {
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(dbConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void createDB(String dbName)
    {
    	
    	try
    	{
    		String kuery="CREATE DATABASE "+dbName+" ;";
    		Statement st=conexion.createStatement();
    		System.out.println(kuery);
    		st.executeUpdate(kuery);
    		System.out.println("Ey que llego");
    		JOptionPane.showMessageDialog(null,"Se ha creado la base de datos"+dbName+" correctamente");
    	}
    	catch(SQLException ex)
    	{
    		Logger.getLogger(dbConection.class.getName()).log(Level.SEVERE,null,ex);
    	}
    }
}

