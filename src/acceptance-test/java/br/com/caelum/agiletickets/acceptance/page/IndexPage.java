package br.com.caelum.agiletickets.acceptance.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public EstabelecimentosPage navegaParaEstabelecimentos() {
        driver.findElement(By.linkText("Estabelecimentos")).click();
        return new EstabelecimentosPage(driver);
    }

    public SessaoPage navegaParaSessaoEspecifica(int id) {
        driver.findElement(By.cssSelector(String.format("a[href='agiletickets/sessao/%s']",id))).click();
        return new SessaoPage(driver);
    }

    public String pegaMensagem() {
        return driver.findElement(By.id("message")).getText();
    }
}
