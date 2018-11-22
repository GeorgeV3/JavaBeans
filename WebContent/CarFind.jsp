<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<jsp:useBean id="newCar" scope="request" class="pack.FindCarBean"></jsp:useBean>
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

<form action ="CarFind.jsp" >
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

<% if (newCar.getCc() != null || newCar.getColour() != null || newCar.getFactory() != null || newCar.getModel() != null
            || newCar.getRegdate() != null || newCar.getRegistration() != null){
	ArrayList<pack.FindCarBean> carsList = newCar.find(); %>
	<table border="1">
	<% for(pack.FindCarBean car : carsList){
		%>
		<tr>
			<td><%= car.getRegistration() %></td>
			<td><%= car.getFactory() %></td>
			<td><%= car.getModel() %></td>
			<td><%= car.getCc() %></td>
			<td><%= car.getRegdate() %></td>
			<td><%= car.getColour() %></td>
		</tr>	
	<% 	
	}
	%>
	</table>
	<% 
	}

%>


</body>
</html>