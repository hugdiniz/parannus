<html>
	<%@ include file="header.jsp" %>
	<body>
	
		<div class="menuSecundario">
			<span style="font-size:20px;">Consulta Solicita��o</span>
			<a class="btn btn-primary collapsed pull-right" href="/Parannus/CriarSolicitacao" >Criar Solicita��o</a>
		<hr style="margin-top: 7px;	">
		</div>								
		<div class="camposBotao">
			<form action="ConsultarSolicitacao" method="post">
			<div>					
				<div class="Table">				    
				    <div class="Row">
				        <div class="Cell">
				            <span>Tipo da solicita��o</span>
				        </div>
				        <div class="Cell">
				            <input type="text"  name="tipo" class="input-block-level"  placeholder="">
				        </div>				        
				    </div>
				    <div class="Row">
				        <div class="Cell">
				            <span>Sugest�o</span>
				        </div>
				        <div class="Cell">
				            <input type="text"  name="sugestao" class="input-block-level" ">
				        </div>				        
				    </div>
				    <div class="Row">
				        <div class="Cell">
				           <span>Impacto</span>
				        </div>
				        <div class="Cell">
				            <input type="text"  name="impacto" class="input-block-level">
				        </div>				        
				    </div>
				</div>
				
				<input class="btn btn-primary collapsed" type="submit" name="buscar" value="Buscar">		
			</div>
			</form>
			
			<c:if test='${!empty solicitacaos}'>
				<table class="table">
	      			<caption>Resultado da Consulta</caption>
					<thead>
			        	<tr>		          
			          	<th>Sugest�o</th>
			          	<th>Tipo da Solicita��o</th>
			          	<th>Impacto</th>
			        	</tr>
			      	</thead>
			    	<tbody>
						<c:forEach var="solicitacao" items="${solicitacaos}" >
							<tr>          
			          			<td>${solicitacao.sugestao}</td>
			          			<td>${solicitacao.tipo}</td>
			          			<td>${solicitacao.impacto}</td>
			          			<c:if test='${perfil == "GERENTE"}'>
   									<td><a style="margin-left: 60%; "class="btn btn-primary collapsed" href="/Parannus/EditarSolicitacao?id=${solicitacao.id}" ><span aria-hidden="true" class="glyphicon glyphicon-cog"></span></a></td>
								</c:if>			          			
			        		</tr>			    			
						</c:forEach>
					</tbody>
				</table>
			</c:if>

		</div>	

	</body>
	<%@ include file="rodape.jsp" %>
</html>