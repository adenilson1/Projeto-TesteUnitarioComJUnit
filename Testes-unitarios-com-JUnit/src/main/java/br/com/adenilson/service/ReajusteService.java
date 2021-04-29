package br.com.adenilson.service;

import java.math.BigDecimal;

import br.com.adenilson.modelo.Desempenho;
import br.com.adenilson.modelo.Funcionario;

public class ReajusteService {
	
	public void concederReajuste(Funcionario funcionario, Desempenho desempenho){
		BigDecimal reajuste = desempenho.percentualReajuste();
		funcionario.reajustarSalario(reajuste);
		
	}

}
