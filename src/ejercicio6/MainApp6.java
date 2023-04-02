package ejercicio6;

import db.DbConection;
public class MainApp6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbConection dbc = new DbConection();
		
		
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");
		dbc.createDB("ta_18_ej6");

		// Crear tablas en la BBDD
		
		String nombreTabla1 = "piezas";
		String tablaColum1 = "codigo INT AUTO_INCREMENT, nombre VARCHAR(100),"
				+ "PRIMARY KEY(codigo)";
		dbc.createTable("ta_18_ej6", nombreTabla1, tablaColum1);
		
		String nombreTabla2 = "proveedores";
		String tablaColum2 = "id CHAR(4), nombre VARCHAR(100), PRIMARY KEY(id)";
		dbc.createTable("ta_18_ej6", nombreTabla2, tablaColum2);
		
		String nombreTabla3 = "suministra";
		String tablaColum3 = "codigo_pieza INT, id_proveedor CHAR(4), precio FLOAT, "
				+ "PRIMARY KEY(codigo_pieza, id_proveedor), "
				+ "FOREIGN KEY(codigo_pieza) REFERENCES piezas(codigo) "
				+ "ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "FOREIGN KEY (id_proveedor) REFERENCES proveedores(id) "
				+ "ON DELETE CASCADE ON UPDATE CASCADE";
		dbc.createTable("ta_18_ej6", nombreTabla3, tablaColum3);
		
		

		// Insertar datos en las tablas
	
				String columnas1 = "codigo, nombre";

				String[] totalValues1 = { "1,'Tornillo'","2,'Pernos'","3,'Espárragos'",
						"4,'Tuercas'","5,'Arandelas'","6,'Remaches'",
						"7,'Insertos'","8,'Columnillas'" };
				for (String valor : totalValues1) {
					dbc.insertData("ta_18_ej6", nombreTabla1, columnas1, valor);
				}
		
				
				String columnas2 = "id, nombre";

				String[] totalValues2 = { "'A','Cpisefa'","'B','Eurex'","'C','Some'","'D','Europages'" };
				
				for (String valor2 : totalValues2) {
					dbc.insertData("ta_18_ej6", nombreTabla2, columnas2, valor2);
				}
				
				String columnas3 = "codigo_pieza, id_proveedor, precio";

				String[] totalValues3 = { "1,'A',3.5","2,'B',2.4","3,'C',9.7","4,'D',2.99" };
				
				for (String valor3 : totalValues3) {
					dbc.insertData("ta_18_ej6", nombreTabla3, columnas3, valor3);
				}


		// Enseñar y Eliminar datos en la tabla
		dbc.getValues("ta_18_ej6", "piezas", columnas1);
		dbc.getValues("ta_18_ej6", "proveedores", columnas2);
		dbc.deleteRecord("ta_18_ej6.piezas", "codigo", "1");
		dbc.closeConnection();
		
		
		
	

	
		
		

	}

}
