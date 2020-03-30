<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!--  <h1 style="text-align: center">Doctor/physician/specialist's fees for visit to the patient at home.</h1> -->
	 
  <form:form action="editAndRedirect" method="post" modelAttribute="claimStatement">
	
	<div class="row" style="padding-left: 100px;padding-right: 100px;margin-top: 50px">
            <div class="panel panel-primary">    
	<table class="table table-bordered">
	
			<th style="border-color: navy;">Bill Ref No</th>
			<th style="border-color: navy;">Description</th>
			<th style="border-color: navy;">Amount</th>
			<th style="border-color: navy;">Total</th>
			<th style="border-color: navy;">Operations</th>
			
	
		<tr>
		
					  <form:hidden path="id"/>
					  <form:hidden path="claimtype"/>
			  		  <td  style="border-color: navy;"><form:input type="text" path = "billrefno" /></td>
			  		 
					  <td style="border-color: navy;"><form:input type="text"  path = "description" /></td>
					  <td style="border-color: navy;"><form:input type="text" path = "amoount"  /></td>
					  <td style="border-color: navy;"><form:input type="text"  path = "total" /></td>
					 
					 <!--  <a href="#" style="margin-right: 20px">Change</a> -->
					  
<%-- 					 <a href="<c:url value='/editAndRedirect/${billrefno},${description},${amoount},${total},${claimtype},${id}'/>">Edit</a>
 --%>					  <td colspan="2" align="center"><input type="submit" value="Update"></td>
					  
					 
					  
					 
			
		</tr>
		
	</table>
	
	</div>
	
	</div>	
	  </form:form>
	
</body>
</html>