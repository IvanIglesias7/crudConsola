package crud.conexion;

import java.sql.Connection;

/**
 * Interfaz de la clase conexion
 */
public interface conexionServicio {

	//Método que hace conexion a base de datos y devuelve una respuesta.
	public Connection conexion();
	
	
}
