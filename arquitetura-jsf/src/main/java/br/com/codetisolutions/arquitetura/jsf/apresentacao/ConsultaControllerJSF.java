package br.com.codetisolutions.arquitetura.jsf.apresentacao;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.codetisolutions.arquitetura.apresentacao.ConsultaController;
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
 * <b>Título:</b> ConsultaControllerJSF.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 04/08/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class ConsultaControllerJSF<E extends Entidade> extends ConsultaController<E> {

	/** Atributo baseControllerJSF. */
	private ControllerBaseJSF controllerBaseJSF;

	/** Atributo formulario. */
	private Formulario<E> formulario;

	/** Atributo service. */
	private Service<E, ? extends BO<E>> service;

	/** Constante ARQUITETURA_MSG_CONSULTA_VAZIA. */
	private static final String ARQUITETURA_MSG_CONSULTA_VAZIA = "arquitetura.msg.consultaVazia";

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.Controller#abreIniciar()
	 */
	@Override
	public String abreIniciar() {

		this.iniciarDados();

		return this.getNavigationAbreIniciar();
	}

	/**
	 * Método responsável por inicializar os dados de um controlador.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void iniciarDados() {

		this.getControllerBaseJSF().iniciarDados();
	}

	/**
	 * Método responsável por apontar a rota de navegação da página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /inicial == rota do arquivo JSF</i>.
	 */
	protected String getNavigationAbreIniciar() {

		return this.getClass().getSimpleName() + "/inicial";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.Controller#voltarInicio()
	 */
	@Override
	public String voltarInicio() {

		return this.getControllerBaseJSF().voltarInicio();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.ConsultaController#abreDetalhar()
	 */
	@Override
	public String abreDetalhar() {

		return this.getNavigationAbreDetalhar();
	}

	/**
	 * Método responsável por apontar a rota de navegação da página detalhamento de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /detalhar == rota do arquivo JSF</i>.
	 */
	protected String getNavigationAbreDetalhar() {

		this.carregarDados();

		return this.getClass().getSimpleName() + "/detalhar";
	}

	@Override
	public void consultar() {

		super.consultar();

		if (this.getFormulario().getColecaoEntidades() == null || this.getFormulario().getColecaoEntidades().isEmpty()) {

			this.exibirMensagemNaTela(ConsultaControllerJSF.ARQUITETURA_MSG_CONSULTA_VAZIA);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.Controller#exibirMensagemNaTela(java.lang.String[])
	 */
	@Override
	public void exibirMensagemNaTela(final String... mensagens) {

		this.getControllerBaseJSF().exibirMensagemNaTela(mensagens);
	}

	/**
	 * Método responsável por adicionar uma mensagem de sucesso na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemSucesso
	 *            - mensagem de sucesso.
	 */
	@Override
	public void adicionarMensagemSucesso(final String mensagemSucesso) {

		this.getControllerBaseJSF().adicionarMensagemSucesso(mensagemSucesso);
	}

	/**
	 * Método responsável por adicionar uma mensagem de alerta na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemALerta
	 *            - mensagem de alerta.
	 */
	@Override
	public void adicionarMensagemAlerta(final String mensagemAlerta) {

		this.getControllerBaseJSF().adicionarMensagemAlerta(mensagemAlerta);
	}

	/**
	 * Método responsável por adicionar uma mensagem de erro na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemErro
	 *            - mensagem de erro.
	 */
	@Override
	public void adicionarMensagemErro(final String mensagemErro) {

		this.getControllerBaseJSF().adicionarMensagemErro(mensagemErro);
	}

	/**
	 * Método responsável por verificar se existe mensagens configuradas.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>{ TRUE, se existir mensagem configurada }<br>
	 *         { FALSE, se <b>não</b> existir mensagem configurada }</i>.
	 */
	public boolean hasMessage() {

		return this.getControllerBaseJSF().hasMessage();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletRequest</code>.
	 *
	 * @return <code>HttpServletRequest</code>.
	 */
	public HttpServletRequest getRequest() {

		return this.getControllerBaseJSF().getRequest();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletResponse</code>.
	 *
	 * @return <code>HttpServletResponse</code>.
	 */
	public HttpServletResponse getResponse() {

		return this.getControllerBaseJSF().getResponse();
	}

	/**
	 * Retorna o valor do atributo <code>facesContext</code>.
	 *
	 * @return <code>FacesContext</code>.
	 */
	public FacesContext getFacesContext() {

		return this.getControllerBaseJSF().getFacesContext();
	}

	/**
	 * Retorna o valor do atributo <code>baseControllerJSF</code>
	 *
	 * @return <code>BaseControllerJSF</code>
	 */
	public ControllerBaseJSF getControllerBaseJSF() {

		if (this.controllerBaseJSF == null) {

			this.controllerBaseJSF = new ControllerBaseJSF();
		}

		return this.controllerBaseJSF;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.ConsultaController#getFormulario()
	 */
	@Override
	public Formulario<E> getFormulario() {

		return this.formulario;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.ConsultaController#getService()
	 */
	@Override
	public Service<E, ? extends BO<E>> getService() {

		return this.service;
	}
}
