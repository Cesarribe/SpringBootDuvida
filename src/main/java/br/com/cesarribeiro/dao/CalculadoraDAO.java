package br.com.cesarribeiro.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CalculadoraDAO implements ICalculadoraDAO {
    @Override
    public double soma(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divisao (double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("nao divisivel por zero");
        }
        return num1 / num2;
    }
}
