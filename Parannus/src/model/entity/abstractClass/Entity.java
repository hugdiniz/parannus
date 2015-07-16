package model.entity.abstractClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.gson.Gson;

	


public abstract class Entity
{
	//public abstract void cadastrar(Entity entidade);
	//public abstract void editar(Entity novaEntidade);
	protected transient Long id;
	
	public static Entity createEntity(String json,Long id,Class clas) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Gson gson = new Gson();
		Object object = gson.fromJson(json, clas);
		((Entity)object).id = id;
		return (Entity) object;
	}
	
	public Entity(Long id) 
	{
		this.id = id;
	}
	public Entity()
	{
		
	}
	@Override
	public String toString()
	{
		Gson gson = new Gson();		
		return gson.toJson(this);
	}
	
	public Long getId()
	{
		return id;
	}
	
	

}
