package br.com.spassu.cliente.domain;

public class Cliente {
	
	private int id;
	private String Nome;
	private CidadeEnum Cidade;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public CidadeEnum getCidade() {
		return Cidade;
	}
	public void setCidade(CidadeEnum cidade) {
		Cidade = cidade;
	}
}
