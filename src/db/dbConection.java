package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class dbConection {
    private Connection conexion;

    public static void main(String[] args) {
        dbConection dbc = new dbConection();
        dbc.connect("192.168.4.105:3306");
        dbc.closeConnection();
    }

    public void connect(String IP) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+IP+" ", "remote", "P@ssw0rd_Remote");
            System.out.print("Server Connected");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.print("No se ha podido conectar con mi base de datos");
            System.out.print(ex);
        }
   
    }

    public void closeConnection() {
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(dbConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

