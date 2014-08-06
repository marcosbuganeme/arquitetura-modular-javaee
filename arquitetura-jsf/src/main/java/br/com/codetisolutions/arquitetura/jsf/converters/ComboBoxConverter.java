package br.com.codetisolutions.arquitetura.jsf.converters;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;
import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.persistencia.DAO;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ComboBoxConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 05/08/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe extensora.
 * 
 * @param <D>
 *            - DAO que será manipulado pela classe extensora.
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class ComboBoxConverter<E extends Entidade, D extends DAO<E>> implements Converter {

	/** Atributo dao. */
	private D dao;

	/**
	 * Descrição Padrão: <br>
	 * Converte para o tipo <code>Object</code>. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent componente, final String value) throws ConverterException {

		if (value != null && !"".equals(value)) {

			try {

				final Field campoID = this.getTipoEntidade().getDeclaredField("id");

				final Class<?> classe = campoID.getType();

				final String nomeClasse = classe.getSimpleName();

				if (nomeClasse.equals(Long.class.getSimpleName())) {

					return this.getDao().obter(Long.parseLong(value));

				} else if (nomeClasse.equals(Integer.class.getSimpleName())) {

					return this.getDao().obter(Integer.parseInt(value));
				}

			} catch (final Throwable exception) {

				Logger.getLogger("***** ERRO NA CLASSE :>:> ").info(this.getClass().getSimpleName() + " :>:> " + " MOTIVO" + exception.getMessage() + " *****");
			}

		}

		return null;
	}

	/**
	 * Descrição Padrão: <br>
	 * Converte para o tipo <code>String</code>. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent componente, final Object objeto) throws ConverterException {


		return null;
	}

	/**
	 * Método responsável por recuperar o tipo da entidade através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <code>tipo da entidade</code>.
	 */
	protected Class<E> getTipoEntidade() {

		return (Class<E>) this.getTypeGenerics()[0];
	}

	/**
	 * Método responsável por recuperar o tipo do dao através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <code>tipo do dao</code>
	 */
	protected Class<D> getTipoDAO() {

		return (Class<D>) this.getTypeGenerics()[1];
	}

	/**
	 * Método responsável por obter os tipos genericos utilizados nesta classe.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <code>tipos genericos</code>
	 */
	protected Type[] getTypeGenerics() {

		return ( (ParameterizedTypeImpl) this.getClass().getGenericSuperclass() ).getActualTypeArguments();
	}

	/**
	 * Retorna o valor do atributo <code>dao</code>
	 *
	 * @return <code>D</code>
	 */
	public D getDao() {

		if (this.dao == null) {

			try {

				this.dao = this.getTipoDAO().newInstance();

			} catch (final Exception e) {

				Logger.getLogger("***** ERRO NA CLASSE :>:> ").info(this.getClass().getSimpleName() + " :>:> MOTIVO :>:> " + e.getMessage() + " *****");
			}
		}

		return this.dao;
	}
}
