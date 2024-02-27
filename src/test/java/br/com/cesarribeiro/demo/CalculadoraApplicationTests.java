package br.com.cesarribeiro.demo;

import br.com.cesarribeiro.dao.CalculadoraDAO;
import br.com.cesarribeiro.dao.ICalculadoraDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculadoraApplicationTests {

	@Autowired
	private CalculadoraDAO calculatorDAO;

	@Test
	public void testSoma() {
		double result = calculatorDAO.soma(3, 5);
		assertEquals(8, result);
	}

	@Test
	public void testSubtracao() {
		double result = calculatorDAO.subtracao(10, 3);
		assertEquals(7, result);
	}

	@Test
	public void testMultiplicacao() {
		double result = calculatorDAO.multiplicacao(4, 6);
		assertEquals(24, result);
	}

	@Test
	public void testDivisao() {
		double result = calculatorDAO.divisao(20, 5);
		assertEquals(4, result);
	}

	@Test
	public void testDividePorZero() {
		try {
			calculatorDAO.divisao(10, 0);
		} catch (IllegalArgumentException e) {
			assertEquals("Cannot divide by zero", e.getMessage());
		}
	}
}