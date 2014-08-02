package br.com.codetisolutions.arquitetura.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.enuns.EnumEscopoValidacao;
import br.com.codetisolutions.arquitetura.validacao.Validacao;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Validador.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Anotação responsável pela validação de regras de negócio.
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
public @interface Validador {

	/**
	 * Método responsável por obter a classe de validação para a entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>classe de validação para a entidade</i>.
	 */
	Class<? extends Validacao<? extends Entidade>> validarClasse();

	/**
	 * Método responsável por obter o escopo de validação no qua o validador será executado.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o escopo em que irá reger a validação</i>.
	 */
	EnumEscopoValidacao escopoValidacao() default EnumEscopoValidacao.ALL;

}
