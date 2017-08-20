package br.com.projeto.infraestrutura.util;

public class Util {
	
	public static String retiraMascaraTelefone(String telefone){
		return telefone.replace("(","").replace(")","").replace("-","");
	}
	
	public static boolean isNumeroTelefone(String conteudo){
		return Character.isDigit(conteudo.charAt(0));
	}
	
	public static String converterStringParaMiniscula(String conteudo){
		String conteudoConvertido = null;
		
		if (conteudo != null){
			conteudoConvertido = conteudo.toLowerCase();
		}
		
		return conteudoConvertido;
	}
	
	public static boolean verificaNumeroValidoMaiorQueZero(Long numero){
		return numero != null && numero > 0;
	}
	
}
