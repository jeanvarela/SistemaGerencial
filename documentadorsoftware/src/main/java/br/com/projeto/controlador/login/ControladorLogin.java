package br.com.projeto.controlador.login;

import java.util.List;

import br.com.projeto.modelo.entidade.usuario.Usuario;
import br.com.projeto.modelo.repositorio.usuario.IRepositorioUsuario;
import br.com.projeto.modelo.repositorio.usuario.RepositorioUsuario;

public class ControladorLogin implements IControladorLogin{
	
	private IRepositorioUsuario repositorioUsuario;
	
	public ControladorLogin() {
		this.repositorioUsuario  = new RepositorioUsuario();
	}

	/**
	 * Objetivo: verificar se a combina��o email/senha existem no banco de dados
	 * 
	 * Parametro: login -> login de acesso do usu�rio
	 *            senha -> senha de acesso do usu�rio
	 *             
	 * Retorno: Retorna um boolean indicando se a combina��o email/senha existe.
	 *          Se essa combina��o existe � retornado true, caso contr�rio retorna false.
	 */
	@Override
	public Usuario logar(String login, String senha) {
		List<Usuario> listaUsuarios = this.repositorioUsuario.logar(login, senha);
		
		if (listaUsuarios != null &&  listaUsuarios.size() > 0){
			return listaUsuarios.get(0);
		}
				
		return null;
	}
	
	@Override
	public Usuario recuperarUsuario(String login, String senha) {
		List<Usuario> listaUsuarios = this.repositorioUsuario.logar(login, senha);
		
		if (listaUsuarios != null &&  listaUsuarios.size() > 0){
			return listaUsuarios.get(0);
		}
				
		return null;
	}

}
