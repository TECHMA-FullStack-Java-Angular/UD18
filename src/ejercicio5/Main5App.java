package ejercicio5;

import db.DbConection;

public class Main5App {

	public static void main(String[] args) {

		// Creamos el objeto dbc encargada de conectar con la BBDD
		DbConection dbc = new DbConection();

		// Guardamos el nombre de la BBDD
		String nombreBD = "ta18_ejercicio5";

		// Conectandose a la BBDD
		// dbc.connect("192.168.1.153:3306", "remote", "Aa802000**");
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");

		// Elimina y crea la base de datos ta18_ejercicio5
		dbc.createDB(nombreBD);

		// Selecciona BBDD
		dbc.selectDB(nombreBD);

		// Crear la tabla despachos
		String nombreTabla = "despachos";
		String tablaColum = "numero int, capacidad int, primary key(numero)";
		dbc.createTable(nombreBD, nombreTabla, tablaColum);

		// Crear la tabla directores
		nombreTabla = "directores";
		tablaColum = "dni varchar(8), nom_apels nvarchar(255), dni_jefe varchar(8) NULL, despacho int NULL, primary key(dni), foreign key(dni_jefe) references directores(dni) on delete set null on update cascade, foreign key(despacho) references despachos(numero) on delete set null on update cascade";
		dbc.createTable(nombreBD, nombreTabla, tablaColum);

		// Insertar registros en la tabla despachos
		String columnas = "numero, capacidad";
		String[] valuesArray = { "1, 4", "2, 5", "3, 6" };

		for (String values : valuesArray) {
			dbc.insertData(nombreBD, "despachos", columnas, values);
		}

		// Insertar insertar registros en la tabla directores
		String columnas2 = "dni, nom_apels, dni_jefe, despacho";
		valuesArray = new String[] { "'12345678', 'Alberto del Pozo', NULL, 1",
				"'23456789', 'Tamyle Morales', '12345678', 2", "'34567890', 'Carlos Crespo', '12345678', 3" };

		for (String values : valuesArray) {
			dbc.insertData(nombreBD, "directores", columnas2, values);
		}

		// Enseñar y Eliminar datos en la tabla
		dbc.getValues("ta18_ejercicio5", "despachos", columnas);
		dbc.deleteRecord("ta18_ejercicio5.despachos", "numero", "1");

		// Cerrar conexion
		dbc.closeConnection();

	}
}