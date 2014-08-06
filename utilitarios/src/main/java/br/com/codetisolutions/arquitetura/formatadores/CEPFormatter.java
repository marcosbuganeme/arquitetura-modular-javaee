package br.com.codetisolutions.arquitetura.formatadores;

import br.com.codetisolutions.arquitetura.pattern.FormatacaoPattern;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> CEPFormatter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela formatação de CEPS.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class CEPFormatter extends Formatter {

	/** Atributo TAMANHO_CEP. */
	private static final int TAMANHO_CEP = 8;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public CEPFormatter() {

		super();
	}

	/**
	 * Método responsável por formatar o cep de acordo com o pattern passado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cep
	 *            - cep que será formatado.
	 * 
	 * @return <i>cep formatado</i>.
	 */
	public static String formatarCep(final String cep) {

		String resultadoFormatacaoCep = null;

		if (CEPFormatter.isCepValido(cep)) {

			resultadoFormatacaoCep = Formatter.formatarString(cep, FormatacaoPattern.getCEP());
		}

		return resultadoFormatacaoCep;
	}

	/**
	 * Método responsável por validar um cep.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cep
	 *            - que será validado.
	 * 
	 * @return <i>cep validado</i>.
	 */
	public static boolean isCepValido(final String cep) {

		return ( ( cep != null ) && ( cep.length() == CEPFormatter.TAMANHO_CEP ) );
	}
}
