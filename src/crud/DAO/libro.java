package crud.DAO;


/**
 * Entidad libro de la base de datos gestorBibliotecaPersonal
 */
public class libro {

	//Attributes
	
	int id_libro;
	String titulo;
	String autor;
	String isbn;
	int edicion;
	
	//Constructor
	public libro(int id_libro, String titulo, String autor, String isbn, int edicion) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicion = edicion;
	}
	
	public libro() {}

	//Getters & Setters
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	
	
	
	
}
