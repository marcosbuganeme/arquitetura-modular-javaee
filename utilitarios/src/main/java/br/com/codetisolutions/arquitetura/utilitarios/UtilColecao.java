package br.com.codetisolutions.arquitetura.utilitarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> UtilColecao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe utilitária para manipulação e validação de coleções.
 * </p>
 *
 * Data de criação: 01/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class UtilColecao {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private UtilColecao() {

		super();
	}

	/**
	 * Método responsável por verificar se uma lista parametrizada contêm elementos.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - coleção que será validada.
	 * 
	 * @return <i>{ TRUE, se a lista estiver vazia }<br>
	 *         { FALSE, se a lista <b>não</b> estiver vazia }</i>.
	 */
	public static boolean isVazio(final Collection<?> colecaoDados) {

		return ( UtilColecao.getTamanhoColecao(colecaoDados) == 0 );
	}

	/**
	 * Método responsável por capturar a quantidade de elementos que estão contidos em uma lista.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista de dados que terá o tamanho verificado.
	 * 
	 * @return <i>o numero máximo de elementos que estão contidos na lista</i>.
	 */
	public static int getTamanhoColecao(final Collection<?> colecaoDados) {

		int tamanhoDaColecao = 0;

		if (UtilColecao.isReferenciaMemoria(colecaoDados)) {

			tamanhoDaColecao = colecaoDados.size();
		}

		return tamanhoDaColecao;

	}

	/**
	 * Método responsável por recuperar o valor do elemetno que está referenciado em um determinado índice da coleção de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista que contêm o elemento que será recuperado.
	 * 
	 * @param indice
	 *            - posição da lista em que o elemento se encontra.
	 * 
	 * @return <i>o elemento recuperado da coleção de dados</i>.
	 */
	public static <E> E getElementoDoIndice(final List<E> colecaoDados, final int indice) {

		E resultadoElementoDoIndice = null;

		if (!UtilColecao.isVazio(colecaoDados) && indice >= 0 && indice < colecaoDados.size()) {

			resultadoElementoDoIndice = colecaoDados.get(indice);
		}

		return resultadoElementoDoIndice;

	}

	/**
	 * Método responsável por recuperar o valor do elemetno que está referenciado em um determinado índice da coleção de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista que contêm o elemento que será capturado.
	 * 
	 * @param indice
	 *            - posição da lista em que o elemento se encontra.
	 * 
	 * @return <i>o elemento recuperado da coleção de dados</i>.
	 */
	public static <E> E getElementoDoIndice(final Collection<E> colecaoDados, final int indice) {

		final List<E> lista = new ArrayList<E>(colecaoDados);

		return getElementoDoIndice(lista, indice);
	}

	/**
	 * Método responsável por recuperar o último elemento de uma coleção de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista que contêm o elemento que será recuperado.
	 * 
	 * @return <i>o último elemento da coleção de dados</i>.
	 */
	public static <E> E getUltimoElementoDaColecao(final Collection<E> colecaoDados) {

		final int ultimaPosicaoColecao = colecaoDados.size() - 1;

		return UtilColecao.getElementoDoIndice(colecaoDados, ultimaPosicaoColecao);
	}

	/**
	 * Método responsável por ordenar os elementos da coleção. <br>
	 * Os objetos deverão implementar <code>Comparable</code> para que a ordenação seja feita.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista que será ordenada.
	 * 
	 * @return <i>coleção de dados ordenada</i>.
	 */
	public static <E extends Comparable<? super E>> Collection<E> ordenar(final Collection<E> colecaoDados) {

		List<E> resultadoListaOrdenada = null;

		if (UtilColecao.isReferenciaMemoria(colecaoDados)) {

			resultadoListaOrdenada = new ArrayList<E>(colecaoDados);

			Collections.sort(resultadoListaOrdenada);
		}

		return resultadoListaOrdenada;
	}

	/**
	 * Método responsável por ordenar uma coleção de dados com base no <code>Comparator</code> parametrizado no escopo do método.
	 *
	 * @author marcosbuganeme
	 *
	 * @param colecaoDados
	 *            - lista que seŕa ordenada.
	 * 
	 * @param comparador
	 *            - filtro de comparação.
	 * 
	 * @return <i>coleção de dados ordenada</i>.
	 */
	public static <T> Collection<T> ordenar(final Collection<T> colecaoDados, final Comparator<? super T> comparador) {

		if (UtilColecao.isReferenciaMemoria(colecaoDados) && UtilColecao.isReferenciaMemoria(comparador)) {

			Collections.sort((List<T>) colecaoDados, comparador);

		}

		return colecaoDados;

	}

	/**
	 * Método responsável por verificar se um objeto parametrizado possui referência em memória.
	 *
	 * @author marcosbuganeme
	 *
	 * @param objeto
	 *            - que será validado.
	 * 
	 * @return <i>{ TRUE, se o objeto possuir referência em memória } <br>
	 *         { FALSE, se o objeto <b>não</b> possuir referência em memória }</i>.
	 */
	private static boolean isReferenciaMemoria(final Object objeto) {

		return objeto != null;
	}

}
