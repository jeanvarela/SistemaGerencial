package br.com.projeto.modelo.entidade.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projeto.modelo.entidade.GenericDomain;
import br.com.projeto.modelo.entidade.usuario.PerfilAcesso;

@Entity
@Table(name = "item_menu")
public class ItemMenu extends GenericDomain{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String       label;
	
	@Column(length = 100, nullable = false)
	private String 		 acao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_perfil_acesso")
	private PerfilAcesso perfilAcesso;
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}
	
	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}	
}
