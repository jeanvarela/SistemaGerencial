package br.com.projeto.modelo.entidade.menu;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projeto.modelo.entidade.GenericDomain;

@Entity
@Table(name = "menu")
public class Menu extends GenericDomain{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String descricao;
	
	@OneToMany
	@JoinColumn(name = "codigo_item_menu")
	private List<ItemMenu> itemMenu;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ItemMenu> getItemMenu() {
		return itemMenu;
	}

	public void setItemMenu(List<ItemMenu> itemMenu) {
		this.itemMenu = itemMenu;
	}
}
