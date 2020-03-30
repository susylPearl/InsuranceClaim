<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Finance Review Page</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="row"
		style="padding-left: 100px; padding-right: 100px; margin-top: 50px">
		<div class="panel panel-primary">

			<c:url var="logoutUrl" value="/logout" />
			<form class="form-inline" action="${logoutUrl}" method="post">

				<input type="submit" value="Log out"
					style="float: right; margin-top: 10px; margin-right: 5px" /> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center">Lab Test
						Fee</h3>
				</div>
			</div>


			<form:form action="/InsuranceMedicalClaim/detailClaimLabTestReport" modelAttribute="financereviewlabtest">

				<div class="row"
					style="padding-left: 100px; padding-right: 100px; margin-top: 50px">
					<div class="panel panel-primary">
						<table class="table table-bordered">

							<th style="border-color: navy;">Bill Ref No</th>
							<th style="border-color: navy;">Description</th>
							<th style="border-color: navy;">Amount</th>
							<th style="border-color: navy;">Total</th>


							<c:forEach items="${listclaims}" var="claimstatement">
								<tr>
									<td style="border-color: navy;"><input type="text"
										style="border: none;" value="${claimstatement.billrefno}"
										readonly="true" /></td>
									<td style="border-color: navy;"><input type="text"
										style="border: none;" value="${claimstatement.description}"
										readonly="true" /></td>
									<td style="border-color: navy;"><input type="text"
										style="border: none;" value="${claimstatement.amoount}"
										readonly="true" /></td>
									<td style="border-color: navy;"><input type="text"
										style="border: none;" value="${claimstatement.total}"
										readonly="true" /></td>






								</tr>
							</c:forEach>



						</table>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-4"></div>
					<div class="col-lg-2">
						<button class="btn btn-success" value="Decline" name="decline"
							id="next">Decline</button>
						<button class="btn btn-success" value="Approve" name="approve"
							id="next">Approve</button>

					</div>

					<br>
                  
					<div class="row" 
						style="padding-left: 100px; padding-right: 0px; margin-top: 50px">
						
						<div class="col-lg-2">
							<th><strong>Comment:</strong></th> 
						</div>
						<div class="col-lg-6">

							<textarea rows="3" cols="20" class="form-control" name="comment"
								path="comment" maxlength="100" id="comment"> </textarea>
							

						</div>
						</div>
						
						<c:if test="${not empty error}">
							<label style="color: red;padding-left: 315px" class="col-lg-7 control-label">
						     ${error}
						</label>
						</c:if>
						
						<c:if test="${not empty msg}">
						<label class="col-lg-7 control-label" style="color: gray;padding-left: 315px">
						     ${msg}
						</label>
						</c:if>
						
					
					
					<br>
				</div>






			</form:form>
		</div>
	</div>
</body>
</html>