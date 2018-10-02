package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		TipoDeEspetaculo tipoDeEspetaculo = sessao.getEspetaculo().getTipo();

		BigDecimal acrescimoPorEscassez = BigDecimal.ZERO;
		if(sessao.porcentagemDeIngressosDisponiveis() <= tipoDeEspetaculo.getPorcentagemDaEscassez()) {
			acrescimoPorEscassez = sessao.getPreco().multiply(tipoDeEspetaculo.getAumentoPorEscassez());
		}

		BigDecimal acrescimoPorDuracao = BigDecimal.ZERO;
		if(sessao.getDuracaoEmMinutos() > tipoDeEspetaculo.getDuracaoLimite()){
			acrescimoPorDuracao = sessao.getPreco().multiply(tipoDeEspetaculo.getAumentoPorDuracao());
		}

		return sessao.getPreco()
				.add(acrescimoPorEscassez)
				.add(acrescimoPorDuracao)
				.multiply(BigDecimal.valueOf(quantidade));
	}

}