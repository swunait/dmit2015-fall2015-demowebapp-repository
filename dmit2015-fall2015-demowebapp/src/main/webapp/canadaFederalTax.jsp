<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="ca.nait.dmit.domain.CanadaFederalTax, java.text.NumberFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canada Federal Tax</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	
	<div class="container">
		<div class="jumbotron">
			<h1>Canada Federal Tax Calculator</h1>
		</div>
<%
if( request.getMethod().equalsIgnoreCase("POST") )
{
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
		out.println(htmlResponseText);
	} else {
		out.println(errors.toString());
	}
}
%>

			
		<form method="post" action="canadaFederalTax.jsp">
			<div class="form-group">
				<label for="username">Your Name:</label>
				<input type="text" id="username" name="username" class="form-control" required="required" placeholder="enter your name"/>
			</div>
			
			<div class="form-group">
				<label for="taxbleIncome">Your Taxable Income:</label>
				<input type="text" id="taxableIncome" name="taxableIncome" class="form-control" required="required" placeholder="enter your taxable income"/>
			</div>
			
			<input type="submit" value="Calculate" class="btn btn-primary" />
		
		</form>
	</div>

</body>
</html>