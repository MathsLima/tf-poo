public class Caminhao {
    private String placa;
    private String modelo;

    public Caminhao(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo +
                '}';
    }
}