package br.com.projeto.visao.bean.cargo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.projeto.controlador.cargo.ControladorCargo;
import br.com.projeto.controlador.cargo.IControladorCargo;
import br.com.projeto.modelo.entidade.cargo.Cargo;

@ManagedBean(name="cargoLista")
@ViewScoped
public class CargoListBean {

	private List<Cargo> cargos;
	
	public CargoListBean() {
		IControladorCargo controladorCargo = new ControladorCargo();
		this.cargos = controladorCargo.buscarListaCargo(null);
	}
	
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}	
}
