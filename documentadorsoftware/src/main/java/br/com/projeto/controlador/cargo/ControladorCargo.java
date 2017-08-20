package br.com.projeto.controlador.cargo;

import java.util.List;

import br.com.projeto.modelo.entidade.cargo.Cargo;
import br.com.projeto.modelo.repositorio.cargo.IRepositorioCargo;
import br.com.projeto.modelo.repositorio.cargo.RepositorioCargo;

public class ControladorCargo implements IControladorCargo {

	private IRepositorioCargo repositorioCargo;

	public ControladorCargo() {
		repositorioCargo = new RepositorioCargo();
	}
	
	@Override
	public long insereCargo(Cargo cargo) {
	    return repositorioCargo.salvar(cargo); 
	}

	@Override
	public List<Cargo> buscarListaCargo(String... propriedades) {
		return repositorioCargo.listar(propriedades);
	}

}
