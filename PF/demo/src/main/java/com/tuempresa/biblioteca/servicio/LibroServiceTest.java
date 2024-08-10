import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LibroServiceTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroService libroService;

    public LibroServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetLibroById() {
        Libro libro = new Libro();
        libro.setId(1L);
        libro.setTitulo("Test Title");

        when(libroRepository.findById(1L)).thenReturn(Optional.of(libro));

        Libro result = libroService.getLibroById(1L);

        assertEquals("Test Title", result.getTitulo());
        verify(libroRepository, times(1)).findById(1L);
    }

    // Otras pruebas unitarias para agregar, actualizar y eliminar libros
}
