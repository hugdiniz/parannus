<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right" style="margin-right: 8%; margin-top: 1%;">
          <li ><a href="/Parannus/">�rea de Trabalho</a></li>
          <li><a href="/Parannus/ConsultarSolicitacao">Solicita��o</a></li>
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