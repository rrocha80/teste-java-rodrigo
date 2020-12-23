package br.com.spassu.cliente.service;

import java.util.List;
import java.util.Optional;

import br.com.spassu.cliente.domain.Cliente;

public class ClienteServiceImpl implements ClienteService {
	private String dados;

	@Override
	public Cliente insert(String comando) {
		dados = comando;
		return montarCliente();
	}

	@Override
	public List<Cliente> update(String comando, List<Cliente> clientes) {
		dados = comando;
		Cliente c = new Cliente();
		c = montarCliente();
		int id = Integer.parseInt(findId(comando));

		Optional<Cliente> opt = clientes.stream().filter(cliente -> cliente.getId().equals(id)).findAny();
		if (opt.isPresent()) {
			opt.get().setNome(c.getNome());
			opt.get().setCidade(c.getCidade());
		}

		return clientes;
	}

	@Override
	public List<Cliente> delete(String comando, List<Cliente> clientes) {
		dados = comando;
		Cliente c = new Cliente();
		c = montarCliente();
		int id = Integer.parseInt(findId(comando));

		Optional<Cliente> opt = clientes.stream().filter(cliente -> cliente.getId().equals(id)).findAny();
		if (opt.isPresent()) {
			clientes.remove(opt.get());
		}

		return clientes;
	}

	@Override
	public void findById(String comando, List<Cliente> clientes) {
		dados = comando;
		Cliente c = new Cliente();
		c = montarCliente();
		int id = Integer.parseInt(findId(comando));

		Optional<Cliente> opt = clientes.stream().filter(cliente -> cliente.getId().equals(id)).findAny();
		if (opt.isPresent()) {
			System.out.println(opt.get().getId() + " " + opt.get().getNome() + " " + opt.get().getCidade());
		} else {
			System.out.println("Cliente não encontrado!");
		}

	}

	@Override
	public Cliente findByCliente(int id, List<Cliente> clientes) {
		Cliente c = new Cliente();

		Optional<Cliente> opt = clientes.stream().filter(cliente -> cliente.getId().equals(id)).findAny();
		if (opt.isPresent()) {
			c = opt.get();
		} else {
			System.out.println("Cliente não encontrado!");
		}

		return c;

	}

	private String coletarDados(String valor) {
		int um;
		int dois;
		um = valor.indexOf(";");
		valor = valor.replaceFirst(";", ",");
		if (valor.indexOf(";") > 0) {
			dois = valor.indexOf(";");
		} else {
			dois = valor.length();
		}

		dados = valor;

		return valor.substring(um + 1, dois).trim();
	}

	private String findId(String valor) {
		int um;
		int dois;
		um = valor.indexOf(";");
		valor = valor.replaceFirst(";", ",");
		if (valor.indexOf(";") > 0) {
			dois = valor.indexOf(";");
		} else {
			dois = valor.length();
		}

		return valor.substring(um + 1, dois).trim();
	}

	private Cliente montarCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(Integer.parseInt(coletarDados(dados)));
		cliente.setNome(coletarDados(dados));
		cliente.setCidade(coletarDados(dados));

		return cliente;
	}

}
