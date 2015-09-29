package ca.nait.dmit.domain;

/**
 * The Canadian federal income tax that a person pays is a function of the person’s taxable income.  
 * The following table contains the formulas for computing a single person’s tax (Federal tax rates for 2015).
 * Bracket	Taxable Income					Marginal tax rate	Tax paid
 * --------	-------------------------------	-------------------	----------------------------------------
 * 1		$44,701 or less					15%					15%
 * 2		Between $44,701 and $89,401		22%					$6705 + 22% of the amount over $44,701
 * 3		Between $89,401 and $138,586	26%					$16,539 + 26% of the amount over $89,401
 * 4		Over $138,586					29%					$29,327 + 29% of the amount over $138,586
 * The marginal tax rate is the tax rate you pay on the last dollar earned. 
 * This rate gives you an idea of how much tax would be taken from any additional earnings you might make.
 * 
 * @author Sam Wu
 * @version 2015.09.28
 */
public class CanadaFederalTax {
	
	private static final double BRACKET1_MARGINAL_TAX_RATE = 0.15;
	private static final double BRACKET2_MARGINAL_TAX_RATE = 0.22;
	private static final double BRACKET3_MARGINAL_TAX_RATE = 0.26;
	private static final double BRACKET4_MARGINAL_TAX_RATE = 0.29;
	private static final double BRACKET1_MAX_INCOME = 44701;
	private static final double BRACKET2_MAX_INCOME = 89401;
	private static final double BRACKET3_MAX_INCOME = 138586;
	private static final double BRACKET2_BASE_AMOUNT = 6705;
	private static final double BRACKET3_BASE_AMOUNT = 16539;
	private static final double BRACKET4_BASE_AMOUNT = 29327;
	
	
	
	private String name;
	private double taxableIncome;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	
	public CanadaFederalTax() {
		super();
	}
	public CanadaFederalTax(String name, double taxableIncome) {
		super();
		this.name = name;
		this.taxableIncome = taxableIncome;
	}

	public double marginalTaxRate() {
		double taxRate = 0;
		
		if( taxableIncome <= BRACKET1_MAX_INCOME )
			taxRate = BRACKET1_MARGINAL_TAX_RATE;
		else if ( taxableIncome <= BRACKET2_MAX_INCOME )
			taxRate = BRACKET2_MARGINAL_TAX_RATE;
		else if ( taxableIncome <= BRACKET3_MAX_INCOME )
			taxRate = BRACKET3_MARGINAL_TAX_RATE;
		else
			taxRate = BRACKET4_MARGINAL_TAX_RATE;
		
		return taxRate;
	}
	
	public double federalTax() {
		double taxOwed = 0;
		
		if( taxableIncome <= BRACKET1_MAX_INCOME )
			taxOwed = BRACKET1_MARGINAL_TAX_RATE * taxableIncome;
		else if ( taxableIncome <= BRACKET2_MAX_INCOME )
			taxOwed = BRACKET2_BASE_AMOUNT + BRACKET2_MARGINAL_TAX_RATE * (taxableIncome - BRACKET1_MAX_INCOME);
		else if ( taxableIncome <= BRACKET3_MAX_INCOME )
			taxOwed = BRACKET3_BASE_AMOUNT + BRACKET3_MARGINAL_TAX_RATE * (taxableIncome - BRACKET2_MAX_INCOME);
		else
			taxOwed = BRACKET4_BASE_AMOUNT + BRACKET4_MARGINAL_TAX_RATE * (taxableIncome - BRACKET3_MAX_INCOME);
		
		return taxOwed;
	}
	
}
