package br.com.codetisolutions.arquitetura.excecoes;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ValidacaoException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelos erros provindos de validação.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ValidacaoException extends NegocioException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 6674965279448354080L;

	/** Atributo argumentos. */
	private String[] argumentos;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ValidacaoException() {

		super();
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public ValidacaoException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public ValidacaoException( final Throwable causa ) {

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
	public ValidacaoException( final String mensagem, final Throwable causa ) {

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
	public ValidacaoException( final String mensagem, final String... argumentos ) {

		super(mensagem);

		this.argumentos = argumentos;
	}

	/**
	 * Retorna o valor do atributo <code>argumentos</code>
	 *
	 * @return <code>String[]</code>
	 */
	@Override
	public final String[] getArgumentos() {

		return this.argumentos;
	}
}
