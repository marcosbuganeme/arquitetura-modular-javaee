package br.com.codetisolutions.arquitetura.utilitarios;

import java.util.ResourceBundle;

import br.com.codetisolutions.arquitetura.factorybundle.ResourceBundleFactory;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> UtilResourceBundle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 04/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class UtilResourceBundle {

	public UtilResourceBundle() {

	}

	/**
	 * Método responsável por capturar o valor do atributo vinculado ao resouceBundle da aplicação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o valor do atributo bundle da aplicação</i>.
	 */
	public ResourceBundle getBundle() {

		return  ResourceBundleFactory.getBundle(UtilResourceBundle.getResourceBundleFactory());
	}

	/**
	 * Método responsável por obter o <code>ResourceBundleFactory</code> para o controlador.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o ResouceBundleFactory para a aplicação</i>.
	 */
	public static Class<? extends ResourceBundleFactory> getResourceBundleFactory() {

		return null;
	}

}
