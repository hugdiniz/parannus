package model.entity;

import java.util.List;

	
public interface Entity {

	public abstract void cadastrar(Entity entidade);

	public abstract void editar(Entity novaEntidade);

}
