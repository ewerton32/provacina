package br.com.provacBeta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

    private static Connection connection;
    private static Statement statement;

    public static Statement preparaStatement() {
        if (connection == null) {
            try {
            	/* MS Access  */
            	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
                String url = "jdbc:odbc:bdProvacina";
                String user = "";
                String passwd = "";
            	
                /* MySQL  */
            	/*String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/BDContas";
                String user = "root";
                String passwd = "";*/
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, passwd);
            } catch(SQLException sqle) {
    		    System.out.println("SQLException => ConnectionManager: " + sqle.getMessage());
    	    } catch(ClassNotFoundException cnfe) {
    		    System.out.println("Driver nao encontrado => ConnectionManager: " + cnfe.getMessage());
    		}
    	}
    	try {
    	    statement = connection.createStatement();
    	} catch(SQLException sqle) {
    		    System.out.println("SQLException => ConnectionManager: " + sqle.getMessage());
    	}
    	return statement;
    }

    
    public static void liberaRecursos() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {}
    }

}