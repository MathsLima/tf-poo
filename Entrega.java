import java.util.ArrayList;
import java.util.List;

public class Entrega {
    private static int cont = 1;
    private int id;
    private List<Carga> cargas;
    private double distancia;
    private Veiculo veiculo;

    private String cidade;

    public Entrega(double distancia, Veiculo veiculo, String cidade) {
        this.id = cont++;
        this.cargas = new ArrayList<>();
        this.distancia = distancia;
        this.veiculo = veiculo;

        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void adicionarCarga(Carga carga) throws ExcessaoPersonalizada {
        double pesoTota = cargas.stream().mapToDouble(Carga::getPeso).sum();

        if (pesoTota > veiculo.getCapacidadeCarga()) {
            throw new ExcessaoPersonalizada("Capacidade do veículoexcedida!\nCapacidade do veículo: "
                    + veiculo.getCapacidadeCarga() + "\nCarga total: " + pesoTota);
        }

        cargas.add(carga);
    }

    public double getDistancia() {
        return distancia;
    }

    public String getCidade() {
        return cidade;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public double pesoTotal() {
        return cargas.stream().mapToDouble(Carga::getPeso).sum();
    }

    public int volumesTotal() {
        return cargas.stream().mapToInt(Carga::getNumeroVolumes).sum();
    }

    public double valorTotal() {
        return cargas.stream().mapToDouble(Carga::getValor).sum();
    }

    public double valorMedio() {
        return cargas.isEmpty() ? 0 : valorTotal() / cargas.size();
    }
}
