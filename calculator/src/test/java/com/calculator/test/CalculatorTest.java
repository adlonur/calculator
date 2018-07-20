package com.calculator.test;

import java.util.stream.IntStream;
import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

import static com.calculator.Calculator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

	@Test
	public void calSymbolCheckSize() {
		
		Deque<Double> numbers = new ArrayDeque<>();
		IntStream.rangeClosed(1,5).forEach(number ->numbers.add((double)number));
		Deque<Double> result = calSymbol(numbers, (num1,num2) -> num2 /num1);
		assertThat(result.size(), is(equalTo(4)));
	}
	
	@Test
	public void calSymbolDivisionOperation() {
		Deque<Double> numbers = new ArrayDeque<>();
		numbers.push((double)20);
		numbers.push((double)4);
		Deque<Double> result = calSymbol(numbers, (num1,num2) -> num2 / num1);
		assertThat(result.pop(), is(5.0));
	}
	
	@Test
	public void calSymbolAdditionOperation() {
		Deque<Double> numbers = new ArrayDeque<>();
		numbers.push((double)6);
		numbers.push((double)4);
		Deque<Double> result = calSymbol(numbers, (num1,num2) -> num2 + num1);
		assertThat(result.pop(), is(10.0));
	}
	
	
	@Test
	public void calculatorTestOne(){
		assertThat(calculator("20 5 /"), is(equalTo(4.0)));
	}
	
	@Test
	public void calculatorTestTwo(){
		assertThat(calculator("4 2 + 3 -"), is(equalTo(3.0)));
	}
	
	@Test
	public void calculatorTestThree(){
		assertThat(calculator("3 5 8 * 7 + *"), is(equalTo(141.0)));
	}
	
	@Test
	public void calculatorTestFour(){
		assertThat(calculator("-25.7 4 /"), is(equalTo(-6.425)));
	}
	
}
