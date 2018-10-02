package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA(0.05, 0.10, 0, 0),
	SHOW(0.05, 0.10, 0, 0),
	TEATRO(0, 0, 0, 0),
	BALLET(0.50, 0.20, 60, 0.10),
	ORQUESTRA(0.50, 0.20, 60, 0.10);

	private double porcentagemDaEscassez;
	private double acrescimoPorEscassez;
	private int duracaoLimite;
	private double acrescimoPorDuracao;

	TipoDeEspetaculo(double porcentagemDaEscassez, double acrescimoPorEscassez, int duracaoLimite, double acrescimoPorDuracao) {
		this.porcentagemDaEscassez = porcentagemDaEscassez;
		this.acrescimoPorEscassez = acrescimoPorEscassez;
		this.duracaoLimite = duracaoLimite;
		this.acrescimoPorDuracao = acrescimoPorDuracao;
	}

	public BigDecimal getAcrescimoPorEscassez() {
		return BigDecimal.valueOf(acrescimoPorEscassez);
	}

	public int getDuracaoLimite() {
		return duracaoLimite;
	}

	public BigDecimal getAcrescimoPorDuracao() {
		return BigDecimal.valueOf(acrescimoPorDuracao);
	}

	public double getPorcentagemDaEscassez() {

		return porcentagemDaEscassez;
	}
}
