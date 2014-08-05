package br.com.codetisolutions.persistencia.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.persistencia.DAO;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> HibernateDAO.java
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
@SuppressWarnings("unchecked")
public class HibernateDAO<E extends Entidade> implements DAO<E> {

	/** Atributo entityManager. */
	private EntityManager entityManager;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public HibernateDAO() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param entityManager
	 */
	public HibernateDAO( final EntityManager entityManager ) {

		this.entityManager = entityManager;
	}

	/**
	 * Método responsável por capturar um critéria para uma entidade através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>criteria para a entidade</i>.
	 */
	protected Criteria novoCriteria() {

		final Class<E> tipoDaEntidade = this.getTipoEntidade();

		final Criteria criteria = this.getSession().createCriteria(tipoDaEntidade);

		return criteria;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#obter(java.io.Serializable)
	 */
	@Override
	public E obter(final Serializable identificador) {

		E resultadoObtido = null;

		if (this.isReferenciaMemoria(identificador)) {

			final Class<E> tipoDaEntidade = this.getTipoEntidade();

			resultadoObtido = (E) this.getSession().get(tipoDaEntidade, identificador);

		}

		return resultadoObtido;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#salvarOuAlterar(arquitetura.modelo.Entidade)
	 */
	@Override
	public void salvarOuAlterar(final E entidade) {

		if (this.isReferenciaMemoria(entidade)) {

			if (entidade.isNovoRegistro()) {

				this.getSession().saveOrUpdate(entidade);

			} else {

				this.mesclar(entidade);
			}

		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#inserir(arquitetura.modelo.Entidade)
	 */
	@Override
	public Serializable inserir(final E entidade) {

		Serializable resultadoInserir = null;

		if (this.isReferenciaMemoria(entidade)) {

			resultadoInserir = this.getSession().save(entidade);

		}

		return resultadoInserir;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#alterar(arquitetura.modelo.Entidade)
	 */
	@Override
	public void alterar(final E entidade) {

		if (this.isReferenciaMemoria(entidade)) {

			this.getSession().update(entidade);

		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#mesclar(arquitetura.modelo.Entidade)
	 */
	@Override
	public void mesclar(final E entidade) {

		if (this.isReferenciaMemoria(entidade)) {

			this.getSession().merge(entidade);

		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#remover(arquitetura.modelo.Entidade)
	 */
	@Override
	public void remover(final E entidade) {

		if (this.isReferenciaMemoria(entidade)) {

			this.carregarEntidadePersistente(entidade);

			this.getSession().delete(entidade);

			this.getSession().flush();
		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#removerTodos(java.util.Collection)
	 */
	@Override
	public void removerTodos(final Collection<E> colecaoDados) {

		if (this.isReferenciaMemoria(colecaoDados)) {

			for (final E entidade : colecaoDados) {

				this.remover(entidade);

			}

		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#consultar(arquitetura.modelo.Entidade)
	 */
	@Override
	public Collection<E> consultar(final E entidade) {

		final Criteria criteria = this.novoCriteria();

		if (this.isReferenciaMemoria(entidade)) {

			final Example filtroExemplo = Example.create(entidade);

			filtroExemplo.enableLike(MatchMode.START);

			filtroExemplo.excludeZeroes();

			criteria.add(filtroExemplo);
		}

		return this.consultar(criteria);
	}

	/**
	 * Método responsável por efetuar a consulta sob as condições de um filtro parametrizado do objeto criteria.
	 *
	 * @author marcosbuganeme
	 *
	 * @param criteria
	 *            - filtro da pesquisa.
	 * 
	 * @return <i>coleção de dados sob o filtro da pesquisa</i>
	 */
	protected Collection<E> consultar(final Criteria criteria) {

		final Collection<E> colecaoDados = criteria.list();

		return colecaoDados;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#consultarTodos()
	 */
	@Override
	public Collection<E> consultarTodos() {

		final Criteria criteria = this.novoCriteria();

		final Collection<E> colecaoDados = criteria.list();

		return colecaoDados;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see arquitetura.persistencia.dao.DAO#atualizar(arquitetura.modelo.Entidade)
	 */
	@Override
	public void atualizar(final E entidade) {

		this.getEntityManager().refresh(entidade);

	}

	/**
	 * Método responsável por capturar o tipo da entidade. <br>
	 * O tipo é capturado através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>tipo da classe da entidade</i>.
	 */
	private Class<E> getTipoEntidade() {

		final Type[] tipoEntidade = ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) tipoEntidade[0];
	}

	/**
	 * Método responsável por verificar se um ou mais objetos parametrizados possuem referência em memória.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objetos
	 *            - que serão validados.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir referência em memória } <br>
	 *         { FALSE, se o objeto <b>não</b> possui referência em memória }</i>
	 */
	private boolean isReferenciaMemoria(final Object... objetos) {

		boolean resultadoReferencia = false;

		if (this.isReferenciaMemoria(objetos)) {

			resultadoReferencia = true;

			for (int indice = 0; indice < objetos.length; indice++) {

				if (resultadoReferencia) {

					resultadoReferencia = this.isReferenciaMemoria(objetos[indice]);
				}
			}

		}

		return resultadoReferencia;
	}

	/**
	 * Método responsável por carregar uma entidade e torná-la persistente. <br>
	 * Somente foi utilizado o load, pois foi feita uma verificação para ver se o objeto existia na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - que será pré carregada
	 */
	protected void carregarEntidadePersistente(final E entidade) {

		if (this.isReferenciaMemoria(entidade) && this.isObjetoPersistente(entidade)) {

			final Serializable identificador = entidade.getIdentificador();

			this.getSession().load(entidade, identificador);
		}
	}

	/**
	 * Método responsável por verificar se um determinado objeto se encontra na sessão do hibernate.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que sofrerá a validação.
	 * 
	 * @return <i>{ TRUE, se o objeto for persistente } <br>
	 *         { FALSE, se o objeto <b>não</b> for persistente}</i>.
	 */
	protected boolean isObjetoPersistente(final E entidade) {

		return this.getSession().contains(entidade);
	}

	/**
	 * Retorna o valor do atributo <code>entityManager</code>
	 *
	 * @return <code>EntityManager</code>.
	 */
	public final EntityManager getEntityManager() {

		return this.entityManager;
	}

	/**
	 * Método responsável por obter a sessão do hibernate.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>sessão do hibernate</i>.
	 */
	public final Session getSession() {

		return (Session) this.getEntityManager().getDelegate();
	}

}
