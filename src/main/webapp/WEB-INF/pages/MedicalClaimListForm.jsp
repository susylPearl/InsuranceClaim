<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
 <style type="text/css">
  .error {
	color: red;
	font-weight: bold;
}
 </style>
 
</head>
<body>
	 
	 
  <form:form action="saveclaimstatement" method="post" modelAttribute="claimstatement">
	
	<div class="row" style="padding-left: 100px;padding-right: 100px;margin-top: 50px">
            <div class="panel panel-primary">    
               <div class="panel-heading">
                        <h3 class="panel-title" style="text-align: center">Doctor /Physician  /Specialist's fee</h3>
                    </div>           
		
		<table class="table table-bordered" style="border-width: 2px">

			<th>Bill Ref No</th>
			<th>Description</th>
			<th>Amount</th>
			<th>Total</th>
					
				<tr>

					     <form:hidden path="id"/>
					     <form:hidden path="claimtype" name="claimtype" value="doctorsClinicFee"/>
					     
					     
					  <spring:bind path="billrefno">   		   
					 	 <td><form:input path="billrefno"/>
					  	<form:errors path="billrefno" cssClass="error"/></td>
					  </spring:bind>
					  
					  
					  <spring:bind path="description">
					  <td><form:input path="description"/>
					<form:errors path="description" cssClass="error" /></td>
					  </spring:bind>
					  
					  <spring:bind path="amoount">
					   <td><form:input type="number" path="amoount"/>
					    <form:errors path="amoount" cssClass="error" /></td>
					   </spring:bind>
					   
					   <spring:bind path="total">
					    <td><form:input type="number" path="total"/>
					     <form:errors path="total" cssClass="error"/></td>
					    </spring:bind>
					    
					  

				</tr>
				
				
			
		</table>
		</div>
		<button type="submit" name = "save" class="btn btn-primary pull-right" style="width: auto;">Save</button>
		</div>
		
		
		
		
	
	   
	
	
	
	<div class="row" style="padding-left: 100px;padding-right: 100px;margin-top: 50px">
            <div class="panel panel-primary">    
	<table class="table table-bordered">
	
			<th style="border-color: navy;">Bill Ref No</th>
			<th style="border-color: navy;">Description</th>
			<th style="border-color: navy;">Amount</th>
			<th style="border-color: navy;">Total</th>
			<th style="border-color: navy;">Operations</th>
			
	<c:forEach items="${list}" var="claimstatement">
		<tr>
			  		  <td  style="border-color: navy;"><input type="text" style="border:none; " value="${claimstatement.billrefno}" readonly="readonly" /></td>
					  <td style="border-color: navy;"><input type="text" style="border:none; " value="${claimstatement.description}" readonly="readonly" /></td>
					  <td style="border-color: navy;"><input type="text" style="border:none; " value="${claimstatement.amoount}" readonly="readonly"/></td>
					  <td style="border-color: navy;"><input type="text" style="border:none; " value="${claimstatement.total}" readonly="readonly"/></td>
					  <td style="border-color: navy;"><center>
					  <a href="<c:url value='/editStatemnet/${claimstatement.billrefno},${claimstatement.description},${claimstatement.amoount},${claimstatement.total},${claimstatement.claimtype},${claimstatement.id}'/>">Change</a>
					 
					  </td>
					  
					 
			
		</tr>
	</c:forEach>
	
	
	

	
	
	
	
	</table>
	
	</div>
	<div>
		<button type="submit" name="next" class="btn btn-primary pull-right" style="width: auto;">Next</button>
		</div>
	
	</div>
	
	
	
	
	  </form:form>
	
	
	
</body>
</html>