package model.entity;

import java.util.Date;
import java.util.List;

import model.entity.abstractClass.Entity;
import model.enumerado.Status;


public class Atividade extends Entity
{

	private Date dataCriacao;

	private Date dataInicio;

	private Date dataFim;

	private Status status;

	private Usuario usuario;

	public void enviarFeedback(String feedback)
	{

	}

	public void detalaharAtividade()
	{

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

}
