package br.com.codetisolutions.persistencia;

import java.io.Serializable;
import java.util.Collection;

import br.com.codetisolutions.dominio.Entidade;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> DAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface provedora das funções pré definidas do acesso ao banco de dados.
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
public interface DAO<E extends Entidade> {

	/**
	 * Método responsável por buscar por uma entidade através de seu identificador único.
	 *
	 * @author marcosbuganeme
	 *
	 * @param identificador
	 *            - id do registro.
	 * 
	 * @return <i>entidade pesquisada</i>
	 */
	E obter(final Serializable identificador);

	/**
	 * Método responsável por salvar ou alterar um registro na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será salvo ou alterado.
	 */
	void salvarOuAlterar(final E entidade);

	/**
	 * Método responsável por inserir um registro na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será salvo/inserido.
	 * 
	 * @return <i>identificador da entidade inserida</i>
	 */
	Serializable inserir(final E entidade);

	/**
	 * Método responsável por alterar um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será alterada.
	 */
	void alterar(final E entidade);

	/**
	 * Método responsável por mesclar um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 */
	void mesclar(final E entidade);

	/**
	 * Método responsável por remover um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será removido.
	 */
	void remover(final E entidade);

	/**
	 * Método responsável por remover uma lista de objetos da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista de objetos que serão removidas.
	 */
	void removerTodos(final Collection<E> colecaoDados);

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
	Collection<E> consultar(final E entidade);

	/**
	 * Método responsável por pesquisar sem filtro.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>toda a coleção de dados do objeto da lista</i>
	 */
	Collection<E> consultarTodos();

	/**
	 * Método responsável por sincronizar a entidade com a base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será atualizado.
	 */
	void atualizar(final E entidade);
}
