package ca.nait.dmit.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CanadaFederalTaxTest {

	@Test
	public void testBracket1Income() {
		CanadaFederalTax federalTax = new CanadaFederalTax();
		federalTax.setTaxableIncome(44000);
		assertEquals(0.15, federalTax.marginalTaxRate(), 0);
		assertEquals(6600, federalTax.federalTax(), 0);
	}

	@Test
	public void testBracket2Income() {
		CanadaFederalTax federalTax = new CanadaFederalTax();
		federalTax.setTaxableIncome(88000);
		assertEquals(0.22, federalTax.marginalTaxRate(), 0);
		assertEquals(16230.78, federalTax.federalTax(), 0);
	}

	@Test
	public void testBracket3Income() {
		CanadaFederalTax federalTax = new CanadaFederalTax();
		federalTax.setTaxableIncome(120000);
		assertEquals(0.26, federalTax.marginalTaxRate(), 0);
		assertEquals(24494.74, federalTax.federalTax(), 0);
	}

	@Test
	public void testBracket4Income() {
		CanadaFederalTax federalTax = new CanadaFederalTax();
		federalTax.setTaxableIncome(150000);
		assertEquals(0.29, federalTax.marginalTaxRate(), 0);
		assertEquals(32637.06, federalTax.federalTax(), 0);
	}

}
