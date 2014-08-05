package br.com.codetisolutions.arquitetura.utilitarios;

import java.io.Reader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> UtilObjeto.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe utilitária que ajuda na manipulação de objetos.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public final class UtilObjeto {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UtilObjeto() {

		super();
	}

	/**
	 * Método responsável por capturar a classe do objeto parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - que terá a classe capturada.
	 * 
	 * @return <i>classe do objeto</i>.
	 */
	public static <T> Class<T> getClasse(final T objeto) {

		Class<T> classe = null;

		if (UtilObjeto.isReferenciaMemoria(objeto)) {

			if (UtilObjeto.isClasse(objeto)) {

				classe = (Class<T>) objeto;

			} else {

				classe = (Class<T>) objeto.getClass();
			}

		}

		return classe;
	}

	/**
	 * Método responsável por verificar o tipo da classe de um objeto parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será verificado.
	 * 
	 * @param tipoClasse
	 *            - tipo da classe que deseja verificar.
	 * 
	 * @return <i>{ True, objeto é do tipo da classe parametrizada }<br>
	 *         { False, objeto <b>não</b> é do tipo da classe parametrizada }</i>.
	 */
	public static boolean isObjetoDoTIpo(final Object objeto, final Class<?> tipoClasse) {

		boolean resultadoObjeto = false;

		if (UtilObjeto.isReferenciaMemoria(objeto, tipoClasse)) {

			final Class<?> classeObjeto = UtilObjeto.getClasse(objeto);

			resultadoObjeto = tipoClasse.isAssignableFrom(classeObjeto);
		}

		return resultadoObjeto;
	}

	/**
	 * Método responsável por verificar se um determinado objeto parametrizado é uma Classe.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - que soferá a validação.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância de uma classe }<br>
	 *         { FALSE, o objeto não possui referência e/ou instância de uma classe }</i>.
	 */
	public static boolean isClasse(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Class;
	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir referência em memória } <br>
	 *         { FALSE, se o objeto <b>não</b> possui referência em memória }</i>
	 */
	public static boolean isReferenciaMemoria(final Object objeto) {

		return objeto != null;
	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto1
	 *            - objeto que será validado.
	 * 
	 * @param objeto2
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se os objetos possuirem referências em memória } <br>
	 *         { FALSE, se os objetos <b>não</b> possuirem referências em memória }</i>
	 */
	public static boolean isReferenciaMemoria(final Object objeto1, final Object objeto2) {

		return UtilObjeto.isReferenciaMemoria(objeto1) && UtilObjeto.isReferenciaMemoria(objeto2);
	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @param objeto2
	 *            - objeto que será validado.
	 * 
	 * @param objeto3
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se os objetos possuirem referências em memória } <br>
	 *         { FALSE, se os objetos <b>não</b> possuirem referências em memória }</i>
	 */
	public static boolean isReferenciaMemoria(final Object objeto1, final Object objeto2, final Object objeto3) {

		return UtilObjeto.isReferenciaMemoria(objeto1, objeto2) && UtilObjeto.isReferenciaMemoria(objeto3);
	}

	/**
	 * Método responsável por verificar se objeto parametrizado possui referência de <code>String</code> e se este objeto é vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objetos
	 *            - objetos que serão validados.
	 * 
	 * @return <i>{ TRUE, se os objetos possuirem referências em memória } <br>
	 *         { FALSE, se os objetos <b>não</b> possuirem referências em memória }</i>
	 */
	public static boolean isReferenciaMemoria(final Object... objetos) {

		boolean isReferenciaMemoria = false;

		if (UtilObjeto.isReferenciaMemoria(objetos)) {

			isReferenciaMemoria = true;

			for (final Object objeto : objetos) {

				if (isReferenciaMemoria) {

					isReferenciaMemoria = UtilObjeto.isReferenciaMemoria(objeto);
				}

			}

		}

		return isReferenciaMemoria;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Collection</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir instância do tipo Collection } <br>
	 *         { FALSE, se o objeto <b>não</b> possuir instância do tipo Collection }</i>.
	 */
	public static boolean isColecao(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Collection<?>;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Collection</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se a classe possuir instância do tipo Collection } <br>
	 *         { FALSE, se a classe <b>não</b> for do tipo Collection }</i>.
	 */
	public static boolean isColecao(final Class<?> classe) {

		final Class<?> classeCollection = Collection.class;

		return UtilObjeto.isReferenciaMemoria(classe) && classeCollection.isAssignableFrom(classe);
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Comparable</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Comparable }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Comparable }</i>.
	 */
	public static boolean isComparable(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Comparable<?>;
	}

	/**
	 * Método responsável por verificar se uma classe parametrizado é do tipo <code>Comparable</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, a classe possui referência e é do tipo Comparable }<br>
	 *         { FALSE, a classe <b>não</b> possui referência e/ou é do tipo Comparable }</i>.
	 */
	public static boolean isComparable(final Class<?> classe) {

		final Class<?> classeComparable = Comparable.class;

		return UtilObjeto.isReferenciaMemoria(classe) && classeComparable.isAssignableFrom(classe);
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Map</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Map }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Map }</i>.
	 */
	public static boolean isMapa(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Map<?, ?>;
	}

	/**
	 * Método responsável por verificar se uma classe parametrizado é do tipo <code>Map</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, a classe possui referência e é do tipo Map }<br>
	 *         { FALSE, a classe <b>não</b> possui referência e/ou é do tipo Map }</i>.
	 */
	public static boolean isMapa(final Class<?> classe) {

		final Class<?> classeMapa = Map.class;

		return UtilObjeto.isReferenciaMemoria(classe) && classeMapa.isAssignableFrom(classe);
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Integer</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Integer }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Integer }</i>.
	 */
	public static boolean isInteger(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Integer;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Long</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Long }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Long }</i>.
	 */
	public static boolean isLong(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Integer;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Boolean</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Boolean }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Boolean }</i>.
	 */
	public static boolean isBoolean(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Boolean;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Byte</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Byte }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Byte }</i>.
	 */
	public static boolean isByte(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Byte;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Short</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Short }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Short }</i>.
	 */
	public static boolean isShort(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Short;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Character</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Character }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Character }</i>.
	 */
	public static boolean isCharacter(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Character;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Float</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Float }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Float }</i>.
	 */
	public static boolean isFloat(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Float;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Double</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Double }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Double }</i>.
	 */
	public static boolean isDouble(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Double;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>String</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe String }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe String }</i>.
	 */
	public static boolean isString(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof String;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Date</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Date }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Date }</i>.
	 */
	public static boolean isDate(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Date;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>{@link java.sql.Date}</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe {@link java.sql.Date} <br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe {@link java.sql.Date} </i>.
	 */
	public static boolean isSqlDate(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof java.sql.Date;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>{@link java.sql.Time}</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe {@link java.sql.Time} <br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe {@link java.sql.Time} </i>.
	 */
	public static boolean isSqlTime(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof java.sql.Time;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>{@link java.sql.Timestamp}</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe {@link java.sql.Timestamp} <br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe {@link java.sql.Timestamp} </i>.
	 */
	public static boolean isTimeStamp(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof java.sql.Timestamp;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>Reader</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe Reader }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe Reader }</i>.
	 */
	public static boolean isReader(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof Reader;
	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui instância de uma <code>BigDecimal</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, o objeto possui referência e instância da classe BigDecimal }<br>
	 *         { FALSE, o objeto <b>não</b> possui referência e/ou instância da classe BigDecimal }</i>.
	 */
	public static boolean isBigDecimal(final Object objeto) {

		return UtilObjeto.isReferenciaMemoria(objeto) && objeto instanceof BigDecimal;
	}

}
