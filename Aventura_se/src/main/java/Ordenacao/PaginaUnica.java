package Ordenacao;

import static Webdriver.DriverFactory.getDriver;

import java.time.Duration;

import DSL.Metodos;
import Organizado.ApresentacaoPage;

public class PaginaUnica {


	private static Metodos dsl = new Metodos();
	
	@SuppressWarnings("unused")
	private static ApresentacaoPage page;

	public static boolean fechaWeb = false;

	public static void abrirUnico() throws Exception {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dsl.inesperado();
		getDriver().manage().window().maximize();
		
		page = new ApresentacaoPage();

	}

}