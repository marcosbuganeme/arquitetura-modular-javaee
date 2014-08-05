package br.com.codetisolutions.arquitetura.apresentacao;

import br.com.codetisolutions.arquitetura.dominio.Entidade;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ManutencaoController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável pelo fluxo de navegação do sistema, disponibilizando funções básicas para manutenção de registros.
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
public abstract class ManutencaoController<E extends Entidade> extends ConsultaController<E> {

	/**
	 * Método responsável por abrir a página de inclusão do caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página de inclusão do caso de uso</i>. <br>
	 *         Exemplo de retorno do método --> EmitirRelatorioController + "/incluir".
	 */
	public abstract String abreIncluir();

	/**
	 * Método responsável por abrir a página de alteração do caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página de alteração do caso de uso</i>. <br>
	 *         Exemplo de retorno do método --> EmitirRelatorioController + "/alterar".
	 */
	public abstract String abreAlterar();

	/**
	 * Método responsável por exibir mensagens de exceção na tela.
	 *
	 * @author marcosbuganeme
	 *
	 * @param excecao
	 *            - exceção que será lançada.
	 */
	private void exibirMensagemExcecaoTela(final Exception excecao) {

		this.exibirMensagemNaTela(excecao.getMessage());
	}

	/**
	 * Método responsável por realizar a inclusão ou alteração da entidade configurada no formulario.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void salvarOuAlterar() {

		try {

			final String mensagemSalvarOuAlterar = this.getService().salvarOuAlterar(this.getFormulario().getEntidade());

			this.exibirMensagemNaTela(mensagemSalvarOuAlterar);

		} catch (Exception e) {

			this.exibirMensagemExcecaoTela(e);
		}

	}

	/**
	 * Método responsável por realizar a inserção da entidade configurada no formulario.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void inserir() {

		try {

			final String mensagemInserir = this.getService().inserir(this.getFormulario().getEntidade());

			this.exibirMensagemNaTela(mensagemInserir);

		} catch (Exception e) {

			this.exibirMensagemExcecaoTela(e);
		}
	}

	/**
	 * Método responsável por realizar a alteração da entidade configurada no formulario.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void alterar() {

		try {

			final String mensagemAlterar = this.getService().alterar(this.getFormulario().getEntidade());

			this.exibirMensagemNaTela(mensagemAlterar);

		} catch (Exception e) {

			this.exibirMensagemExcecaoTela(e);
		}
	}

	/**
	 * Método responsável por realizar a mesclagem da entidade configurada no formulario.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void mesclar() {

		try {

			final String mensagemMesclar = this.getService().mesclar(this.getFormulario().getEntidade());

			this.exibirMensagemNaTela(mensagemMesclar);

		} catch (Exception e) {

			this.exibirMensagemExcecaoTela(e);
		}
	}

	/**
	 * Método responsável por realizar a remoção da entidade configurada no formulario.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void remover() {

		try {

			final String mensagemRemover = this.getService().remover(this.getFormulario().getEntidade());

			this.exibirMensagemNaTela(mensagemRemover);

		} catch (Exception e) {

			this.exibirMensagemExcecaoTela(e);
		}
	}

	/**
	 * Método responsável por realizar a remoção da coleção de entidades configurada no formulario.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void removerTodos() {

		try {

			final String mensagemRemoverTodos = this.getService().removerTodos(this.getFormulario().getColecaoEntidades());

			this.exibirMensagemNaTela(mensagemRemoverTodos);

		} catch (Exception e) {

			this.exibirMensagemExcecaoTela(e);
		}
	}

}
