package Estrutura;

import static Webdriver.DriverFactory.killDriver;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.TakesScreenshot;

import Imagens.ScreenShotsTest;
import Ordenacao.PaginaUnica;
import Organizado.ApresentacaoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Apresentacao {
	private ApresentacaoPage page;
	@Rule
	public TestName testeNames = new TestName();
	@Before

	public void abrir() throws Exception {
		
		PaginaUnica.abrirUnico();
		page = new ApresentacaoPage();

	}

	@AfterClass
	public static void fechar() throws IOException {
		ScreenShotsTest.capturaTelas();
		//killDriver();
	}

	@Test

	/*
	 * 1. Realizar login na aplicação Descrição: Realizar login na aplicação e
	 * validar a página de destino esperada.
	 */
	public void a_Id_0001() {

		page.logar();

	}

	@Test

	/*
	 * 2. Realizar logout na aplicação  ID: 0002  Descrição: Realizar logout na
	 * aplicação e validar a página de destino esperada.
	 */

	public void b_Id_0002() {
	

		page.deslogar();

	}

	@Test
	/*
	 * 3. Consultar item no campo de busca  ID: 0003  Descrição: Realizar a
	 * consulta pelo item “bicicleta aro 29” no campo de busca e validar a aparição
	 * de ao menos um item no catálogo de resultados de itens.
	 */
	public void c_Id_0003() {

		page.consultaBike();

	}

	@Test
	/*
	 * 4. Consultar item inexistente no campo de busca  ID: 0004  Descrição:
	 * Realizar a consulta pelo item “ITEM_INEXISTENTE_012345” no campo de busca e
	 * validar a aparição da mensagem de que não foram encontrados resultados.
	 */
	public void d_Id_0004() {
		page.consultaAlgo();

	}

	@Test
	/*
	 * 5. Calcular frete e prazo de um item  ID: 0005  Descrição: Realizar a
	 * consulta pelo item “frigideira” no campo de busca, clicar no primeiro item
	 * disponível, digitar o CEP “06010-067” e validar o retorno da(s)
	 * informação(ões) de frete/prazo.
	 */

	public void e_Id_0005() {

		page.cepTrue();

	}

	@Test
	/*
	 * 6. Validar mensagem de CEP inválido  ID: 0006  Descrição: Realizar a
	 * consulta pelo item “copo” no campo de busca, clicar no primeiro item
	 * disponível, digitar o CEP “00000-000” e validar o retorno da mensagem de CEP
	 * inválido ou não encontrado.
	 */

	public void f_Id_0006() {

		page.cepFalse();

	}

	@Test
	/*
	 * 7. Adicionar um item ao carrinho/cesta  ID: 0007  Descrição: Realizar a
	 * consulta por qualquer item no campo de busca, clicar no primeiro item
	 * disponível, adicioná-lo ao carrinho/cesta e verificar na seção carrinho/cesta
	 * se o mesmo item é apresentado.
	 */
	public void g_Id_0007() {

		page.inserePedido();

	}

	@Test
	/*
	 * 8. Aumentar a quantidade de um item no(a) carrinho/cesta  ID: 0008 
	 * Descrição: Realizar o descritivo do cenário de ID 0007, selecionar/aumentar a
	 * quantidade do item para dois e validar se o preço foi atualizado/dobrado.
	 */

	public void h_Id_0008() {

		page.AddItens();

	}

	@Test
	/*
	 * 9. Adicionar múltiplos itens ao carrinho/cesta  ID: 0009  Descrição:
	 * Realizar o descritivo do cenário de ID 0007 por duas vezes (pesquisando
	 * respectivamente pelo item “fogão” e “geladeira”) e validar ao final se a
	 * seção carrinho/cesta apresenta a quantidade de itens igual à dois.
	 */

	public void i_Id_0009() {
		page.doisItens();
	
	}

	@Test
	/*
	 * 10. Validar mensagem de carrinho/cesta vazio(a)  ID: 0010  Descrição:
	 * Realizar o descritivo do cenário de ID 0007 (pesquisando pelo item
	 * “garrafa”), clicar na opção de exclusão do item e validar a mensagem de
	 * carrinho/cesta vazio(a).
	 */

	public void j_Id_0010() {

		page.excluiItens();

	}

	@Test
	/*
	 * 11. Remover um item do carrinho/cesta  ID: 0011  Descrição: Realizar o
	 * descritivo do cenário de ID 0009, clicar na opção de exclusão do primeiro
	 * item e validar ao final se a seção carrinho/cesta apresenta a quantidade de
	 * itens igual à um.
	 */

	public void l_Id_0011() {

		i_Id_0009();

		page.excluiUmItem();

	}

	@Test
	/*
	 * 12. Validar redirecionamento para a página de login no fluxo de compra  ID:
	 * 0012  Descrição: Realizar o descritivo do cenário de ID 0007 (pesquisando
	 * pelo item “televisão”), clicar na opção de compra e validar o
	 * redirecionamento para a seção/página de login.
	 */

	public void m_Id_0012() {
		page.voltaLogin();

	}

	@Test
	/*
	 * 13. Validar busca por categoria/departamento  ID: 0013  Descrição: Clicar
	 * no menu principal, clicar na opção categoria/departamento correspondente à
	 * “Informática”, clicar no submenu referente à “Notebook(s)” e validar a
	 * exibição de ao menos um item no catálogo de resultados de itens.
	 */

	public void n_Id_0013() {
		page.tecnologia();

	}

	@Test
	/*
	 * 14. Filtrar resultado de busca de itens  ID: 0014  Descrição: Realizar o
	 * descritivo do cenário de ID 0013, selecionar nas opções de filtro a marca
	 * “Lenovo” e ao final validar se o primeiro item disponível no catálogo de
	 * resultados de itens contém em seu nome/descritivo a palavra (marca filtrada)
	 * “Lenovo”.
	 */
	public void o_Id_0014() {
		n_Id_0013();
		page.tecAlvo();
	}

	@Test
	/*
	 * 15. Ordenar resultado de busca de itens  ID: 0015  Descrição: Realizar o
	 * descritivo do cenário de ID 0014, selecionar a opção de ordenação por maiores
	 * preços e validar no catálogo de resultados de itens se o valor do primeiro
	 * item é maior do que o do segundo.
	 */
	public void p_Id_0015() {
		o_Id_0014();
		page.organizar();

	}

}