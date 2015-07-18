

<html>
	<%@ include file="header.jsp" %>
	<body>
	
		<div class="menuSecundario">
			<span style="font-size:20px;">Consulta Solicitação</span>
			<a style="margin-left: 60%; "class="btn btn-primary collapsed">Criar Solicitação</a>
		<hr style="margin-top: 7px;	">
		</div>								
		<div class="camposBotao">
			<form action="ConsultarSolicitacao" method="post">
			<div>	
				<table>
					<tr>
						<td>
							<span>Tipo da solicitação</span>		
						</td>
						<td>
							<input type="text"  name="tipo" class="input-block-level"  placeholder="">	
						</td>
					</tr>
						<tr>
							<td>
								<span>Sugestão</span>
							</td>
							<td>
								<input type="text"  name="sugestao" class="input-block-level" ">
							</td>
						</tr>
					<tr>
						<td>
							<span>Impacto</span>
						</td>
						<td>
							<input type="text"  name="impacto" class="input-block-level">
						</td>
					</tr>				
				</table>
				<input class="btn btn-primary collapsed" type="submit" name="buscar" value="Buscar">		
			</div>
			</form>
			
			<c:if test='${!empty solicitacaos}'>
				<table class="table">
	      			<caption>Resultado da Consulta</caption>
					<thead>
			        	<tr>		          
			          	<th>Sugestão</th>
			          	<th>Tipo da Solicitação</th>
			          	<th>Impacto</th>
			          	<th>Editar</th>
			        	</tr>
			      	</thead>
			    	<tbody>
						<c:forEach var="solicitacao" items="${solicitacaos}" >
							<tr>          
			          			<td>${solicitacao.sugestao}</td>
			          			<td>${solicitacao.tipo}</td>
			          			<td>${solicitacao.impacto}</td>
			        		</tr>			    			
						</c:forEach>
					</tbody>
				</table>
			</c:if>

		</div>
	

		

	</body>
</html>