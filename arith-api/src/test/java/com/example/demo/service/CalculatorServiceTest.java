package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {

	private CalculatorService calculatorService;

	@Before
	public void before() {
		this.calculatorService = new CalculatorService();
	}

	@Test
	public void add() {
		double actual = this.calculatorService.add(12, 13);
		assertEquals(25.0, actual, 0.2);
	}

}
