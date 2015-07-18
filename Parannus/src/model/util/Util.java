package model.util;

import model.entity.abstractClass.Entity;
import model.entity.abstractClass.VO;

import com.google.gson.Gson;

public class Util
{

	public static VO transformEntityToVO(Entity entity,Class clas)
	{
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(entity),clas);
	}
}
