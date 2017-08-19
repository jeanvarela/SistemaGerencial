package br.com.projeto.modelo.repositorio.menu;

import java.util.List;

import br.com.projeto.modelo.entidade.menu.Menu;

public interface IRepositorioMenu {

	public List<Menu> recuperaMenu(long idUsuario);
}
