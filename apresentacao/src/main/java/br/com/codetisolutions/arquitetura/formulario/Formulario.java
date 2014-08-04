package br.com.codetisolutions.arquitetura.formulario;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.logging.Logger;

import br.com.codetisolutions.arquitetura.dominio.Entidade;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Formulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela manutenção da <code>E - Entidade</code> manipulada pela classa concreta, armazenando os dados vindos da camada de visão.
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
@SuppressWarnings("unchecked")
public class Formulario<E extends Entidade> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -5606821856286575455L;

	/** Atributo entidade. */
	private E entidade;

	/** Atributo consulta. */
	private E consulta;

	/** Atributo colecaoEntidades. */
	private Collection<E> colecaoEntidades;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Formulario( final Class<E> clazz ) {

		try {

			this.entidade = clazz.newInstance();

			this.consulta = clazz.newInstance();

		} catch (Exception e) {

			Logger.getLogger(this.getClass().getName()).info("***** ERROR : " + e.getMessage() + " *****");
		}

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * <br>
	 * 
	 * Cria o formulário atribuindo as classes de manutenção o tipo genérico informado.
	 */
	public <F> Formulario() {

		try {

			this.entidade = this.getTipoDaEntidade().newInstance();

			this.consulta = this.getTipoDaEntidade().newInstance();

		} catch (Exception e) {

			Logger.getLogger(this.getClass().getName()).info("***** ERROR : " + e.getMessage() + " *****");
		}
	}

	/**
	 * Método responsável por capturar o tipo da entidade através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <code>o tipo da entidade</code>.
	 */
	private Class<E> getTipoDaEntidade() {

		Type[] tipoEntidade = ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) tipoEntidade[0];
	}

	/**
	 * Retorna o valor do atributo <code>entidade</code>
	 *
	 * @return <code>E</code>
	 */
	public E getEntidade() {

		return entidade;
	}

	/**
	 * Define o valor do atributo <code>entidade</code>.
	 *
	 * @param entidade
	 */
	public void setEntidade(E entidade) {

		this.entidade = entidade;
	}

	/**
	 * Retorna o valor do atributo <code>consulta</code>
	 *
	 * @return <code>E</code>
	 */
	public E getConsulta() {

		return consulta;
	}

	/**
	 * Define o valor do atributo <code>consulta</code>.
	 *
	 * @param consulta
	 */
	public void setConsulta(E consulta) {

		this.consulta = consulta;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoEntidades</code>
	 *
	 * @return <code>Collection<E></code>
	 */
	public Collection<E> getColecaoEntidades() {

		return colecaoEntidades;
	}

	/**
	 * Define o valor do atributo <code>colecaoEntidades</code>.
	 *
	 * @param colecaoEntidades
	 */
	public void setColecaoEntidades(Collection<E> colecaoEntidades) {

		this.colecaoEntidades = colecaoEntidades;
	}

}
