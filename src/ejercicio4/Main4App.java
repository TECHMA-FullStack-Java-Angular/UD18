package ejercicio4;

import db.DbConection;
import utilidades.Utls;

public class Main4App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConection dbc = new DbConection();
		Utls ut = new Utls();
		
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");
//		ut.abrirScanner();
//		ut.crearDB();
		dbc.createDB("ta_18_ej4");

		// Crear tablas en la BBDD
		
		String nombreTabla = "peliculas";
		String tablaColum = "codigo INT NOT NULL, nombre VARCHAR(255) NOT NULL, calificacion_edad VARCHAR(255) DEFAULT NULL, PRIMARY KEY(codigo)";
		dbc.createTable("ta_18_ej4", nombreTabla, tablaColum);
		
		String nombreTabla2 = "salas";
		String tablaColum2 = "codigo INT NOT NULL, nombre VARCHAR(255) NOT NULL, pelicula INT DEFAULT NULL, "
				+ " PRIMARY KEY(codigo), KEY pelicula (pelicula), "
				+ "FOREIGN KEY (pelicula) REFERENCES peliculas (codigo)";
		dbc.createTable("ta_18_ej4", nombreTabla2, tablaColum2);

		// Insertar datos en las tablas
	
				String columnas = "codigo, nombre, calificacion_edad";

				String[] totalValues = { "1,'Citizen Kane','PG'","2,'Singin in the Rain','G'","3,'The Wizard of Oz','G'",
						"4,'The Quiet Man',NULL","5,'North by Northwest',NULL","6,'The Last Tango in Paris','NC-17'",
						"7,'Some Like it Hot','PG-13'","8,'A Night at the Opera',NULL","9,'Citizen King','G'" };
				for (String valor : totalValues) {
					dbc.insertData("ta_18_ej4", nombreTabla, columnas, valor);
				}
		
				

				// Insertar datos en la tabla
				String columnas2 = "codigo, nombre, pelicula";

				String[] totalValues2 = { "1,'Odeon',5","2,'Imperial',1","3,'Majestic',NULL","4,'Royale',6",
						"5,'Paraiso',3","6,'Nickelodeon',NULL" };
				
				for (String valor2 : totalValues2) {
					dbc.insertData("ta_18_ej4", nombreTabla2, columnas2, valor2);
				}

		// Eliminar datos en la tabla
		dbc.getValues("ta_18_ej4", "peliculas", columnas);
		dbc.getValues("ta_18_ej4", "salas", columnas2);
		dbc.deleteRecord("ta_18_ej4.salas", "codigo", "1");
		dbc.closeConnection();
		
		
		
	

	}

}
