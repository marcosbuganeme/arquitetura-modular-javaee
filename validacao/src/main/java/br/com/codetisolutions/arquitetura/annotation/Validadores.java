package br.com.codetisolutions.arquitetura.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Validadores.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Anotação responsável por obter uma lista de validadores de uma entidade.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validadores {

	/**
	 * Método responsável por obter os validadores de uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>os validadores de uma entidade</i>
	 */
	Validador[] validadores();
}
