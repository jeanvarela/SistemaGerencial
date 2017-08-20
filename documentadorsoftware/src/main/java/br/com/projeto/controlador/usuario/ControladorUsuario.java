package br.com.projeto.controlador.usuario;

import java.util.List;

import br.com.projeto.modelo.entidade.usuario.Usuario;
import br.com.projeto.modelo.repositorio.usuario.IRepositorioUsuario;
import br.com.projeto.modelo.repositorio.usuario.RepositorioUsuario;

public class ControladorUsuario implements IControladorUsuario {

	private IRepositorioUsuario repositorioUsuario;
	
	public ControladorUsuario(){
		this.repositorioUsuario = new RepositorioUsuario();
	}
	
	/**
	 * Objetivo: inserir um novo usu�rio
	 * 
	 * Par�metro: Usuario -> o usu�rio que se deseja inserir
	 * 
	 * Retorno: O id do usu�rio inserido
	 */	
	@Override
	public long adicionaUsuario(Usuario usuario) {
		return repositorioUsuario.salvar(usuario);
	}
	
	@Override
	public boolean atualizarUsuario(Usuario usuario) {
		Usuario usuarioAtualizado = (Usuario) repositorioUsuario.editar(usuario);
	
		boolean atualizadoComSucesso = usuarioAtualizado != null && usuarioAtualizado.getCodigo() > 0;
		
		return atualizadoComSucesso;
	}

	@Override
	public boolean verificaEmailCadastrado(String email)  {
		List<Usuario> listaUsuario = (List<Usuario>) repositorioUsuario.recuperaUsuarioPorEmail(email);
		
		return listaUsuario != null && listaUsuario.size() > 0 && listaUsuario.get(0) != null;
	}

}
