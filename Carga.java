public class Carga {
    private double valor;

    public Carga(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carga{valor=" + valor + '}';
    }
}