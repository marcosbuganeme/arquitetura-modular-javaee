package br.com.codetisolutions.arquitetura.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.persistencia.DAO;
import br.com.codetisolutions.arquitetura.utilitarios.UtilValidacao;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> BO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável pela validação das regras de negócio que estão vinculadas a entidade.
 * </p>
 *
 * Data de criação: 31/07/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class BO<E extends Entidade> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -6690425433098662370L;

	/** Constante MENSAGEM_CAMPOS_OBRIGATORIOS_NULOS. */
	private static final String MENSAGEM_CAMPOS_OBRIGATORIOS_NULOS = "arquitetura.msg.camposObrigatoriosNulo";

	/** Constante REGEX_REMOVER_SUPORTE. */
	private static final String REGEX_REMOVER_SUPORTE = "[\\[\\]]";

	/** Constante STRING_VAZIA. */
	private static final String STRING_VAZIA = "";

	/** Atributo utilValidacao. */
	private UtilValidacao<E> utilValidacao;

	/**
	 * Método responsável por capturar o valor de <code>DAO</code>
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>retorna o atributo de dao</i>.
	 */
	protected abstract DAO<E> getDAO();

	/**
	 * Método responsável por capturar os campos obrigatórios de uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o mapa dos campos obrigatórios vinculados a uma entidade</i>.
	 */
	public abstract Map<String, String> getMapaPropriedadesObrigatorias();

	/**
	 * Método responsável por verificar se um registro já existe na base de dados. <br>
	 * Deve ser sobreescrito.
	 *
	 * @author marcosbuganeme
	 * 
	 * @param entidade
	 *            - objeto que será validado.
	 *
	 * @return <i>{ TRUE, registro existe na base de dados. }<br>
	 *         { FALSE, registro <b>não</b> existe na base de dados. }</i>.
	 */
	public boolean isRegistrojaExiste(final E entidade) {

		return false;
	}

	/**
	 * Método responsável por validar os campos obrigatórios de uma entidade parametrizada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que soferá a validação.
	 * 
	 * @throws ValidacaoException
	 */
	public void validarCamposObrigatorios(final E entidade) throws ValidacaoException {

		final Collection<String> camposNulos = UtilValidacao.validarPropriedadesObrigatorias(entidade, this.getMapaPropriedadesObrigatorias());

		if (!camposNulos.isEmpty()) {

			throw new ValidacaoException(BO.MENSAGEM_CAMPOS_OBRIGATORIOS_NULOS, camposNulos.toString().replaceAll(BO.REGEX_REMOVER_SUPORTE, BO.STRING_VAZIA));
		}
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

		final E entidadeObtida = this.getDAO().obter(identificador);

		if (!this.isReferenciaMemoria(entidadeObtida)) {

			throw new RegistroNaoExisteException();
		}

		return entidadeObtida;
	}

	/**
	 * Método responsável por salvar ou alterar um registro na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será salvo ou alterado.
	 */
	public void salvarOuAlterar(final E entidade) throws ValidacaoException {

		this.getUtilValidacao().validar(entidade, EnumEscopoValidacao.BO);

		this.getDAO().salvarOuAlterar(entidade);
	}

	/**
	 * Método responsável por inserir um registro na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será salvo/inserido.
	 * 
	 * @return <i>identificador da entidade inserida</i>.
	 */
	public Serializable inserir(final E entidade) throws ValidacaoException {

		if (this.isRegistrojaExiste(entidade)) {

			throw new RegistroJaExisteException();
		}

		this.getUtilValidacao().validar(entidade, EnumEscopoValidacao.BO);

		final Serializable identificadorEntidade = this.getDAO().inserir(entidade);

		return identificadorEntidade;
	}

	/**
	 * Método responsável por alterar um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será alterada.
	 */
	public void alterar(final E entidade) throws ValidacaoException {

		if (this.isRegistrojaExiste(entidade)) {

			throw new RegistroJaExisteException();
		}

		this.getUtilValidacao().validar(entidade, EnumEscopoValidacao.BO);

		this.getDAO().alterar(entidade);

	}

	/**
	 * Método responsável por mesclar um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será mesclado.
	 */
	public void mesclar(final E entidade) {

		this.getUtilValidacao().validar(entidade, EnumEscopoValidacao.BO);

		this.getDAO().mesclar(entidade);
	}

	/**
	 * Método responsável por remover um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será removido.
	 */
	public void remover(final E entidade) {

		final E entidadeRemover = this.obter(entidade.getIdentificador());

		this.getDAO().remover(entidadeRemover);

	}

	/**
	 * Método responsável por remover uma lista de objetos da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista de objetos que serão removidas.
	 */
	public void removerTodos(final Collection<E> colecaoDados) {

		final Collection<E> dadosRemover = new ArrayList<E>();

		final Iterator<E> iterador = colecaoDados.iterator();

		while (iterador.hasNext()) {

			final E entidade = iterador.next();

			try {

				this.remover(entidade);

				dadosRemover.add(entidade);

			} catch (final Exception e) {

				continue;
			}

		}

		colecaoDados.removeAll(dadosRemover);
	}

	/**
	 * Método responsável por pesquisar através de um filtro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - filtro da consulta.
	 * 
	 * @return <i>coleção de dados do objeto pesquisado</i>.
	 */
	public Collection<E> consultar(final E entidade) {

		return this.getDAO().consultar(entidade);
	}

	/**
	 * Método responsável por pesquisar sem filtro.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>toda a coleção de dados do objeto da lista</i>.
	 */
	public Collection<E> consultarTodos() {

		return this.getDAO().consultarTodos();
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

		this.getDAO().atualizar(entidade);
	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir referência em memória } <br>
	 *         { FALSE, se o objeto <b>não</b> possui referência em memória }</i>
	 */
	private boolean isReferenciaMemoria(final Object objeto) {

		return objeto != null;
	}
}
