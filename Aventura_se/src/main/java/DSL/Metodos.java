package DSL;


import static Webdriver.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class Metodos {

	public void clica(String by) {
		getDriver().findElement(By.xpath(by)).click();
	}

	public void escreva(String by, String texto) {
		getDriver().findElement(By.xpath(by)).sendKeys(texto);
	}

	public Object jsScriptClick(String by) {
		return ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()",
				getDriver().findElement(By.xpath(by)));

	}

	public void zeraCarrinho() {
		getDriver().get("https://www.amazon.com.br/gp/cart/view.html?ref_=sw_gtc");
		for (int i = 0; i < 2; i++) {
			jsScriptClick("//*[@value='Excluir']");
		}
	}

	public void time() {
		((JavascriptExecutor) getDriver())
				.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 700);");

	}

	public boolean validaTrue(String by, String texto) {
		return getDriver().findElement(By.xpath(by)).getText().contains(texto);

	}

	public WebElement elemento(String by) {
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
