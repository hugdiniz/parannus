<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<body>
  
  <div class="menuSecundario">
			<span style="font-size:20px;">Consulta Objetivo</span>
		<hr style="margin-top: 7px;	">
		</div>								
		<div class="camposBotao">
			<form action="ConsultarObjetivo" method="post">
			<div>
			<table>
 			<tr><br>
  			 <td><font face="verdana" color="#4682B4"> Descricao:  </font></td>
  			 <td><input type="text" class="input-block-level" name="descricao" ></td>
		    </tr>
			</table><br><br>
			<input class="btn btn-primary collapsed" type="submit" name="buscar" value="Buscar">
			</div>
			</div>
			</form>			
</body>
</html>