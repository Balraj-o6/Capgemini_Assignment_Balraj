package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalServiceTest {
	private CalculatorService cs;
	
	@BeforeEach
	public void init() {
		ICalculator cal = Mockito.mock(ICalculator.class);
		cs = new CalculatorService(cal);
		when(cal.calculate(20, 5)).thenReturn(25);
		when(cal.calculate(10, 5)).thenReturn(15);
		
	}
	
	@Test
	void addServiceTest() {
		assertEquals(15, cs.addService(10, 5)); 
	}
}
