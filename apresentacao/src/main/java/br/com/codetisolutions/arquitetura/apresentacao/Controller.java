package br.com.codetisolutions.arquitetura.apresentacao;

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
}
