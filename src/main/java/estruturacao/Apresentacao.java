package estruturacao;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Apresentacao {
	private WebDriver driver;

	@Before
	public void abrir() {

		driver = new ChromeDriver();

		driver.get("https://www.amazon.com.br/?ref_=nav_ya_signin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@After
	public void fechar() {

		// driver.quit();
	}

	@Test
	public void loga() {
	

		driver.findElement(By.id("nav-link-accountList")).click();

		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("amazonclientevip@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("123456789241307Jb@");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		String titulo = driver.getTitle();
		Assert.assertEquals("Acessar Amazon", titulo);
		driver.findElement(By.id("nav-link-accountList"));
		//*[@id="nav-link-accountList"]/span
		driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span")).click();
		//*[@id="nav-link-accountList"]
		//*[@id="nav-item-signout"]/span
		//*[@id="nav-item-signout"]/span
	
	}

}
