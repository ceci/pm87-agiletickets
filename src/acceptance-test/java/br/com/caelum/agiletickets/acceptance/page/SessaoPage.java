package br.com.caelum.agiletickets.acceptance.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessaoPage {
    private WebDriver driver;

    public SessaoPage(WebDriver driver) {

        this.driver = driver;
    }

    public IndexPage ReservaIngressos(Integer quantidade){
        driver.findElement(By.id("qtde")).sendKeys(quantidade.toString());
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        return new IndexPage(driver);
    }

    public IndexPage reservaIngressosDeEstudante(Integer quantidade) {
        driver.findElement(By.id("qtde")).sendKeys(quantidade.toString());
        driver.findElement(By.id("desconto")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        return new IndexPage(driver);
    }
}
