package Planilha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

import DSL.Metodos;

public class Registro {

	private static Sheet planilha = initPlanilha();
	private static Metodos dsl = new Metodos();

	private static Sheet initPlanilha() {
		try {
			String file = System.getProperty("user.dir") + "./src/main/resources/evidencia1.xlsx";
			FileInputStream fis = new FileInputStream(new File(file));
			Workbook arquivo = WorkbookFactory.create(fis);
			return arquivo.getSheetAt(0);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void extracaoEmail() throws IOException {
		try {
			Row linhas = planilha.getRow(1);

			WebElement email = dsl.path("//*[@id='ap_email']");
			email.sendKeys(linhas.getCell(1).getStringCellValue());
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
	}

	public static void extracaoSenha() {
		try {
			if (planilha == null) {
				throw new Exception("A planilha não foi inicializada.");
			}
			Row linhas = planilha.getRow(1);
			WebElement senha = dsl.path("//*[@id='ap_password']");
			senha.sendKeys(linhas.getCell(2).getStringCellValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
