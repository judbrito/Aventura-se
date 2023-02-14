package Telas;

import static Webdriver.DriverFactory.getDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotsTest {

	@SuppressWarnings("unused")
	private static String nomeTeste;

	@SuppressWarnings("unused")
	public static void capturaTelas() {
		try {

			SimpleDateFormat formatter = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
			Date date = new Date();

			String nomeArquivo = formatter.format(date);
			String diretorio = ".//src//main//resources//imagens//";

			TakesScreenshot screenshot = (TakesScreenshot) getDriver();

			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destino = new File(diretorio + nomeArquivo + ".png");
			FileUtils.copyFile(source, destino);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}