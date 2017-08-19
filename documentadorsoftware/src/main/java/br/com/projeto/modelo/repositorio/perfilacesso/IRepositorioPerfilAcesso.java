package br.com.projeto.modelo.repositorio.perfilacesso;

import br.com.projeto.modelo.entidade.usuario.PerfilAcesso;

public interface IRepositorioPerfilAcesso {

	public PerfilAcesso recuperaPerfilAcesso(long idUsuario);
}
