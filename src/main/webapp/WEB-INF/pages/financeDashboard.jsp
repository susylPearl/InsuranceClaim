<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Finance Approve Page</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


  
	<%-- <div class="row"
		style="padding-left: 100px; padding-right: 100px; margin-top: 50px">
		 
		<c:url var="logoutUrl" value="/logout" />
		<form class="form-inline" action="${logoutUrl}" method="post">
		  
			<input  type="submit" value="Log out" style="float: right;margin-top: 10px;
			margin-right: 5px"/> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title" style="text-align: center">Finance
					Approval Form</h3>
			</div>
		</div>
		<p>
			Welcome <b><c:out value="${pageContext.request.remoteUser}" /></b>
		<div>
			<tr>

    		<td><input  style="border:none; text-align:center" name = "totalclaim"><a href="<c:url value='/getFinanceClaims/'/>">View
						No of Claims </a></td>
						<td><input style="border:none; text-align:center" name = "totalclaim" value = "${noofclaims}" readonly="true"><center></td>
						<td><input  style="border:none; text-align:center" name = ""><a href="<c:url value='/report/download/xls/'/>">Download Claim Report
						</a></td>
						<td><input  style="border:none; text-align:center" name = ""><a href="<c:url value='/report/pdf/'/>">View  Claim Report Pdf
						</a></td>
		
			
			
						
			</tr>
			
			
			
                               
     

		</div>


		
	</div> --%>
	
	<div class="row" style="padding-left: 100px; padding-right: 100px; margin-top: 50px">
		 
		
		<div class="panel panel-primary">
			<div class="panel-heading" style="height: 20px">
				
					
				<c:url var="logoutUrl" value="/logout" />
				<form class="form-inline" action="${logoutUrl}" method="post">
				  
					<button class="btn btn-small pull-right"  type="submit" value="Log out">Logout</button> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				
			</div>
			
			<div class="panel-heading">
				<h3 class="panel-title" style="text-align: center">Finance
					Approval Form</h3>
			</div>
		
		<div style="padding-left: 100px; padding-right: 100px; margin-top: 30px">
		<p>
			Welcome <b><c:out value="${pageContext.request.remoteUser}" /></b>
		
			
						<tr >

    		<td><input  style="border:none; text-align:center" name = "totalclaim"><a href="<c:url value='/getFinanceClaims/'/>">View
						No of Claims </a></td>
						<td><input style="border:none; text-align:center" name = "totalclaim" value = "${noofclaims}" readonly="true"><center></td>
						<td><input  style="border:none; text-align:center" name = ""><a href="<c:url value='/report/download/xls/'/>">Download Claim Report
						</a></td>
						<td><input  style="border:none; text-align:center" name = ""><a href="<c:url value='/report/pdf/'/>">View  Claim Report Pdf
						</a></td>
		
			
			
						
			</tr>

          </div>
		
	</div>
	

	
</body>
</html>