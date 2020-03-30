<%-- 
    Document   : medicalclaimform
    Created on : Jun 20, 2017, 10:41:24 AM
    Author     : ritendra
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>



<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title>
            Medical Insurance Claim Form
        </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
        </script> 

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--        css link for bootstrap-->
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <!--        css and js link for bootstrap datetimepicker-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>


    </head>
    <body>

        <script>


        </script>


<!--  <p> -->
<%--       Welcome <b><c:out value="${pageContext.request.remoteUser}"/></b> --%>
<!--     </p> -->
<%--     <c:url var="logoutUrl" value="/logout"/> --%>
<%--     <form class="form-inline" action="${logoutUrl}" method="post"> --%>
<!--       <input type="submit" value="Log out" /> -->
<%--       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
<%--     </form> --%>

	<c:if test="${not empty msg}">
				    <div class="col-lg-10 col-lg-offset-1	 alert alert-success" style="margin-top: 20px">
				     <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  						<strong>Info! ${msg}</strong>
					</div>
				</c:if>
				
				<c:if test="${not empty error}">
				    <div class="col-lg-10 col-lg-offset-1	 alert alert-danger" style="margin-top: 20px">
				     <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  						<strong>Warning! ${error}</strong>
					</div>
				</c:if>

<br>

        <form:form id="form" method="POST" action="addMedicalClaim" modelAttribute="medicalclaim">
        
        

            <div class="row" style="padding-left: 100px;padding-right: 100px; margin-top: 50px">
                <br>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Medical Claim Form</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row" style="padding-left: 150px;padding-right: 150px;">
                        
                       
                        
                            <div class="col-lg-4 col-lg-offset-4">


                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLdi-kE9RiLltouWrtjgGLR-jroIU_QKapjG_q-Mdyckoey4ucLaYqsEo" class="img-thumbnail" alt="javra" width="500" height="240"> 
                            </div>
                            <div class="col-lg-12" style="margin-top: 30px">
                            
                             <form:hidden path="id"/>  

						<spring:bind path="nameOfInsured">
							<div class="row">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                        Name of Insured :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" path="nameOfInsured"  readonly="true" />

                                    </div>

                                </div>
                                </spring:bind>
                                <br>


                                <div class="row">
                                <div class="col-lg-6">
                                	<label class="col-lg-3 control-label" style="color: gray;">
                                     Policy No :
                                    </label>
                                    <div class="col-lg-3 col-lg-offset-2">

                                        <form:input type="text" placeholder="" class="form-control" name = "policyNo" path="policyNo" readonly="true" />

                                    </div>
                                </div>
                                
                                 <div class="col-lg-6">
                                 	<label class="col-lg-3  col-lg-offset-2 control-label" style="color: gray;">
                                        Period of Insurance :
                                    </label>
                                    <div class="col-lg-3">

                                        <form:input type="text" placeholder="" class="form-control" name="policyNo" path="policyNo"  readonly="true" />

                                    </div>
                                </div>
                               
                                </div>

                                <br>

						 <spring:bind path="businessAddress">
                                <div class="row">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                        Business Address :
                                    </label>

                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="businessAddress" path="businessAddress" readonly="true" />

                                    </div>  

                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="businessPhoneNo">
                                <div class="row">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Phone / Contact Number:
                                    </label>

                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="businessPhoneNo" path="businessPhoneNo" readonly="true" />

                                    </div>  

                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="BusinessFaxNo">
                                <div class="row">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                      Business Fax No :
                                    </label>

                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="BusinessFaxNo" path="BusinessFaxNo" readonly="true" />

                                    </div>  

                                </div>
                                </spring:bind>
                                <br>
                               
							<spring:bind path="claimantName">
                                <div class="row">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                        Claimant i.e. Employee Name :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" path="claimantName"/>
                                         <form:errors path="claimantName" class="control-label" />
                                    </div>
                                   
                                </div>
                                </div>
                                </spring:bind>
                                <br>

						<spring:bind path="claimantOccupation">
                                <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Claimant Occupation :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantOccupation" path="claimantOccupation" />
										<form:errors path="claimantOccupation" class="control-label" />
                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                             <spring:bind path="claimantAge">   
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Claimant Age :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="number" min="15" class="form-control" name="claimantAge" path="claimantAge" />
										<form:errors path="claimantAge" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                 <spring:bind path="claimantSex">   
                                 <div class="row">
                                  <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Claimant Sex :
                                    </label>
                                    <div class="col-lg-6">

<%--                                         <form:input type="text" placeholder="" class="form-control" name="claimantSex" path="claimantSex" /> --%>
                                        <form:select class="form-control" name="claimantSex" path="claimantSex">
			                            <option>Male</option>
			                            <option>Female</option>
			                            </form:select>
										<form:errors path="claimantSex" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                 <spring:bind path="patientName">   
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Patient Name :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientName" path="patientName" />
										<form:errors path="patientName" class="control-label" />
                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="patientAge">   
                                  <div class="row">
                                  <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Patient Age :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="number" min="15" class="form-control" name="patientAge" path="patientAge" />
										<form:errors path="patientAge" class="control-label" />
                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="patientSex">  
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Patient Sex :
                                    </label>
                                    <div class="col-lg-6">

<%--                                         <form:input type="text" placeholder="" class="form-control" name="patientSex"  path="patientSex"/> --%>
                                        <form:select class="form-control" name="patientSex" path="patientSex">
			                            <option>Male</option>
			                            <option>Female</option>
			                            </form:select>
										<form:errors path="patientSex" class="control-label" />
                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="claimantRelationToPatient"> 
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Claimant relation to the patient :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantRelationToPatient" path="claimantRelationToPatient" />
										<form:errors path="claimantRelationToPatient" class="control-label" />
                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="patientResAddress"> 
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Patient Address :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientResAddress" path="patientResAddress" />
										<form:errors path="patientResAddress" class="control-label" />
                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="patientphoneNo"> 
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Patient Phone Number :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientphoneNo" path="patientphoneNo"/>
										<form:errors path="patientphoneNo" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       <label style="color: navy;">Treatment was due to :</label>
                                    </div>
                                    <div class="col-lg-10">

                                      

                                    </div>
                                </div>
                                <br>
                                
                                 
                                 <spring:bind path="dateOfSymptomsStarted"> 
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Illness :(Date Started)
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="date" placeholder="" class="form-control" name="dateOfSymptomsStarted" path="dateOfSymptomsStarted"/>

                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="dateOfFirstIllenessTreatement"> 
                                  <div class="row">
                                  <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Illness :(Date 1st Treated)
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="date" placeholder="" class="form-control" name="dateOfFirstIllenessTreatement" path="dateOfFirstIllenessTreatement" />

                                    </div>
                                    </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="dateTimeOfAccident">
                                  <div class="row">
                                  <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Accident :(Date Started)
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="date" placeholder="" class="form-control" name="dateTimeOfAccident" path="dateTimeOfAccident" />

                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="dateOfFirstAccidentTreatment">
                                <div class="row">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Accident :(Date 1st Treated)
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="date" placeholder="" class="form-control" name="dateOfFirstAccidentTreatment" path="dateOfFirstAccidentTreatment" />

                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="symptomOfIllness">
                                <div class="row">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Give details of diagnosis/ symptom of illness :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:textarea rows="2" cols="20" class="form-control" name="symptomOfIllness" path= "symptomOfIllness" maxlength="100" /> 

                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="natureAndCauseOfInjuries">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Give details of nature of injuries and how injuries were caused:
                                    </label>
                                    <div class="col-lg-6">

                                        <form:textarea rows="3" cols="20" class="form-control" name="natureAndCauseOfInjuries" path="natureAndCauseOfInjuries" maxlength="150" /> 

                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="nameOfAttendingDoctor">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Doctor Name :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="nameOfAttendingDoctor" path = "nameOfAttendingDoctor" />
										<form:errors path="nameOfAttendingDoctor" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="doctorQualification">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Doctor Qualification :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorQualification" path = "doctorQualification"/>
										<form:errors path="doctorQualification" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="doctorNmcNo">
                                <div class="row">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Doctor N.M.C number :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorNmcNo" path ="doctorNmcNo" />
										<form:errors path="doctorNmcNo" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="doctorContactAddress">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Doctor Address :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorContactAddress" path ="doctorContactAddress" />
										<form:errors path="doctorContactAddress" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="doctorPhoneNo">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Doctor Phone number :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorPhoneNo" path ="doctorPhoneNo" />
										<form:errors path="doctorPhoneNo" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                 <spring:bind path="dateOfClaim">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Date of Claim:
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="date" placeholder="" class="form-control" name="dateOfClaim" path="dateOfClaim"/>
										<form:errors path="dateOfClaim" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="totalClaimedAmount">
                                 <div class="row">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-2 control-label" style="color: gray;">
                                       Total Claimed Amount :
                                    </label>
                                    <div class="col-lg-6">

                                        <form:input type="number" min="0" placeholder="" class="form-control" name="totalClaimedAmount" path="totalClaimedAmount"/>
										<form:errors path="totalClaimedAmount" class="control-label" />
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                                <spring:bind path="CoDoctorVisitDate">
                                <div class="row">
                                
                                    <div class="col-lg-10 control-label">
                                       <label style="color: navy;">Can the patient be available at above given address for visit by Co's Doctor ? If so, when ?</label>
                                    </div>
                                    <div class="col-lg-2">
										
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <div class="col-lg-3">
                                      <form:input type="date" placeholder="" class="form-control" name="CoDoctorVisitDate" path="CoDoctorVisitDate"/>
                                    <form:errors path="CoDoctorVisitDate" class="control-label" />
                                    </div>
                                    <div class="col-lg-6">
										
                                    </div>
                                </div>
                                </div>
                                </spring:bind>
                                <br>
                                
                                
                               
                                
                                
                             
                                <div class="row">
                                    <div class="col-lg-8">
                                       <label style="color: navy;">We hereby declare that the foregoing statements are true to the best of our knowledge.</label>
                                    </div>
                                    <div class="col-lg-4">
										
                                    </div>
                                </div>
                                <br>
                             
                             <div class="row">
                                        <div class="col-lg-4">
                                        </div>
                                        <div class="col-lg-2">
									<c:choose>
										<c:when test="${isNew}">
											<button class="btn btn-success" value="Add" name="add" id="add">Add</button>
										</c:when>

										<c:otherwise>
											<button class="btn btn-success" value="Edit" name="edit" id="edit">Next</button>
										</c:otherwise>

									</c:choose>
									
  
                                        </div>
                                       
                                    </div>
                               </div>

                        </div>
                    </div>
                </div>  
                </div>  

                <script type="text/javascript" src="lib/jquery-1.11.0.js"></script>
                <script type="text/javascript" src="lib/bootstrap.js"></script>
            </form:form>

    </body>


</html>