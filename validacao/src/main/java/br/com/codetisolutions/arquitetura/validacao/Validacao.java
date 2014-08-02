package br.com.codetisolutions.arquitetura.validacao;

import br.com.codetisolutions.arquitetura.dominio.Entidade;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> Validacao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> TAD para definição de regras de validação de entidades.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public interface Validacao<E extends Entidade> {

	/**
	 * Método responsável por obter a mensagem da falha da validação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>chave da mensagem de falha da validação</i>.
	 */
	String getChaveMensagemFalhaValidacao();

	/**
	 * Método responsável por obter a descrição da validação para a geração de logs.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>descrição da mensagem da validação</i>.
	 */
	String getDescricao();

	/**
	 * Método responsável por validar uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será validado.
	 */
	void validar(final E entidade);

	/**
	 * Método responsável por capturar o valor do atributo <code>BO</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>objeto de negócio</i>.
	 */
	Object getBO();

}
