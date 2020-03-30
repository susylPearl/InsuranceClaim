<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="medicalclaimdetails">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
              
                <td><form:input path="claimantName" value="${medicalclaimdetails.claimantName}" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Approve"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html> --%>

<!-- --------- -->

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
    
       
    </head>
    <body>

        <script>


        </script>

        <form:form id="form" method="GET" action="/InsuranceMedicalClaim/detailClaimDoctorClinicReport" modelAttribute="medicalclaimdetails">

            <div class="row" style="padding-left: 100px;padding-right: 100px;">
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


                                <div class="row">
                                    <div class="col-lg-2">
                                        Name of Insured :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" path="nameOfInsured"  readonly="true" />

                                    </div>

                                </div>
                                <br>


                                <div class="row">
                                <div class="col-lg-6">
                                	<div class="col-lg-3">
                                     Policy No :
                                    </div>
                                    <div class="col-lg-3 col-lg-offset-2">

                                        <form:input type="text" placeholder="" class="form-control" name = "policyNo" path="policyNo" readonly="true" />

                                    </div>
                                </div>
                                
                                 <div class="col-lg-6">
                                 	<div class="col-lg-3  col-lg-offset-2">
                                        Period of Insurance :
                                    </div>
                                    <div class="col-lg-3">

                                        <form:input type="text" placeholder="" class="form-control" name="policyNo" path="policyNo"  readonly="true" />

                                    </div>
                                </div>
                                    

                                </div>

                                <br>


                                <div class="row">
                                    <div class="col-lg-2">
                                        Business Address :
                                    </div>

                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="businessAddress" path="businessAddress" readonly="true" />

                                    </div>  

                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-lg-2">
                                       Phone / Contact Number :
                                    </div>

                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="businessPhoneNo" path="businessPhoneNo" readonly="true" />

                                    </div>  

                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-lg-2">
                                      Business Fax No :
                                    </div>

                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="BusinessFaxNo" path="BusinessFaxNo" readonly="true" />

                                    </div>  

                                </div>
                                <br>

                                <div class="row">
                                    <div class="col-lg-2">
                                        Claimant i.e. Employee Name :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantName" path="claimantName" readonly="true"/>

                                    </div>
                                </div>
                                <br>

                                <div class="row">
                                    <div class="col-lg-2">
                                       Claimant Occupation :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantOccupation" path="claimantOccupation" readonly="true" />

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Claimant Age :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantAge" path="claimantAge" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Claimant Sex :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantSex" path="claimantSex" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Patient Name :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientName" path="patientName" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                  <div class="row">
                                    <div class="col-lg-2">
                                       Patient Age :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientAge" path="patientAge" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Patient Sex :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientSex"  path="patientSex" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Claimant relation to the patient :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="claimantRelationToPatient" path="claimantRelationToPatient" readonly="true" />

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Patient Address :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientResAddress" path="patientResAddress" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Patient Phone Number :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="patientphoneNo" path="patientphoneNo" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       <label>Treatment was due to :</label>
                                    </div>
                                    <div class="col-lg-10">

                                      

                                    </div>
                                </div>
                                <br>
                                
                                 
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Illness :(Date Started)
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="dateOfSymptomsStarted" path="dateOfSymptomsStarted" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                  <div class="row">
                                    <div class="col-lg-2">
                                       Illness :(Date 1st Treated)
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="dateOfFirstIllenessTreatement" path="dateOfFirstIllenessTreatement" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                  <div class="row">
                                    <div class="col-lg-2">
                                       Accident :(Date Started)
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="dateTimeOfAccident" path="dateTimeOfAccident" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-lg-2">
                                       Accident :(Date 1st Treated)
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="dateOfFirstAccidentTreatment" path="dateOfFirstAccidentTreatment" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-lg-2">
                                       Give details of diagnosis/ symptom of illness :
                                    </div>
                                    <div class="col-lg-6">

                                        <textarea rows="2" cols="20" class="form-control" name="symptomOfIllness" path= "symptomOfIllness" maxlength="100" readonly="true"> </textarea>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Give details of nature of injuries and how injuries were caused:
                                    </div>
                                    <div class="col-lg-6">

                                        <textarea rows="3" cols="20" class="form-control" name="natureAndCauseOfInjuries" path="natureAndCauseOfInjuries" maxlength="150" readonly="true"> </textarea>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Doctor Name :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="nameOfAttendingDoctor" path = "nameOfAttendingDoctor" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Doctor Qualification :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorQualification" path = "doctorQualification" readonly="true" />

                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-lg-2">
                                       Doctor N.M.C number :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorNmcNo" path ="doctorNmcNo" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Doctor Address :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorContactAddress" path ="doctorContactAddress" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Doctor Phone number :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="doctorPhoneNo" path ="doctorPhoneNo" readonly="true" />

                                    </div>
                                </div>
                                <br>
                                
                                 <div class="row">
                                    <div class="col-lg-2">
                                       Total Claimed Amount :
                                    </div>
                                    <div class="col-lg-6">

                                        <form:input type="text" placeholder="" class="form-control" name="totalClaimedAmount" path="totalClaimedAmount" readonly="true"/>

                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-lg-2">
                                      
                                    </div>
                                    <div class="col-lg-10">
										 <label>We hereby declare that the foregoing statements are true to the best of our knowledge.</label>
                                    </div>
                                </div>
                                <br>

                               

                             <div class="row">
                                        <div class="col-lg-4">
                                        </div>
                                        <div class="col-lg-2">
                                            <button class="btn btn-success" value="Next" name="next" id="next">Next</button>
                                            

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
