package Estruturacao;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Apresentacao {

	private WebDriver driver;
	private Metodos dsl;
	private ApresentacaoPage page;

	@Before
	public void abrir() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com.br");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dsl = new Metodos(driver);
		page = new ApresentacaoPage(driver);
	}

	@After
	public void fechar() {
		driver.quit();
	}

	@Test
	// 1111111111111111
	public void loga() {
		page.setAcesso("amazonclientevip@yahoo.com", "123456789241307Jb@");
		if (driver.getTitle().isEmpty()) {
			Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", driver.getTitle());
			Assert.assertEquals("Acessar Amazon", driver.getTitle());
		}
		System.out.println(driver.getTitle());
	}

	@Test
	// 22222222222
	public void desloga() {
		page.desloga();
		Assert.assertTrue("Fazer login",
				dsl.validaTrue("//*[@class='a-box-inner a-padding-extra-large']//h1", "Fazer login"));
	}

	@Test
	// 33333333333
	public void consultaBike() {
		page.consultaAlgo("bicicleta aro 29");
		Assert.assertTrue("Bicicleta", dsl.validaTrue("//*[contains(text(),'Bicicleta')]", "Bicicleta"));
	}

	@Test
	// 444444444444
	public void consultaError() {
		page.consultaAlgo("devdebrito");
		Assert.assertTrue("Nenhum resultado para",
				dsl.validaTrue("//*[contains(text(),'Nenhum resultado para ')]", "Nenhum resultado para"));
	}

	@Test
	// 555555555
	public void cepTrue() {
		page.cepTrue("Frigideira", "06010067");
		page.validaTrue();
	}

	@Test
	// 6666666666666
	public void cepFalse() {
		page.cepFalse("copo", "00000000");
		page.validaFalse();
	}

	@Test
	// 77777777777
	public void addCarrinho() {
		page.inserePedido();
		page.validacaoSete();
	}

	@Test
	// 8888888888888
	public void addQtdItens() {
		addCarrinho();
		page.AddItens();
		page.validacaoOito();

	}

	@Test
	// 9999999999
	public void addCarrinhoItens() {
		page.doisItens();
		page.validacaoNove();
	}

	@Test
	// 10 10 10
	public void excluirAlgumItem() {
		addCarrinho();
		page.excluiItens();
		page.validacaoDez();
	}

	@Test
	// 11 11 11
	public void excluirUmItem() {
		addCarrinhoItens();
		page.excluiUmItem();
		page.validacaodoOnze();

	}

	@Test
	// 12 12 12
	public void pesquisaAposLogin() {
		page.vaiLogar();
		page.validacaodoDoze();
	}

	@Test
	// 13 13 13
	public void pesquisaTecnologia() {
		page.tecnologia();
		page.validacaoTreze();
	}

	@Test
	// 14 14 14
	public void pesquisaTecAlvo() {
		pesquisaTecnologia();

		page.validacaoQuatorze();

	}

	@Test
	// 15 15 15
	public void organizarcao() {
		pesquisaTecAlvo();
		page.organizar();
		page.validacaoQuinze();

	}
}
