package DSL;

import static Webdriver.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import Planilha.Registro;

@SuppressWarnings("unused")
public class Metodos {

	private static Sheet planilha;
	private Row linhas;
	private Sheet sheet;

	public WebElement clicar(String by) {
		WebElement clicou = getDriver().findElement(By.xpath(by));
		clicou.click();
		return clicou;
	}

	public WebElement clicarSimples() {
		WebElement clicou = getDriver().findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		clicou.click();
		return clicou;
	}

	public void setLinhas(Row linha10) {
		this.linhas = linha10;
	}

	public void lerLogoff(String by, int row) {
		WebElement email = getDriver().findElement(By.xpath(by));
		email.sendKeys(linhas.getCell(row).getStringCellValue());
		return;
	}

	public void lerParametro(int row) {
		WebElement email = getDriver().findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		email.sendKeys(linhas.getCell(row).getStringCellValue());
		return;
	}

	public void lerParametroEncadeado(int row) {
		WebElement testeCinco = getDriver().findElement(By.xpath("//*[@id='GLUXZipUpdateInput_0']"));
		testeCinco.sendKeys(String.valueOf(linhas.getCell(row).getStringCellValue()));
		time();
		return;
	}

	public void encadeamento() {
		apagarImput();

	}

	public void apagarImput() {
		WebElement clicou = getDriver().findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		clicou.clear();
		WebElement clicado = getDriver().findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		clicado.sendKeys(Keys.TAB);

	}

	public String escrever(String by, String texto) {
		String xpath = "//*[@id='nav-link-accountList-nav-line-1']";
		WebElement element = getDriver().findElement(By.xpath(by));
		getDriver().findElement(By.xpath(by)).sendKeys(texto);
		return xpath;

	}

	public Object jsScriptClick(String by) {
		return ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()",
				getDriver().findElement(By.xpath(by)));

	}

	public void zerarCarrinho() {
		getDriver().get("https://www.amazon.com.br/gp/cart/view.html?ref_=sw_gtc");
		for (int i = 0; i < 2; i++) {
			jsScriptClick("//*[@value='Excluir']");
		}
	}

	public void time() {
		((JavascriptExecutor) getDriver())
				.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 700);");
	}

	public boolean validarTrue(String by, String texto) {
		return getDriver().findElement(By.xpath(by)).getText().contains(texto);

	}

	public WebElement path(String by) {
		return getDriver().findElement(By.xpath(by));
	}

	@SuppressWarnings("unchecked")
	public List<WebElement> ListElemento(String by) {
		return (List<WebElement>) getDriver().findElement(By.xpath(by));
	}

	public void visivel(String by) {
		assertTrue(getDriver().findElement(By.xpath(by)).isDisplayed());

	}

	public void propaganda() {
		List<WebElement> element = getDriver().findElements(By.xpath("//*[@id='attachSiNoCoverage-announce']"));
		if (!element.isEmpty()) {
			try {
				element.get(0).click();
			} catch (ElementClickInterceptedException e) {
				Actions action = new Actions(getDriver());
				action.moveToElement(element.get(0)).click().build().perform();
			}
		}
	}

	public void inesperado() throws Exception {
		try {
			getDriver().get("https://www.amazon.com.br");
		} catch (Exception e) {

			if (e instanceof UnexpectedTagNameException) {

				getDriver().close();
			} else {

				throw e;
			}
		}

	}
}
