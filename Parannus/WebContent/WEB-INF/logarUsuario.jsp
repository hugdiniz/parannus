<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<style><jsp:include page="lib/bootstrap/css/bootstrap.min.css"></jsp:include></style>
<script><jsp:include page="lib/bootstrap/js/bootstrap.min.js"></jsp:include></script>

<html>
	<body>
	  <div class="container" style="margin-top: 10%; width: 500px;">	
	    
	    <form action="LogarUsuario" method="post">
	      <h2 class="form-signin-heading"><img alt="Parannus" style="width: 300px; margin-left: 20%; margin-top: 1%; margin-bottom: 10%;" src="imagens/Parannus.png"></h2>
	      <input type="text"  name="login" class="input-block-level" placeholder="login">
	      <input type="password" name="senha"  class="input-block-level" placeholder="senha">
	      <input class="btn btn-large btn-primary" style="margin-top: 2%;" type="submit" name="logar" value="Logar">
	    </form>
			
	  </div> 
	</body>
</html>