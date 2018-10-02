package br.com.caelum.agiletickets.acceptance;

import br.com.caelum.agiletickets.acceptance.page.IndexPage;
import br.com.caelum.agiletickets.acceptance.page.SessaoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

public class SessaoTest extends BaseTest {
    private SessaoPage sessaoPage;

    @Before
    public void setUp() {
        sessaoPage = indexPage.navegaParaSessaoEspecifica(7);
    }

    @Test
    public void deveMostrarValorCorretoQuandoReservarIngressos(){
        IndexPage indexPage = sessaoPage.ReservaIngressos(3);

        String mensagem = indexPage.pegaMensagem();
        Assert.assertEquals(mensagem,is("Sessão reservada com sucesso por R$ 150,00"));
    }

    @Test
    public void deveMostrarPrecoDeMeiaQuandoForEstudante(){
        IndexPage indexPage = sessaoPage.ReservaIngressos(1);
        String mensagemPrecoCheio = indexPage.pegaMensagem();
        Assert.assertEquals(mensagemPrecoCheio, is("Sessão reservada com sucesso por R$ 50,00"));

        sessaoPage = indexPage.navegaParaSessaoEspecifica(7);
        indexPage = sessaoPage.reservaIngressosDeEstudante(2);
        String mensagemPagandoMeia = indexPage.pegaMensagem();
        Assert.assertEquals(mensagemPagandoMeia, is("Sessão reservada com sucesso por R$ 50,00"));
    }
}
