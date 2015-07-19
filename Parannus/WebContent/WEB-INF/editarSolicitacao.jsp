<%@ include file="header.jsp" %>

<script>
$(function ()
{
	
});

function criarObjetivo(objetivoNome)
{	
	novoObjetivo = '<div><span id="objetivoDescricao">'+objetivoNome+'</span><a onclick="retirarObjetivo(this)" class="glyphicon glyphicon-minus retirarButton"></a></div>';
	$("#divObjetivos").append(novoObjetivo);
}
function retirarObjetivo(campo)
{
	campo.parentElement.remove();	
}

function enviar()
{	
	var objetivos = "[";
	var primeiro = true;
	for(i=0;i<$('#divObjetivos span').size();i++)
	{
		objetivo = $('#divObjetivos span')[i].innerHTML;
		if(primeiro)
		{
			objetivos = objetivos + objetivo;
			primeiro = false;
		}
		else
		{
			objetivos = objetivos +","+ objetivo;
		}			
	}
	objetivos = objetivos +"]";
	$("#inputObjetivos").val(objetivos);
	alert(objetivos);
	$("form").submit();
}


</script>




<html>	
	<body>
	
		<div class="menuSecundario">
			<span style="font-size:20px;">Editar Solicitação</span>			
		<hr style="margin-top: 7px;	">
		</div>								
		<div class="camposBotao">
			<form action="EditarSolicitacao" method="post">
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
						
				
				<input id="idObjetivo" type="hidden" name="id" value="${solicitacao.id}">
				
				<input id="inputObjetivos" type="hidden" name="objetivos" value="">
				<div class="menuSecundario" style="margin-top:2%;">
					<span style="font-size:19px;">Objetivos</span>
					<button type="button" class="btn btn-primary " style="margin-left: 80%; font-size:95%;" data-toggle="modal" data-target="#objetivoModal">Criar Objetivo</button>			
					<hr style="margin-top: 7px;	">
					<div id="divObjetivos">
						<c:forEach var="objetivo" items="${solicitacao.objetivos}" >
							<div><span id="objetivoDescricao">${objetivo.objetivoNome}</span><a  onclick="retirarObjetivo(this)" class="glyphicon glyphicon-minus retirarButton"></a></div>					    			
						</c:forEach>
					</div>					
					
				</div>
				<input class="btn btn-primary collapsed" style="margin-top: 3%; width: 75px;" onclick="enviar()" name="salvar" value="Salvar">
				<a class="btn btn-primary collapsed" style="margin-top: 3%;" href="/Parannus/ConsultarSolicitacao">Voltar</a>
			</div>
			</form>
		</div>	
	</body>
</html>