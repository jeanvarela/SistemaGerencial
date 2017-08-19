package br.com.projeto.visao.bean.cargo;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;

@ManagedBean(name="cargo")
@ViewScoped
public class CargoBean {

	private String  descricao;
	private boolean ativo;
	private long    id; 
	
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
	
	public void chamaTelaIndex(){
		try {
			Faces.redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrar(){
		
	}
}
