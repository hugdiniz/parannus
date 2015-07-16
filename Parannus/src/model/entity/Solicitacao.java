package model.entity;

import java.util.List;

import model.entity.abstractClass.Entity;



public class Solicitacao extends Entity
{

	private String sugestao;

	private String impacto;

	private String tipo;

	private Objetivo objetivo;

	public Solicitacao(String sugestao,String impacto,String tipo)
	{
		this.sugestao = sugestao;
		this.impacto = impacto;
		this.tipo = tipo;
		//this.objetivo = objetivo;
	}
	public void gerenciarSolicitacao() 
	{
		
	}

	public void associarObjetivo(Objetivo objetivo) {

	}

	public void avaliar() {

	}


	/**
	 * @see Diagrama de Classes.br.ufrrj.im.dominio.Entity#cadastrar(Diagrama de Classes.br.ufrrj.im.dominio.Entity)
	 * 
	 *  
	 */
	public void cadastrar(Entity entidade) {

	}


	
	/**
	 * @see Diagrama de Classes.br.ufrrj.im.dominio.Entity#editar(Diagrama de Classes.br.ufrrj.im.dominio.Entity)
	 */
	public void editar(Entity novaEntidade) {

	}
	
	public String getSugestao()
	{
		return sugestao;
	}

}
