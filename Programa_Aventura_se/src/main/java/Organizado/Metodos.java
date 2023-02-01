package Organizado;

import static org.junit.Assert.assertFalse;
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
		DriverFactory.getDriver().findElement(By.xpath(by)).click();
	}

	public void escreva(String by, String texto) {
		DriverFactory.getDriver().findElement(By.xpath(by)).sendKeys(texto);
	}

	public Object jsScriptClick(String by) {
		return ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click()", DriverFactory.getDriver().findElement(By.xpath(by)));

	}

	public void time() {
		((JavascriptExecutor) DriverFactory.getDriver()).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 700);");

	}

	public boolean validaTrue(String by, String texto) {
		return DriverFactory.getDriver().findElement(By.xpath(by)).getText().contains(texto);

	}

	public WebElement elemento(String by) {
		return DriverFactory.getDriver().findElement(By.xpath(by));
	}

	@SuppressWarnings({ "unchecked" })
	public List<WebElement> ListElemento(String by) {
		return (List<WebElement>) DriverFactory.getDriver().findElement(By.xpath(by));
	}

	public void visivel(String by) {
		assertTrue(DriverFactory.getDriver().findElement(By.xpath(by)).isDisplayed());

	}

	public void invalido(String by) {
		assertFalse(DriverFactory.getDriver().findElement(By.xpath(by)).isSelected());
	}

	public void propaganda() {
		List<WebElement> element = DriverFactory.getDriver().findElements(By.xpath("//*[@id='attachSiNoCoverage-announce']"));
		if (!element.isEmpty()) {
			try {
				element.get(0).click();
			} catch (ElementClickInterceptedException e) {
				Actions action = new Actions(DriverFactory.getDriver());
				action.moveToElement(element.get(0)).click().build().perform();
			}
		}
	}

	public void inesperado() throws Exception {
		try {
			DriverFactory.getDriver().get("https://www.amazon.com.br");
		} catch (Exception e) {
		
			if (e instanceof UnexpectedTagNameException) {
			
				DriverFactory.getDriver().close();
			} else {
				
				throw e;
			}
		}

	}
}