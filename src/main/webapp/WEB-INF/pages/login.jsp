<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head th:include="layout :: head(title=~{::title},links=~{})">
    <title>Please Login</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
   

    
    <div class="container"  style="margin-top: 150px">
    <div class="row">
        <div class="col-sm-4 col-md-3 col-md-offset-4">
<!--             <h1 class="text-center login-title">Insurace Claim</h1> -->
<!--             <div class="account-wall"> -->
            <div class="avatar ">
                    <img src="http://assets-cdn.javra.com/wp-content/uploads/2016/02/javra-logo.png" 
                    alt=""style="margin-bottom: 30px; height: 100px; width: 250px" />
                </div>
               
                     <c:url var="login" value="/login"></c:url>
                <form class="form-signin"  action="${login}" method="post">
                <input type="text" class="form-control" placeholder="Username" name="username" autofocus>
                
                <br>
                <input type="password" class="form-control" placeholder="Password" name="password" required>
                
                <c:if test="${not empty error}">
					<label class="error control-label" style="color: red;">${error}</label>
				</c:if>
				
				<c:if test="${not empty msg}">
					<label class="msg control-label">${msg}</label>
				</c:if>
                
<!--                  <label id="remember" class="checkbox"> -->
<!--                     <input type="checkbox" value="remember-me"> -->
<!--                     Remember me -->
<!--                 </label> -->
                
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Login &nbsp;&nbsp; <i class="fa fa-sign-in"></i></button>
                    
                   <br>
                    <label style="color: navy;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Login to claim insurance.</label>
               
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                </form>
<!--             </div> -->
        </div>
    </div>
</div>

 </body>
</html>

