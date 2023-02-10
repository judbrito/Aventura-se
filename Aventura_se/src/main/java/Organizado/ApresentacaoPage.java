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
import Planilha.Registro;
@SuppressWarnings("unused")
public class ApresentacaoPage {
	private Sheet planilha;

	Registro arquivo = new Registro();

	DSL.Metodos dsl = new Metodos();

	// Logar teste 1

	public String logar() throws IOException {

        dsl.path("//*[@id='nav-link-accountList-nav-line-1']");
        dsl.clicar("//*[@id='nav-link-accountList']");
		arquivo.extracaoEmail();
		 dsl.clicar("//*[@id='continue']");
		 Registro.extracaoSenha();
		 dsl.clicar("//*[@id='signInSubmit']");
		
		
		if (getDriver().getTitle().isEmpty()) {
			Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", getDriver().getTitle());
			Assert.assertEquals("Acessar Amazon", getDriver().getTitle());
		}
		return null;

	}

//teste 02
	public String deslogar() {

		dsl.path("//*[@id='nav-link-accountList']");
		dsl.jsScriptClick("//*[@id='nav-item-signout']/span");
		Assert.assertTrue("Fazer login",
				dsl.validarTrue("//*[@class='a-box-inner a-padding-extra-large']//h1", "Fazer login"));
		return null;

	}

	// teste 3
	public void validaBike() {
	
		Assert.assertTrue("Bicicleta", dsl.validarTrue("//*[contains(text(),'Bicicleta')]", "Bicicleta"));

	}

	// test 4
	public void consultaAlgo(String texto) {

		dsl.escrever("//*[@id='twotabsearchtextbox']", texto);
		dsl.clicar("//*[@id='nav-search-submit-button']");

		Assert.assertTrue("Nenhum resultado para",
				dsl.validarTrue("//*[contains(text(),'Nenhum resultado para ')]", "Nenhum resultado para"));
	}

	// teste 5
	public void cepTrue(String texto, String cep) {

		dsl.escrever("//*[@id='twotabsearchtextbox']", texto);
		dsl.clicar("//*[@id='nav-search-submit-button']");
		dsl.clicar("//*[@data-index=\"2\"]//*[@class='a-size-base-plus a-color-base a-text-normal']");
		dsl.clicar("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
		dsl.escrever("//*[@id='GLUXZipUpdateInput_0']", cep);
		dsl.jsScriptClick("//*[@id='GLUXZipUpdate']/span/input");

		WebElement visivel = dsl.path("//*[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']");
		assertNotNull(visivel);
		System.out.println(visivel.getText());

	}

	// teste 6
	public void cepFalse(String texto, String cep) {

		dsl.escrever("//*[@id='twotabsearchtextbox']", texto);
		dsl.clicar("//*[@id='nav-search-submit-button']");
		dsl.clicar("//*[@data-index='2']//h2//span");
		dsl.clicar("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
		dsl.escrever("//*[@id='GLUXZipUpdateInput_0']", cep);
		dsl.jsScriptClick("//*[@id='GLUXZipUpdate-announce']");

		WebElement visivel = dsl.path("//*[@id='GLUXZipError']/div/div/div");
		System.out.println(visivel.getText());
		assertFalse("Insira um CEP válido",
				dsl.validarTrue("//*[@id='GLUXZipError']/div/div/div", "Insira um CEP válido"));

	}

	// teste 7
	public void inserePedido() {
		dsl.escrever("//*[@id='twotabsearchtextbox']", "console games lançamentos");
		dsl.clicar("//*[@id='nav-search-submit-button']");
		dsl.clicar("//*[@data-index='1']//*[contains(text(),'Console')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.clicar("//*[@id='nav-cart']");

		Assert.assertTrue("Console", dsl.validarTrue("//*[@class='a-truncate-cut']", "Console"));

	}

	// test 8

	public void AddItens() {

		WebElement custo = dsl.path("//span[@id='sc-subtotal-amount-buybox']/span");

		String umItem = custo.getText();
		System.out.println("Valor unitário " + umItem);

		WebElement element = dsl.path("//*[@id='quantity']");
		Select itens = new Select(element);
		itens.selectByValue("2");
		dsl.time();

	}

	// test 9
	public void doisItens() {

		// foga
		dsl.escrever("//*[@id='twotabsearchtextbox']", "fogão");
		dsl.clicar("//*[@id='nav-search-submit-button']");
		dsl.clicar(
				"//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal' ]//*[contains(text(),'Fogão')or contains(text(),'Preto')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.propaganda();

		// gela
		dsl.escrever("//*[@id='twotabsearchtextbox']", "geladeira");
		dsl.clicar("//*[@id='nav-search-submit-button']");
		dsl.clicar("//*[@data-index='2']//*[contains(text(),'Geladeira') or contains(text(),'Refrigerador')]");
		dsl.clicar("//*[@id='add-to-cart-button']");
		dsl.jsScriptClick("//*[@class='a-button-text']//..//a");

	}

	public void validaNove() {
		Assert.assertTrue("2", dsl.validarTrue("//*[@id='nav-cart-count']//.", "2"));

	}

	// test 10

	public void excluiItens() {

		dsl.jsScriptClick("//*[@value='Excluir']");

		Assert.assertTrue("foi removido de Carrinho de compras.", dsl.validarTrue(
				"//*[text()='foi removido de Carrinho de compras.']", "foi removido de Carrinho de compras."));

	}

	// test 11

	public void excluiUmItem() {

		WebElement element = dsl.path("//*[@id='activeCartViewForm']//select");
		Select Item = new Select(element);
		Item.selectByValue("1");
		if (element.getTagName().equals("select")) {
			dsl.jsScriptClick("//*[@id='sc-active-cart']//*[@class='a-declarative']//.");

		}

		Assert.assertTrue("1", dsl.validarTrue("//*[@id='activeCartViewForm']//select", "1"));
	}

	// test 12
	public void voltaLogin() {

		dsl.escrever("//*[@id='twotabsearchtextbox']", "televisão");
		dsl.clicar("//*[@id='nav-search-submit-button']");
		dsl.clicar(
				"//*[@data-index='2']//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'televisão') or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'monitor')]");
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
		dsl.clicar("//*[@id='hmenu-close-menu']/../..//*//*[contains(text(),'Notebooks')]");

		dsl.visivel("//*[@class='a-section octopus-pc-asin-title-review-section']//*[contains(text(),'Note')]");

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
		WebElement menorPreco = dsl.path("//*[contains(text(),'Mais')]//..//../../..//*[contains(text(),'até')]");
		WebElement maiorPreco = dsl.path("//*[contains(text(),'WUXGA')]//..//../../..//*[contains(text(),'até')]");
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
