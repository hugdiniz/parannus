<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<style><jsp:include page="lib/bootstrap/css/bootstrap.min.css"></jsp:include></style>
<script><jsp:include page="lib/bootstrap/js/bootstrap.min.js"></jsp:include></script>
<div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right" style="margin-right: 8%; margin-top: 1%;">
          <li ><a href="/Parannus/">Área de Trabalho</a></li>
          <li><a href="/Parannus/ConsultarSolicitacao">Solicitação</a></li>
          <li><span></span></li>
          <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">${usuarioNome} <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="/Parannus/DeslogarUsuario">Deslogar</a></li>
            </ul>
          </li>
          
        </ul>
        <a class="muted" href="/Parannus/"><img alt="Parannus" style="width: 120px; margin-left: 5%; margin-top: 1%;" src="imagens/Parannus.png"></a>
      </div>

      <hr style="margin-top: 23px;">
</div>