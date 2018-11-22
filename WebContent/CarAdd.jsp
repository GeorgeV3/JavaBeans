<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %> 
<jsp:useBean id="newCar" scope="request" class="pack.NewCarBean"></jsp:useBean>
<jsp:setProperty property="registration" name="newCar" param="registration"/>
<jsp:setProperty property="factory" name="newCar" param="factory"/>
<jsp:setProperty property="model" name="newCar" param="model"/>
<jsp:setProperty property="colour" name="newCar" param="colour"/>
<jsp:setProperty property="cc" name="newCar" param="cc"/>
<jsp:setProperty property="regdate" name="newCar" param="regdate"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% if (newCar.getCc() != null && newCar.getColour() != null && newCar.getFactory() != null && newCar.getModel() != null 
			&& newCar.getRegdate() != null && newCar.getRegistration() != null){
									%>
										<p><%= newCar.registerCar() %></p>
										
		<%}
		else { %>
	<form action ="CarAdd.jsp">
  Registration:<br>
  <input type="text" name="registration"  >
  <br>
  Factory:<br>
  <input type="text" name="factory" >
    <br>
   Model:<br>
  <input type="text" name="model" >
    <br>
   Colour:<br>
  <input type="text" name="colour" >
    <br>
   CC:<br>
  <input type="text" name="cc" >
    <br>
   Regdate:<br>
  <input type="text" name="regdate" >
  <br><br>
  <input type="submit" value="Submit">
  <br>
  <input type ="reset" value="Reset">
  </form>

  <% }%>

</body>
</html>