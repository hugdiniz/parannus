package model.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.entity.abstractClass.Entity;
import model.entity.abstractClass.VO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.javafx.geom.AreaOp.AddOp;


public class DAO
{
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private static Connection rootConection;
	
	protected DAO() throws ClassNotFoundException, SQLException
	{
		inicializarDb();
	}
	
	private static DAO dao;
	public static DAO getInstance() throws ClassNotFoundException, SQLException
	{
		if (dao == null)
		{
			dao = new DAO();
		}
		return dao;
	}
	
	public void inicializarDb() throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER_CLASS);
		rootConection = DriverManager.getConnection("jdbc:h2:~/parannus", "admin", "foca");
	}

	
	private PreparedStatement createPreparedStatement(String sql,Collection vars) throws SQLException
	{
		PreparedStatement prep = rootConection.prepareStatement(sql);
		
		Integer posicao = 1;
		for (Object object : vars)
		{
			prep.setObject(posicao,object);
			posicao++;
		}
	
		return prep;
	}
	public void insertOrUpdate(Entity e) throws SQLException 
	{
		
		String sql = "";
		String tableName = e.getClass().getSimpleName().toLowerCase();
		Collection vars = new ArrayList();
		if (e.getId() != null)
		{
			sql = "UPDATE "+tableName +" SET (id,valor) = (?,?) where id ="+e.getId()+";";
			vars.add(e.getId());
		}
		else
		{
			//campos.append("INSERT INTO aluno (");
			sql = "INSERT INTO "+tableName +" SET valor = ?;";
		}
		
		vars.add(e.toString());
		createPreparedStatement(sql,vars).executeUpdate();
	}
	public Collection search(VO vo,Class clas) throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		
		String tableName = clas.getSimpleName().toLowerCase();
		String sql = "SELECT * FROM "+tableName +" where ";
		Collection vars = new ArrayList();
		if (vo.getId() != null)
		{
			sql = sql + " id = ?;";
			vars.add(vo.getId());
		}
		else
		{
			sql = sql + " valor like ?;";
			String restriction =  vo.toString().replaceAll("\",\"", "\"%\"");
			restriction =  restriction.replaceAll("\\{", "\\{%");
			restriction =  restriction.replaceAll("\\}", "%\\}");
			vars.add(restriction);
		}	
		ResultSet resultSet = createPreparedStatement(sql, vars).executeQuery();
		
		Collection arrayOut = new ArrayList();
		Gson gson = new Gson();
		while (resultSet.next())
		{			
			Object object = Entity.createEntity(resultSet.getString("valor"), resultSet.getLong("id"), clas);
			arrayOut.add((Entity) object);
		}
		
		return arrayOut;
	}
}
