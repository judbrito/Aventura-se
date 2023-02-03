package Estrutura;



import static Organizado.DriverFactory.getDriver;
import static Organizado.DriverFactory.killDriver;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Organizado.ApresentacaoPage;
import Organizado.Metodos;


public class Apresentacao {
	
	private Metodos dsl;
	private ApresentacaoPage page;
	


	@Before
	public void abrir() throws Exception {

		getDriver().get("https://www.amazon.com.br");
		getDriver().manage().window().maximize();
		dsl = new Metodos();
		dsl.inesperado();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		page = new ApresentacaoPage();
	}

	@After
	public void fechar() {
		killDriver();
	}

	@Test
	// 1111111111111111
	public void loga() {
		page.setAcesso("amazonclientevip@yahoo.com", "123456789241307Jb@");
		page.validaUm();

	}

	@Test
	// 22222222222
	public void desloga() {
	
		page.desloga();

	}

	@Test
	// 33333333333
	public void consultaBike() {
		page.consultaAlgo("bicicleta aro 29");
		page.validaTres();
	}

	@Test
	// 444444444444
	public void consultaError() {
		page.consultaAlgo("devdebrito");
		page.validaQuatro();
	}

	@Test
	// 555555555
	public void cepTrue() {
		page.cepTrue("Frigideira", "06010067");
		page.validaCinco();
	}

	@Test
	// 6666666666666
	public void cepFalse() {
		page.cepFalse("copo", "00000000");
		page.validaSeis();
	}

	@Test
	// 77777777777
	public void addCarrinho() {
		page.inserePedido();
		page.validaSete();
	}

	@Test
	// 8888888888888
	public void addQtdItens() {
		addCarrinho();
		page.AddItens();
		page.validaOito();

	}

	@Test
	// 9999999999
	public void addCarrinhoItens() {
		page.doisItens();
		page.validaNove();
	}

	@Test
	// 10 10 10
	public void excluirAlgumItem() {
		addCarrinho();
		page.excluiItens();
		page.validaDez();
	}

	@Test
	// 11 11 11
	public void excluirUmItem() {
		addCarrinhoItens();
		page.excluiUmItem();
		page.validadoOnze();

	}

	@Test
	// 12 12 12
	public void pesquisaAposLogin() {
		page.vaiLogar();
		page.validadoDoze();
	}

	@Test
	// 13 13 13
	public void pesquisaTecnologia() {
		page.tecnologia();
		page.validaTreze();
	}

	@Test
	// 14 14 14
	public void pesquisaTecAlvo() {
		pesquisaTecnologia();
		page.validaQuatorze();

	}

	@Test
	// 15 15 15
	public void organizarcao() {
		pesquisaTecAlvo();
		page.organizar();
		page.validaQuinze();

	}
}
