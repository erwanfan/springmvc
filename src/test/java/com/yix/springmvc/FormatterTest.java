package com.yix.springmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.format.number.CurrencyFormatter;


public class FormatterTest {

	@Test
	public void test1() throws ParseException {
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setRoundingMode(RoundingMode.HALF_UP);
		currencyFormatter.setFractionDigits(2);
		
		Assert.assertEquals(new BigDecimal("123.13"), currencyFormatter.parse("$123.125", Locale.US));
	}
	
	@Test
	public void test2() throws ParseException {
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setRoundingMode(RoundingMode.HALF_UP);
		currencyFormatter.setFractionDigits(2);
		
		Assert.assertEquals("$123.00", currencyFormatter.print(new BigDecimal("123"), Locale.US));
	}
}
