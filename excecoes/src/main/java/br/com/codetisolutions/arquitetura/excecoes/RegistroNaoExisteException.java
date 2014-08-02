package br.com.codetisolutions.arquitetura.excecoes;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> RegistroNaoExisteException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo tratamento de exceções quando um determinado registro não se encontra na base de dados.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class RegistroNaoExisteException extends ValidacaoException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Constante MENSAGEM_REGISTRO_NAO_EXISTE. */
	public static final String MENSAGEM_REGISTRO_NAO_EXISTE = "arquitetura.msg.registroNaoExiste";

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public RegistroNaoExisteException() {

		super(RegistroNaoExisteException.getMensagemRegistroNaoExiste());
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem de exceção.
	 */
	public RegistroNaoExisteException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public RegistroNaoExisteException( final Throwable causa ) {

		super(causa);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public RegistroNaoExisteException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - chave no arquivo de propriedades.
	 * 
	 * @param argumentos
	 *            - valores relacionados a chave.
	 */
	public RegistroNaoExisteException( final String mensagem, final String... argumentos ) {

		super(mensagem, argumentos);
	}

	/**
	 * Retorna o valor do atributo <code>mensagemRegistroNaoExiste</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemRegistroNaoExiste() {

		return RegistroNaoExisteException.MENSAGEM_REGISTRO_NAO_EXISTE;
	}

}
