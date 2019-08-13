package com.virtusa.codetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.virtusa.codetest.NumberWordConverter;

public class NumberWordConverterUnitTest {

	@Test
	public void whenMoneyNegative_thenReturnInvalidInput() {
		assertEquals(NumberWordConverter.INVALID_INPUT_GIVEN, NumberWordConverter.convert(-13));
	}

	@Test
	public void whenZeroGiven_thenReturnEmptyString() {
		assertEquals("", NumberWordConverter.convert(0));
	}

	@Test
	public void whenOnlyGiven_thenReturnWords() {
		assertEquals("one", NumberWordConverter.convert(1L));
	}

	@Test
	public void whenAlmostAMillioGiven_thenReturnWords() {
		String expectedResult = "fifty six million and nine hundred and forty five thousand and seven hundred and eighty one";
		assertEquals(expectedResult, NumberWordConverter.convert(56945781));
	}

	@Test
	public void whenOneBillionGiven_thenReturnInvalidInput() {
		assertEquals(NumberWordConverter.INVALID_INPUT_GIVEN, NumberWordConverter.convert(1_000_000_000));
	}

}
