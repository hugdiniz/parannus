package model.entity;

import java.util.List;

import model.entity.abstractClass.Entity;



public class Usuario extends Entity
{

	private String nome;

	private String matricula;

	private Perfil perfil;

	private Solicitacao solicitacao;

	public void login(String login, String senha) {

	}

	public void logout() {

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
