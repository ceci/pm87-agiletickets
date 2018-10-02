package br.com.caelum.agiletickets.acceptance;

import br.com.caelum.agiletickets.acceptance.page.EstabelecimentosPage;
import org.junit.Before;
import org.junit.Test;

public class EstabelecimentoTest extends BaseTest {

	private EstabelecimentosPage estabelecimentos;

	@Before
	public void setUp() {
		estabelecimentos = indexPage.navegaParaEstabelecimentos();
	}

	@Test
	public void aoAdicionarUmEstabelecimentoDeveMostraLoNaTabela() {
		estabelecimentos.adicioneEstabelecimento("Caelum", "R. Vergueiro, 3185");

		estabelecimentos.ultimaLinhaDeveConter("Caelum", "R. Vergueiro, 3185");
	}

	@Test
	public void aoAdicionarUmEstabelecimentoSemNomeDeveMostrarErro() {
		estabelecimentos.adicioneEstabelecimento("", "R. Vergueiro, 3185");

		estabelecimentos.deveMostrarErro("O nome não pode ser vazio");
	}

	@Test
	public void aoAdicionarUmEstabelecimentoSemEnderecoDeveMostrarErro() {
		estabelecimentos.adicioneEstabelecimento("Caelum", "");

		estabelecimentos.deveMostrarErro("O endereco não pode ser vazio");
	}

	@Test
	public void mostraQueHaEstacionamentoQuandoCadastramosQueSim() {
		estabelecimentos.adicioneEstabelecimentoComEstacionamento(true);

		estabelecimentos.ultimaLinhaDeveTerEstacionamento(true);
	}

	@Test
	public void mostraQueNaoHaEstacionamentoQuandoCadastramosQueNao() {
		estabelecimentos.adicioneEstabelecimentoComEstacionamento(false);

		estabelecimentos.ultimaLinhaDeveTerEstacionamento(false);
	}
}
