public class Carga {
    private int numeroVolumes;
    private double peso;
    private double valor;

    public Carga(int numeroVolumes, double peso, double valor) {
        this.numeroVolumes = numeroVolumes;
        this.peso = peso;
        this.valor = valor;
    }

    public int getNumeroVolumes() {
        return numeroVolumes;
    }

    public double getPeso() {
        return peso;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carga{" +
                ", numeroVolumes=" + numeroVolumes +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
