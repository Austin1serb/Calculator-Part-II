package com.austin.calculatorpt1;

public class Calculator {
    private double[] numbers = new double[100];
    private String[] operations = new String[99];
    private int numIndex = 0;
    private int opIndex = 0;

    public void performOperation(double value) {
        if (numIndex < numbers.length) {
            numbers[numIndex++] = value;
        } else {
            System.out.println("Max number of operands reached.");
        }
    }

    public void performOperation(String operation) {
        if (operation.equals("=")) {
            resolveOperations();
        } else {
            if (opIndex < operations.length) {
                operations[opIndex++] = operation;
            } else {
                System.out.println("Max number of operations reached.");
            }
        }
    }

    private void resolveOperations() {
        // Handle multiplication and division first
        for (int i = 0; i < opIndex; i++) {
            if (operations[i].equals("*") || operations[i].equals("/")) {
                numbers[i] = operations[i].equals("*") ?
                    numbers[i] * numbers[i + 1] :
                    numbers[i] / numbers[i + 1];

                // Shift the remaining numbers and operations left
                for (int j = i + 1; j < numIndex - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                for (int j = i; j < opIndex - 1; j++) {
                    operations[j] = operations[j + 1];
                }
                numIndex--;
                opIndex--;
                i--;
            }
        }

        // Handle addition and subtraction
        for (int i = 0; i < opIndex; i++) {
            numbers[i] = operations[i].equals("+") ?
                numbers[i] + numbers[i + 1] :
                numbers[i] - numbers[i + 1];

            // Shift the remaining numbers left
            for (int j = i + 1; j < numIndex - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numIndex--;
        }
        opIndex = 0;
    }

    public double getResults() {
        if (numIndex != 1) {
            System.out.println("Calculation error!");
            return 0;
        }
        return numbers[0];
    }
}
