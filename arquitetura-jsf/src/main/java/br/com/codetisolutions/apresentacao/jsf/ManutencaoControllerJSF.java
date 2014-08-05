package br.com.codetisolutions.apresentacao.jsf;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController;
import br.com.codetisolutions.arquitetura.dominio.Entidade;
import br.com.codetisolutions.arquitetura.excecoes.NegocioException;
import br.com.codetisolutions.arquitetura.formulario.Formulario;
import br.com.codetisolutions.arquitetura.negocio.BO;
import br.com.codetisolutions.arquitetura.servico.Service;

/**
 * <p>
 * <b>Organização:</b> 4code TI Solutions
 * </p>
 *
 * <p>
 * <b>Título:</b> ManutencaoControllerJSF.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe <code>ManutencaoController</code> vinculada a tecnologia <b>JSF</b>.
 * </p>
 *
 * Data de criação: 04/08/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public abstract class ManutencaoControllerJSF<E extends Entidade> extends ManutencaoController<E> {

	/** Atributo consultaControllerJSF. */
	private ConsultaControllerJSF<E> consultaControllerJSF;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.Controller#abreIniciar()
	 */
	@Override
	public String abreIniciar() {

		this.iniciarDados();

		return this.getNavigationAbreIniciar();
	}

	/**
	 * Método responsável por inicializar os dados de um controlador.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public abstract void iniciarDados();

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.Controller#voltarInicio()
	 */
	@Override
	public String voltarInicio() {

		this.iniciarDados();

		return this.getNavigationAbreIniciar();
	}

	/**
	 * Método responsável por apontar a rota de navegação da página inicial de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /inicial == rota do arquivo JSF</i>.
	 */
	protected String getNavigationAbreIniciar() {

		return this.getClass().getSimpleName() + "/inicial";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#abreIncluir()
	 */
	@Override
	public String abreIncluir() {

		try {

			this.getFormulario().setEntidade(this.getTipoDaEntidade().newInstance());

		} catch (final Exception excecao) {

			Logger.getLogger("***** ERRO na classe :>:>:>:>:> ").info(this.getClass().getSimpleName() + excecao.getMessage() + " *****");
		}

		return this.getNavigationAbreIncluir();
	}

	/**
	 * Método responsável por capturar o tipo da entidade. <br>
	 * O tipo é capturado através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>tipo da classe da entidade</i>.
	 */
	private Class<E> getTipoDaEntidade() {

		final Type[] tipoEntidade = ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) tipoEntidade[0];
	}

	/**
	 * Método responsável por apontar a rota de navegação da página de inclusão de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /incluir == rota do arquivo JSF</i>.
	 */
	protected String getNavigationAbreIncluir() {

		return this.getClass().getSimpleName() + "/incluir";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#abreAlterar()
	 */
	@Override
	public String abreAlterar() {

		this.carregarDados();

		return this.getNavigationAbreAlterar();
	}

	/**
	 * Método responsável por apontar a rota de navegação da página alteração de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /alterar == rota do arquivo JSF</i>.
	 */
	protected String getNavigationAbreAlterar() {

		return this.getClass().getSimpleName() + "/alterar";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ConsultaController#abreDetalhar()
	 */
	@Override
	public String abreDetalhar() {

		this.carregarDados();

		return this.getNavigationAbreDetalhar();
	}

	/**
	 * Método responsável por apontar a rota de navegação da página detalhamento de um caso de uso.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome da classe + /detalhar == rota do arquivo JSF</i>.
	 */
	protected String getNavigationAbreDetalhar() {

		return this.getClass().getSimpleName() + "/detalhar";
	}

	@Override
	public void salvarOuAlterar() {

		try {

			this.getService().validar(this.getFormulario().getEntidade());

			super.salvarOuAlterar();

			this.getFormulario().setEntidade(this.getTipoDaEntidade().newInstance());

			super.consultarTodos();

		} catch (final NegocioException e) {

			this.exibirMensagemNaTela(e.getMessage());

		} catch (final Exception e) {

			throw new NegocioException();
		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#inserir()
	 */
	@Override
	public void inserir() {

		try {

			this.getService().validar(this.getFormulario().getEntidade());

			super.inserir();

			this.getFormulario().setEntidade(this.getTipoDaEntidade().newInstance());

			super.consultarTodos();

		} catch (final NegocioException e) {

			this.exibirMensagemNaTela(e.getMessage());

		} catch (final Exception e) {

			throw new NegocioException();
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#alterar()
	 */
	@Override
	public void alterar() {

		try {

			this.getService().validar(this.getFormulario().getEntidade());

			super.alterar();

			super.consultarTodos();

		} catch (final NegocioException negocioException) {

			this.getService().atualizar(this.getFormulario().getEntidade());

			this.exibirMensagemNaTela(negocioException.getMessage());

		} catch (final Exception exception) {

			this.exibirMensagemNaTela(exception.getMessage());
		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#mesclar()
	 */
	@Override
	public void mesclar() {

		try {

			this.getService().validar(this.getFormulario().getEntidade());

			super.mesclar();

			this.getFormulario().setEntidade(this.getTipoDaEntidade().newInstance());

			super.consultarTodos();

		} catch (final NegocioException e) {

			this.exibirMensagemNaTela(e.getMessage());

		} catch (final Exception e) {

			throw new NegocioException();
		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#remover()
	 */
	@Override
	public void remover() {

		super.remover();

		super.consultarTodos();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ManutencaoController#removerTodos()
	 */
	@Override
	public void removerTodos() {

		super.removerTodos();

		super.consultarTodos();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ConsultaController#consultar()
	 */
	@Override
	public void consultar() {

		this.getConsultaControllerJSF().consultar();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.Controller#exibirMensagemNaTela(java.lang.String[])
	 */
	@Override
	public void exibirMensagemNaTela(final String... mensagens) {

		this.getConsultaControllerJSF().exibirMensagemNaTela(mensagens);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.Controller#adicionarMensagemSucesso(java.lang.String)
	 */
	@Override
	public void adicionarMensagemSucesso(final String mensagemSucesso) {

		this.getConsultaControllerJSF().adicionarMensagemSucesso(mensagemSucesso);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.Controller#adicionarMensagemAlerta(java.lang.String)
	 */
	@Override
	public void adicionarMensagemAlerta(final String mensagemAlerta) {

		this.getConsultaControllerJSF().adicionarMensagemAlerta(mensagemAlerta);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.Controller#adicionarMensagemErro(java.lang.String)
	 */
	@Override
	public void adicionarMensagemErro(final String mensagemErro) {

		this.getConsultaControllerJSF().adicionarMensagemErro(mensagemErro);
	}

	/**
	 * Método responsável por verificar se existe mensagens configuradas.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>{ TRUE, se existir mensagem configurada }<br>
	 *         { FALSE, se <b>não</b> existir mensagem configurada }</i>.
	 */
	public boolean hasMessage() {

		return this.getConsultaControllerJSF().hasMessage();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletRequest</code>.
	 *
	 * @return <code>HttpServletRequest</code>.
	 */
	public HttpServletRequest getRequest() {

		return this.getConsultaControllerJSF().getRequest();
	}

	/**
	 * Retorna o valor do atributo <code>httpServletResponse</code>.
	 *
	 * @return <code>HttpServletResponse</code>.
	 */
	public HttpServletResponse getResponse() {

		return this.getConsultaControllerJSF().getResponse();
	}

	/**
	 * Retorna o valor do atributo <code>facesContext</code>.
	 *
	 * @return <code>FacesContext</code>.
	 */
	public FacesContext getFacesContext() {

		return this.getConsultaControllerJSF().getFacesContext();
	}

	/**
	 * Retorna o valor do atributo <code>consultaControllerJSF</code>
	 *
	 * @return <code>ConsultaControllerJSF<E></code>
	 */
	private ConsultaControllerJSF<E> getConsultaControllerJSF() {

		if (this.consultaControllerJSF == null) {

			this.consultaControllerJSF = new ConsultaControllerJSF<E>() {

				@Override
				public Formulario<E> getFormulario() {

					return ManutencaoControllerJSF.this.getFormulario();
				}

				@Override
				public Service<E, ? extends BO<E>> getService() {

					return ManutencaoControllerJSF.this.getService();
				}

			};

		}

		return this.consultaControllerJSF;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ConsultaController#getFormulario()
	 */
	@Override
	public abstract Formulario<E> getFormulario();

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.codetisolutions.arquitetura.apresentacao.ConsultaController#getService()
	 */
	@Override
	public abstract Service<E, ? extends BO<E>> getService();

}
