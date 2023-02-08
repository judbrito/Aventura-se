package Estrutura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dados {

	@SuppressWarnings("deprecation")
	@Test
	public void main() throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File(
				"C:\\Users\\JudrianideBrito\\Desktop\\PROJETO BRITO\\programa_aventura_se\\Aventura_se\\src\\main\\resources\\evidencia.xlsx");
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		// creating a Sheet object
		XSSFSheet sheet = wb.getSheet("massaDados");

		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Creating an object of ChromeDriver
		WebDriver driver = new ChromeDriver();
		// Create a row object to retrieve row at index 3
		XSSFRow titulo = sheet.createRow(0);

	
		titulo.createCell(0).setCellValue("Identificação");
		titulo.createCell(1).setCellValue("Entrada");
		titulo.createCell(2).setCellValue("Senha");
		titulo.createCell(3).setCellValue("Situação");	
		titulo.createCell(14).setCellValue("Situação");	
	
		driver.get("https://www.amazon.com.br");
		
	
		WebElement entrada = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
		entrada.click();
		WebElement email = driver.findElement(By.xpath("//*[@id='ap_email']"));
		WebElement processa = driver.findElement(By.xpath("//*[@id='continue']"));
		processa.click();	
		WebElement senha = driver.findElement(By.xpath("//*[@id='ap_password']"));
		

	
	
		WebElement submitBtn = driver.findElement(By.xpath("//*[@id='signInSubmit']"));

		// iterate over all the rows in Excel and put data in the form.
		for (int i = 1; i <= rowCount; i++) {
			// Enter the values read from Excel in firstname,lastname,mobile,email,address
			email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			senha.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		

			// Click on the gender radio button using javascript
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", submitBtn);

			WebElement confirmationMessage = driver
					.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));

			// create a new cell in the row at index 6
			XSSFCell cell = sheet.getRow(i).createCell(3);

			// check if confirmation message is displayed
			if (confirmationMessage.isDisplayed()) {
				// if the message is displayed , write PASS in the excel sheet
				cell.setCellValue("PASS");

			} else {
				// if the message is not displayed , write FAIL in the excel sheet
				cell.setCellValue("FAIL");
			}

			// Write the data back in the Excel file
			FileOutputStream outputStream = new FileOutputStream(
					"C:\\Users\\JudrianideBrito\\Desktop\\PROJETO BRITO\\programa_aventura_se\\Aventura_se\\src\\main\\resources\\evidencia.xlsx");
			wb.write(outputStream);

			// close the confirmation popup
			WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
			js.executeScript("arguments[0].click();", closebtn);

			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		}

		// Close the workbook
		wb.close();

		// Quit the driver
		driver.quit();
	}
}