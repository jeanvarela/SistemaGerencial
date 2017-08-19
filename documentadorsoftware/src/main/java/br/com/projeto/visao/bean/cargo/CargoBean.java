package br.com.projeto.visao.bean.cargo;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

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
/*		Cargo cargo = new Cargo();
		cargo.setDescricao(this.descricao);
		cargo.setAtivo(this.ativo);
		
		IControladorCargo controladorCargo = new ControladorCargo();
		controladorCargo.insereCargo(cargo);
*/
/*		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, null,"Mensagem");
		
		context.addMessage(null, mensagem);
	
		context.getExternalContext().getFlash().setKeepMessages(true);*/
		
		String mensagem = "Mensagem para teste";
		MensagensUtil.enviarMensagem(mensagem,FacesMessage.SEVERITY_INFO);

		 try {
				Faces.redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
	}
	}
}
