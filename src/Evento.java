import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Evento {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Participante> participantes;
    private Resultado resultado;

    public Evento(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void asignarParticipante(Participante participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
        }
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void registrarResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Resultado getResultado() {
        return resultado;
    }
}
