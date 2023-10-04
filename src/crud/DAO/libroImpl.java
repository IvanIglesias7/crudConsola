package crud.DAO;

import crud.DTO.libroDTO;

public class libroImpl implements libroService {

	@Override
	public libro libroDTOaDAO(libroDTO libroDTO) {
		
		libro lib = new libro();
		
		lib.setTitulo(libroDTO.getTitulo());
		lib.setAutor(libroDTO.getAutor());
		lib.setIsbn(libroDTO.getIsbn());
		lib.setEdicion(libroDTO.getEdicion());

		return lib;
	}

}
