package br.com.adenilson.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.adenilson.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {// comporar o bonus, porem ele não pode passa de 1000.
			throw new IllegalArgumentException("Funcionario com salario maior do que R$"
					+ "10000.00 não pode receber bônus");
		}
		return valor.setScale(2,RoundingMode.HALF_UP);
	}

}
