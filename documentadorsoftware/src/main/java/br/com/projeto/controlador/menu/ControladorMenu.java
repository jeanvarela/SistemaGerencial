package br.com.projeto.controlador.menu;

import java.util.List;

import br.com.projeto.modelo.entidade.menu.Menu;
import br.com.projeto.modelo.repositorio.menu.IRepositorioMenu;
import br.com.projeto.modelo.repositorio.menu.RepositorioMenu;

public class ControladorMenu implements IControladorMenu{

	private IRepositorioMenu repositorioMenu;
	
	public ControladorMenu() {
		this.repositorioMenu = new RepositorioMenu();
	}
	
	@Override
	public List<Menu> montaMenu(long idUsuario) {
		return repositorioMenu.recuperaMenu(idUsuario);
	}

	
}
