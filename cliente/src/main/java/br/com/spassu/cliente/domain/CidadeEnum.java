package br.com.spassu.cliente.domain;

public enum CidadeEnum {
	
	SP_SAO_PAULO("São Paulo", "SP"),
	SP_JUNDIAI("Jundiaí", "SP"),
	ES_VILA_VELHA("Vila Velha", "ES"),
	RN_NATAL("Natal", "RN");
	
	private String deCidade;
	private String deEstado;
	
	private CidadeEnum(String deCidade, String deEstado) {
		this.deCidade = deCidade;
		this.deEstado = deEstado;
	}

	public String getDeCidade() {
		return deCidade;
	}

	public void setDeCidade(String deCidade) {
		this.deCidade = deCidade;
	}

	public String getDeEstado() {
		return deEstado;
	}

	public void setDeEstado(String deEstado) {
		this.deEstado = deEstado;
	}
}
