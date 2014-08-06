package br.com.codetisolutions.arquitetura.formatadores;

import br.com.codetisolutions.arquitetura.pattern.PatternFormatacao;
import br.com.codetisolutions.arquitetura.utilitarios.UtilString;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> CartaoFormatter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por formatar os números de cartões de créditos.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class CartaoCreditoFormatter extends Formatter {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private CartaoCreditoFormatter() {

		super();
	}

	/**
	 * Método responsável por formatar o cartão de crédito parametrizado de acordo com o pattern definido para Cartão de Crédito. Veja a classe <code>FormatacaoPattern</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param numeroCartao
	 *            - String que representa o número do cartão de crédito.
	 * 
	 * @return <i>cartão formatado</i>
	 */
	public static String formatarStringCartaoCredito(final String numeroCartao) {

		String resultadoFormatarCartao = null;

		if (numeroCartao != null && !"".equals(numeroCartao)) {

			final String patternFormatacaoCartao = PatternFormatacao.getCartaoCredito();

			resultadoFormatarCartao = Formatter.formatarString(numeroCartao, patternFormatacaoCartao);

		}

		return resultadoFormatarCartao;
	}

	/**
	 * Método responsável por formatar o cartão de crédito.
	 *
	 * @author marcosbuganeme
	 *
	 * @param numeroCartao
	 *            - Number que representa o número do cartão de crédito.
	 * 
	 * @return <i>cartão formatado</i>
	 */
	public static String formatarCartaoCredito(final Number numeroCartao) {

		return CartaoCreditoFormatter.formatarStringCartaoCredito(UtilString.toString(numeroCartao));
	}
}
