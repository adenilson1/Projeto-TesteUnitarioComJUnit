package br.com.adenilson.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.adenilson.modelo.Desempenho;
import br.com.adenilson.modelo.Funcionario;
import br.com.adenilson.service.ReajusteService;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	
	@BeforeEach
	public void inicializa() {
		System.out.println("inicializar");
		service = new ReajusteService();
		funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2000.00"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("fim");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}

	@Test
	void rajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADedejar() {
		
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("2060.00"),funcionario.getSalario());

	}
	
	@Test
	void rajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForBom() {
		
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("2300.00"),funcionario.getSalario());

	}
	
	@Test
	void rajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForOtimo() {
		
		
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("2400.00"),funcionario.getSalario());

	}

}
