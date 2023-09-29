package crud.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class libroDTOImpl implements libroDTOService {

	@Override
	public libroDTO libroDTOSelectAll(ResultSet rs) {
		
		libroDTO libDTO = new libroDTO();
		
		try {
			while (rs.next())
			  {
			    libDTO.setId_libro(rs.getInt("id_libro"));
			    libDTO.setTitulo(rs.getString("titulo"));
			    libDTO.setAutor(rs.getString("autor"));
			    libDTO.setIsbn(rs.getString("isbn"));
			    libDTO.setEdicion(rs.getInt("edicion"));
			   
			    System.out.println(libDTO.toString());  //Muestro resultados
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libDTO;
		
	}

	
}
