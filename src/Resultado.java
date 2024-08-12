import java.util.Map;

class Resultado {
    private Participante ganador;
    private Map<Participante, Integer> posiciones;

    public Resultado(Participante ganador, Map<Participante, Integer> posiciones) {
        this.ganador = ganador;
        this.posiciones = posiciones;
    }

    public <Map> Resultado(Participante p1, Map posiciones) {
    }

    public Participante getGanador() {
        return ganador;
    }

    public Map<Participante, Integer> getPosiciones() {
        return posiciones;
    }
}
