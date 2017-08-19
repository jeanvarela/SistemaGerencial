package br.com.projeto.controlador.menu;

import java.util.List;

import br.com.projeto.modelo.entidade.menu.Menu;

public interface IControladorMenu {

	public List<Menu> montaMenu(long idUsuario);
}
