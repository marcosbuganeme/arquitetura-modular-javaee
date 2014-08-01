package br.com.codetisolutions.arquitetura.factorybundle;

import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ResourceBundleFactory.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela determinação de qual <code>ResourceBundle</code> será obtida as mensagens do sistema.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class ResourceBundleFactory {

	/**
	 * Método responsável por criar o resourceBundle para a aplicação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>resiyrceBundle para a aplicação</i>.
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * Método responsável por obter o resourceBundle a partir do factory parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param factoryClass
	 *            - classe do factory que irá prover a criação do resourceBundle.
	 * 
	 * @return <i>resourceBundle para a aplicação</i>.
	 */
	public static ResourceBundle getBundle(final Class<? extends ResourceBundleFactory> factoryClass) {

		try {

			return factoryClass.newInstance().getResourceBundle();

		} catch (final Exception e) {

			Logger.getLogger("factory.resourceBundle.ResourceBundleFactory").info(" ***** ERROR ***** : " + e.getMessage());
		}

		return null;
	}

}
