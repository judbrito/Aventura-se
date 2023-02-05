package Ordenacao;

import static Webdriver.DriverFactory.getDriver;

import java.time.Duration;

import DSL.Metodos;
import Organizado.ApresentacaoPage;

public class PaginaUnica {

	private static Metodos dsl;
	@SuppressWarnings("unused")
	private static  ApresentacaoPage page;

	public static boolean fechaWeb = false;

	public static   void abrirUnico() throws Exception {
		getDriver().get("https://www.amazon.com.br");
		getDriver().manage().window().maximize();
		dsl = new Metodos();
		dsl.inesperado();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		page = new ApresentacaoPage();
	}


	
	

}
