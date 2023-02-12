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
	public static Metodos dsl;

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

	public void extracaoQuatro() {
		try {
			Row linhas = planilha.getRow(4);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extracaoCinco() {
		try {
			Row linhas = planilha.getRow(5);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void extracaoEncadeamento() {

		testandoEstancia.lerParametroEncadeado(2);

	}

	public void extracaoSeis() {
		try {
			Row linhas = planilha.getRow(6);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extracaoEncadeamentoSeis() {

		testandoEstancia.lerParametroEncadeado(2);

	}

	public void extracaoSete() {
		try {
			Row linhas = planilha.getRow(7);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extracaoOito() {
		try {
			Row linhas = planilha.getRow(8);

			testandoEstancia.setLinhas(linhas);
			testandoEstancia.lerParametro(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}