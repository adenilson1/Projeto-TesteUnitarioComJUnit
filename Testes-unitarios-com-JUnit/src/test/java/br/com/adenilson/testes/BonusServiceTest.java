package br.com.adenilson.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.adenilson.modelo.Funcionario;
import br.com.adenilson.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

		//outra maneira de lançar o exception no teste, é usar o try/catch
		
//		try {
//			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("5000")));
//			fail("Não deu a exception");
//		} catch (Exception e) {
//			assertEquals("Funcionario com salario maior do que R$"
//					+ "10000.00 não pode receber bônus", e.getMessage());
//		}
		

	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);

	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExtamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);

	}

}
