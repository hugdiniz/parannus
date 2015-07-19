<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<%@ include file="header.jsp" %>
<style><jsp:include page="lib/bootstrap/css/bootstrap.min.css"></jsp:include></style>
<script><jsp:include page="lib/bootstrap/js/bootstrap.min.js"></jsp:include></script>

<script>
	function gerarSelect()
	{
		var tipos = JSON.parse($("#tipos").val());
		var html = "";
		for (i in tipos)
		{
			$("#perfilEnum").append("<option value='"+tipos[i]+"'>" + tipos[i] + "</option>");
		}
		
	}

	$(function ()
	{
		gerarSelect();
	});
</script>


<!--  <div class="masthead">
 	<a class="muted" href="/Parannus/"><img alt="Parannus" style="width: 120px; margin-left: 5%; margin-top: 1%;" src="imagens/Parannus.png"></a>
</div>-->

<body>
	<form action="CriarUsuario" method="post">
		<div>
		<table>
 			<tr>
  			 <td><font face="verdana" color="#4682B4"> Nome:  </font></td>
  			 <td><input type="text" class="input-block-level" name="nome" placeholder="Nome"> <br /></td>
		    </tr>
 			<tr>
  				 <td><font face="verdana" color="#4682B4"> Login: </font></td>
   				 <td><input type="text" class="input-block-level" name="login" placeholder="Login"> <br /></td>
 			</tr>
 			<tr>
  				 <td><font face="verdana" color="#4682B4"> Senha: </font></td>
   				 <td><input type="password" class="input-block-level" name="senha" placeholder="Senha"> <br /></td>
 			</tr>
 			<tr>
  				 <td><font face="verdana" color="#4682B4"> Tipos:  </font></td>
  				 <td><input id="tipos" type="hidden" value='${tipos}'><select id="perfilEnum" name ="perfil"> </select> <br /></td>
			</table>
	       <input class="btn btn-primary collapsed" style="margin-top: 2%;" type="submit" name="criar" value="Criar">
	       <a class="btn btn-primary collapsed" style="margin-top: 2%;"  href="/Parannus/" >Cancelar</a>
	   
	   </div>
	    </form>	
			
			
			
		
		
		 			
		</div>
	</form>
</body>