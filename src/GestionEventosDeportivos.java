import java.util.HashMap;
import java.util.Map;

public class GestionEventosDeportivos {
    private Map<String, Evento> eventos;
    private Map<String, Participante> participantes;

    public GestionEventosDeportivos() {
        this.eventos = new HashMap<>();
        this.participantes = new HashMap<>();
    }

    public void registrarEvento(Evento evento) {
        if (eventos.containsKey(evento.getNombre())) {
            System.out.println("El evento " + evento.getNombre() + " ya está registrado.");
        } else {
            eventos.put(evento.getNombre(), evento);
            System.out.println("Evento " + evento.getNombre() + " registrado con éxito.");
        }
    }

    public void registrarParticipante(Participante participante) {
        if (participantes.containsKey(participante.getId())) {
            System.out.println("El participante con ID " + participante.getId() + " ya está registrado.");
        } else {
            participantes.put(participante.getId(), participante);
            System.out.println("Participante " + participante.getNombre() + " registrado con éxito.");
        }
    }

    public void asignarParticipanteAEvento(String idParticipante, String nombreEvento) throws EventoNoEncontradoException, ParticipanteNoEncontradoException {
        Participante participante = participantes.get(idParticipante);
        Evento evento = eventos.get(nombreEvento);

        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado: " + nombreEvento);
        }
        if (participante == null) {
            throw new ParticipanteNoEncontradoException("Participante no encontrado: " + idParticipante);
        }

        participante.registrarEnEvento(evento);
        System.out.println("Participante " + participante.getNombre() + " asignado al evento " + nombreEvento + ".");
    }

    public void registrarResultadoDeEvento(String nombreEvento, Resultado resultado) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado: " + nombreEvento);
        }
        evento.registrarResultado(resultado);
        System.out.println("Resultado registrado para el evento " + nombreEvento + ".");
    }

    public Evento consultarEvento(String nombreEvento) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado: " + nombreEvento);
        }
        return evento;
    }
}
