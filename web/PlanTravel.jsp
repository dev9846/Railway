<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan My Travel</title>
        <link rel="stylesheet" href="css/railway.css" type="text/css" />
    </head>
    <body>
        <div class="center">
            <%@include file="includes/header.jsp" %>
            <br/>
            <div class="fromTo">
                <h4 style="font-family: calibri">Station From</h4>
                <input type="text" name="txtFrom" placeholder="Station From" class="textbox"/>
                <br/>
                <br/>
                <h4 style="font-family: calibri">Station To</h4>
                <input type="" name="txtTo" placeholder="Station To" class="textbox"/>
                <br/>
                <br/>
                <h4 style="font-family: calibri">Date</h4>
                <input type="datetime" name="txtDate" placeholder="Date" class="textbox"/>
                <br/>
                <br/>
                <div style="margin: 0 auto; width: 100px ">
                    <input type="submit" name="Find" value="Find" class="newButtonLink" />
                </div>
            </div>
            <div class="trainList">
                
            </div>
        </div>
    </body>
</html>
