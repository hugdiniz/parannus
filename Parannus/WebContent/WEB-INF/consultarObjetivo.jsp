<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<body>
  
  <!--  <div class="menuSecundario">
			<span style="font-size:20px;">Consulta Solicitação</span>
			<a class="btn btn-primary collapsed pull-right" href="/Parannus/Criar" >Criar Solicitação</a>
		<hr style="margin-top: 7px;	">
		</div>-->								
		<div class="camposBotao">
			<form action="ConsultarSolicitacao" method="post">
			<div>					
				<div class="Table">				    
				    <div class="Row">
				        <div class="Cell">
				            <span>Descrição</span>
				        </div>
				        <div class="Cell">
				            <input type="text"  name="tipo" class="input-block-level"  placeholder="">
				        </div>				        
				    </div>
				</div>	
				<input class="btn btn-primary collapsed" type="submit" name="buscar" value="Buscar">		
			</div>
			</form>
			
			<c:if test='${!empty objetivos'>
				<table class="table">
	      			<caption>Resultado da Consulta</caption>
					<thead>
			        	<tr>		          
			          	<th>Objetivo</th>
			          	</tr>
			      	</thead>
			    	<tbody>
						<c:forEach var="solicitacao" items="${objetivos}" >
							<tr>          
			          			<td>${objetivo.descricao}</td>
			          		<!-- 	<td><a style="margin-left: 60%; "class="btn btn-primary collapsed" href="/Parannus/EditarObjetivo?id=${objetivo.id}" ><span aria-hidden="true" class="glyphicon glyphicon-cog"></span></a></td>
			        	 -->	</tr>			    			
						</c:forEach>
					</tbody>
				</table>
			</c:if>

		</div>
	

		
</body>
</html>