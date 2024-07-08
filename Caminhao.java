import java.util.List;
import java.util.ArrayList;
public class Caminhao extends Veiculo {
    private int numeroEixos;
    private double altura;
    private double comprimento;

    public Caminhao(String placa, String modelo, double capacidadeCarga, int numeroEixos, double altura,
            double comprimento) {
        super(placa, modelo, capacidadeCarga);
        this.numeroEixos = numeroEixos;
        this.altura = altura;
        this.comprimento = comprimento;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public double getAltura() {
        return altura;
    }

    public double getComprimento() {
        return comprimento;
    }
    @Override
    public List<String> toJanela(){
        List<String> lista = new ArrayList<>();
        lista.add("Veículo tipo Caminhão");
        lista.add("Placa: " + getPlaca());
        lista.add("Modelo: " + getModelo());
        lista.add("Capacidade de carga: " + getCapacidadeCarga());
        lista.add("Número de eixos: " + numeroEixos);
        lista.add("Altura: " + altura);
        lista.add("Comprimento: " + comprimento);
        return lista;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                super.toString() +
                ", numeroEixos=" + numeroEixos +
                ", altura=" + altura +
                ", comprimento=" + comprimento +
                '}';
    }
}
