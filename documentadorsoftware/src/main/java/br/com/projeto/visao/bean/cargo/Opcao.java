package br.com.projeto.visao.bean.cargo;

public class Opcao {
	
	private int    idOpcao;
	private String descricao;
	
	public Opcao(int idOpcao, String descricao) {
		this.idOpcao = idOpcao;
		this.descricao = descricao;
	}

	public int getIdOpcao() {
		return idOpcao;
	}

	public void setIdOpcao(int idOpcao) {
		this.idOpcao = idOpcao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
