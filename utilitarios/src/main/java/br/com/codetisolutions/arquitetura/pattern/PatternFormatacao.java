package br.com.codetisolutions.arquitetura.pattern;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> FormataPattern.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover os diversos Patterns para formatação de objetos.
 * </p>
 *
 * Data de criação: 06/08/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class PatternFormatacao {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private PatternFormatacao() {

		super();
	}

	/**
	 * Método responsável por montar o pattern para os CEPS.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>cep formatado</i>.
	 */
	public static String getCEP() {

		return "##.###-###";
	}

	/**
	 * Método responsável por
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>cnpj formatado</i>.
	 */
	public static String getCNPJ() {

		return "##.###.###/####-##";
	}

	/**
	 * Método responsável por
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>cpf formatado</i>.
	 */
	public static String getCPF() {

		return "###.###.###-##";
	}

	/**
	 * Método responsável por montar um pattern que formate e valida emails.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>email formatado</i>.
	 */
	public static String getEmail() {

		return "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	}

	/**
	 * Método responsável por montar um pattern que receba somente o número telefonico.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>formatacao pattern para numeros de 8 digitos</i>.
	 */
	public static String getTelefoneOitoDigitos() {

		return "####-####";
	}

	/**
	 * Método responsável por montar um pattern que se adapte a realidade dos 9 digitos para celulares.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>formatacao pattern para numeros de 9 digitos</i>.
	 */
	public static String getTelefoneCelularNoveDigitos() {

		return "#####-####";
	}

	/**
	 * Método responsável por montar um pattern para telefones que recebem código DDD + telefone.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>formatacao pattern para numeros de 10 digitos</i>.
	 */
	public static String getTelefoneDezDigitos() {

		return "## ####-####";
	}

	/**
	 * Método responsável por montar um pattern para telefones extrangeiros que recebem o código da operadora do país + código DDD + telefone.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>formatacao pattern para numeros de 12 digitos</i>.
	 */
	public static String getTelefoneDozeDigitos() {

		return "## ## ####-####";
	}

	/**
	 * Método responsável por montar um pattern para números de cartão de crédito.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>formatacao pattern para numeros de cartão de crédito</i>.
	 */
	public static String getCartaoCredito() {

		return "#### #### #### ####";
	}

}
