package br.com.codetisolutions.arquitetura.jsf.converters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> DateConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por converter objetos do tipo Date.
 * </p>
 *
 * Data de criação: 05/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class DateConverter implements Converter {

	/** Constante PATTERN_FORMATACAO_DATA. */
	private static final String PATTERN_FORMATACAO_DATA = "dd/MM/yyyy";

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

		Date data = null;

		boolean erro = false;

		try {

			if (value != null && !"".equals(value) && value.indexOf("_") == -1) {

				if (DateConverter.isDataValida(value)) {

					data = new SimpleDateFormat(DateConverter.PATTERN_FORMATACAO_DATA).parse(value);

				} else {

					erro = true;
				}
			}

		} catch (final Exception e) {

			erro = true;
		}

		if (erro) {

			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("A data especificada é inválida" + value));
		}

		return data;
	}

	/**
	 * Método responsável por validar uma data parametrizada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param data
	 *            - data que será validada.
	 * 
	 * @return { TRUE, se a data for válida }<br>
	 *         { FALSE, se a data <b>não</b> for válida}.
	 */
	private static boolean isDataValida(final String data) {

		boolean resultadoDataValida = false;

		try {

			final String[] dataDividida = data.split("/");

			final int dia = Integer.parseInt(dataDividida[0]);

			final int mes = Integer.parseInt(dataDividida[1]);

			final int ano = Integer.parseInt(dataDividida[2]);

			int quantidadeDiasNoMes = 0;

			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {

				quantidadeDiasNoMes = 31;

			} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {

				quantidadeDiasNoMes = 30;

			} else if (mes == 2) {

				quantidadeDiasNoMes = ( ano % 4 == 0 ) ? 29 : 28;
			}

			resultadoDataValida = ( dia < 1 || dia > quantidadeDiasNoMes ) ? false : true;

		} catch (final Exception exception) {

			resultadoDataValida = false;

			Logger.getLogger("***** ERRO NA CLASSE ").info(DateConverter.class.getSimpleName() + ":>:> MOTIVO :>:>" + exception.getMessage() + " *****");
		}

		return resultadoDataValida;
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

		String value = "";

		if (objeto != null) {

			value = new SimpleDateFormat(DateConverter.PATTERN_FORMATACAO_DATA).format(objeto);
		}

		return value;
	}
}
