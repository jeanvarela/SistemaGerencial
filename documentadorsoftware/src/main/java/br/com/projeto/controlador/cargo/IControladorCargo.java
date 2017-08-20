package br.com.projeto.controlador.cargo;

import java.util.List;

import br.com.projeto.modelo.entidade.cargo.Cargo;

public interface IControladorCargo {
	
	public long  insereCargo(Cargo cargo);
	
	public List<Cargo> buscarListaCargo(String... propriedades);
}
