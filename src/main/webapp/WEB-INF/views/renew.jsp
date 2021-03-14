<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head lang="en">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Renewal Policy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/components/header.jsp" />
	<h1>Renewal Policy</h1>

	<div class="container-fluid">
		<c:if test="${!empty messages}">
			<div class="alert alert-warning">
				<p>${messages }</p>
			</div>
		</c:if>
		<form:form method="POST" action="renewPolicy" modelAttribute="policy">
			<div class="mb-3">
				<label for="PolicyNo" class="form-label">Policy No: ${policyId }</label> <input
					type="text" class="form-control" name="policyNo" id="PolicyNo"
					value="${policyID }" hidden required>
			</div>
			<div class="mb-3">
				<label for="RenewalDate" class="form-label">Renewal Date</label> <input
					type="date" class="form-control" name="renewalDate" readonly
					id="RenewalDate" value="${renewalDate}">
			</div>
			<div class="mb-3">
				<label for="ExpiryDate" class="form-label">Expiry Date</label> <input
					type="date" class="form-control" name="expiryDate" 
					id="ExpiryDate" required>
			</div>
			<div class="mb-3">
				<label for="PolicyOwner" class="form-label">Policy Owner</label> <input
					type="text" class="form-control" name="policyOwner" id="policyno"
					readonly value="${p}">
			</div>
			<div class="mb-3">
				<label for="EngineNo" class="form-label">Engine No:</label> <input
					type="text" class="form-control" name="engineNo" id="EngineNo"
					required>
			</div>
			<div class="mb-3">
				<label for="ChassisNo" class="form-label">Chassis No:</label> <input
					type="text" class="form-control" name="chassisNo" id="ChassisNo"
					required>
			</div>
			<div class="mb-3">
				<label for="vehicleRegistrationNo" class="form-label">Vehicle
					Registration No:</label> <input type="text" class="form-control"
					name="vehicleRegistrationNo" id="vehicleRegistrationNo" required>
			</div>
			<div class="mb-3">
				<label for="BillingCurrency" class="form-label">Billing
					Currency</label> <select class="form-control" id="sel1" name="billingCurrency" required>
					<option key="vnd" value="vnd" selected>VND</option>
					<option key="usd" value="usd">USD</option>
					<option key="SGD" value="SGD">SGD</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="SumInsured" class="form-label">Sum Insured:</label> <input
					type="number" class="form-control" name="sumInsured"
					id="SumInsured" min=0 required>
			</div>
			<div class="mb-3">
				<label for="Rate" class="form-label">Rate</label> <input
					type="number" class="form-control" name="rate" id="Rate" min=0 step=0.01
					required>
			</div>
			<div class="mb-3">
				<label for="AnnualPremium" class="form-label">Annual Premium</label>
				<input type="text" class="form-control" name="annualPremium"
					id="AnnualPremium" required>
			</div>
			<div class="mb-3">
				<label for="PostedPremium" class="form-label">Posted Premium</label>
				<input type="text" class="form-control" name="postedPremium" id="PostedPremium"
					required>
			</div>
			<input type="submit" class="btn btn-warning" id="issue" name="Issue" value="Issue"/>
			<button type="button" class="btn btn-secondary" id="refresh">Refresh</button>
			<input type="submit" class="btn btn-success" id="save" name="Save" value="Save"/>
		</form:form>
	</div>
	<jsp:include page="/WEB-INF/views/components/footer.jsp" />
	<script href="<c:url value="/resources/static/js/renew.js" />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script>
		$("#refresh").on(
				"click",
				function() {
					console.log("HelloWorld");
					var sumInsured = $("#SumInsured").val();
					var rate = $("#Rate").val();
					var resultAnnual = ((sumInsured * rate) / 100).toFixed(2);
					var renewDate = new Date($("#RenewalDate").val());
					var expiryDate = new Date($("#ExpiryDate").val());
					var postedPremium = 0;
					var days = Math.ceil((expiryDate.getTime() - renewDate
							.getTime())
							/ (1000 * 360 * 24));
					if (days < 0)
						alert("Expiry Date must be greater than Renewal Date");
					else {
						if(leapYear(expiryDate.getFullYear()))
							postedPremium = (resultAnnual*days/366).toFixed(2);
						else{
							postedPremium = (resultAnnual*days/365).toFixed(2);
						}
					}
					$("#PostedPremium").val(postedPremium);
					$("#AnnualPremium").val(resultAnnual);
				})

		function leapYear(year) {
			var result;
			if (year / 400) {
				result = true
			} else if (year / 100) {
				result = false
			} else if (year / 4) {
				result = true
			} else {
				result = false
			}
			return result
		}
	</script>
</body>
</html>