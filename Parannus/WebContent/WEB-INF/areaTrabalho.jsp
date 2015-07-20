<%@ include file="header.jsp" %>
<style>
.item
{
	width:100%;
	height:40%;
}
.item img
{
	width:100%;
	height:40%;
}

.carousel-control.left 
{
    background-image: none;
    background-repeat: repeat-x;
}
.carousel-control.right
{
    background-image: none;
    background-repeat: repeat-x;
}
</style>

<div data-ride="carousel" class="carousel slide" id="myCarousel" style="margin-top: -30px;">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
      </ol>
      <div role="listbox" class="carousel-inner">
        <div class="item active">
          <img alt="First slide" src="imagens/background.png" class="first-slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Melhoria</h1>
              <p>Que muda para melhor estado ou condição. Aquilo que é melhor, melhoramento.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img alt="Second slide" src="imagens/background.png" class="second-slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Iniciativas de Melhoria de Processos</h1>
              <p>Organizações de software necessitam implementar de forma contínua tecnologias inovadoras e melhores práticas visando aumentar suas capacidades no desenvolvimento de software.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img alt="Third slide" src="imagens/background.png" class="third-slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Parannus</h1>
              <p>Parranus, Melhoria do finlandes, é um software esta sendo desenvolvido para facilitar as implementações de software de melhoria</p>
            </div>
          </div>
        </div>
      </div>
      <a data-slide="prev" role="button" href="#myCarousel" class="left carousel-control">
        <span aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a data-slide="next" role="button" href="#myCarousel" class="right carousel-control">
        <span aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    
<%@ include file="rodape.jsp" %>