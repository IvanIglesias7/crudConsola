package crud.consultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import crud.DTO.libroDTO;
import crud.DTO.libroDTOImpl;

public class consultaImpl implements consultaServicio {

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
		// TODO Auto-generated method stub
		
	}

	
}
