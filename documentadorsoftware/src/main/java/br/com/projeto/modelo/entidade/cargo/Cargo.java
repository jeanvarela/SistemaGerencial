package br.com.projeto.modelo.entidade.cargo;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.projeto.modelo.entidade.GenericDomain;

@Entity
@Table(name="cargo")
public class Cargo extends GenericDomain{

	private String  descricao;
	private boolean ativo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
