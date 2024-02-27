package br.com.cesarribeiro.demo;

import br.com.cesarribeiro.dao.CalculadoraDAO;
import br.com.cesarribeiro.dao.ICalculadoraDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CalculadoraApplication {

	private static final ICalculadoraDAO calculatorDAO = new CalculadoraDAO();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Calculator App");

		while (true) {
			System.out.println("Enter operation (add, subtract, multiply, divide) or 'exit' to quit:");
			String operation = scanner.nextLine().trim().toLowerCase();

			if (operation.equals("exit")) {
				System.out.println("Exiting Calculator App. Goodbye!");
				break;
			}

			System.out.println("Enter first number:");
			double num1 = scanner.nextDouble();

			System.out.println("Enter second number:");
			double num2 = scanner.nextDouble();
			scanner.nextLine(); // Consume newline

			double result;
			switch (operation) {
				case "add":
					result = calculatorDAO.soma(num1, num2);
					break;
				case "subtract":
					result = calculatorDAO.subtracao(num1, num2);
					break;
				case "multiply":
					result = calculatorDAO.multiplicacao(num1, num2);
					break;
				case "divide":
					result = calculatorDAO.divisao(num1, num2);
					break;
				default:
					System.out.println("Invalid operation. Please try again.");
					continue;
			}

			System.out.println("Result: " + result);
		}
	}
}

