package ejercicios1;

import db.DbConection;
//import db.DbConection;
import utilidades.Utls;

public class Main1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DbConection dbc = new DbConection();
		Utls ut = new Utls();

		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");
//		ut.abrirScanner();
//		ut.crearDB();
		dbc.createDB("ta_18_ej1");

//		// Crear una tabla en la BBDD
		String nombreTabla = "fabricantes";
		String tablaColum = "codigo INT NOT NULL, nombre VARCHAR(255) NOT NULL, PRIMARY KEY(codigo)";
		dbc.createTable("ta_18_ej1", nombreTabla, tablaColum);

		// Insertar datos en la tabla
		String columnas = "codigo, nombre";

		String[] totalValues = { "1,'Sony'", "2,'Creative Labs'", "3,'Hewlett-Packard'", "4,'Iomega'", "5,'Fujitsu'",
				"6,'Winchester'" };
		for (String valor : totalValues) {
			dbc.insertData("ta_18_ej1", nombreTabla, columnas, valor);
		}

//		dbc.insertData("ta_18_ej1", nombreTabla, columnas, values);

		//Crear tabla articulos
		String nombreTabla2 = "articulos";
		String tablaColum2 = "codigo INT NOT NULL, nombre VARCHAR(255) NOT NULL, precio decimal(10,0) NOT NULL, "
				+ "fabricante int NOT NULL, PRIMARY KEY(codigo), KEY fabricante (fabricante), "
				+ "FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo)";
		dbc.createTable("ta_18_ej1", nombreTabla2, tablaColum2);

		// Insertar datos en la tabla
		String columnas2 = "codigo, nombre, precio, fabricante";

		String[] totalValues2 = { "1,'Hard drive',240,5","2,'Memory',120,6","3,'ZIP drive',150,4",
				"4,'Floppy disk',5,6","5,'Monitor',240,1","6,'DVD drive',180,2","7,'CD drive',90,2",
				"8,'Printer',270,3","9,'Toner cartridge',66,3","10,'DVD burner',180,2" };
		for (String valor2 : totalValues2) {
			dbc.insertData("ta_18_ej1", nombreTabla2, columnas2, valor2);
		}

		// Eliminar datos en la tabla
//		dbc.getValues("ta_18_ej1", "fabricantes", columnas);
//		dbc.deleteRecord("ta_18_ej1.fabricantes", "codigo", "6");
		dbc.closeConnection();

	}

}
