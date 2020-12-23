package br.com.spassu.cliente.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Compra {

	private Integer cliente;
	private LocalDate data;
	private Double valor;
	private Double valorImposto;

	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

}
