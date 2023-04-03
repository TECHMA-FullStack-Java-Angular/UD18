package ejercicio7;

import db.DbConection;

public class Main7App {
	public static void main(String[] args) {

		DbConection dbc = new DbConection();

		// Conéctate a la base de datos
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");

		// Elimina y crea la base de datos ud18_ejercicio2
		dbc.createDB("ud18_ejercicio7");

		// Selecciona la base de datos
		dbc.selectDB("ud18_ejercicio7");

		// Crear tabla cientificos
		String tableName1 = "cientificos";
		String tableColumns1 = "dni varchar(8), NomApels nvarchar(255),PRIMARY KEY (dni)";
		dbc.createTable("ud18_ejercicio7", tableName1, tableColumns1);

		// Crear tabla proyecto
		String tableName2 = "proyecto";
		String tableColumns2 = "id char(4), nombre nvarchar(255), horas int, PRIMARY KEY (id)";
		dbc.createTable("ud18_ejercicio7", tableName2, tableColumns2);
		
		// Crear tabla asignado_a
		String tableName3 = "asignado_a";
		String tableColumns3 = "id char(4), dni varchar(8), PRIMARY KEY (id, dni),FOREIGN KEY (id) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE,FOREIGN KEY (dni) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE";
		dbc.createTable("ud18_ejercicio7", tableName3, tableColumns3);

		// Insertar registros en la tabla cientificos
		String columns1 = "dni, NomApels";
		String values1_1 = "34589812, 'Pedro PicaPica'";
		String values1_2 = "37462813, 'LMDSgow'";
		String values1_3 = "63654810, 'Desrt Rollo'";
		dbc.insertData("ud18_ejercicio7", tableName1, columns1, values1_1);
		dbc.insertData("ud18_ejercicio7", tableName1, columns1, values1_2);
		dbc.insertData("ud18_ejercicio7", tableName1, columns1, values1_3);

		// Insertar registros en la tabla empleados
		String columns2 = "id, nombre, horas";
		String values2_1 = "'ARPM','Extraccion',23 ";
		String values2_2 = "'RPJA', 'Especiment 12', 2";
		dbc.insertData("ud18_ejercicio7", tableName2, columns2, values2_1);
		dbc.insertData("ud18_ejercicio7", tableName2, columns2, values2_2);
		
		String columns3 = "dni, id";
		String values3_1 = "'37462813', 'RPJA'";
		String values3_2 = "'63654810', 'ARPM'";
		dbc.insertData("ud18_ejercicio7", tableName3, columns3, values3_1);
		dbc.insertData("ud18_ejercicio7", tableName3, columns3, values3_2);

		// Enseñar y Eliminar datos en la tabla
		dbc.getValues("ud18_ejercicio7", "cientificos", columns1);
		dbc.deleteRecord("ud18_ejercicio7.cientificos", "dni", "34589812");

		// Cerrar conexión
		dbc.closeConnection();

	}

}

