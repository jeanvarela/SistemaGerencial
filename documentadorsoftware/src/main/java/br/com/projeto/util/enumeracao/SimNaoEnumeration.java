package br.com.projeto.util.enumeracao;

import java.util.Arrays;
import java.util.List;

public enum SimNaoEnumeration {

	NAO(0),
	SIM(1);
	
    public int opcao;
	 
	SimNaoEnumeration(int valor) {
		 opcao = valor;
	}
	
	public int getOpcao() {
		return opcao;
	}
}
