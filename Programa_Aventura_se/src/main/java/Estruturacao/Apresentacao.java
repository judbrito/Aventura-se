package Estruturacao;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Apresentacao {

	private WebDriver driver;
	private Metodos dsl;

	@Before
	public void abrir() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com.br/");
		dsl = new Metodos(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@After
	public void fechar() {

		driver.quit();
	}

	@Test

	// 1111111111111111
	public void loga() {
		dsl.clica("//*[@id='nav-link-accountList-nav-line-1']");
		dsl.escreva("//*[@id='ap_email']", "amazonclientevip@yahoo.com");
		dsl.clica("//*[@id='continue']");
		dsl.escreva("//*[@id='ap_password']", "123456789241307Jb@");
		dsl.clica("//*[@id='signInSubmit']");

		Assert.assertEquals("Acessar Amazon", driver.getTitle());

	}

	@Test

	// 22222222222
	public void desloga() {
		loga();

		dsl.jsScriptClick("//*[@id='nav-item-signout']/span");

		Assert.assertTrue("Fazer login",
				dsl.validaTrue("//*[@class='a-box-inner a-padding-extra-large']//h1", "Fazer login"));

	}

	@Test

	// 33333333333
	public void consultaBike() {
		dsl.escreva("//*[@id='twotabsearchtextbox']", "bicicleta aro 29");
		dsl.clica("//*[@id='nav-search-submit-button']");

		Assert.assertTrue("Bicicleta", dsl.validaTrue("//*[contains(text(),'Bicicleta')]", "Bicicleta"));

	}

	@Test

	// 444444444444
	public void consultaError() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("devdebrito");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

		Assert.assertTrue("Nenhum resultado para",
				dsl.validaTrue("//*[contains(text(),'Nenhum resultado para ')]", "Nenhum resultado para"));

	}

	@Test

	// 555555555
	public void comprarCepTrue() {
		dsl.escreva("//*[@id='twotabsearchtextbox']", "Frigideira");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index=\"2\"]//*[@class='a-size-base-plus a-color-base a-text-normal']");
		dsl.clica("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
		dsl.escreva("//*[@id='GLUXZipUpdateInput_0']", "06010067");
		dsl.jsScriptClick("//*[@id='GLUXZipUpdate']/span/input");

		assertTrue(driver.findElement(By.xpath("//*[@class='a-text-bold']")).isDisplayed());

	}

	@Test

	// 6666666666666
	public void comprarCepFalse() {
		dsl.escreva("//*[@id='twotabsearchtextbox']", "copo");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='2']//h2//span");
		dsl.clica("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
		dsl.escreva("//*[@id='GLUXZipUpdateInput_0']", "00000000");
		dsl.jsScriptClick("//*[@id='GLUXZipUpdate-announce']");

		Assert.assertFalse("Insira um CEP válido",
				dsl.validaTrue("//*[@id='GLUXZipError']/div/div/div", "Insira um CEP válido"));

	}

	@Test

	// 77777777777
	public void addCarrinho() {

		dsl.escreva("//*[@id='twotabsearchtextbox']", "console");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='2']//*[contains(text(),'Console')]");
		dsl.clica("//*[@id='add-to-cart-button']");
		dsl.clica("//*[@id='nav-cart']");

		Assert.assertTrue("Console", dsl.validaTrue("//*[@class='a-truncate-cut']", "Console"));

	}

	@Test

	// 8888888888888
	public void addQtdItens() {

		addCarrinho();
		WebElement custo = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
		String umItem = custo.getText();
		System.out.println("Valor unitário " + umItem);

		WebElement element = driver.findElement(By.xpath("//*[@id='quantity']"));
		Select itens = new Select(element);
		itens.selectByValue("2");

		dsl.time();

		WebElement ver = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
		String doisItens = ver.getText();

		Assert.assertTrue(umItem != doisItens);
		System.out.println("Valor dobrado " + doisItens);

//		
	}

	@SuppressWarnings("unused")
	@Test

	// 9999999999
	public void addCarrinhoItens() {
		// foga
		dsl.escreva("//*[@id='twotabsearchtextbox']", "fogão");

		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='1' ]//h2//a/span");
		dsl.clica("//*[@id='add-to-cart-button']");

		List<WebElement> casoHaja = driver.findElements(By.xpath("//*[@id='attachSiNoCoverage-announce']"));
		if (!casoHaja.isEmpty()) {
			WebElement element = casoHaja.get(0);

			dsl.jsScriptClick("//*[@id='attachSiNoCoverage-announce']");

		}

		dsl.time();

		// gela
		dsl.escreva("//*[@id='twotabsearchtextbox']", "geladeira");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='2']//img");
		dsl.clica("//*[@id='add-to-cart-button']");
		dsl.jsScriptClick("//*[@id='attachSiNoCoverage-announce']");

		dsl.time();

		Assert.assertTrue("2", dsl.validaTrue("//*[@id='nav-cart-count']//.", "2"));

	}

	@Test

	// 10 10 10
	public void excluirAlgumItem() {
		addCarrinho();
		dsl.jsScriptClick("//*[@value='Excluir']");
		Assert.assertTrue("foi removido de Carrinho de compras.", dsl.validaTrue(
				"//*[text()='foi removido de Carrinho de compras.']", "foi removido de Carrinho de compras."));

	}

	@Test

	// 11 11 11
	public void excluirUmItem() {
		addCarrinhoItens();
		dsl.clica("//*[@id='sw-gtc']//a");
		dsl.jsScriptClick("//*[@id='sc-active-cart']//*[@class='a-declarative']//.");

		// Assert.assertTrue("1", dsl.validaTrue("//*[@id='nav-cart-count']", "1"));

	}

	@Test

	// 12 12 12
	public void PesquisaAposLogin() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("televisão");
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//*[@data-index='2']//*[contains(text(),'Televisão')]")).click();

		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("nav-cart")).click();
		driver.findElement(By.className("a-button-input")).click();
		Assert.assertTrue("Fazer login", dsl.validaTrue("//*[@class='a-spacing-small']", "Fazer login"));

	}

	@Test

	// 13 13 13
	public void PesquisaTecnologia() {

		driver.findElement(By.className("hm-icon-label")).click();
		dsl.jsScriptClick("//*[@class='nav-sprite hmenu-arrow-more']//..//div");
		dsl.time();
		dsl.jsScriptClick("//*[@class='hmenu-item']//*[contains(text(),'Computadores e Informática')]");

		dsl.clica("//*[@id='hmenu-close-menu']/../..//*//*[contains(text(),'Notebooks')]");

		assertTrue(driver
				.findElement(By.xpath(
						"//*[@class='a-section octopus-pc-asin-title-review-section']//*[contains(text(),'Note')]"))
				.isDisplayed());

	}

	@Test

	// 14 14 14
	public void PesquisaTecAlvo() {

		PesquisaTecnologia();
		dsl.jsScriptClick("//*[contains(text(),'Marca')]/../..//i");

		driver.findElement(By.xpath("//*[contains(text(),'Marca')]/../..//i"));

		Assert.assertFalse(driver.findElement(By.xpath("//*[contains(text(),'Marca')]/../..//i")).isSelected());
	}

	@SuppressWarnings("unused")
	@Test

	// 15 15 15
	public void organizar() {

		driver.get(
				"https://www.amazon.com.br/s?bbn=16364755011&rh=n%3A16364755011%2Cp_89%3ALenovo&dc&qid=1674655776&rnid=18120432011&ref=lp_16364755011_nr_p_89_0");
		dsl.time();

		WebElement element = driver.findElement(By.id("s-result-sort-select"));

		Select itens = new Select(element);
		itens.selectByVisibleText("Preço: alto a baixo");
		WebElement menorPreco = driver
				.findElement(By.xpath("//*[contains(text(),'Mais')]//..//../../..//*[contains(text(),'até')]"));
		// System.out.println(menorPreco.getText());

		WebElement maiorPreco = driver
				.findElement(By.xpath("//*[contains(text(),'WUXGA')]//..//../../..//*[contains(text(),'até')]"));
		List<WebElement> lista = new ArrayList<WebElement>();
		lista.add(maiorPreco);

		for (int i = 0; i < lista.size(); i++) {

			if (i == 0 || i == 1) {

				System.out.println(lista.get(i).getText());

			}
		}
	}

}
