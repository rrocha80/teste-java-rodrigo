package br.com.spassu.cliente.domain;

import lombok.Data;

@Data
public class Cliente {

	private Integer id;
	private String Nome;
	private String Cidade;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", Nome=" + Nome + ", Cidade=" + Cidade + "]";
	}

}
