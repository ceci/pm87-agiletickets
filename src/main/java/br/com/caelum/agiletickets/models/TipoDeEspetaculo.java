package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA(0.05, 0.10, 0, 0),
	SHOW(0.05, 0.10, 0, 0),
	TEATRO(0, 0, 0, 0),
	BALLET(0.50, 0.20, 60, 0.10),
	ORQUESTRA(0.50, 0.20, 60, 0.10);

	private double porcentagemDaEscassez;
	private double aumentoPorEscassez;
	private int duracaoLimite;
	private double aumentoPorDuracao;

	TipoDeEspetaculo(double porcentagemDaEscassez, double aumentoPorEscassez, int duracaoLimite, double aumentoPorDuracao) {
		this.porcentagemDaEscassez = porcentagemDaEscassez;
		this.aumentoPorEscassez = aumentoPorEscassez;
		this.duracaoLimite = duracaoLimite;
		this.aumentoPorDuracao = aumentoPorDuracao;
	}

	public BigDecimal getAumentoPorEscassez() {
		return BigDecimal.valueOf(aumentoPorEscassez);
	}

	public int getDuracaoLimite() {
		return duracaoLimite;
	}

	public BigDecimal getAumentoPorDuracao() {
		return BigDecimal.valueOf(aumentoPorDuracao);
	}

	public double getPorcentagemDaEscassez() {

		return porcentagemDaEscassez;
	}
}
