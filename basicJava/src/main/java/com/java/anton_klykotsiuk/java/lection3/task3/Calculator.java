package com.java.anton_klykotsiuk.java.lection3.task3;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.runCalculator();
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        return (b != 0) ? (double) a / b : divisionByZeroException();
    }

    private double divisionByZeroException() {
        throw new ArithmeticException();
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    private void runCalculator() {
        int a;
        int b;
        Scanner in = new Scanner(System.in);

        System.out.print("Input A: ");
        a = in.nextInt();

        System.out.print("Input B: ");
        b = in.nextInt();

        System.out.println("Sum of " + a + " and " + b + " = " + sum(a, b));
        System.out.println("Subtraction of " + b + " from " + a + " = " + subtract(a, b));
        System.out.println("Multiplication of " + a + " by " + b + " = " + multiply(a, b));
        System.out.println("Division of " + a + " by " + b + " = " + String.format("%.2f", divide(a, b)));
        in.close();
    }
}
