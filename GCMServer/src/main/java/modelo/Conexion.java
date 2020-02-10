package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection conectar() {
		/*Connection con = null;
 
		try {
			
			String url = "jdbc:mysql://localhost:3306/wildfly?"+"user=root&password=minoche53";
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion Satisfactoria");
			}
 
		} catch (SQLException e) {
			System.out.println("no wey no se conecta");
			System.out.println(e.getMessage());
		}
		return con;
	}*/
	
	
		Connection conn = null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	String url = "jdbc:mysql://localhost:3306/wildfly?"+"user=root&password=minoche53";
			conn = DriverManager.getConnection(url);
	    	
	    	//conn = DriverManager.getConnection("jdbc:sqlserver://localhost:55334;databaseName=Frutemu;integratedSecurity=true","","");
	    } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
	}
		return conn;}

}
