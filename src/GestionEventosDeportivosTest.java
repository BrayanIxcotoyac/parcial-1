import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionEventosDeportivosTest {

    private Evento evento;
    private Participante participante1;
    private Participante participante2;

    @BeforeEach
    public void setUp() {
        // Inicializar datos para las pruebas
        evento = new Evento("Maratón", "Carrera de 10 km", new Date(), new Date(System.currentTimeMillis() + 3600000)); // 1 hora después
        participante1 = new Participante("Juan Perez", "P1");
        participante2 = new Participante("Ana Gomez", "P2");
    }

    @Test
    public void testAsignarParticipante() {
        evento.asignarParticipante(participante1);
        assertTrue(evento.getParticipantes().contains(participante1), "El participante debería estar en la lista de participantes");

        evento.asignarParticipante(participante1); // Intentar agregar el mismo participante nuevamente
        assertEquals(1, evento.getParticipantes().size(), "No se debería duplicar el participante en la lista");
    }

    @Test
    public void testRegistrarResultado() {
        Resultado resultado = new Resultado(participante1, List.of(participante1, participante2));
        evento.registrarResultado(resultado);
        assertEquals(resultado, evento.getResultado(), "El resultado registrado debería ser el mismo que el obtenido");
    }

    @Test
    public void testFechasValidas() {

    }
}
