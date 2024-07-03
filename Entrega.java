import java.util.*;

public class Entrega {
    private static int cont = 0;
    private int id;
    private List<Carga> cargas;
    private double distancia;
    private Caminhao caminhao;
    private static final double valorFixo = 100.0;

    public Entrega(double distancia, Caminhao caminhao) {
        this.id = cont++;
        this.cargas = new ArrayList<>();
        this.distancia = distancia;
        this.caminhao = caminhao;
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

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", distancia=" + distancia +
                ", caminhao=" + caminhao.toString() +
                '}';
    }
}