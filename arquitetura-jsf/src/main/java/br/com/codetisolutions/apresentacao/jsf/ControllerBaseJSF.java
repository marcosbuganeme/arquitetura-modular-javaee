package br.com.codetisolutions.apresentacao.jsf;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ControllerBaseJSF.java
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
public class ControllerBaseJSF implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -735243567000463544L;

	/** Atributo controllerJSF. */
	private ControllerJSF controllerJSF;

	/**
	 * Método responsável por iniciar os dados de um controlador.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void iniciarDados() {

		return;
	}

	/**
	 * Método responsável por abrir a página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página inicial</i>.
	 */
	public String abreIniciar() {

		return this.getControllerJSF().abreIniciar();
	}

	/**
	 * Método responsável por apontar a rota de navegação da página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /inicial == rota do arquivo JSF</i>.
	 */
	public String getNavigationAbreIniciar() {

		return this.getControllerJSF().getNavigationAbreIniciar();
	}

	/**
	 * Método responsável por voltar para a página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>volta para a página inicial</i>.
	 */
	public String voltarInicio() {

		return this.getControllerJSF().voltarInicio();
	}

	/**
	 * Método responsável por exibir uma mensagem na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagens
	 *            - mensagens que serão exibidas na tela.
	 */
	public void exibirMensagemNaTela(final String... mensagens) {

		this.getControllerJSF().exibirMensagemNaTela(mensagens);
	}

	/**
	 * Método responsável por adicionar uma mensagem de sucesso na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemSucesso
	 *            - mensagem de sucesso.
	 */
	public void adicionarMensagemSucesso(final String mensagemSucesso) {

		this.getControllerJSF().adicionarMensagemSucesso(mensagemSucesso);
	}

	/**
	 * Método responsável por adicionar uma mensagem de alerta na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemALerta
	 *            - mensagem de alerta.
	 */
	public void adicionarMensagemAlerta(final String mensagemAlerta) {

		this.getControllerJSF().adicionarMensagemAlerta(mensagemAlerta);
	}

	/**
	 * Método responsável por adicionar uma mensagem de erro na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemErro
	 *            - mensagem de erro.
	 */
	public void adicionarMensagemErro(final String mensagemErro) {

		this.getControllerJSF().adicionarMensagemErro(mensagemErro);
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

		return this.getControllerJSF().hasMessage();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletRequest</code>.
	 *
	 * @return <code>HttpServletRequest</code>.
	 */
	public HttpServletRequest getRequest() {

		return this.getControllerJSF().getRequest();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletResponse</code>.
	 *
	 * @return <code>HttpServletResponse</code>.
	 */
	public HttpServletResponse getResponse() {

		return this.getControllerJSF().getResponse();
	}

	/**
	 * Retorna o valor do atributo <code>facesContext</code>.
	 *
	 * @return <code>FacesContext</code>.
	 */
	public FacesContext getFacesContext() {

		return this.getControllerJSF().getFacesContext();
	}

	/**
	 * Retorna o valor do atributo <code>controllerJSF</code>
	 *
	 * @return <code>ControllerJSF</code>
	 */
	public ControllerJSF getControllerJSF() {

		if (this.controllerJSF == null) {

			this.controllerJSF = new ControllerJSF();
		}

		return this.controllerJSF;
	}
}
