package br.com.projeto.visao.bean.cargo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.projeto.modelo.entidade.cargo.Cargo;
import br.com.projeto.util.constante.Constantes;

@ManagedBean(name="cargoLista")
@ViewScoped
public class CargoListBean {

	private List<Cargo> cargos;

	@SuppressWarnings("unchecked")
	public CargoListBean() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) contexto.getExternalContext().getSession(false);
    	this.cargos = (List<Cargo>)session.getAttribute(Constantes.LISTA);
	}
	
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}	
	
}
