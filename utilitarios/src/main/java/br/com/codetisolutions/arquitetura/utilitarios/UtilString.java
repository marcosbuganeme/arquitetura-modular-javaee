package br.com.codetisolutions.arquitetura.utilitarios;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> UtilString.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe utilitária para a manipulação de <code>STRING</code>.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class UtilString {

	/** Constante STRING_VAZIA. */
	public static final String STRING_VAZIA = "";

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UtilString() {

		super();
	}

	/**
	 * Método responsável por verificar se uma <code>String</code> possui referência e se esta <code>String</code> está vazia.
	 *
	 * @author marcosbuganeme
	 *
	 * @param string
	 * 
	 * @return
	 */
	public static boolean isVazio(final Object string) {

		return UtilString.isReferenciaMemoria(string) && UtilString.isStringValida(string) && ( (String) string ).trim().equals(UtilString.STRING_VAZIA);
	}

	/**
	 * Método responsável por verificar se objetos do tipo <code>String</code> não são vazias. <br>
	 * Continuando a cadeia de verificações.
	 *
	 * @author marcosbuganeme
	 *
	 * @param string1
	 *            - string que será verificada.
	 * 
	 * @param string2
	 *            - string que será verificada.
	 * 
	 * @return <i></i>
	 */
	public static boolean isVazio(final Object string1, final Object string2) {

		return UtilString.isVazio(string1) || UtilString.isVazio(string2);
	}

	/**
	 * Método responsável por verificar se vários objetos do tipo <code>String</code> estão vazios.
	 *
	 * @author marcosbuganeme
	 *
	 * @param arrayString
	 *            - o array de Strings que serão verificadas.
	 * 
	 * @return <i>{ TRUE, se o array de strings estiver vazio } <br>
	 *         { FALSE, se o array de strings <b>não</b> estiver vazio }</i>.
	 */
	public static boolean isVazioTodos(final Object... arrayString) {

		boolean stringVazia = true;

		if (UtilString.isVazio(arrayString)) {

			stringVazia = false;

			for (Object string : arrayString) {

				if (!stringVazia) {

					stringVazia = UtilString.isVazio(string);

				}

			}
		}

		return stringVazia;
	}

	/**
	 * Método responsável por verificar se duas strings são iguais.
	 *
	 * @author marcosbuganeme
	 *
	 * @param string1
	 * 
	 * @param string2
	 * 
	 * @return <i>{ TRUE, se o array de strings estiver vazio } <br>
	 *         { FALSE, se o array de strings <b>não</b> estiver vazio }</i>.
	 */
	public static boolean isStringIguais(final Object string1, final Object string2) {

		boolean resultadoStringIguais = false;

		if (!UtilString.isVazio(string1, string2)) {

			resultadoStringIguais = string1.equals(string2);

		}

		return resultadoStringIguais;
	}

	/**
	 * Método responsável por transformar em <b>maiscúlo</b> todos os caracteres de uma <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - que soferá a ação.
	 * 
	 * @return <i>uma string com caracteres maiusculos</i>.
	 */
	public static String maiuscula(final Object objeto) {

		String maiuscula = null;

		if (!UtilString.isVazio(objeto)) {

			maiuscula = ( (String) objeto ).toUpperCase();

		}

		return maiuscula;

	}

	/**
	 * Método responsável por transformar em <b>minuscúlo</b> todos os caracteres de uma <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - que soferá a ação.
	 * 
	 * @return <i>uma string com caracteres minusculos</i>.
	 */
	public static String minuscula(final Object objeto) {

		String minuscula = null;

		if (!UtilString.isVazio(objeto)) {

			minuscula = ( (String) objeto ).toLowerCase();

		}

		return minuscula;
	}

	/**
	 * Método responsável por alterar uma string por parâmetro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOrigem
	 *            - string que será modificada.
	 * 
	 * @param stringLocalizar
	 *            - string que será localizada.
	 * 
	 * @param stringSubstituir
	 *            - string que será substituida.
	 * 
	 * @return <i>string alterada</i>.
	 */
	public static String substituiString(final String stringOrigem, final String stringLocalizar, final String stringSubstituir) {

		String substituirString = stringOrigem;

		if (UtilString.isVazioTodos(stringOrigem, stringLocalizar, stringSubstituir)) {

			substituirString = stringOrigem.replaceAll(stringLocalizar, stringSubstituir);

		}

		return substituirString;
	}

	/**
	 * Método responsável por remover uma determinada string.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOrigem
	 *            - string que será modificada.
	 * 
	 * @param stringLocalizar
	 *            - string que será localizada.
	 * 
	 * @return <i>string alterada</i>.
	 */
	public static String removeString(final String stringOrigem, final String stringLocalizar) {

		String removerString = stringOrigem;

		if (!UtilString.isVazio(stringOrigem, stringLocalizar)) {

			removerString = stringOrigem.replaceAll(stringLocalizar, UtilString.STRING_VAZIA);

		}

		return removerString;
	}

	/**
	 * Método responsável por dividir uma string pelo seu delemitador.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOriginal
	 *            - string que será modificada.
	 * 
	 * @param delimitador
	 *            - caracteres que serão delimitados da string original.
	 * 
	 * @return <i>lista de caracteres divididos pelo delimitador</i>
	 */
	public static List<String> divideString(final String stringOriginal, final String delimitador) {

		final List<String> listaResultado = new ArrayList<String>();

		if (!UtilString.isVazio(stringOriginal) && !UtilString.isVazio(delimitador)) {

			final StringTokenizer stringToken = new StringTokenizer(stringOriginal, delimitador);

			while (stringToken.hasMoreTokens()) {

				listaResultado.add(stringToken.nextToken());
			}

		}

		return listaResultado;
	}

	/**
	 * Método responsável por remover o acento de uma <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOriginal
	 *            - string que seŕa modificada.
	 * 
	 * @return <i>string alterada</i>.
	 */
	public static String removeAcento(final String stringOriginal) {

		String stringResultado = null;

		if (!UtilString.isVazio(stringOriginal)) {

			stringResultado = Normalizer.normalize(stringOriginal, Normalizer.Form.NFD);

			stringResultado = stringResultado.replaceAll("[^\\p{ASCII}]", UtilString.STRING_VAZIA);

		}

		return stringResultado;

	}

	/**
	 * Método responsável por remover os números de uma <code>string</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOrigem
	 *            - string que será modificada.
	 * 
	 * @return <i>string alterada</i>.
	 */
	public static String removeNumero(final String stringOrigem) {

		String stringResultado = null;

		if (!UtilString.isVazio(stringOrigem)) {

			final String regex = "[-+]?[0-9]*";

			stringResultado = UtilString.removeString(stringOrigem, regex);

		}

		return stringResultado;

	}

	/**
	 * Método responsável por remover o sufixo de uma <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOrigem
	 *            - string que será modificada.
	 * 
	 * @param sufixo
	 *            - que será removido.
	 * 
	 * @return <i>string modificada</i>.
	 */
	public static String removeSufixo(final String stringOrigem, final String sufixo) {

		String stringSemSufixo = stringOrigem;

		if (!UtilString.isVazio(stringOrigem, sufixo) && stringOrigem.endsWith(sufixo)) {

			final int indiceInicial = 0;

			final int indiceFinal = stringOrigem.length() - sufixo.length();

			stringSemSufixo = stringOrigem.substring(indiceInicial, indiceFinal);
		}

		return stringSemSufixo;

	}

	/**
	 * Método responsável por remover o prefixo de uma <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param stringOrigem
	 *            - string que será modificada.
	 * 
	 * @param prefixo
	 *            - que será removido.
	 * 
	 * @return <i>string modificada</i>.
	 */
	public static String removePrefixo(final String stringOrigem, final String prefixo) {

		String stringSemPrefixo = stringOrigem;

		if (!UtilString.isVazio(stringOrigem, prefixo)) {

			final int delimitadorNumerico = 1;

			while (stringOrigem.startsWith(prefixo)) {

				stringSemPrefixo = stringOrigem.substring(delimitadorNumerico);

			}
		}

		return stringSemPrefixo;

	}

	/**
	 * Método responsável por retornar a <code>String</code> do objeto solicitado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto solicitado.
	 * 
	 * @return <i>string do objeto</i>
	 */
	public static String toString(final Object objeto) {

		String stringResultado = null;

		if (UtilString.isReferenciaMemoria(objeto) && UtilString.isStringValida(objeto)) {

			stringResultado = objeto.toString();

		}

		return stringResultado;
	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir instância de um String e se esta String <b>não</b> for vazia } <br>
	 *         { FALSE, se o objeto <b>não</b> possuir instância de STRING e/ou for vazia }</i>.
	 */
	private static boolean isReferenciaMemoria(final Object objeto) {

		return objeto != null;

	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir instância de um String e se esta String <b>não</b> for vazia } <br>
	 *         { FALSE, se o objeto <b>não</b> possuir instância de STRING e/ou for vazia }</i>.
	 */
	private static boolean isStringValida(final Object objeto) {

		return objeto instanceof String;

	}

	/**
	 * Método responsável por verificar o tamanho da <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param string
	 *            - stirng que será medida.
	 * 
	 * @return <i>tamanho da string</i>.
	 */
	public static int getTamanho(final String string) {

		int tamanhoString = 0;

		if (!UtilString.isVazio(string)) {

			tamanhoString = string.length();
		}

		return tamanhoString;
	}
}
