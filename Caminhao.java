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
    public String toString() {
        return "Caminhao{" +
                super.toString() +
                ", numeroEixos=" + numeroEixos +
                ", altura=" + altura +
                ", comprimento=" + comprimento +
                '}';
    }
}
