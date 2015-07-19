<html>
	<%@ include file="header.jsp" %>
	<body>
	
		<div class="menuSecundario">
			<span style="font-size:20px;">Criar Solicitação</span>			
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
				<div style="margin-top: 3%;">
					<input class="btn btn-primary collapsed" type="submit" name="criar" value="Criar">
					<a class="btn btn-primary collapsed" href="/Parannus/ConsultarSolicitacao">Voltar</a>	
				</div>	
			</div>
			</form>
		</div>
	</body>
</html>