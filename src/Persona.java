import java.util.ArrayList;
import java.util.List;

class Persona {
    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Participante extends Persona {
    private String id;
    private List<Evento> eventos;

    public Participante(String nombre, String id) {
        super(nombre);
        this.id = id;
        this.eventos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void registrarEnEvento(Evento evento) {
        if (!eventos.contains(evento)) {
            eventos.add(evento);
            evento.asignarParticipante(this);
        }
    }
}