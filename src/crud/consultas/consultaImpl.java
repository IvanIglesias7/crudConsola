package crud.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import crud.DAO.libro;
import crud.DAO.libroImpl;
import crud.DTO.libroDTO;
import crud.DTO.libroDTOImpl;
import crud.util.util;

public class consultaImpl implements consultaServicio {

	libroDTOImpl libDTOS = new libroDTOImpl();
	libroDTO libroDTO = new libroDTO();
	@Override
public void selectAll(Connection con) {
		
		try
	    {	      
		  libroDTOImpl ldi = new libroDTOImpl();
		  libroDTO libDTO = new libroDTO();
	      String query = "SELECT * FROM gbp_almacen.gbp_alm_cat_libros";
	      
	      Statement st = con.createStatement();// Creo el statement
	      
	      ResultSet rs = st.executeQuery(query);// Ejecuto la query y recibo el resultado
	      
	      libDTO = ldi.libroDTOSelectAll(rs);
	      
	      st.close();// Cierro statement
	    }
	    catch (Exception e)
	    {
	      System.err.println("Error! ");
	      System.err.println(e.getMessage());
	    }
	  }

	@Override
	public void insert(Connection con) {
		
		boolean continuar= false;
		Scanner scan = new Scanner(System.in);
		libroImpl libS = new libroImpl();
		
		do {
			System.out.println("Introduzca los valores deseados para insertar.");
			libro lib = new libro(); 
			lib = libS.libroDTOaDAO(libDTOS.preguntaLibro());
			
			
			PreparedStatement pst; //statement con parámetros.
			try {
				pst = con.prepareStatement("INSERT INTO gbp_almacen.gbp_alm_cat_libros(\r\n"
						+ "	id_libro, titulo, autor, isbn, edicion)\r\n"
						+ "	VALUES (DEFAULT, ?, ?, ?, ?);");
				
				pst.setString(1, lib.getTitulo()); //asigno a cada ? su correspondiente propiedad
				pst.setString(2, lib.getAutor());
				pst.setLong(3, lib.getIsbn());
				pst.setInt(4, lib.getEdicion());
				
				pst.execute(); //ejecutamos la query entera	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (continuar == true);
	}

	@Override
	public void modificar(Connection conexion) {
		
		System.out.println("Estos son los libros que hay actualmente: ");
		selectAll(conexion);
		try {
			long isbn = util.getIsbnLibro();
			PreparedStatement pst;
			String consulta = "UPDATE gbp_almacen.gbp_alm_cat_libros"
					+ "	SET id_libro=DEFAULT, titulo=?, autor=?, isbn=?, edicion=?\r\n"
					+ "	WHERE isbn = ?;";
			pst = conexion.prepareStatement(consulta);
			
			libroDTO lib = libDTOS.preguntaLibro();
			pst.setString(1, lib.getTitulo());
			pst.setString(2, lib.getAutor());
			pst.setLong(3, lib.getIsbn());
			pst.setInt(4, lib.getEdicion());
			pst.setLong(5, isbn);
			
			pst.execute();
			
			System.out.println("El libro : " + lib.getTitulo() + " ha sido modificado");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void eliminar(Connection conexion) {
		
		System.out.println("Estos son los libros que hay actualmente: ");
		selectAll(conexion);
		
		try {
			
			long isbn = util.getIsbnLibro();
			PreparedStatement pst;
			String consulta = "DELETE FROM gbp_almacen.gbp_alm_cat_libros"
					+ "	WHERE isbn = ?;";
			pst = conexion.prepareStatement(consulta);
			
			System.out.println("El libro con isbn " + isbn + " va a ser eliminado.");
			pst.setLong(1, isbn);

			System.out.println("Listo!");
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	


	
}
