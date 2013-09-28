<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="model.*"%>
<%@page import="DbClasses.*"%>
<%
    //DatabaseHelper dbHelper = new DatabaseHelper();
    String username = request.getParameter("txtUsername");
    String password = request.getParameter("txtPass");
    
   // UserT user = new UserTData().getTestUser();
   UserT user = new UserTData().getUser(username, password);
   // UserT user = new UserTData().getUser(username);
    
    //for(UserT user : new UserTData().getUsers())
    //{
      //  System.out.print(user.getUsername() + " " + user.getPassword());
       /* if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            session.setAttribute("User", user);
            break;
        }*/
    //}
    
   
    session.setAttribute("User", user);
   
    
    response.sendRedirect(request.getContextPath() + "/PlanTravel.jsp");

%>
