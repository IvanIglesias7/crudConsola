package crud.consultas;

import java.sql.Connection;

//Interfaz para hacer consultas que se implementará en la clase consultaImpl
public interface consultaServicio {
		
		//Hace un select de toda la tabla 
		public void selectAll(Connection con);
		
		//Hace un insert a bd
		public void insert(Connection con);
	}

