package br.com.caelum.agiletickets.acceptance;

import br.com.caelum.agiletickets.PreencheBanco;
import br.com.caelum.agiletickets.acceptance.page.IndexPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	private static String BASE_URL = "http://localhost:8080";
	private static WebDriver driver;
	IndexPage indexPage;

	@BeforeClass
	public static void abreBrowser() {
		PreencheBanco.main();
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();
		driver.get(BASE_URL);
	}

	@Before
	public void setUp() {
		indexPage = new IndexPage(driver);
	}

	@AfterClass
	public static void teardown() {
		driver.close();
	}

}
