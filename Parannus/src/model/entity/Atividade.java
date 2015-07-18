package model.entity;

import java.util.Date;
import model.entity.abstractClass.Entity;
import model.enumerado.StatusEnum;


public class Atividade extends Entity
{

	private Date dataCriacao;

	private Date dataInicio;

	private Date dataFim;

	private StatusEnum status;

	private Usuario usuario;

}
