<script>
function adicionarObjetivo(objetivo)
{
	objetivo = JSON.parse('{"objetivoNome"="'+objetivo+'"}');
	objetivos = JSON.parse($("#objetivosJSON").val());	
	
}

</script>


<div class="modal fade" id="objetivoModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Criar Objetivo</h4>
      </div>
      <div class="modal-body">
        <span>Objetivo: </span><input id="inputModalObjetivo" type="text" class="input-block-level">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<html>
	<%@ include file="header.jsp" %>
	<body>
	
		<div class="menuSecundario">
			<span style="font-size:20px;">Editar Solicitação</span>			
		<hr style="margin-top: 7px;	">
		</div>								
		<div class="camposBotao">
			<form action="CriarSolicitacao" method="post">
			<div>	
				<table>
					<tr>
						<td>
							<span>Tipo da solicitação</span>		
						</td>
						<td>
							<input type="text"  name="tipo" class="input-block-level"  value="${solicitacao.tipo}">	
						</td>
					</tr>
						<tr>
							<td>
								<span>Sugestão</span>
							</td>
							<td>
								<input type="text"  name="sugestao" class="input-block-level" value="${solicitacao.sugestao}">
							</td>
						</tr>
					<tr>
						<td>
							<span>Impacto</span>
						</td>
						<td>
							<input type="text"  name="impacto" class="input-block-level" value="${solicitacao.impacto}">
						</td>
					</tr>				
				</table>				
						
				
				
				<input id="objetivosJSON" type="hidden" name="objetivos" value="${solicitacao.objetivos}">
				<div class="menuSecundario" style="margin-top:2%;">
					<span style="font-size:19px;">Objetivos</span>
					<button type="button" class="btn btn-primary " style="margin-left: 80%; font-size:95%;" data-toggle="modal" data-target="#objetivoModal">Criar Objetivo</button>			
					<hr style="margin-top: 7px;	">
					<div>
						<c:forEach var="objetivo" items="${solicitacao.objetivos}" >
							<span id="${objetivo.id}Objetivo">${objetivo.objetivoNome}</span><a class="glyphicon glyphicon-minus retirarButton"></a>					    			
						</c:forEach>
					</div>					
					
				</div>
				<input class="btn btn-primary collapsed" style="margin-top: 3%;" type="submit" name="criar" value="Criar">
				<a class="btn btn-primary collapsed" style="margin-top: 3%;" href="/Parannus/ConsultarSolicitacao">Voltar</a>
			</div>
			</form>
		</div>
	</body>
</html>