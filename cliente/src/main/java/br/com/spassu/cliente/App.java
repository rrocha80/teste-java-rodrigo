package br.com.spassu.cliente;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.spassu.cliente.domain.Cliente;
import br.com.spassu.cliente.domain.Compra;
import br.com.spassu.cliente.service.ClienteService;
import br.com.spassu.cliente.service.ClienteServiceImpl;
import br.com.spassu.cliente.service.CompraService;
import br.com.spassu.cliente.service.CompraServiceImpl;

public class App {
	public static void main(String[] args) throws ParseException {

		ClienteService serviceCliente = new ClienteServiceImpl();
		CompraService serviceCompra = new CompraServiceImpl();

		Cliente cliente = new Cliente();
		List<Cliente> clienteList = new ArrayList<Cliente>();

		Compra compra = new Compra();
		List<Compra> compraList = new ArrayList<Compra>();

		int opcao = 0;
		String valor = "";

		Scanner scanner = new Scanner(System.in);

		while (opcao != 9) {
			menu();

			valor = scanner.nextLine();

			opcao = opcaoEscolhida(valor);

			switch (opcao) {
			case 1:
				if (clienteList.size() > 0) {
					for (Cliente cliente2 : clienteList) {
						System.out.println("| " + cliente2.getId() + " | " + cliente2.getNome() + " | "
								+ cliente2.getCidade() + " | ");
					}
				}
				break;

			case 2:
				cliente = serviceCliente.insert(valor);
				System.out.println("Cliente " + cliente.getId() + " incluído");
				clienteList.add(cliente);
				break;

			case 3:
				clienteList = serviceCliente.update(valor, clienteList);
				System.out.println("Cliente " + cliente.getId() + " alterado");
				break;

			case 4:
				clienteList = serviceCliente.delete(valor, clienteList);
				System.out.println("Cliente " + cliente.getId() + " excluído");
				break;

			case 5:
				serviceCliente.findById(valor, clienteList);
				break;

			case 6:
				compra = serviceCompra.insert(valor, clienteList);
				System.out.println("Compra para o cliente " + cliente.getId() + " incluída");
				compraList.add(compra);
				break;

			case 7:
				serviceCompra.listarCompras(compraList, clienteList);
				break;

			case 8:
				serviceCompra.listarClientesEspeciais(compraList, clienteList);
				break;

			default:
				break;
			}
		}
		
		System.out.println("Sistema encerrado!");

	}

	private static void menu() {
		System.out.println("-----------------------------");
		System.out.println("(1) - Listar clientes");
		System.out.println("(2) - Incluir cliente");
		System.out.println("(3) - Alterar cliente");
		System.out.println("(4) - Excluir cliente");
		System.out.println("(5) - Consultar cliente");
		System.out.println("(6) - Incluir compra");
		System.out.println("(7) - Listar compras");
		System.out.println("(8) - Listar clientes especiais");
		System.out.println("(9) - SAIR");
		System.out.println("-----------------------------");
	}

	private static int opcaoEscolhida(String valor) {
		return Integer.parseInt(valor.substring(0, 1));
	}
}
