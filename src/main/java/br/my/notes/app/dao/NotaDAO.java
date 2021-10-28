package br.my.notes.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.my.notes.app.model.Nota;

public class NotaDAO {

	private Connection connection;

	public NotaDAO(Connection conection) {
		this.connection = conection;
	}
	
	public void salvar(Nota nota) {
		String sql = "INSERT INTO nota(nota,nome) VALUES (?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, nota.getNota());
			prepareStatement.setString(2, nota.getNome());
			prepareStatement.executeUpdate();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Nota acheNotaPorId(Long id) {
		String sql = "SELECT * FROM nota WHERE id = ?";
		try {
			Nota nota = null;
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				nota = new Nota(resultSet.getLong("id"),resultSet.getString("nome"), resultSet.getString("nota"));
			}
			return nota;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM nota WHERE id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, this.acheNotaPorId(id).getId());
			prepareStatement.executeUpdate();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}	
	}	

	public Nota atualizar(Nota nota) {
		String sql = "UPDATE nota SET nota = ? ,nome = ? WHERE id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, nota.getNota());
			prepareStatement.setString(2, nota.getNome());
			prepareStatement.setLong(3, nota.getId());
			prepareStatement.executeUpdate();
			return this.acheNotaPorId(nota.getId());
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
