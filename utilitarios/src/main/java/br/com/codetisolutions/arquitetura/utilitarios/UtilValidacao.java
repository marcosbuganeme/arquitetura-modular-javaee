package br.com.codetisolutions.arquitetura.utilitarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.beanutils.PropertyUtils;

import br.com.codetisolutions.arquitetura.annotation.Validador;
import br.com.codetisolutions.arquitetura.annotation.Validadores;
import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.enuns.EnumEscopoValidacao;
import br.com.codetisolutions.arquitetura.validacao.Validacao;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> UtilValidacao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe utilitária responsável pela validação dos validadores de uma ou mais entidades.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public class UtilValidacao<E extends Entidade> {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UtilValidacao() {

		super();
	}

	/**
	 * Método responsável por obter as classes dos validadores para a entidade parametrizada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param classeDaEntidade
	 * 
	 * @param escopoValidacao
	 * 
	 * @return
	 */
	public static <E extends Entidade> List<Class<?>> getValidadores(final Class<E> classeDaEntidade, final EnumEscopoValidacao escopoValidacao) {

		final List<Class<?>> validadores = new ArrayList<Class<?>>();

		if (UtilValidacao.isReferenciaMemoria(classeDaEntidade) && classeDaEntidade.isAnnotationPresent(Validadores.class)) {

			final Validador[] contemListaValidadores = classeDaEntidade.getAnnotation(Validadores.class).validadores();

			for (final Validador validador : contemListaValidadores) {

				if (EnumEscopoValidacao.ALL.equals(validador.escopoValidacao()) || validador.escopoValidacao().equals(escopoValidacao)) {

					validadores.add(validador.validarClasse());

				}
			}
		}

		return validadores;
	}

	/**
	 * Método responsável por executar as validações na entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será validado.
	 * 
	 * @param escopoValidacao
	 * 
	 * @throws ValidacaoException
	 */
	public void validar(final E entidade, final EnumEscopoValidacao escopoValidacao) throws ValidacaoException {

		final List<Class<?>> capturaListaValidadores = UtilValidacao.getValidadores(entidade.getClass(), escopoValidacao);

		if (UtilValidacao.isReferenciaMemoria(capturaListaValidadores) && capturaListaValidadores.size() > 0) {

			for (final Class<?> classeValidadora : capturaListaValidadores) {

				Validacao<E> validacao = null;

				try {

					validacao = (Validacao<E>) classeValidadora.newInstance();

					Logger.getLogger(this.getClass().getName()).info("***** EXECUTANDO ***** : " + validacao.getDescricao());

				} catch (final Exception e) {

					Logger.getLogger(this.getClass().getName()).info("***** ERROR ***** : " + e.getMessage());
				}

				validacao.validar(entidade);

			}
		}

	}

	/**
	 * Método responsável por validar as propriedades do bean como não nulo, ou, se for <code>String</code> como não vazio.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será validado.
	 * 
	 * @param mapaPropriedades
	 *            - mapa com as {propriedades, campos} que serão validados.
	 * 
	 * @return <i>campos nulos</i>.
	 */
	public static Collection<String> validarPropriedadesObrigatorias(final Object entidade, final Map<String, String> mapaPropriedades) {

		final Map<String, String> mapaPropriedadesValorados = mapaPropriedades;

		final List<String> camposNulos = new ArrayList<String>();

		if (UtilValidacao.isReferenciaMemoria(mapaPropriedadesValorados)) {

			for (final String propriedade : camposNulos) {

				if (!UtilValidacao.isReferenciaMemoria(camposNulos)) {

					camposNulos.add(mapaPropriedadesValorados.get(propriedade));
				} else {

					Object objeto;

					try {

						objeto = PropertyUtils.getProperty(entidade, propriedade);

						if (UtilValidacao.isReferenciaMemoria(objeto)) {

							camposNulos.add(mapaPropriedadesValorados.get(propriedade));

						}

					} catch (final Exception e) {

						Logger.getLogger(UtilValidacao.class.getName()).info("***** ERROR ***** :" + e.getMessage());

					}
				}

			}

		}

		return camposNulos;
	}

	/**
	 * Método responsável por verificar se o objeto parametrizado possui referência em memória.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possui referência em memória } <br>
	 *         { FALSE, se o objeto <b>não</b> possui referência em memória}</i>.
	 */
	private static boolean isReferenciaMemoria(final Object objeto) {

		if (objeto == null) {

			return false;

		}

		return UtilValidacao.isStringValida(objeto);
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

		if (objeto instanceof String && ( (String) objeto ).isEmpty()) {

			return false;

		}

		return UtilValidacao.isColecaoValida(objeto);
	}

	/**
	 * Método responsável por verificar se o objeto possui instancia de <code>Collection</code> e validar se esta é ou não uma coleção vazia.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - objeto que será validado. -
	 * 
	 * @return <i>{ TRUE, se o objeto possui instancia de Collection e se esta Collection não for vazia } <br>
	 *         { FALSE, se o objeto <b>não</b> possuir instância de Collection e/ou for vazia }</i>.
	 */
	private static boolean isColecaoValida(final Object objeto) {

		if (objeto instanceof Collection<?> && ( (Collection<?>) objeto ).isEmpty()) {

			return false;

		}

		return true;
	}
}
