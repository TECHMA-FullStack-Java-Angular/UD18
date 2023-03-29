package ejercicios1;
import db.DbConection;

public class Main1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DbConection dbc = new DbConection();
		
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");
		dbc.createDB("ta_18_ej1");

		// Crear una tabla en la BBDD
		String nombreTabla = "fabricantes";
		String tablaColum = "codigo INT NOT NULL, nombre VARCHAR(255) NOT NULL, PRIMARY KEY(codigo)";
		dbc.createTable("ta_18_ej1", nombreTabla, tablaColum);

		// Insertar datos en la tabla
		String columnas = "codigo, nombre";
		String values = "2, 'Creative Labs'";

//		dbc.insertData("ta_18_ej1", nombreTabla, columnas, values);

		// Eliminar datos en la tabla
		dbc.getValues("ta_18_ej1", "fabricantes", columnas);
		dbc.deleteRecord("ta_18_ej1.fabricantes", "codigo", "1");
		dbc.closeConnection();
		
		
		
	}

}
