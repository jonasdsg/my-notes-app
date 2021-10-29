package br.my.notes.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notas_application","root","");
			return connection;
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
