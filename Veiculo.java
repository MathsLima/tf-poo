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
