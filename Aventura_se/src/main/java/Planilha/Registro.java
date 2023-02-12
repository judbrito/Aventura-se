package Planilha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import DSL.Metodos;

public class Registro {

	private Sheet planilha;
	Metodos testandoEstancia = new Metodos();
	private Metodos dsl;

	public Registro() {
		new Metodos();
		this.inicializarPlanilha();

	}

	public void inicializarPlanilha() {
		try {
			String file = System.getProperty("user.dir") + "./src/main/resources/evidencia1.xlsx";
			FileInputStream fis = new FileInputStream(new File(file));
			Workbook arquivo = WorkbookFactory.create(fis);
			this.planilha = arquivo.getSheetAt(0);

		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public void extracaoEmail() {
		Row linhas = planilha.getRow(1);
		linhas.getCell(1);
		try {
			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerLogoff("//*[@id='ap_email']", 1);

		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
	}

	public void extracaoSenha() {

		Row linhas = planilha.getRow(1);
		linhas.getCell(1);

		try {
			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerLogoff("//*[@id='ap_password']", 2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extracaoTres() {
		try {
			Row linhas = planilha.getRow(3);
			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void estracaoQuatro() {
		try {
			Row linhas = planilha.getRow(4);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void estracaoCinco() {
		try {
			Row linhas = planilha.getRow(5);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void estracaoEncadeamento() {	
			
			testandoEstancia.lerParametroEncadeado(2);

	}
}

//			testandoEstancia.lerDoisParametros(null, 1, 2)//5
//		
//			testandoEstancia.lerDoisParametros(null, 0, 0)//6
//			testandoEstancia.lerExcel7("//*[@id='twotabsearchtextbox']", 7);
//			testandoEstancia.lerDoisParametros(null, 0, 0)//9
//			testandoEstancia.lerExcel10("//*[@id='twotabsearchtextbox']", 10);
//			testandoEstancia.lerDoisParametros(null, 0, 0)//11
//			testandoEstancia.lerExcel2("//*[@id='twotabsearchtextbox']", 12);
