package Estruturacao;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Metodos {
	private WebDriver driver;

	public Metodos(WebDriver driver) {

		this.driver = driver;
	}

	public void clica(String by) {
		driver.findElement(By.xpath(by)).click();
	}

	public void escreva(String by, String texto) {
		driver.findElement(By.xpath(by)).sendKeys(texto);
	}

	public Object jsScriptClick(String by) {
	return	((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(by)));

	}
	

	public void  time() {
		 ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 900);");

	}

	public boolean validaTrue(String by,String texto) {
		return driver.findElement(By.xpath(by)).getText().contains(texto);
 
	}

	
}
