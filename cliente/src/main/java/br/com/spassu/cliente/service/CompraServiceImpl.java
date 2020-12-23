package br.com.spassu.cliente.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import br.com.spassu.cliente.domain.Cliente;
import br.com.spassu.cliente.domain.Compra;

public class CompraServiceImpl implements CompraService {

	private String dados;
	ClienteService serviceCliente = new ClienteServiceImpl();

	@Override
	public Compra insert(String Compra, List<Cliente> clienteList) throws ParseException {
		dados = Compra;

		serviceCliente.findById(Compra, clienteList);

		return montarCliente();

	}

	@Override
	public void listarCompras(List<Compra> compras, List<Cliente> clienteList) {
		Cliente cliente = new Cliente();
		Double totalCompras = Double.valueOf(0);
		Integer percencual = 0;

		if (compras.size() > 0) {
			for (Compra compra : compras) {
				totalCompras = totalCompras + compra.getValor();
				
				cliente = serviceCliente.findByCliente(compra.getCliente(), clienteList);
				
				if (ultimaLetraCidade(cliente.getCidade()).equals("a")) {
					percencual = 10;
				} else if (ultimaLetraCidade(cliente.getCidade()).equals("o")) {
					percencual = 20;
				}
				
				System.out.println("| " + cliente.getId() + " | " + cliente.getNome() + " | "
						+ formatarData(compra.getData()) + " | " + formatoMoeda(compra.getValor()) + " | "
						+ formatoMoeda(calculoPercentual(compra.getValor(), percencual)) + " | ");
			}
		}

		System.out.println("Total Compras: " + formatoMoeda(totalCompras));

	}

	@Override
	public void listarClientesEspeciais(List<Compra> compras, List<Cliente> clienteList) {
		Cliente cliente = new Cliente();
		Double totalCompras = Double.valueOf(0);

		if (compras.size() > 0) {
			for (Compra compra : compras) {
				if (compra.getValor() >= 1.000) {
					cliente = serviceCliente.findByCliente(compra.getCliente(), clienteList);
					System.out.println("| " + cliente.getId() + " | " + cliente.getNome() + " | "
							+ formatoMoeda(compra.getValor()) + " | ");

				}

			}
		}

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

	private Compra montarCliente() throws ParseException {
		Compra compra = new Compra();

		compra.setCliente(Integer.parseInt(coletarDados(dados)));

		String data = coletarDados(dados);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		compra.setData(LocalDate.parse(data, formato));

		String valor = coletarDados(dados);
		valor = valor.replace(".", "");
		valor = valor.replace(",", ".");

		compra.setValor(Double.valueOf(valor));

		return compra;
	}

	private String formatarData(LocalDate data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	private String formatoMoeda(Double valor) {
		Locale localeBR = new Locale("pt", "BR");
		NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);

		return dinheiroBR.format(valor);
	}

	private Double calculoPercentual(Double valor, Integer percentual) {
		return valor * percentual.doubleValue() / 100;

	}
	
	private String ultimaLetraCidade(String cidade) {
		return cidade.substring(cidade.length() - 1, cidade.length());
		
	}

}
