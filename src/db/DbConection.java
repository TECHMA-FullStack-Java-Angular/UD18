package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DbConection {
	private Connection conexion;

	public void connect(String IP, String user, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://" + IP + " ", user, password);
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
			Logger.getLogger(DbConection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void createDB(String dbName) {

		try {
			String kuery = " CREATE DATABASE IF NOT EXISTS " + dbName + " ;";
			Statement st = conexion.createStatement();
			System.out.println(kuery);
			st.executeUpdate(kuery);
			System.out.println("Ey que llego");
			System.out.println("Se ha creado la base de datos" + dbName + " correctamente");
		} catch (SQLException ex) {
			Logger.getLogger(DbConection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	//Metodo que se asegura que se esta usando la BBDD
	public void selectDB(String dbName) {
	    try {
	        String queryDb = "USE " + dbName + ";";
	        Statement stdb = conexion.createStatement();
	        stdb.executeUpdate(queryDb);
	    } catch (SQLException ex) {
	        Logger.getLogger(DbConection.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	// Método para crear una tabla en una base de datos
	public void createTable(String nombreBBDD, String nombreTabla, String tablaColum) {
		try {
			String queryDb = "USE " + nombreBBDD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			String query = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " (" + tablaColum + ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(query);

			System.out.println("Se ha creado la tabla " + nombreTabla + " correctamente");
		} catch (SQLException ex) {
			Logger.getLogger(DbConection.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Error creando la tabla " + nombreTabla);
		}
	}

	// Método para insertar datos en una tabla
	public void insertData(String dbName, String tableName, String columns, String values) {
		try {
			String queryDb = "USE " + dbName + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(query);

			System.out.println("Datos insertados correctamente en la tabla " + tableName);
		} catch (SQLException ex) {
			Logger.getLogger(DbConection.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Error insertando datos en la tabla " + tableName);
		}
	}

	// METODO QUE OBTIENE VALORES MYSQL
	public void getValues(String db, String table_name) {

		try {
			String queryDb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			String query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("Columna 1: " + resultSet.getString("numero"));
				System.out.println("Columna 2: " + resultSet.getString("capacidad"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
	}

	// METODO QUE ELIMINA VALORES DE NUESTRA BASE DE DATOS
	public void deleteRecord(String table_name_columna, String columna, String campo) {
		try {
			String query = "DELETE FROM " + table_name_columna + " WHERE " + columna + "= \"" + campo + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(query);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}

}