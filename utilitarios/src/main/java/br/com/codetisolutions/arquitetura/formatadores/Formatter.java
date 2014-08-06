package br.com.codetisolutions.arquitetura.formatadores;

import javax.swing.JFormattedTextField;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Formatter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelas operações de formatação de objetos.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class Formatter {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	protected Formatter() {

		super();
	}

	/**
	 * Método responsável por formatar uma string de acordo com o pattern parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param string
	 *            - String que será formatada.
	 * 
	 * @param pattern
	 *            - pattern que será utilizado na formatação.
	 * 
	 * @return <i>string formatada de acordo com o pattern repassado</i>.
	 */
	protected static String formatarString(final String string, final String pattern) {

		final JFormattedTextField formatar = new JFormattedTextField(pattern);

		formatar.setText(string);

		return formatar.getText();
	}

}
