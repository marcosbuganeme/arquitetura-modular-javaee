package br.com.codetisolutions.arquitetura.jsf.converters;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> BigDecimalConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Conversor de objetos BigDecimal.
 * </p>
 *
 * Data de criação: 05/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class BigDecimalConverter implements Converter {

	/**
	 * Descrição Padrão: <br>
	 * Obtem o Object vinculado ao value parametrizado. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent componente, String value) {

		Object objeto = null;

		try {

			if (value != null && !"".equals(value)) {

				value = value.replaceAll("\\.", "").replaceAll(",", ".");

				objeto = new BigDecimal(value);
			}

		} catch (Exception exception) {

			Logger.getLogger("***** ERRO ").info(this.getClass().getSimpleName() + " :>:> MOTIVO :>:> " + exception.getMessage() + " *****");
		}

		return objeto;
	}

	/**
	 * Descrição Padrão: <br>
	 * Obtem a String vinculada ao objeto parametrizado. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent componente, final Object objeto) {

		String value = "";

		if (objeto != null) {

			value = new DecimalFormat("#,##0.00").format(objeto);
		}

		return value;
	}

}
