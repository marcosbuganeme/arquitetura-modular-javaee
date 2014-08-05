package br.com.codetisolutions.arquitetura.excecoes;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> NegocioException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe que trata das exceções de negócio.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class NegocioException extends RuntimeException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -8567820448168840809L;

	/** Atributo argumentos. */
	private String[] argumentos;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public NegocioException() {

		super();
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public NegocioException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - motivo da exceção.
	 */
	public NegocioException( final Throwable causa ) {

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
	public NegocioException( final String mensagem, final Throwable causa ) {

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
	public NegocioException( final String mensagem, final String... argumentos ) {

		super(mensagem);

		this.argumentos = argumentos;
	}

	/**
	 * Retorna o valor do atributo <code>argumentos</code>
	 *
	 * @return <code>String[]</code>
	 */
	public String[] getArgumentos() {

		return this.argumentos;
	}

}
