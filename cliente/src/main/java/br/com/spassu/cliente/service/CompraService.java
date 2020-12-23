package br.com.spassu.cliente.service;

import java.text.ParseException;
import java.util.List;

import br.com.spassu.cliente.domain.Cliente;
import br.com.spassu.cliente.domain.Compra;

public interface CompraService {

	public Compra insert(String Compra, List<Cliente> clienteList) throws ParseException;

	public void listarCompras(List<Compra> compras, List<Cliente> clienteList);

	public void listarClientesEspeciais(List<Compra> compras, List<Cliente> clienteList);

}
