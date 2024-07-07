import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transportadora {
    private List<Entrega> entregas;
    private List<Veiculo> veiculos;

    public Transportadora() {
        entregas = new ArrayList<>();
        veiculos = new ArrayList<>();

        // dados de exemplo setados inicialmente
        Caminhao caminhao1 = new Caminhao("ABC-1234", "Scania", 15500, 3, 4, 15);
        Caminhao caminhao2 = new Caminhao("BCA-1635", "Mercedes", 10000, 2, 4, 10);
        Caminhao caminhao3 = new Caminhao("XYZ-7777", "Volvo", 20000, 3, 4, 16);
        Van van1 = new Van("JKL-6458", "Fiat Ducato", 1500.0, true, false);
        Van van2 = new Van("DEF-5678", "Mercedes Sprinter", 2000.0, false, true);
        Van van3 = new Van("GHI-9012", "Renault Master", 1800.0, true, true);
        veiculos.add(caminhao1);
        veiculos.add(caminhao2);
        veiculos.add(caminhao3);
        veiculos.add(van1);
        veiculos.add(van2);
        veiculos.add(van3);

        Entrega entrega1 = new Entrega(25, caminhao1, "Porto Alegre");
        entrega1.adicionarCarga(new Carga(30));
        entrega1.adicionarCarga(new Carga(200.0));

        Entrega entrega2 = new Entrega(150, caminhao2, "Gravatai");
        entrega2.adicionarCarga(new Carga(300.0));
    }

    public void adicionarEntrega(Entrega entrega) throws ExcessaoPersonalizada {
        for (Entrega ent : entregas) {
            if (ent.getId() == entrega.getId()) {
                throw new ExcessaoPersonalizada("Id de entrega já existe.");
            }
        }
        entregas.add(entrega);
    }

    public boolean deletarEntrega(int id) throws ExcessaoPersonalizada {
        entregas.removeIf(Objects::nonNull);
        return false;
    }

    public Entrega consultarEntregaID(int id) throws ExcessaoPersonalizada {
        return entregas.stream()
                .filter(entrega -> entrega.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Entrega> consultarEntregas() {
        return new ArrayList<>(entregas);
    }

    public List<Veiculo> consultarVeiculos() {
        return veiculos;
    }

    public double consultarValoresEntregas() {
        return entregas.stream()
                .mapToDouble(Entrega::calcularValorTotal)
                .sum();
    }

    public int qtdCargas() {
        return entregas.stream()
                .mapToInt(entrega -> entrega.getCargas().size())
                .sum();
    }

    public double somaDistancia() {
        return entregas.stream()
                .mapToDouble(Entrega::getDistancia)
                .sum();
    }

    public double totalEntregas() {
        return entregas.size();
    }

    public double mediaCargasEntrega() {
        int cargasTotal = qtdCargas();
        int entregasTotal = entregas.size();
        if (entregasTotal == 0) {
            return 0;
        } else {
            return cargasTotal / entregasTotal;
        }
    }
}
