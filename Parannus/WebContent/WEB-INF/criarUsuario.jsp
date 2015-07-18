<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

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

<div class="masthead">
 	<a class="muted" href="/Parannus/"><img alt="Parannus" style="width: 120px; margin-left: 5%; margin-top: 1%;" src="imagens/Parannus.png"></a>
</div>

<body>
	<form action="CriarConsumidor" method="post">
		<div>
		<input id="tipos" type="hidden" value='${tipos}'>
		<input type="text" class="input-block-level" placeholder="nome">
		<input type="text" class="input-block-level" placeholder="login">
		<input type="password" class="input-block-level" placeholder="senha">
			
			
		<select id="perfilEnum" name ="perfil">
		
		</select>
		
		    	
			
			
			
		</div>
	</form>
</body>