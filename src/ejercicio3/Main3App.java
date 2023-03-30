package ejercicio3;

import db.DbConection;

public class Main3App {

	public static void main(String[] args) {

		// Creamos el objeto dbc encargada de conectar con la BBDD
		DbConection dbc = new DbConection();

		// Guardamos el nombre de la BBDD
		String nombreBD = "ta14_ejercicio5";

		// Conetamos con la BBDD
		dbc.connect("192.168.1.153:3306", "remote", "pass");

		// Elimina y crea la base de datos nombreBD
		dbc.createDB(nombreBD);

		// Selecciona la base de datos
		dbc.selectDB(nombreBD);

		// Crear tabla almacenes
		String tablaAlmacenes = "almacenes";
		String tablaColumAlmacenes = "codigo INT AUTO_INCREMENT, lugar VARCHAR(100), capacidad INT, PRIMARY KEY (codigo)";
		dbc.createTable(nombreBD, tablaAlmacenes, tablaColumAlmacenes);

		// Crear tabla cajas
		String tablaCajas = "cajas";
		String tablaColumCajas = "num_referencia CHAR(5), contenido VARCHAR(100), valor INT, almacen INT NULL, "
				+ "PRIMARY KEY (num_referencia), FOREIGN KEY(almacen) REFERENCES almacenes(codigo) ON DELETE SET NULL ON UPDATE CASCADE";
		dbc.createTable(nombreBD, tablaCajas, tablaColumCajas);

		// Insertar registros en la tabla almacenes
		String columAlmacenes = "codigo, lugar, capacidad";
		String values1_1 = "1, 'Barcelona', 50000";
		String values1_2 = "2, 'Madrid', 80000";
		String values1_3 = "3, 'Valencia', 90000";
		dbc.insertData(nombreBD, tablaAlmacenes, columAlmacenes, values1_1);
		dbc.insertData(nombreBD, tablaAlmacenes, columAlmacenes, values1_2);
		dbc.insertData(nombreBD, tablaAlmacenes, columAlmacenes, values1_3);

		// Insertar registros en la tabla cajas
		String columCajas = "num_referencia, contenido, valor, almacen";
		String values2_1 = "'12345', 'Peras', 1000, 1";
		String values2_2 = "'67890', 'Manzanas', 2000, 2";
		String values2_3 = "'09876', 'Naranjas', 3000, 3";
		dbc.insertData(nombreBD, tablaCajas, columCajas, values2_1);
		dbc.insertData(nombreBD, tablaCajas, columCajas, values2_2);
		dbc.insertData(nombreBD, tablaCajas, columCajas, values2_3);

		// Cerrar conexion
		dbc.closeConnection();

	}

}
