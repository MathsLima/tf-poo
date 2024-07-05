import java.util.*;

public class Entrega {
    private static int cont = 0;
    private int id;
    private List<Carga> cargas;
    private double distancia;
    private Caminhao caminhao;
    private static final double valorFixo = 10.0;

    private String cidade;

    public Entrega(double distancia, Caminhao caminhao, String cidade) {
        this.id = cont++;
        this.cargas = new ArrayList<>();
        this.distancia = distancia;
        this.caminhao = caminhao;

        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void adicionarCarga(Carga carga) {
        cargas.add(carga);
    }

    public double calcularValorTotal() {
        return valorFixo * distancia * cargas.size();
    }

    public double getDistancia() {
        return distancia;
    }

    public String getCidade() { return cidade;}

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public List<Carga> getCargas() {
        return cargas;
    }
}
