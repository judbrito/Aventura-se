package Organizado;

import static Webdriver.DriverFactory.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import DSL.Metodos;
import Planilha.Registro;
import Webdriver.DriverFactory;
import Planilha.Registro;

@SuppressWarnings("unused")
public class ApresentacaoPage {
	private Sheet planilha;

	Registro registro = new Registro();

	private Metodos dsl = new Metodos();

	public ApresentacaoPage() {
		new Metodos();
	}

	// teste 01

	public void logar() {

		dsl.path("//*[@id='nav-link-accountList-nav-line-1']");
		dsl.clicar("//*[@id='nav-link-accountList']");
		registro.extrairEmail();

		dsl.clicar("//*[@id='continue']");

		registro.extrairSenha();
		dsl.clicar("//*[@id='signInSubmit']");

		if (getDriver().getTitle().isEmpty()) {

			Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", getDriver().getTitle());
			Assert.assertEquals("Acessar Amazon", getDriver().getTitle());

		}

	}

	// teste 02
	public void deslogar() {

		dsl.jsScriptClick("//*[@id='nav-item-signout']/span");

		Assert.assertTrue("Fazer login",
				dsl.validarTrue("//*[@class='a-box-inner a-padding-extra-large']//h1", "Fazer login"));

	}

	// teste 3
	public void consultaBike() {

		registro.extrairTres();
		dsl.clicarSimples();
		Assert.assertTrue("Bicicleta", dsl.validarTrue("//*[contains(text(),'Bicicleta')]", "Bicicleta"));
	}

	// test 4
	public void consultaAlgo() {
		registro.extrairQuatro();
		dsl.clicarSimples();

		Assert.assertTrue("Nenhum resultado para",
				dsl.validarTrue("//*[contains(text(),'Nenhum resultado para ')]", "Nenhum resultado para"));
	}

	// teste 5
	public void cepTrue() {

		registro.extrairCinco();
		dsl.clicarSimples();

		dsl.clicar("//*[@data-index='2']//*[@class='a-size-base-plus a-color-base a-text-normal']");

		dsl.encadeamento();

		dsl.clicar("//*[@id='contextualIngressPtLabel_deliveryShortLine']");

		dsl.time();
		registro.extrairEncadeamento();

		dsl.clicar("//*[@id='GLUXZipUpdate']/span/input");

		Assert.assertTrue("06010067‌",
				dsl.validarTrue("//*[@id='contextualIngressPtLabel_deliveryShortLine']/span[2]", "06010067‌"));

		WebElement visivel = dsl.path("//*[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']");
		assertNotNull(visivel);
		System.out.println(visivel.getText());
		dsl.apagarInput();
	}

	// teste 6
	public void cepFalse() {

		registro.extrairSeis();
		dsl.clicarSimples();

		dsl.clicar("//*[@data-index='2']//*[@class='a-size-base-plus a-color-base a-text-normal']");

		dsl.encadeamento();
		dsl.clicar("//*[@id='contextualIngressPtLabel_deliveryShortLine']");

		dsl.time();
		registro.extrairEncadeamento();

		dsl.jsScriptClick("//*[@id='GLUXZipUpdate']/span/input");

		WebElement visivel = dsl.path("//*[@id='GLUXZipError']/div/div/div");
		System.out.println(visivel.getText());

		assertFalse("Insira um CEP válido",
				dsl.validarTrue("//*[@id='GLUXZipError']/div/div/div", "Insira um CEP válido"));
		dsl.apagarInput();
	}

	// teste 7
	public void inserePedido() {
		dsl.apagarInput();
		registro.extrairSete();
		dsl.clicarSimples();
		dsl.clicar("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//*[contains(text(),'Console')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.clicar("//*[@id='nav-cart']");
		Assert.assertTrue("Console", dsl.validarTrue("//*[@class='a-truncate-cut']", "Console"));
		dsl.apagarInput();
	}

	// test 8

	public void AddItens() {

		registro.extrairOito();
		dsl.clicarSimples();
		dsl.clicar("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//*[contains(text(),'Console')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.clicar("//*[@id='nav-cart']");

		WebElement custo = dsl.path("//span[@id='sc-subtotal-amount-buybox']/span");

		String umItem = custo.getText();
		System.out.println("Valor unitário " + umItem);
		dsl.time();
		dsl.apagarInput();
		dsl.itensCarrinho();
	}

	// test 9
	public void doisItens() {

		// foga
		registro.extrairNove();
		dsl.clicarSimples();
		dsl.clicar("//*[@class='a-link-normal s-underline-text s-underline-link-text "
				+ "s-link-style a-text-normal' ]//*[contains(text(),'Fogão')" + "or contains(text(),'Preto')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.propaganda();
		dsl.apagarInput();
		// gela

		registro.encadeamento();
		dsl.clicarSimples();
		dsl.clicar("//*[@data-index='2']//*[contains(translate(text(),"
				+ " 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),"
				+ " 'geladeira') or contains(translate(text(),"
				+ " 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')," + " 'refrigerador')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.jsScriptClick("//*[@class='a-button-text']//..//a");
		Assert.assertTrue("2", dsl.validarTrue("//*[@id='nav-cart-count']//.", "2"));
		dsl.itensCarrinho();
	}

	
	// test 10

	public void excluiItens() {

		registro.extrairDez();

		dsl.clicarSimples();
		dsl.clicar("//*[@data-index='1']//*[contains(translate(text(),"
				+ "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),"
				+ "'garrafa') or contains(translate(text(),"
				+ "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')," + "'refrigerador')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.clicar("//*[@id='nav-cart']");

		dsl.jsScriptClick("//*[@value='Excluir']");

		Assert.assertTrue("foi removido de Carrinho de compras.", dsl.validarTrue(
				"//*[text()='foi removido de Carrinho de compras.']", "foi removido de Carrinho de compras."));
		dsl.zerarCarrinho();
	}

	// test 11

	public void excluiUmItem() {

		WebElement element = dsl.path("//*[@id='activeCartViewForm']//select");
		Select Item = new Select(element);
		Item.selectByValue("1");
		if (element.getTagName().equals("select")) {
			dsl.jsScriptClick("//*[@id='sc-active-cart']//*[@class='a-declarative']//.");

		}

		Assert.assertTrue("Subtotal (1 item):",
				dsl.validarTrue("//*[@id='sc-subtotal-label-activecart']", "Subtotal (1 item):"));
	}

	// test 12
	public void voltaLogin() {

		registro.extrairDoze();
		dsl.clicarSimples();
		dsl.clicar("//*[@data-index='2']//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
				+ " 'abcdefghijklmnopqrstuvwxyz'), 'televisão') or contains(translate(text(),"
				+ " 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'monitor')]");
		dsl.propaganda();
		dsl.time();
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.clicar("//*[@id='nav-cart']");
		dsl.clicar("//*[@class='a-button-input']");

		Assert.assertTrue("Fazer login", dsl.validarTrue("//*[@class='a-spacing-small']", "Fazer login"));
	}

	// teste 13
	public void tecnologia() {
		dsl.clicar("//*[@class='hm-icon-label']");
		dsl.jsScriptClick("//*[@class='nav-sprite hmenu-arrow-more']//..//div");
		dsl.time();
		dsl.jsScriptClick("//*[@class='hmenu-item']//*[contains(text(),'Computadores e Informática')]");
		dsl.clicar("//*[@id='hmenu-close-menu']/../..//*[contains(text(),'Notebooks')]");

		dsl.visivel("//*[@class='a-section octopus-pc-asin-title-review-section']" 
		+ "//*[contains(text(),'Note')]");
		
		Assert.assertTrue("Notebook", dsl.validarTrue("//*[@class='a-size-base a-color-base']", "Notebook"));
	}

	// teste 14
	public void tecAlvo() {

		dsl.jsScriptClick("//*[contains(text(),'Marca')]/../..//*[contains(text(),'Lenovo')]");
		assertFalse(dsl.path("//*[contains(text(),'Marca')]/../..//i").isSelected());

	}

	// teste 15

	public void organizar() {

		WebElement element = dsl.path("//*[@id='s-result-sort-select']");
		Select itens = new Select(element);
		itens.selectByVisibleText("Preço: alto a baixo");
		dsl.time();
		WebElement menorPreco = dsl.path("//a[@class='a-size-base a-link-normal "
				+ "s-underline-text s-underline-link-text s-link-style a-text-normal']//*[contains(text(),'88')]");
		WebElement maiorPreco = dsl.path("//a[@class='a-size-base a-link-normal s-underline-text "
				+ "s-underline-link-text s-link-style a-text-normal']//*[contains(text(),'94')]");
		List<WebElement> lista = new ArrayList<WebElement>();
		lista.add(maiorPreco);
		for (int i = 0; i < lista.size(); i++) {
			if (i == 0 || i == 1) {
				lista.get(i).getText();
			}
			Assert.assertTrue(maiorPreco != menorPreco);
			System.out.println("Valor mais alto cobrado: " + maiorPreco.getText());

		}
	}

}
