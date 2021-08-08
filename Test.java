package com.austin.calculatorpt1;

public class Test {

	public static void main(String[] args) {
	Calculator calculator = new Calculator();
	calculator.performOperation(10.5);
	calculator.performOperation("+");
	calculator.performOperation(5.2);
	calculator.performOperation("*");
	calculator.performOperation(10);
	calculator.performOperation("=");
	calculator.getResults();
	System.out.println(calculator.getResults());
	}
	

}
