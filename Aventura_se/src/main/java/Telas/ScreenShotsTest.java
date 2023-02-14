package Imagens;

import static Webdriver.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotsTest {
	
	public static TestName testeNames = new TestName();



	public static void capturaTelas() throws IOException {
		TakesScreenshot imagens = (TakesScreenshot) getDriver();
		File arquivo = imagens.getScreenshotAs(OutputType.FILE);
		File destino = new File(testeNames.getMethodName() + "_"
				+ new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date()) + ".png");
		FileUtils.copyFile(arquivo, destino);
	}
}
