
import java.util.ArrayList;
import java.util.List;

public class Van extends Veiculo {
    private boolean isolamentoTermico;
    private boolean compartimentoFragil;

    public Van(String placa, String modelo, double capacidadeCarga, boolean isolamentoTermico,
            boolean compartimentoFragil) {
        super(placa, modelo, capacidadeCarga);
        this.isolamentoTermico = isolamentoTermico;
        this.compartimentoFragil = compartimentoFragil;
    }

    public boolean isIsolamentoTermico() {
        return isolamentoTermico;
    }

    public boolean isCompartimentoFragil() {
        return compartimentoFragil;
    }
    @Override
    public List<String> toJanela(){
        List<String> lista = new ArrayList<>();
        lista.add("Veículo tipo Van");
        lista.add("Placa: " + getPlaca());
        lista.add("Modelo: " + getModelo());
        lista.add("Capacidade de carga: " + getCapacidadeCarga());
        lista.add("Isolamento térmico: " + (isolamentoTermico ? "Sim" : "Não"));
        lista.add("Compartimento frágil: " + (compartimentoFragil ? "Sim" : "Não"));
        return lista;

    }

    @Override
    public String toString() {
        return "Van{" +
                super.toString() +
                ", isolamentoTermico=" + isolamentoTermico +
                ", compartimentoFragil=" + compartimentoFragil +
                '}';
    }

}
