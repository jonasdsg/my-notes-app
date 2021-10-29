package br.my.notes.app;

import br.my.notes.app.dao.NotaDAO;
import br.my.notes.app.model.Nota;
import br.my.notes.app.services.FabricaDeConexao;

public class AppTest {

	public static void main(String[] args) {
		NotaDAO dao = new NotaDAO(FabricaDeConexao.getConnection());
		dao.salvar(new Nota(null, "Rafael", "Programador Java Senior"));
	}

}
