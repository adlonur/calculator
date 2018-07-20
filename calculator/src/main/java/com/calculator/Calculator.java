package com.calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.BiFunction;

public class Calculator {

	public static void main(String[] args) {
		System.out.println(calculator("3 5 8 * 7 + *"));
	}

	public static Double calculator(String input) {

		Deque<Double> numbers = new ArrayDeque<>();

		Arrays.asList(input.split(" ")).stream().forEach(number -> {
			switch (number) {
			case "+":
				calSymbol(numbers, (n1, n2) -> n2 + n1);
				break;
			case "-":
				calSymbol(numbers, (n1, n2) -> n2 - n1);
				break;
			case "*":
				calSymbol(numbers, (n1, n2) -> n2 * n1);
				break;
			case "/":
				calSymbol(numbers, (n1, n2) -> n2 / n1);
				break;
			default:
				numbers.push(Double.parseDouble(number));
			}
		});
		
		return numbers.pop();
	}

	public static Deque<Double> calSymbol(Deque<Double> numbers, BiFunction<Double, Double, Double> operation) {
		numbers.push(operation.apply(numbers.pop(), numbers.pop()));
		return numbers;
	}
}
