package crud.util;

import java.util.Scanner;

public class util {

	static Scanner scan = new Scanner(System.in);
	
	static public int menu() {
		
		boolean valido = true;

			System.out.println("Bienvenido al gestor de biblioteca.");
			System.out.println("------------------------------------");
			System.out.println("1 - Añadir libro");
			System.out.println("2 - Modificar libro");
			System.out.println("3 - Eliminar libro");
			System.out.println("4 - Ver todos los libros");
			System.out.println("0 - Salir");
			System.out.println("------------------------------------");	
			
			while(!scan.hasNextInt()){
				System.out.println("Eso no es un número");
				scan.next();//Así recoge otro registro en vez de quedarse en bucle.
			}
	
		
		int opcion = scan.nextInt();
		return opcion;
		
	}
	
	
	
	
}
