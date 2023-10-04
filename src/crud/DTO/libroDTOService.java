package crud.DTO;

import java.sql.ResultSet;

public interface libroDTOService {

	public libroDTO libroDTOSelectAll(ResultSet rs);
	
	public libroDTO preguntaLibro();
}
