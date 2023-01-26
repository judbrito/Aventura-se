package Estruturacao;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Apresentacao {

	private WebDriver driver;
	private String titulo;

	@Before
	public void abrir() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 700);");

		driver.get("https://www.amazon.com.br/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@After
	public void fechar() {

		//driver.quit();
	}

	@Test  @Ignore 
	

	// 1111111111111111
	public void loga() {

		driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")).click();
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("amazonclientevip@yahoo.com");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("123456789241307Jb@");
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();

		titulo = driver.getTitle();
		Assert.assertEquals("Acessar Amazon", titulo);

	}

	@Test  @Ignore 
	

	// 22222222222
	public void desloga() {
		loga();

		WebElement desLog = driver.findElement(By.xpath("//*[@id='nav-item-signout']/span"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", desLog);

		WebElement saiu = driver.findElement(By.xpath("//*[@class='a-box-inner a-padding-extra-large']//h1"));
		Assert.assertTrue("Fazer login", saiu.getText().contains("Fazer login"));

	}

	@Test  @Ignore 
	

	// 33333333333
	public void consultaBike() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("bicicleta aro 29");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

		Assert.assertTrue("Bicicleta",
				driver.findElement(By.xpath("//*[contains(text(),'Bicicleta')]")).getText().contains("Bicicleta"));
	}

	@Test  @Ignore 
	

	// 444444444444
	public void consultaError() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("devdebrito");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

		Assert.assertTrue("Nenhum resultado para",
				driver.findElement(By
						.xpath("//*[contains(text(),'Nenhum resultado para ')]"))
						.getText().contains("Nenhum resultado para"));

	}

	@Test  @Ignore 
	

	// 555555555
	public void comprarCepTrue() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Frigideira");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//*[@data-index=\"1\" ]/..//*[contains(text(),'Lider')]")).click();
		driver.findElement(By.id("contextualIngressPtLabel_deliveryShortLine")).click();

		driver.findElement(By.id("GLUXZipUpdateInput_0")).sendKeys("06010067");

		WebElement cep = driver.findElement(By.id("GLUXZipUpdate-announce"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cep);

		WebElement endereco = driver.findElement(By.className("a-text-bold"));
		System.out.println("Previsão para entrega: " + endereco.getText());

	}

	@Test  @Ignore 
	

	// 6666666666666
	public void comprarCepFalse() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("copo");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//*[@data-index='2']//h2//span")).click();
		driver.findElement(By.id("contextualIngressPtLabel_deliveryShortLine")).click();

		driver.findElement(By.id("GLUXZipUpdateInput_0")).sendKeys("00000000");

		WebElement cep = driver.findElement(By.id("GLUXZipUpdate-announce"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", cep);
		Assert.assertFalse("Insira um CEP válido", driver.findElement(By.xpath("//*[@id='GLUXZipError']/div/div/div"))
				.getText().contains("Insira um CEP válido"));

	}

	@Test  @Ignore
	

	// 77777777777
	public void addCarrinho() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("vassoura");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//*[@data-index='1']//*[contains(text(),'Vassoura')]")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("nav-cart")).click();

		Assert.assertTrue("Vassoura", driver.findElement(By.className("a-truncate-cut")).getText().contains("Vassoura"));

	}

	@Test  @Ignore 
	

	// 8888888888888
	public void addQtdItens() {

		addCarrinho();
		System.out.println("Valor do item unitário "
				+ driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span")).getText());

		WebElement element = driver.findElement(By.xpath("//*[@id='quantity']"));
		Select itens = new Select(element);
		itens.selectByValue("2");

		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");

		WebElement ver = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
		String mostra = ver.getText();

		Assert.assertEquals(mostra,
				driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span")).getText());
		System.out.println("Valores dos itens dobrado " + mostra);

	}

	@SuppressWarnings("unused")
	@Test  @Ignore 

	// 9999999999
	public void addCarrinhoItens() {
		// fogao
		WebElement frame = null;
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("fogão");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@data-index='1' ]//h2//a/span")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
	
		
		
		if(frame != null) {
		 frame = driver.findElement(By.xpath("/html/body/iframe[3]"));
			WebElement toDo = driver.findElement(By.xpath("//*[@id='attachSiNoCoverage-announce']"));
			driver.switchTo().frame(frame);
			toDo.click();
			
		}
		driver.switchTo().defaultContent();
		
			
		// gela
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("geladeira");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@data-index='2']//img")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		
		Assert.assertTrue("2", driver.findElement(By.id("nav-cart-count")).getText().contains("2"));
	}

	

	@Test  @Ignore 
	

	// 10 10 10
	public void excluirAlgumItem() {
		addCarrinho();

		WebElement excluir = driver.findElement(By.xpath("//*[@value='Excluir']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", excluir);
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 700);");
		Assert.assertTrue("foi removido de Carrinho de compras.",
				driver.findElement(By.xpath("//*[text()='foi removido de Carrinho de compras.']")).getText()
						.contains("foi removido de Carrinho de compras."));

	}

	@Test  @Ignore 
	

	// 11 11 11
	public void excluirUmItem() {
		addCarrinhoItens();
		driver.findElement(By.xpath("//*[@id='sw-gtc']//a")).click();

		WebElement excluir = driver.findElement(By.xpath("//*[@value='Excluir']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", excluir);
		Assert.assertTrue("1", driver.findElement(By.id("nav-cart-count")).getText().contains("1"));

	}

	@Test  @Ignore 
	

	// 12 12 12
	public void PesquisaAposLogin() {

		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("televisão");
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//*[@data-index='2']//*[contains(text(),'Televisão')]")).click();

		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("nav-cart")).click();
		driver.findElement(By.className("a-button-input")).click();
		Assert.assertTrue("Fazer login",
				driver.findElement(By.className("a-spacing-small")).getText().contains("Fazer login"));

	}

	@Test  @Ignore 
	

	// 13 13 13
	public void PesquisaTecnologia() {

		driver.findElement(By.className("hm-icon-label")).click();
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 900);");
		WebElement vertudo = driver.findElement(By.xpath("//*[@class='nav-sprite hmenu-arrow-more']//..//div"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", vertudo);

		WebElement pc = driver
				.findElement(By.xpath("//*[@class='hmenu-item']//*[contains(text(),'Computadores e Informática')]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", pc);

	
	
		driver.findElement(By.xpath("//*[@id='hmenu-close-menu']/../..//*//*[contains(text(),'Notebooks')]")).click();

		WebElement exibir = driver.findElement(By.xpath("//*[@class='a-section octopus-pc-asin-info-section']//span[contains(text(),'novo')]"));
		System.out.println(exibir.getText());
	}

	@Test  @Ignore 
	

	// 14 14 14
	public void PesquisaTecAlvo() {

		PesquisaTecnologia();

		WebElement clica = driver.findElement(By.xpath("//*[contains(text(),'Marca')]/../..//i"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clica);

		driver.findElement(By.xpath("//*[contains(text(),'Marca')]/../..//i"));

		Assert.assertFalse(driver.findElement(By.xpath("//*[contains(text(),'Marca')]/../..//i")).isSelected());
	}

	@Test  @Ignore 
	

	// 15 15 15
	public void organizar() {

		driver.get(
				"https://www.amazon.com.br/s?bbn=16364755011&rh=n%3A16364755011%2Cp_89%3ALenovo&dc&qid=1674655776&rnid=18120432011&ref=lp_16364755011_nr_p_89_0");
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		WebElement element = driver.findElement(By.id("s-result-sort-select"));

		Select itens = new Select(element);
		itens.selectByVisibleText("Preço: alto a baixo");
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		WebElement maiorPreco = driver
				.findElement(By.xpath("//*[contains(text(),'WUXGA')]//..//../../..//*[contains(text(),'até')]"));
		System.out.println(maiorPreco.getText());

		WebElement menorPreco = driver
				.findElement(By.xpath("//*[contains(text(),'Mais')]//..//../../..//*[contains(text(),'até')]"));
		System.out.println(menorPreco.getText());

	}

}
