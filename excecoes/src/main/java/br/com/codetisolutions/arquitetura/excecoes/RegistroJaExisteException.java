package br.com.codetisolutions.arquitetura.excecoes;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> RegistroJaExisteException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo tratamento de exceções quando um registro já existe e está sendo duplicado na base de dados.
 * </p>
 *
 * Data de criação: 02/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class RegistroJaExisteException extends ValidacaoException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1703094141528337827L;

	/** Constante MENSAGEM_REGISTRO_JA_EXISTE. */
	public static final String MENSAGEM_REGISTRO_JA_EXISTE = "arquitetura.msg.registroJaExiste";

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public RegistroJaExisteException() {

		super(RegistroJaExisteException.getMensagemRegistroJaExiste());
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem de exceção.
	 */
	public RegistroJaExisteException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public RegistroJaExisteException( final Throwable causa ) {

		super(causa);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem de exceção.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public RegistroJaExisteException( final String mensagem, final Throwable causa ) {

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
	public RegistroJaExisteException( final String mensagem, final String... argumentos ) {

		super(mensagem, argumentos);
	}

	/**
	 * Retorna o valor do atributo <code>mensagemRegistroJaExiste</code>
	 *
	 * @return <code>String</code>
	 */
	public static final String getMensagemRegistroJaExiste() {

		return RegistroJaExisteException.MENSAGEM_REGISTRO_JA_EXISTE;
	}

}
