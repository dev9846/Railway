<%-- 
    Document   : index
    Created on : Sep 14, 2013, 11:33:56 AM
    Author     : Krupal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="css/railway.css" type="text/css" />
</head>
<body>
    <div class="center">
        <%@include file="includes/header.jsp" %>
        <br/>
        hello world

        <div class="login">
            <form method="post" action="controllers/_Login.jsp">
                <h2 style="font-family: calibri">Login</h2>
                <input type="text" name="txtUsername" style="width: 85%;" class="input" placeholder="Username"/><br/><br/>
                <input type="password" name="txtPass" style="width: 85%;" class="input" placeholder="Password"/><br/>
                <br/>

                <div style="height: 45px; width: 300px;">
                    <input type="submit" name="Login" class="newButtonLink" />
                    <input type="reset" name="Cancel" class="newButtonLink" />
                </div>
                <div style="padding: 16px; font-size: 12px;">
                    <a href="#" >Forgot Password?</a>&nbsp;|&nbsp;
                    <a href="Register.html" >New Registration</a>    
                </div>
            </form>
        </div>
    </div>

</body>
