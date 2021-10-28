package br.my.notes.app.model;

public class Nota {
	private Long id;
	private String nome;
	private String nota;

	public Nota(Long id, String nome, String nota) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getNota() {
		return nota;
	}

}
