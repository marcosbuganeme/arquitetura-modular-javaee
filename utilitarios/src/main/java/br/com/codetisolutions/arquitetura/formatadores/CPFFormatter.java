package br.com.codetisolutions.arquitetura.formatadores;

import br.com.codetisolutions.arquitetura.pattern.PatternFormatacao;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> CPFFormatter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela formatação de CPFS.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class CPFFormatter extends Formatter {

	/** Atributo TAMANHO_CPF. */
	private static final int TAMANHO_CPF = 11;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public CPFFormatter() {

		super();
	}

	/**
	 * Método responsável por formatar o CPF parametrizado de acordo com o pattern definido para CPF. Veja a classe <code>FormatacaoPattern</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cpf
	 *            - cpf que será formatado.
	 * 
	 * @return <i>cpf formatado</i>.
	 */
	public static String formatarStringCPF(final String cpf) {

		String resultadoFormatacaoCPF = null;

		if (CPFFormatter.isCPFValido(cpf)) {

			resultadoFormatacaoCPF = Formatter.formatarString(cpf, PatternFormatacao.getCPF());
		}

		return resultadoFormatacaoCPF;
	}

	/**
	 * Método responsável por validar um cpf.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cpf
	 *            - cpf que será validado.
	 * 
	 * @return <i>cpf validado</i>.
	 */
	public static boolean isCPFValido(final String cpf) {

		return cpf != null && cpf.length() == CPFFormatter.TAMANHO_CPF;
	}
}
