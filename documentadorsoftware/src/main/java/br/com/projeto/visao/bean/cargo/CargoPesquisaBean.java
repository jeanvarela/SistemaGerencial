package br.com.projeto.visao.bean.cargo;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;

import br.com.projeto.controlador.cargo.ControladorCargo;
import br.com.projeto.controlador.cargo.IControladorCargo;
import br.com.projeto.infraestrutura.util.Util;
import br.com.projeto.modelo.entidade.cargo.Cargo;
import br.com.projeto.util.constante.Constantes;
import br.com.projeto.util.enumeracao.SimNaoEnumeration;

@ManagedBean(name="cargoPesquisa")
@ViewScoped
public class CargoPesquisaBean {
	
	private List<SimNaoEnumeration> opcoes;
	private SimNaoEnumeration         ativo;
	private String      descricao;
	
	public CargoPesquisaBean(){		
	}
	
	public SimNaoEnumeration[] getOpcoesAtivo(){
		return SimNaoEnumeration.values();
	}
	
	public SimNaoEnumeration getAtivo() {
		return ativo;
	}
	
	public void setAtivo(SimNaoEnumeration ativo) {
		this.ativo = ativo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void pesquisar(){
		String busca = Util.verificarInformacaoPreenchida(this.descricao) ? this.descricao : null;
		
		IControladorCargo controladorCargo = new ControladorCargo();
		List<Cargo> cargos = controladorCargo.buscarListaCargo(busca);
		
		try {
				FacesContext contexto = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) contexto.getExternalContext().getSession(false);
				session.setAttribute(Constantes.LISTA, cargos);
				
				Faces.redirect("pages/cadastro/cargo/listagem.xhtml");
		    } catch (IOException e) {
				e.printStackTrace();
			}
	}
}
