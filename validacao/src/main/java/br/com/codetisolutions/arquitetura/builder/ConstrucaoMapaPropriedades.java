package br.com.codetisolutions.arquitetura.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ConstrucaoMapaPropriedades.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe que auxilia na manipulação de mapas de propriedades.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class ConstrucaoMapaPropriedades {

	/** Atributo mapaPropriedades. */
	private Map<String, String> mapaPropriedades;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ConstrucaoMapaPropriedades() {

		this.mapaPropriedades = new HashMap<String, String>();
	}

	/**
	 * Método responsável por criar o mapa de propriedades.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>mapa de propriedades</i>.
	 */
	public static ConstrucaoMapaPropriedades criar() {

		return new ConstrucaoMapaPropriedades();
	}

	/**
	 * Método responsável por adicionar um registro ao mapa de propriedades.
	 *
	 * @author marcosbuganeme
	 *
	 * @param propriedadeEntidade
	 *            - propriedade da entidade.
	 * 
	 * @param campoVisao
	 *            - campo do arquivo properties que representa o campo.
	 * 
	 * @return <i>mapa de propriedades</i>.
	 */
	public ConstrucaoMapaPropriedades adicionar(final String propriedadeEntidade, final String campoVisao) {

		this.getMapaPropriedades().put(propriedadeEntidade, campoVisao);

		return this;
	}

	/**
	 * Método responsável por adicionar um registro ao mapa de propriedades.
	 *
	 * @author marcosbuganeme
	 *
	 * @param propriedadeEntidade
	 *            - propriedade da entidade.
	 * 
	 * @param campoVisao
	 *            - campo do arquivo properties que representa o campo.
	 * 
	 * @param condicao
	 *            - critério para adicionar o novo campo ao mapa de propriedades.
	 * 
	 * @return <i>mapa de propriedades</i>.
	 */
	public ConstrucaoMapaPropriedades adicionar(final String propriedadeEntidade, final String campoVisao, final boolean condicao) {

		if (condicao) {

			this.getMapaPropriedades().put(propriedadeEntidade, propriedadeEntidade);
		}

		return this;
	}

	/**
	 * Retorna o valor do atributo <code>mapaPropriedades</code>
	 *
	 * @return <code>Map<String,String></code>
	 */
	public final Map<String, String> getMapaPropriedades() {

		return mapaPropriedades;
	}

}
