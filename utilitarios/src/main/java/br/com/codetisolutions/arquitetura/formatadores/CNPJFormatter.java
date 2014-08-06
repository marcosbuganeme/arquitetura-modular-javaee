package br.com.codetisolutions.arquitetura.formatadores;

import br.com.codetisolutions.arquitetura.pattern.PatternFormatacao;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> CNPJFormatter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela formatação de CNPJ's.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class CNPJFormatter extends Formatter {

	/** Constante TAMANHO_CNPJ. */
	private static final int TAMANHO_CNPJ = 14;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public CNPJFormatter() {

	}

	/**
	 * Método responsável por formatar o CNPJ parametrizado de acordo com o pattern definido para CNPJ. Veja a classe <code>FormatacaoPattern</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cnpj
	 *            - cnpj que será formatado.
	 * 
	 * @return <i>string formatada de acordo com o pattern definido</i>.
	 */
	public static String formatarStringCNPJ(final String cnpj) {

		String resultadoFormatacaoCNPJ = null;

		if (CNPJFormatter.isCNPJValido(cnpj)) {

			resultadoFormatacaoCNPJ = Formatter.formatarString(cnpj, PatternFormatacao.getCNPJ());
		}

		return resultadoFormatacaoCNPJ;
	}

	/**
	 * Método responsável por verificar se o CNPJ é válido.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cnpj
	 *            - string que será validada.
	 * 
	 * @return <i>{ TRUE, o CNPJ é válido }<br>
	 *         { FALSE, o CNPJ <b>não</b> é válido }</i>.
	 */
	private static boolean isCNPJValido(final String cnpj) {

		return cnpj != null && cnpj.length() == CNPJFormatter.TAMANHO_CNPJ;
	}

}
