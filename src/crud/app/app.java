package crud.app;

import java.sql.Connection;

import crud.conexion.*;
import crud.consultas.consultaImpl;
import crud.consultas.consultaServicio;
import crud.util.util;

public class app {

	public static void main(String[] args) {
	
		//Instancias
		conexionServicio c = new conexion();
		consultaServicio cs = new consultaImpl();
		//Declaraciones
		boolean salir = false;
		
		do {
			
			int opcion = util.menu();
			
			switch(opcion) {
			
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				cs.selectAll(c.conexion());
				break;
			case 0:
				System.out.println("Hasta otra!");
				salir = true;
				break;
				
			default:
				System.out.println("Ese número no está entre las opciones");
				break;
			}
		} while (!salir);
		
	}

}
