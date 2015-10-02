package ca.nait.dmit.controller;

import java.io.Serializable;
import java.text.NumberFormat;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ca.nait.dmit.domain.CanadaFederalTax;
import helper.JSFHelper;

@Named
@ViewScoped
public class CanadaFederalTaxController implements Serializable {
	private static final long serialVersionUID = 1L;

	private CanadaFederalTax canadaFederalTax = new CanadaFederalTax();

	public CanadaFederalTax getCanadaFederalTax() {
		return canadaFederalTax;
	}

	public void setCanadaFederalTax(CanadaFederalTax canadaFederalTax) {
		this.canadaFederalTax = canadaFederalTax;
	}
	
	public void calculate() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String message = String.format("%s you owe the Canadian government %s in taxes.", 
				canadaFederalTax.getName(),
				currencyFormat.format( canadaFederalTax.federalTax())
				);
		JSFHelper.addInfoMessage(message);
	}
}
