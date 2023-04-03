package ejercicio8;

import db.DbConection;

public class Main8App {
	public static void main(String[] args) {

		DbConection dbc = new DbConection();

		// Conéctate a la base de datos
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");

		dbc.createDB("ud18_ejercicio8");

		// Selecciona la base de datos
		dbc.selectDB("ud18_ejercicio8");

		// Crear tabla cientificos
		String tableName1 = "productos";
		String tableColumns1 = "codigo int, nombre nvarchar(255),precio int,PRIMARY KEY (codigo)";
		dbc.createTable("ud18_ejercicio8", tableName1, tableColumns1);

		// Crear tabla proyecto
		String tableName2 = "cajeros";
		String tableColumns2 = "codigo int, nomApels nvarchar(255), PRIMARY KEY (codigo)";
		dbc.createTable("ud18_ejercicio8", tableName2, tableColumns2);
		
		String tableName3= "maquinas_registradoras";
		String tableColumns3 = "codigo int, piso int, PRIMARY KEY (codigo)";
		dbc.createTable("ud18_ejercicio8", tableName2, tableColumns2);
		
		// Crear tabla asignado_a
		String tableName4 = "venta";
		String tableColumns4 = "cajero int, maquina int, producto int, PRIMARY KEY (cajero,maquina, producto),"
				+ "FOREIGN KEY (cajero) REFERENCES cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "FOREIGN KEY (producto) REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
		dbc.createTable("ud18_ejercicio8", tableName3, tableColumns3);

		String columns1 = "codigo, nombre, precio";
		String values1_1 = "6785, 'PicaPica', 2";
		String values1_2 = "1354, 'GrowGrow',14";
		String values1_3 = "9075, 'Rollo',12";
		dbc.insertData("ud18_ejercicio8", tableName1, columns1, values1_1);
		dbc.insertData("ud18_ejercicio8", tableName1, columns1, values1_2);
		dbc.insertData("ud18_ejercicio8", tableName1, columns1, values1_3);

		String columns2 = "codigo, nomApels";
		String values2_1 = "4512,'Pedro Pi'";
		String values2_2 = "3142, 'Laura Impa'";
		dbc.insertData("ud18_ejercicio8", tableName2, columns2, values2_1);
		dbc.insertData("ud18_ejercicio8", tableName2, columns2, values2_2);
		
		String columns3 = "codigo, piso";
		String values3_1 = "3957, 1";
		String values3_2 = "3456, 34";
		dbc.insertData("ud18_ejercicio8", tableName3, columns3, values3_1);
		dbc.insertData("ud18_ejercicio8", tableName3, columns3, values3_2);
		
		String columns4 = "cajero,maquina, producto";
		String values4_1 = "4512, 3957, 1254";
		String values4_2 = "3142, 3456, 6785";
		dbc.insertData("ud18_ejercicio8", tableName4, columns4, values4_1);
		dbc.insertData("ud18_ejercicio8", tableName4, columns4, values4_2);

		// Enseñar y Eliminar datos en la tabla
		dbc.getValues("ud18_ejercicio8", "cientificos", columns1);
		dbc.deleteRecord("ud18_ejercicio8.cientificos", "dni", "34589812");

		// Cerrar conexión
		dbc.closeConnection();

	}

}

