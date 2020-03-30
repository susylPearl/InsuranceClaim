<%-- 
    Document   : financeclaim
    Created on : Jun 20, 2017, 10:57:44 PM
    Author     : vivek
--%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.sql.*"%>  

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Claim Status Report</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

        <div class="row" style="padding-left: 100px;padding-right: 100px;margin-top: 50px">
            <div class="panel panel-primary">    
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center">Claim Status Report</h3>
                </div>
             
                <table class="table table-bordered"> 

                    <tr>
                        <td style="text-align: justify;"><center><b>Claimant Name</b></td>

                        <td style="text-align: justify;"><center><b>Claimant Designation</b></td>

                        <td style="text-align: justify;"><center><b>Claimant Relation to patient</b></td>

                        <td style="text-align: justify;"><center><b>Doctors Name</b></td>
                                               
                        <td style="text-align: justify;"><center><b>Claim Amount</b></td>

                        <td style="text-align: justify;"><center><b>Date of Claim</b></td>
                        
                        <td style="text-align: justify;"><center><b>Claim Status</b></td>
                        
<%--                          <td style="text-align: justify;"><center><b>Operations</b></td> --%>
                    </tr>


                    <c:forEach items="${listclaims}" var="empAppList">

                        <tr>
                            <td><input style="border:none; text-align:center" name = "empname" value = "${empAppList.claimantName}" readonly="true"><center></td>
                            <td><input style="border:none; text-align:center" name = "empDesgination" value = "${empAppList.claimantOccupation}" readonly="true"><center></td>
                            <td><input style="border:none; text-align:center" name = "empRelationToPatient" value = "${empAppList.claimantRelationToPatient}" readonly="true"><center></td>
                            <td><input style="border:none; text-align:center" name = "doctorsname" value = "${empAppList.nameOfAttendingDoctor}" readonly="true"><center></td>
                            <td><input style="border:none; text-align:center" name = "empClaimAmount" value = "${empAppList.totalClaimedAmount}" readonly="true"><center></td>
                            <td><input style="border:none; text-align:center" name = "empclaimDate" value = "${empAppList.dateOfClaim}" readonly="true"><center></td>
                             
                          
                          <c:choose>
                        	  <c:when test="${empAppList.status == 'Approved'}">
                        	  		<td><input style="border:none; text-align:center; color: gray;" name = "empclaimDate" value = "${empAppList.status}" readonly="true"><center></td>
<%-- 									<td><a href="<c:url value='/approveClaim/?claimid=${empAppList.id}'/>" >View</a></td> --%>
								</c:when>
                            
                            	<c:otherwise>
                            		<td><input style="border:none; text-align:center; color: red;" name = "empclaimDate" value = "${empAppList.status}" readonly="true"><center></td>
<%--                             		<td><a href="<c:url value='/approveClaim/?claimid=${empAppList.id}'/>" >Edit</a></td> --%>
                            	</c:otherwise>
                          </c:choose>
							
                            
                        </tr>
                        
                    </c:forEach>
                        
                </table>
                
            </div>
            <div  align="center">
                
            </div>
            
        </div>    </body>
</html>
