package model.enumerado;

import java.util.ArrayList;
import java.util.Collection;

public enum PerfilEnum {

	GERENTE,

	RESPONSAVEL;
	
	
	
	public String toString() 
	{
		return this.name();		
	};
	public static Collection valores()
	{
		Collection perfils = new ArrayList();
		for (PerfilEnum perfilEnum : PerfilEnum.values())
		{
			perfils.add(perfilEnum.name());
		}
		return perfils;
	}

}
