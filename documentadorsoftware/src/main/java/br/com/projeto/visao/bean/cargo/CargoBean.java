package br.com.projeto.visao.bean.cargo;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;

import br.com.projeto.controlador.cargo.ControladorCargo;
import br.com.projeto.controlador.cargo.IControladorCargo;
import br.com.projeto.infraestrutura.util.Util;
import br.com.projeto.modelo.entidade.cargo.Cargo;
import br.com.projeto.util.mensagens.MensagensUtil;

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
	
	public void cancelar(){
		try {
			Faces.redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public void cadastrar(){
		Cargo cargo = new Cargo();
		cargo.setDescricao(this.descricao);
		cargo.setAtivo(this.ativo);
		
		IControladorCargo controladorCargo = new ControladorCargo();
		long idCargo = controladorCargo.insereCargo(cargo);

		if (Util.verificaNumeroValidoMaiorQueZero(idCargo)){
			MensagensUtil.enviarMensagem(MensagensUtil.getMensagem("cargoInseridoComSucesso"),
					                     FacesMessage.SEVERITY_INFO);

			 try {
					Faces.redirect("index.xhtml");
				 } catch (IOException e) {
					e.printStackTrace();
				 }
		}
	}
}
