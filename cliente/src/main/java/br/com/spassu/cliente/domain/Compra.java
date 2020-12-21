package br.com.spassu.cliente.domain;

import java.time.LocalDate;

public class Compra {
	
	private Cliente cliente;
	private LocalDate data;
	private Double valor;
	private Double valorImposto;
	
	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getValorImposto() {
		return valorImposto;
	}
	public void setValorImposto(Double valorImposto) {
		this.valorImposto = valorImposto;
	}
}
