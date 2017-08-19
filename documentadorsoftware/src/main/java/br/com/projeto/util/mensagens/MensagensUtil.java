package br.com.projeto.util.mensagens;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MensagensUtil {
	
	public static String getMensagem(String messageId) {  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        String mensagem = "";  
        Locale locale = facesContext.getViewRoot().getLocale();  
        ResourceBundle bundle = ResourceBundle.getBundle("mensagem.messages", locale);  
       
        try {  
        	mensagem = bundle.getString(messageId);  
        } catch (Exception e) {  
        }  
        
        return mensagem;  
    }
	
	public static void enviarMensagem(String mensagem,Severity severity){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(severity, null,mensagem);
		
		context.addMessage(null, facesMessage);
	
		context.getExternalContext().getFlash().setKeepMessages(true);

	}
}
