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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

@SuppressWarnings("unused")
public class Metodos {

	private static Metodos dsl;
	private Sheet sheet;


	public WebElement clicar(String by) {
		WebElement clicou = path(by);
		clicou.click();
		return clicou;
	}



	public void lerPaginasXls(String by, String xpath, int row, int cell) {
		WebElement bike = dsl.path(by);
		bike.sendKeys(sheet.getRow(row).getCell(cell).getStringCellValue());
		dsl.clicar(xpath);

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
