package br.com.codetisolutions.apresentacao.jsf;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.codetisolutions.arquitetura.apresentacao.Controller;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ControllerJSF.java
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
 * @version 1.0.0
 */
public class ControllerJSF extends Controller implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2606590925033905989L;

	/** Atributo logger. */
	protected Logger logger = Logger.getLogger(this.getClass().getName());

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
	 * @see arquitetura.apresentacao.Controller#iniciarDados()
	 */
	public void iniciarDados() {

		return;
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

		for (final String mensagem : mensagens) {

			this.getFacesContext().addMessage("", new FacesMessage(mensagem));
		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.Controller#adicionarMensagemSucesso(java.lang.String)
	 */
	@Override
	public void adicionarMensagemSucesso(final String mensagemSucesso) {

		this.exibirMensagemNaTela(FacesMessage.SEVERITY_INFO, mensagemSucesso);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.Controller#adicionarMensagemAlerta(java.lang.String)
	 */
	@Override
	public void adicionarMensagemAlerta(final String mensagemAlerta) {

		this.exibirMensagemNaTela(FacesMessage.SEVERITY_WARN, mensagemAlerta);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.apresentacao.Controller#adicionarMensagemErro(java.lang.String)
	 */
	@Override
	public void adicionarMensagemErro(final String mensagemErro) {

		this.exibirMensagemNaTela(FacesMessage.SEVERITY_ERROR, mensagemErro);
	}

	/**
	 * Método responsável por exibir uma mensagem na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param severidade
	 *            - tipo da mensagem { <b>INFO</b> <b>WARN</b> <b>ERROR</b>}
	 * 
	 * @param mensagemSumario
	 *            - mensagem que será exibida.
	 * 
	 */
	private void exibirMensagemNaTela(final Severity severidade, final String mensagemSumario) {

		this.getFacesContext().addMessage("", new FacesMessage(severidade, mensagemSumario, ""));
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

		return this.getFacesContext().getMessages().hasNext();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletResponse</code>.
	 *
	 * @return <code>HttpServletResponse</code>.
	 */
	public HttpServletResponse getResponse() {

		return (HttpServletResponse) this.getFacesContext().getExternalContext().getResponse();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletRequest</code>.
	 *
	 * @return <code>HttpServletRequest</code>.
	 */
	public HttpServletRequest getRequest() {

		return (HttpServletRequest) this.getFacesContext().getExternalContext().getRequest();
	}

	/**
	 * Retorna o valor do atributo <code>facesContext</code>.
	 *
	 * @return <code>FacesContext</code>.
	 */
	public FacesContext getFacesContext() {

		return FacesContext.getCurrentInstance();
	}

}
