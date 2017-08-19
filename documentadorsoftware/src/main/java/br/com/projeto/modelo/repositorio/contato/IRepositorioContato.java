package br.com.projeto.modelo.repositorio.contato;

import java.util.List;

import br.com.projeto.modelo.entidade.contato.Contato;
import br.com.projeto.util.dao.IGenericDAO;

public interface IRepositorioContato  extends IGenericDAO<Contato> {
	
	/**
	 * Fun��o: recuperar os contatos de um usu�rio.
	 */
	public List<Contato> recuperaContatos(Long idUsuario, String criterioBusca, int tipoBusca);
	
	/**
	 * Fun��o: recuperar a lista de contatos de um determinado usu�rio.
	 */
	public List<Contato> recuperaContatos(Long idUsuario);

	/**
	 * Fun��o: recuperar um contato.
	 */
	public Contato recuperaContato(Long idContato);
}
