<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Dashboard</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


  
	<div class="row" style="padding-left: 100px; padding-right: 100px; margin-top: 50px">
		 
		
		<div class="panel panel-primary">
			<div class="panel-heading" style="height: 80px">
				
					
				<c:url var="logoutUrl" value="/logout" />
				<form class="form-inline" action="${logoutUrl}" method="post">
				  <h4 class="panel-title" style="text-align: center">User Dashboard</h4>
					<button class="btn btn-small pull-right"  type="submit" value="Log out">Logout</button> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				
			</div>
		
		<p>
<%-- 			Welcome <b><c:out value="${pageContext.request.remoteUser}" /></b> --%>
		
			
						<div>
    						<a href="<c:url value='/getMedicalClaimStatus'/>"><h4  style="margin:10px">
                            View Claims Status Count <span class="label label-info" style="size: 30px; margin-right: 20px;">${claimCount}</span>
                           </h4> </a>
                            </div>
                            
                            <c:url var="newClaimUrl" value="/redirectToMedicalClaimPage" />
                            <form class="form-inline" action="${newClaimUrl}" method="post">
	                            <div>
	                            	<button class="btn btn-primary" value="Edit" name="edit" id="edit" style="margin: 15px">New Claim</button>
	                            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	                            </div>
							</form>
			
			
			
                               
     

		</div>


		
	</div>
	
</body>
</html>