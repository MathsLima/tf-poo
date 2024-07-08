import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo implements Comparable<Veiculo> {
    private String placa;
    private String modelo;
    private double capacidadeCarga;

    public Veiculo(String placa, String modelo, double capacidadeCarga) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
    public List<String> toJanela(){
        List<String> lista = new ArrayList<>();
        lista.add("Veículo tipo Van");
        lista.add("Placa: " + getPlaca());
        lista.add("Modelo: " + getModelo());
        lista.add("Capacidade de carga: " + getCapacidadeCarga());
        return lista;
    }
    @Override
    public int compareTo(Veiculo outro) {
        return this.placa.compareTo(outro.placa);
    }

    @Override
    public String toString() {
        return "capacidadeCarga=" + capacidadeCarga +
                "; placa=" + placa +
                "; modelo=" + modelo;
    }
}
