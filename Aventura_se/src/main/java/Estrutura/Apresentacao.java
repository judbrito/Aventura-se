package Estrutura;

import static Webdriver.DriverFactory.killDriver;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import DSL.Metodos;
import Ordenacao.PaginaUnica;
import Organizado.ApresentacaoPage;
import Planilha.Registro;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Apresentacao {




	private ApresentacaoPage page;

	DSL.Metodos dsl = new Metodos();

	@Before

	public void abrir() throws Exception {

		PaginaUnica.abrirUnico();
		page = new ApresentacaoPage();

	}

	@AfterClass
	public static void fechar() {

		killDriver();
	}

	@Test
	/*
	 * 1. Realizar login na aplicação Descrição: Realizar login na aplicação e
	 * validar a página de destino esperada.
	 */
	public void a_Id_0001() throws EncryptedDocumentException, IOException {

		page.logar();

		

	}

	@Test
	public void b_Id_0002() throws EncryptedDocumentException, IOException {

		page.deslogar();

	}

	@Test

	public void c_Id_0003() throws EncryptedDocumentException, IOException {

	
		page.validaBike();

	}

	@Test

	public void d_Id_0004() {
		page.consultaAlgo("devdeBrito");

	}

	@Test

	public void e_Id_0005() {
		page.cepTrue("Frigideira", "06010067");

	}

	@Test

	public void f_Id_0006() {
		page.cepFalse("copo", "00000000");

	}

	@Test

	public void g_Id_0007() {
		page.inserePedido();

	}

	@Test

	public void h_Id_0008() {
		g_Id_0007();
		page.AddItens();

	}

	@Test

	public void i_Id_0009() {
		page.doisItens();
	}

	@Test

	public void j_Id_0010() {
		g_Id_0007();
		page.excluiItens();

	}

	@Test

	public void l_Id_0011() {

		i_Id_0009();

		page.excluiUmItem();

	}

	@Test

	public void m_Id_0012() {
		page.voltaLogin();

	}

	@Test

	public void n_Id_0013() {
		page.tecnologia();

	}

	@Test

	public void o_Id_0014() {
		n_Id_0013();
		page.tecAlvo();
	}

	@Test

	public void p_Id_0015() {
		o_Id_0014();
		page.organizar();

	}
}

