package ca.nait.dmit.servlet;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.nait.dmit.domain.CanadaFederalTax;

/**
 * Servlet implementation class CanadaFederalTaxServlet
 */
@WebServlet("/CanadaFederalTaxServlet")
public class CanadaFederalTaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CanadaFederalTaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		String name = request.getParameter("username");
		String taxableIncomeString = request.getParameter("taxableIncome");
		
		int errorCount = 0;
		StringBuffer errors = new StringBuffer("Please fix the following issue(s):");
		errors.append("<ul class=\"bg-danger\">");
		if( name.isEmpty() ) {
			errors.append("<li>Name is required.</li>");
			errorCount++;
		}
		if( taxableIncomeString == null || taxableIncomeString.isEmpty() ) {
			errors.append("<li>Taxable Income is required.</li>");
			errorCount++;
		}
		errors.append("</ul>");
		if( errorCount == 0 ) {
			double taxableIncome = Double.parseDouble( taxableIncomeString );
			CanadaFederalTax canadaFederalTax = new CanadaFederalTax();
			canadaFederalTax.setName(name);
			canadaFederalTax.setTaxableIncome(taxableIncome);
			
			NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
			String htmlResponseText = "<strong>" + canadaFederalTax.getName() + "</strong> you owe the Canadian government <strong>"
					+ currencyFormat.format(canadaFederalTax.federalTax()) + "</strong> in federal taxes.";
			response.getWriter().println(htmlResponseText);
		} else {
			response.getWriter().println(errors.toString());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
