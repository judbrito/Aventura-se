package Estrutura;

import static Webdriver.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Ordenacao.PaginaUnica;
import Organizado.ApresentacaoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Apresentacao {
	static DSL.Metodos dsl;
	private ApresentacaoPage page;

	@Before

	public void abrir() throws Exception {

		PaginaUnica.abrirUnico();
		dsl = new DSL.Metodos();
		page = new ApresentacaoPage();

	}

	@AfterClass
	public static void fechar() {
		if (PaginaUnica.fechaWeb) {

		}
		killDriver();
	}
	
	@Test

	public void a_Id_0001() {
		page.setAcesso("amazonclientevip@yahoo.com", "123456789241307Jb@");

	}

	@Test
	public void b_Id_0002() {

		page.desloga();

	}

	@Test

	public void c_Id_0003() {
		page.consultabike("bicicleta aro 29");
		
	}

	@Test

	public void d_Id_0004() {
		page.consultaAlgo("devdebrito");

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
