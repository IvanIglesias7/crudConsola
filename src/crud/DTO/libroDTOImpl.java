package crud.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class libroDTOImpl implements libroDTOService {

    private Scanner scan = new Scanner(System.in);

    @Override
    public libroDTO libroDTOSelectAll(ResultSet rs) {

        libroDTO libDTO = new libroDTO();

        try {
            while (rs.next()) {
                libDTO.setId_libro(rs.getInt("id_libro"));
                libDTO.setTitulo(rs.getString("titulo"));
                libDTO.setAutor(rs.getString("autor"));

                // Cambia la línea siguiente para manejar el ISBN como un long
                long isbn = rs.getLong("isbn");
                libDTO.setIsbn(isbn);

                libDTO.setEdicion(rs.getInt("edicion"));

                System.out.println(libDTO.toString());  // Muestra resultados
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libDTO;

    }


    public libroDTO preguntaLibro() {

        libroDTO libroDTO = new libroDTO();

        System.out.println("¿Título?");
        String titulo = scan.nextLine();
        while (titulo.isEmpty()) {
            System.out.println("El título no puede estar vacío. Introduce un título válido:");
            titulo = scan.nextLine();
        }
        libroDTO.setTitulo(titulo);

        System.out.println("¿Autor?");
        String autor = scan.nextLine();
        while (autor.isEmpty()) {
            System.out.println("El autor no puede estar vacío. Introduce un autor válido:");
            autor = scan.nextLine();
        }
        libroDTO.setAutor(autor);

        System.out.println("¿ISBN?");
        String isbnStr = scan.nextLine();
        while (isbnStr.isEmpty() || !esNumero(isbnStr)) {
            System.out.println("El ISBN no puede estar vacío y debe ser un número. Introduce un ISBN válido:");
            isbnStr = scan.nextLine();
        }
        int isbn = Integer.parseInt(isbnStr);
        libroDTO.setIsbn(isbn);

        System.out.println("¿Edición?");
        while (!scan.hasNextInt()) {
            System.out.println("Eso no tiene pinta de edición válida. Introduce un número de edición:");
            scan.nextLine(); // Limpia la entrada no válida
        }
        int edicion = scan.nextInt();
        libroDTO.setEdicion(edicion);

        return libroDTO;
    }

    private boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
