package Ejercicio9;

import db.DbConection;

public class Main9App {
	public static void main(String[] args) {

		DbConection dbc = new DbConection();

		// Conéctate a la base de datos
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");

		dbc.createDB("ud18_ejercicio9");

		// Selecciona la base de datos
		dbc.selectDB("ud18_ejercicio9");

		String tableName1 = "facultad";
		String tableColumns1 = "codigo int, nombre nvarchar(100),PRIMARY KEY (codigo)";
		dbc.createTable("ud18_ejercicio9", tableName1, tableColumns1);
		
		String tableName2 = "investigadores";
		String tableColumns2 = "dni varchar(8), nomApels nvarchar(255), facultad int, PRIMARY KEY (dni)"
				+ "FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
		dbc.createTable("ud18_ejercicio9", tableName2, tableColumns2);
		
		String tableName3= "equipos";
		String tableColumns3 = "numSerie char(4),nombre nvarchar(100), facultad int, PRIMARY KEY (numSerie)"
				+"FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
		dbc.createTable("ud18_ejercicio9", tableName2, tableColumns2);
		
		// Crear tabla asignado_a
		String tableName4 = "reserva";
		String tableColumns4 = "dni varchar(8), numSerie char(4), comienzo datatime,fin datatime, PRIMARY KEY (dni, numSerie),"
				+ "FOREIGN KEY (dni) REFERENCES investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (numSerie) REFERENCES equipos(numSerie) ON DELETE CASCADE ON UPDATE CASCADE";
		dbc.createTable("ud18_ejercicio9", tableName3, tableColumns3);

		String columns1 = "int, nombre";
		String values1_1 = "6785, 'LasLas'";
		String values1_2 = "1354, 'Mineria'";
		String values1_3 = "9075, 'Frien'";
		dbc.insertData("ud18_ejercicio9", tableName1, columns1, values1_1);
		dbc.insertData("ud18_ejercicio9", tableName1, columns1, values1_2);
		dbc.insertData("ud18_ejercicio9", tableName1, columns1, values1_3);

		String columns2 = "dni, nomApels,facultad";
		String values2_1 = "46571829,'Pedro Pi',9075";
		String values2_2 = "63857920, 'Laura Impa',6785";
		dbc.insertData("ud18_ejercicio9", tableName2, columns2, values2_1);
		dbc.insertData("ud18_ejercicio9", tableName2, columns2, values2_2);
		
		String columns3 = "numSerie, nombre,facultad";
		String values3_1 = "'T5AG', 'JuanEquipo',6785";
		String values3_2 = "'P63A', 'TuquiTuqui',9075";
		dbc.insertData("ud18_ejercicio9", tableName3, columns3, values3_1);
		dbc.insertData("ud18_ejercicio9", tableName3, columns3, values3_2);
		
		String columns4 = "dni,numSerie, comienzo, fin";
		String values4_1 = "46571829, 'P63A', '10-11-2000','09-09-2011'";
		String values4_2 = "63857920, 'T5AG', '11-12-2010','07-06-2017'";
		dbc.insertData("ud18_ejercicio9", tableName4, columns4, values4_1);
		dbc.insertData("ud18_ejercicio9", tableName4, columns4, values4_2);

		// Enseñar y Eliminar datos en la tabla
		dbc.getValues("ud18_ejercicio9", "investigadores", columns1);
		dbc.deleteRecord("ud18_ejercicio9.cientificos", "dni", "46571829");

		// Cerrar conexión
		dbc.closeConnection();

	}

}