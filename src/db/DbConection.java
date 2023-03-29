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

//	    public static void main(String[] args) {
//	        dbConection dbc = new dbConection();
//	        dbc.connect("192.168.1.153:3306","remote","Aa802000**");
//	        dbc.createDB("Pedro_pintame");
//	        
//	     // Crear una tabla en la base de datos Pedro_pintame
//	        String tableName = "mi_tabla";
//	        String tableColumns = "id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(50), apellido VARCHAR(50), edad INT";
//	        dbc.createTable("Pedro_pintame", tableName, tableColumns);
//	        
//	        // Insertar datos en la tabla mi_tabla
//	        String columns = "nombre, apellido, edad";
//	        String values = "'Juan', 'Pérez', 30";
//	        dbc.insertData("Pedro_pintame", tableName, columns, values);
//	        
//	        dbc.getValues("ta14_ejercicio7", "despachos");
//	        dbc.deleteRecord("ta14_ejercicio7.directores","nom_apels","Juan Pérez");
//	        dbc.closeConnection();
//	    }

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
//	    		System.out.println(kuery);
			st.executeUpdate(kuery);
//	    		System.out.println("Ey que llego");
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos" + dbName + " correctamente");
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

			JOptionPane.showMessageDialog(null, "Se ha creado la tabla " + nombreTabla + " correctamente");
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

			JOptionPane.showMessageDialog(null, "Datos insertados correctamente en la tabla " + tableName);
		} catch (SQLException ex) {
			Logger.getLogger(DbConection.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Error insertando datos en la tabla " + tableName);
		}
	}

	// METODO QUE OBTIENE VALORES MYSQL
	public void getValues(String db, String table_name, String columnas) {
		String[] columna = columnas.split(",");

		try {
			String queryDb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			String query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);

			while (resultSet.next()) {

				for (String valor : columna) {
					System.out.println(resultSet.getString(valor.trim()));
				}

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