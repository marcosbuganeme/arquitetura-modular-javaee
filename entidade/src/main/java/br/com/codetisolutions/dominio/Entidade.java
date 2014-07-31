/**
 * 
 */
package br.com.codetisolutions.dominio;

import java.io.Serializable;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Entidade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 31/07/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface Entidade extends Serializable {

	/**
	 * Método responsável por capturar o ID do registro.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>identificador (id) do registro</i>
	 */
	Serializable getIdentificador();

	/**
	 * Método responsável por verificar se um determinado registro é novo.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>{ TRUE, se o objeto possuir id nulo } <br>
	 *         { FALSE, se o objeto <b>não</b> possuir id nulo }</i>.
	 */
	boolean isNovoRegistro();
}
