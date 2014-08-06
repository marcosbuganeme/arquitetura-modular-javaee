package br.com.codetisolutions.arquitetura.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

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
 * @param <E>
 * @param <D>
 *
 * @version 1.0.0
 */
public class ComboBoxConverter<E extends Entidade, D extends DAO<E>> implements Converter {

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent componente, final String value) {

		return null;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent componente, final Object objeto) {

		return null;
	}

}
