<html>
	<%@ include file="header.jsp" %>
	<body>
	
		<div class="menuSecundario">
			<span style="font-size:20px;">Consultar Objetivo</span>
		<hr style="margin-top: 7px;	">
		</div>								
		<div class="camposBotao">
			<form action="ConsultarObjetivo" method="post">
			<div>					
				<div class="Table">				    
				    <div class="Row">
				        <div class="Cell">
				            <span>Descrição</span>
				        </div>
				        <div class="Cell">
				            <input type="text"  name="descricao" class="input-block-level"  placeholder="">
				        </div>				        
				    </div>				   
				</div>
				
				<input class="btn btn-primary collapsed" type="submit" name="buscar" value="Buscar">		
			</div>
			</form>
			
			<c:if test='${!empty objetivos}'>
				<table class="table">
	      			<caption>Resultado da Consulta</caption>
					<thead>
			        	<tr>		          
			          	<th>Descrição</th>
			        	</tr>
			      	</thead>
			    	<tbody>
						<c:forEach var="objetivo" items="${objetivos}" >
							<tr>          
			          			<td>${objetivo.objetivoNome}</td>
			          		</tr>			    			
						</c:forEach>
					</tbody>
				</table>
			</c:if>

		</div>	

	</body>
	<%@ include file="rodape.jsp" %>
</html>