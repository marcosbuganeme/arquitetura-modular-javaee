package br.com.codetisolutions.arquitetura.servico;

import java.io.Serializable;
import java.util.Collection;

import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.enuns.EnumEscopoValidacao;
import br.com.codetisolutions.arquitetura.excecoes.ValidacaoException;
import br.com.codetisolutions.arquitetura.negocio.BO;
import br.com.codetisolutions.arquitetura.utilitarios.UtilValidacao;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Service.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável pelas regras de negócio que estão vinculadas ao ECDU. <br>
 * Também contêm algumas funções pré definidas de manutenção na base de dados.
 * </p>
 *
 * Data de criação: 31/07/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 * 
 * @param <B>
 *            - Classe de negócio que gerencia as regras de negócio que estão vinculadas a entidade.
 *
 * @version 1.0.0
 */
public abstract class Service<E extends Entidade, B extends BO<E>> {

	/** Constante MENSAGEM_INSERIR_SUCESSO. */
	private static final String MENSAGEM_INSERIR_SUCESSO = "arquitetura.msg.inserirSucesso";

	/** Constante MENSAGEM_SALVAR_SUCESSO. */
	private static final String MENSAGEM_SALVAR_SUCESSO = "arquitetura.msg.salvarSucesso";

	/** Constante MENSAGEM_ALTERAR_SUCESSO. */
	private static final String MENSAGEM_ALTERAR_SUCESSO = "arquitetura.msg.alterarSucesso";

	/** Constante MENSAGEM_MESCLAR_SUCESSO. */
	private static final String MENSAGEM_MESCLAR_SUCESSO = "arquitetura.msg.mesclarSucesso";

	/** Constante MENSAGEM_REMOVER_SUCESSO. */
	private static final String MENSAGEM_REMOVER_SUCESSO = "arquitetura.msg.removerSucesso";

	/** Constante MENSAGEM_REMOVER_TODOS_SUCESSO. */
	private static final String MENSAGEM_REMOVER_TODOS_SUCESSO = "arquitetura.msg.removerTodosSucesso";

	/** Atributo utilValidacao. */
	private UtilValidacao<E> utilValidacao;

	/**
	 * Retorna o valor do atributo <code>mensagemInserirSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	protected abstract BO<E> getBO();

	/**
	 * Método responsável por validar as propriedades obrigatórias de um objeto parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será validado.
	 * 
	 * @throws ValidacaoException
	 */
	public void validar(final E entidade) throws ValidacaoException {

		this.getBO().validarCamposObrigatorios(entidade);

		this.getUtilValidacao().validar(entidade, EnumEscopoValidacao.SERVICE);
	}

	/**
	 * Método responsável por buscar por uma entidade através de seu identificador único.
	 *
	 * @author marcosbuganeme
	 *
	 * @param identificador
	 *            - id do registro.
	 * 
	 * @return <i>entidade pesquisada</i>.
	 */
	public E obter(final Serializable identificador) {

		return this.getBO().obter(identificador);
	}

	/**
	 * Método responsável por salvar ou alterar um registro na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será salvo ou alterado.
	 * 
	 * @return <i>chave da mensagem de sucesso da operação</i>.
	 */
	public String salvarOuAlterar(final E entidade) throws ValidacaoException {

		this.getBO().salvarOuAlterar(entidade);

		return Service.MENSAGEM_SALVAR_SUCESSO;

	}

	/**
	 * Método responsável por inserir um registro na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será salvo/inserido.
	 * 
	 * @return <i>chave da mensagem de sucesso da operação</i>.
	 */
	public String inserir(final E entidade) throws ValidacaoException {

		this.getBO().inserir(entidade);

		return Service.MENSAGEM_INSERIR_SUCESSO;

	}

	/**
	 * Método responsável por alterar um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será alterado.
	 * 
	 * @return <i>chave da mensagem de sucesso da operação</i>.
	 */
	public String alterar(final E entidade) throws ValidacaoException {

		this.getBO().alterar(entidade);

		return Service.MENSAGEM_ALTERAR_SUCESSO;

	}

	/**
	 * Método responsável por mesclar um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será mesclado.
	 * 
	 * @return <i>chave da mensagem de sucesso da operação</i>.
	 */
	public String mesclar(final E entidade) throws ValidacaoException {

		this.getBO().mesclar(entidade);

		return Service.MENSAGEM_MESCLAR_SUCESSO;

	}

	/**
	 * Método responsável por remover um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será removido.
	 * 
	 * @return <i>chave da mensagem de sucesso da operação</i>.
	 */
	public String remover(final E entidade) {

		this.getBO().remover(entidade);

		return Service.MENSAGEM_REMOVER_SUCESSO;

	}

	/**
	 * Método responsável por remover uma lista de objetos da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista de objetos que serão removidas.
	 * 
	 * @return <i>chave da mensagem de sucesso da operação</i>.
	 */
	public String removerTodos(final Collection<E> colecaoDados) throws ValidacaoException {

		this.getBO().removerTodos(colecaoDados);

		return Service.MENSAGEM_REMOVER_TODOS_SUCESSO;
	}

	/**
	 * Método responsável por pesquisar através de um filtro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - filtro da consulta.
	 * 
	 * @return <i>coleção de dados do objeto pesquisado</i>
	 */
	public Collection<E> consultar(final E entidade) {

		return this.getBO().consultar(entidade);
	}

	/**
	 * Método responsável por pesquisar sem filtro.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>toda a coleção de dados do objeto da lista</i>
	 */
	public Collection<E> consultarTodos() {

		return this.getBO().consultarTodos();
	}

	/**
	 * Método responsável por sincronizar a entidade com a base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será atualizado.
	 */
	public void atualizar(final E entidade) {

		this.getBO().atualizar(entidade);
	}

	/**
	 * Retorna o valor do atributo <code>mensagemInserirSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemInserirSucesso() {

		return Service.MENSAGEM_INSERIR_SUCESSO;
	}

	/**
	 * Retorna o valor do atributo <code>mensagemSalvarSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemSalvarSucesso() {

		return Service.MENSAGEM_SALVAR_SUCESSO;
	}

	/**
	 * Retorna o valor do atributo <code>mensagemAlterarSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemAlterarSucesso() {

		return Service.MENSAGEM_ALTERAR_SUCESSO;
	}

	/**
	 * Retorna o valor do atributo <code>mensagemMesclarSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemMesclarSucesso() {

		return Service.MENSAGEM_MESCLAR_SUCESSO;
	}

	/**
	 * Retorna o valor do atributo <code>mensagemRemoverSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemRemoverSucesso() {

		return Service.MENSAGEM_REMOVER_SUCESSO;
	}

	/**
	 * Retorna o valor do atributo <code>mensagemRemoverTodosSucesso</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemRemoverTodosSucesso() {

		return Service.MENSAGEM_REMOVER_TODOS_SUCESSO;
	}

	/**
	 * Retorna o valor do atributo <code>utilValidacao</code>
	 *
	 * @return <code>UtilValidacao<E></code>
	 */
	public UtilValidacao<E> getUtilValidacao() {

		if (this.utilValidacao == null) {

			this.utilValidacao = new UtilValidacao<E>();
		}

		return this.utilValidacao;
	}
}
