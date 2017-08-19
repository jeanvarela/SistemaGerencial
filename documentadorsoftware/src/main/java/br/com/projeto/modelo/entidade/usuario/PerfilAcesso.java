package br.com.projeto.modelo.entidade.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.projeto.modelo.entidade.GenericDomain;

@Entity
@Table(name = "perfil_acesso")
public class PerfilAcesso extends GenericDomain{

	private static final long serialVersionUID = 1L;

	
	@Column(length = 100, nullable = false)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
