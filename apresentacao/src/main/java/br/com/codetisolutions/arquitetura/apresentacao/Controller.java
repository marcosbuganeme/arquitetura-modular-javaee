package br.com.codetisolutions.arquitetura.apresentacao;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.codetisolutions.arquitetura.factorybundle.ResourceBundleFactory;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Controller.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável pelo fluxo de navegação do sistema.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class Controller {

	/**
	 * Método responsável por abrir a página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página inicial de um caso de uso</i>. <br>
	 *         Exemplo de retorno do método --> EmitirRelatorioController + "/inicial".
	 */
	public abstract String abreIniciar();

	/**
	 * Método responsável por voltar a página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página inicial de um caso de uso</i>.
	 */
	public String voltarInicio() {

		return this.abreIniciar();
	}

	/**
	 * Método responsável por vincular uma mensagem através da chave da mensagem parametrizada no escopo do método.
	 *
	 * @author marcosbuganeme
	 *
	 * @param chaveMensagem
	 *            - chave da mensagem do arquivo properties.
	 * 
	 * @return <i>mensagem que será exibida na tela</i>.
	 */
	public String getMessage(final String chaveMensagem) {

		return this.getBundle().getString(chaveMensagem);
	}

	/**
	 * Método responsável por vincular uma mensagem através da chave da mensagem parametrizada no escopo do método.
	 *
	 * @author marcosbuganeme
	 *
	 * @param chaveMensagem
	 *            - chave da mensagem do arquivo properties.
	 * 
	 * @param parametro
	 *            - parâmetros de formatação da mensagem.
	 * 
	 * @return <i>mensagem que será exibida na tela</i>.
	 */
	public String getMessage(final String chaveMensagem, final Object[] parametro) {

		final String mensagem = this.getBundle().getString(chaveMensagem);

		return MessageFormat.format(mensagem, parametro);
	}

	/**
	 * Método responsável por vincular mensagens através das chaves das mensagens parametrizadas no escopo do método.
	 *
	 * @author marcosbuganeme
	 *
	 * @param chaveMensagens
	 *            - chaves das mensagens do arquivo properties.
	 * 
	 * @return <i>mensagens que serão exibidas na tela</i>.
	 */
	public String[] getMessages(final String... chaveMensagens) {

		final String[] mensagens = new String[chaveMensagens.length];

		for (int indice = 0; indice < chaveMensagens.length; indice++) {

			mensagens[indice] = this.getBundle().getString(chaveMensagens[indice]);
		}

		return mensagens;
	}

	/**
	 * Método responsável por exibir mensagens na tela de acordo com a tecnologia utilizada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - que será exibida na tela.
	 */
	public abstract void exibirMensagemNaTela(final String... mensagem);

	/**
	 * Método responsável por adicionar uma mensagem de sucesso.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemSucesso
	 *            - mensagem de sucesso que será exibida em tela.
	 */
	public void adicionarMensagemSucesso(final String mensagemSucesso) {

		this.exibirMensagemNaTela(mensagemSucesso);
	}

	/**
	 * Método responsável por adicionar uma mensagem de alerta.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemAlerta
	 *            - mensagem de alerta que será exibida em tela.
	 */
	public void adicionarMensagemAlerta(final String mensagemAlerta) {

		this.exibirMensagemNaTela(mensagemAlerta);
	}

	/**
	 * Método responsável por adicionar uma mensagem de erro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagemErro
	 *            - mensagem de erro que será exibida em tela.
	 */
	public void adicionarMensagemErro(final String mensagemErro) {

		this.exibirMensagemNaTela(mensagemErro);
	}

	/**
	 * Método responsável por capturar o valor do atributo vinculado ao resouceBundle da aplicação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o valor do atributo bundle da aplicação</i>.
	 */
	public abstract ResourceBundle getBundle();

	/**
	 * Método responsável por obter o <code>ResourceBundleFactory</code> para o controlador.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o ResouceBundleFactory para a aplicação</i>.
	 */
	public abstract Class<? extends ResourceBundleFactory> getResourceBundleFactory();
}
