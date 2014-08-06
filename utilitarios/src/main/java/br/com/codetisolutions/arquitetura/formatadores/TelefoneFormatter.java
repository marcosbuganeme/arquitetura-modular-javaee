package br.com.codetisolutions.arquitetura.formatadores;

import java.util.HashMap;
import java.util.Map;

import br.com.codetisolutions.arquitetura.pattern.PatternFormatacao;
import br.com.codetisolutions.arquitetura.utilitarios.UtilString;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> TelefoneFormatter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela formatação de telefones.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class TelefoneFormatter extends Formatter {

	/** Atributo mapPatterns. */
	private static Map<Integer, String> mapPatterns;

	/** Constante NUMERO_CARACTERES_TELEFONE_OITO_DIGITOS. */
	private static final int NUMERO_CARACTERES_TELEFONE_OITO_DIGITOS = 8;

	/** Atributo NUMERO_CARACTERES_TELEFONE_CELULAR_NOVE_DIGITOS. */
	private static final int NUMERO_CARACTERES_TELEFONE_CELULAR_NOVE_DIGITOS = 9;

	/** Constante NUMERO_CARACTERES_TELEFONE_DEZ_DIGITOS. */
	private static final int NUMERO_CARACTERES_TELEFONE_DEZ_DIGITOS = 10;

	/** Constante NUMERO_CARACTERES_TELEFONE_DOZE_DIGITOS. */
	private static final int NUMERO_CARACTERES_TELEFONE_DOZE_DIGITOS = 12;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public TelefoneFormatter() {

		super();
	}

	/**
	 * Método responsável por formatar o telefone parametrizado de acordo com os patterns definidos para telefone/celular. Veja a classe <code>FormatacaoPattern</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param telefone
	 *            - string que será formatada.
	 * 
	 * @return <i>string formatada de acordo com o pattern definido</i>.
	 */
	public static String formatarStringTelefone(final String telefone) {

		String resultadoFormatacaoTelefone = null;

		if (TelefoneFormatter.isTelefoneValido(telefone)) {

			final String telefonePattern = TelefoneFormatter.getPattern(telefone);

			resultadoFormatacaoTelefone = Formatter.formatarString(telefone, telefonePattern);
		}

		return resultadoFormatacaoTelefone;
	}

	/**
	 * Método responsável por verificar se o telefone é válido.
	 *
	 * @author marcosbuganeme
	 *
	 * @param telefone
	 *            - string que será validada.
	 * 
	 * @return <i>{ TRUE, se o telefone for válido }<br>
	 *         { FALSE, se o telefone <b>não</b> for válido}</i>.
	 */
	private static boolean isTelefoneValido(final String telefone) {

		return telefone != null && TelefoneFormatter.isTamanhoTelefoneValido(telefone);
	}

	/**
	 * Método responsável por verificar se o tamanho do telefone é válido.
	 *
	 * @author marcosbuganeme
	 *
	 * @param telefone
	 *            - string que será validado.
	 * 
	 * @return <i>{ TRUE, se o tamanho do telefone for válido }<br>
	 *         { FALSE, se o tamanho do telefone <b>não</b> for válido }</i>.
	 */
	private static boolean isTamanhoTelefoneValido(final String telefone) {

		final int tamanho = UtilString.getTamanho(telefone);

		return tamanho == TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_OITO_DIGITOS || tamanho == TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_DEZ_DIGITOS || tamanho == TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_DOZE_DIGITOS || tamanho == TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_CELULAR_NOVE_DIGITOS;
	}

	/**
	 * Método responsável por obter qual é o pattern do telefone parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param telefone
	 *            - string que terá seu pattern obtido.
	 * 
	 * @return <i>obter o pattern do telefone</i>.
	 */
	private static String getPattern(final String telefone) {

		final int tamanhoTelefone = UtilString.getTamanho(telefone);

		return TelefoneFormatter.getPatterns().get(Integer.valueOf(tamanhoTelefone));
	}

	/**
	 * Método responsável por validar todos os possíveis patterns para telefone/celular.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>mapa que contêm os patterns para telefone/celular</i>.
	 */
	private static Map<Integer, String> getPatterns() {

		if (TelefoneFormatter.mapPatterns == null) {

			TelefoneFormatter.mapPatterns = new HashMap<Integer, String>();

			TelefoneFormatter.mapPatterns.put(Integer.valueOf(TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_OITO_DIGITOS), PatternFormatacao.getTelefoneOitoDigitos());

			TelefoneFormatter.mapPatterns.put(Integer.valueOf(TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_CELULAR_NOVE_DIGITOS), PatternFormatacao.getTelefoneCelularNoveDigitos());

			TelefoneFormatter.mapPatterns.put(Integer.valueOf(TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_DEZ_DIGITOS), PatternFormatacao.getTelefoneDezDigitos());

			TelefoneFormatter.mapPatterns.put(Integer.valueOf(TelefoneFormatter.NUMERO_CARACTERES_TELEFONE_DOZE_DIGITOS), PatternFormatacao.getTelefoneDozeDigitos());
		}

		return TelefoneFormatter.mapPatterns;
	}
}
