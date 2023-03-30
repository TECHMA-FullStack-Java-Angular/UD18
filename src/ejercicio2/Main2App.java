package ejercicio2;

import db.DbConection;

public class Main2App {

	public static void main(String[] args) {
		
DbConection dbc = new DbConection();
	    
	    // Conéctate a la base de datos
	    dbc.connect("192.168.1.153:3306", "remote", "Aa802000**");
	    
	    // Elimina y crea la base de datos ud14_ejercicio4
	    dbc.createDB("ud14_ejercicio4");
	    
	    // Selecciona la base de datos
	    dbc.selectDB("ud14_ejercicio4");

	    // Crear tabla departamentos
	    String tableName1 = "departamentos";
	    String tableColumns1 = "cod_departamento INT AUTO_INCREMENT, nombre VARCHAR(100), presupuesto INT, PRIMARY KEY (cod_departamento)";
	    dbc.createTable("ud14_ejercicio4", tableName1, tableColumns1);

	    // Crear tabla empleados
	    String tableName2 = "empleados";
	    String tableColumns2 = "dni VARCHAR(8), nombre VARCHAR(100), apellidos VARCHAR(255), departamento INT, PRIMARY KEY (dni), FOREIGN KEY (departamento) REFERENCES departamentos(cod_departamento) ON DELETE CASCADE ON UPDATE CASCADE";
	    dbc.createTable("ud14_ejercicio4", tableName2, tableColumns2);

	    // Insertar registros en la tabla departamentos
	    String columns1 = "cod_departamento, nombre, presupuesto";
	    String values1_1 = "1, 'Recursos Humanos', 50000";
	    String values1_2 = "2, 'Desarrollo', 80000";
	    String values1_3 = "3, 'Desarrollo', 80000";
	    dbc.insertData("ud14_ejercicio4", tableName1, columns1, values1_1);
	    dbc.insertData("ud14_ejercicio4", tableName1, columns1, values1_2);
	    dbc.insertData("ud14_ejercicio4", tableName1, columns1, values1_3);

	    // Insertar registros en la tabla empleados
	    String columns2 = "dni, nombre, apellidos, departamento";
	    String values2_1 = "'12345678', 'Juan', 'Gonzalez', 1";
	    String values2_2 = "'23456789', 'Esther', 'Cruz', 2";
	    dbc.insertData("ud14_ejercicio4", tableName2, columns2, values2_1);
	    dbc.insertData("ud14_ejercicio4", tableName2, columns2, values2_2);

	    // Cerrar conexión
	    dbc.closeConnection();

	}

}
