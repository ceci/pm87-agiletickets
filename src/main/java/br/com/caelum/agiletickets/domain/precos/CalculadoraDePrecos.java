package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		TipoDeEspetaculo tipoDeEspetaculo = sessao.getEspetaculo().getTipo();

		return sessao.getPreco()
				.add(acrescimoPorEscassez(sessao, tipoDeEspetaculo))
				.add(acrescimoPorDuracao(sessao, tipoDeEspetaculo))
				.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal acrescimoPorDuracao(Sessao sessao, TipoDeEspetaculo tipoDeEspetaculo) {
		BigDecimal acrescimoPorDuracao = BigDecimal.ZERO;
		if(sessao.getDuracaoEmMinutos() > tipoDeEspetaculo.getDuracaoLimite()){
			acrescimoPorDuracao = sessao.getPreco().multiply(tipoDeEspetaculo.getAcrescimoPorDuracao());
		}
		return acrescimoPorDuracao;
	}

	private static BigDecimal acrescimoPorEscassez(Sessao sessao, TipoDeEspetaculo tipoDeEspetaculo) {
		BigDecimal acrescimoPorEscassez = BigDecimal.ZERO;
		if(sessao.porcentagemDeIngressosDisponiveis() <= tipoDeEspetaculo.getPorcentagemDaEscassez()) {
			acrescimoPorEscassez = sessao.getPreco().multiply(tipoDeEspetaculo.getAcrescimoPorEscassez());
		}
		return acrescimoPorEscassez;
	}

}