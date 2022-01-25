package Dao;

import java.sql.*;

public class ConexaoDao{ 
	
	String url = "jdbc:jtds:sqlserver://NathanTK:1433/MusicSchool";
	String usuario = "Jeferson";
	String senha = "123456";
	
	public Connection getConnection() throws ClassNotFoundException {
		 try {
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		 }         
		 catch(SQLException ex) {
			throw new RuntimeException(ex);
		 }
    }
 
}
