public class Van extends Veiculo {
    private boolean isolamentoTermico;
    private boolean compartimentoFragil;

    public Van(String placa, String modelo, double capacidadeCarga, boolean isolamentoTermico,
            boolean compartimentoFragil) {
        super(placa, modelo, capacidadeCarga);
        this.isolamentoTermico = isolamentoTermico;
        this.compartimentoFragil = compartimentoFragil;
    }

    public boolean isIsolamentoTermico() {
        return isolamentoTermico;
    }

    public boolean isCompartimentoFragil() {
        return compartimentoFragil;
    }

    @Override
    public String toString() {
        return "Van{" +
                super.toString() +
                ", isolamentoTermico=" + isolamentoTermico +
                ", compartimentoFragil=" + compartimentoFragil +
                '}';
    }
}
