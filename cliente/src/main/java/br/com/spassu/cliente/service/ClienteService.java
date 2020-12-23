package br.com.spassu.cliente.service;

import java.util.List;

import br.com.spassu.cliente.domain.Cliente;

public interface ClienteService {

	public Cliente insert(String cliente);

	public List<Cliente> update(String comando, List<Cliente> clientes);

	public List<Cliente> delete(String comando, List<Cliente> clienteList);

	public void findById(String comando, List<Cliente> clienteList);

	public Cliente findByCliente(int id, List<Cliente> clientes);

}
