package br.com.codetisolutions.arquitetura.apresentacao;

import java.io.Serializable;
import java.util.Collection;

import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.formulario.Formulario;
import br.com.codetisolutions.arquitetura.negocio.BO;
import br.com.codetisolutions.arquitetura.servico.Service;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ConsultaController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável pelo fluxo de navegação do sistema, disponibilizando simples funções para consulta básica de dados.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class ConsultaController<E extends Entidade> extends Controller {

	/**
	 * Método responsável por abrir a página detalhar de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página detalhar de um caso de uso</i>. <br>
	 *         Exemplo de retorno do método --> EmitirRelatorioController + "/detalhar".
	 */
	public abstract String abreDetalhar();

	/**
	 * Método responsável por realizar uma consulta de dados de acordo com o filtro passado como parâmetro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - filtro da pesquisa.
	 */
	public void consultar(final E entidade) {

		this.getFormulario().setConsulta(entidade);

		this.consultar(entidade);
	}

	/**
	 * Método responsável por realizar uma consulta de acordo com o Formulario.getConsulta().
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void consultar() {

		final Collection<E> colecaoDadosResultado = this.getService().consultar(this.getFormulario().getConsulta());

		this.getFormulario().setColecaoEntidades(colecaoDadosResultado);
	}

	/**
	 * Método responsável por realizar uma consulta sem um prévio filtro, trazendo da base de dados todos os dados vinculados a entidade.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void consultarTodos() {

		final Collection<E> colecaoDadosResultado = this.getService().consultarTodos();

		this.getFormulario().setColecaoEntidades(colecaoDadosResultado);
	}

	/**
	 * Método responsável por carregar os dados da entidade.
	 *
	 * @author marcosbuganeme
	 *
	 */
	protected void carregarDados() {

		final E entidade = this.getFormulario().getEntidade();

		final Collection<E> colecaoEntidades = this.getFormulario().getColecaoEntidades();

		Serializable identificador = null;

		if (!this.isReferenciaMemoria(entidade) || entidade.isNovoRegistro() && this.isReferenciaMemoria(colecaoEntidades) && !colecaoEntidades.isEmpty()) {

			identificador = this.getIdentificador(colecaoEntidades.iterator().next());

		} else {

			identificador = this.getIdentificador(this.getFormulario().getEntidade());
		}

		this.getFormulario().setEntidade(this.getService().obter(identificador));
	}

	/**
	 * Método responsável por verificar se o objeto parametrizado é diferente de nulo.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, objeto é diferente de nulo }<br>
	 *         { FALSE, objeto <b>não</b> é diferente de nulo }</i>.
	 */
	private boolean isReferenciaMemoria(final Object objeto) {

		return objeto != null;
	}

	/**
	 * Método responsável por obter o identificador da entidade parametrizada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - entidade que terá o seu identificador obtido.
	 * 
	 * @return <i>identificador da entidade</i>.
	 */
	private Serializable getIdentificador(final E entidade) {

		return entidade.getIdentificador();
	}

	/**
	 * Método responsável por capturar o valor do atributo <b>formulario</b>.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o valor do atributo formulario</i>.
	 */
	public abstract Formulario<E> getFormulario();

	/**
	 * Método responsável por capturar o valor do atributo <b>service</b>.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o valor do atributo service</i>.
	 */
	public abstract Service<E, ? extends BO<E>> getService();

}
