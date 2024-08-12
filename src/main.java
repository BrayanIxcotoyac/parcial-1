import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        // Ejemplo de uso
        GestionEventosDeportivos gestion = new GestionEventosDeportivos();

        Participante p1 = new Participante("Juan", "P001");
        Participante p2 = new Participante("Maria", "P002");
        gestion.registrarParticipante(p1);
        gestion.registrarParticipante(p2);

        Evento e1 = new Evento("Futbol", "Torneo de Futbol", new Date(), new Date());
        gestion.registrarEvento(e1);

        try {
            gestion.asignarParticipanteAEvento("P001", "Futbol");
            gestion.asignarParticipanteAEvento("P002", "Futbol");

            Map<Participante, Integer> posiciones = new HashMap<>();
            posiciones.put(p1, 1);
            posiciones.put(p2, 2);

            Resultado resultado = new Resultado(p1, posiciones);
            gestion.registrarResultadoDeEvento("Futbol", resultado);

            Evento eventoConsultado = gestion.consultarEvento("Futbol");
            System.out.println("Ganador: " + eventoConsultado.getResultado().getGanador().getNombre());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
