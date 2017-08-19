package br.com.projeto.controlador.contato;

import java.util.List;

import br.com.projeto.modelo.entidade.contato.Contato;

public interface IControladorContato {

	/**
	 * Fun��o: inserir um novo contato. Recebe como paramentro o objeto contato
	 * e retorna um objeto contato com o identificador.
	 */
	public Contato insereContato(Contato contato);
	
	/**
	 * Fun��o: recuperar a lista de contatos de um determinado usu�rio.
	 * 
	 * Parametros: @idUsuario: o identificador do usu�rio
	 *             @criterioBusca: a string de busca
	 *             @tipoBusca: indica se a busca � por nome ou por celular. Valor 1 indica 
	 *                         pesquisar por NOME e valor 2 indica pesquisa por celular.    
	 */
	public List<Contato> recuperaContatos(Long idUsuario, String criterioBusca, int tipoBusca);
	
	/**
	 * Fun��o: recuperar a lista de todos os contatos de um determinado usu�rio.
	 */
	public List<Contato> recuperaContatoPorUsuario(Long idUsuario);
	
	/**
	 * Fun��o: recuperar um determinado contato.
	 */
	public Contato recuperaContato(long idContato);
	
	/**
	 * Fun��o: atualizar as informa�oes de um determinado contato.
	 */
	public Contato atualizaContato(Contato contato);
}
