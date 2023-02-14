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
	Metodos testandoInstancia = new Metodos();
	public static Metodos dsl;

	public Registro() {
		new Metodos();
		this.inicializarPlanilha();

	}

	public void inicializarPlanilha() {
		try {
			String file = System.getProperty("user.dir") + "./src/main/resources/evidencia.xlsx";
			FileInputStream fis = new FileInputStream(new File(file));
			Workbook arquivo = WorkbookFactory.create(fis);
			this.planilha = arquivo.getSheetAt(0);

		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public void extrairEmail() {
		Row linhas = planilha.getRow(1);
		linhas.getCell(1);
		try {
			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerLogoff("//*[@id='ap_email']", 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairSenha() {
		try {
			Row linhas = planilha.getRow(1);
			linhas.getCell(1);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerLogoff("//*[@id='ap_password']", 2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairTres() {
		try {
			Row linhas = planilha.getRow(3);
			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairQuatro() {
		try {
			Row linhas = planilha.getRow(4);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairCinco() {
		try {
			Row linhas = planilha.getRow(5);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void extrairEncadeamento() {

		testandoInstancia.lerParametroEncadeado(2);

	}

	public void extrairSeis() {
		try {
			Row linhas = planilha.getRow(6);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairEncadeamentoSeis() {

		testandoInstancia.lerParametroEncadeado(2);

	}

	public void extrairSete() {
		try {
			Row linhas = planilha.getRow(7);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairOito() {
		try {
			Row linhas = planilha.getRow(8);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairNove() {
		try {
			Row linhas = planilha.getRow(9);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void encadeamento() {
		try {

			testandoInstancia.lerParametro(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairDez() {
		try {
			Row linhas = planilha.getRow(10);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void extrairDoze() {
		try {
			Row linhas = planilha.getRow(12);

			testandoInstancia.setLinhas(linhas);
			testandoInstancia.lerParametro(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
