import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AreaDados extends JDialog {
    private Transportadora transportadora;

    public AreaDados(Frame parent, Transportadora t) {
        super(parent, "Area de Dados", true);
        this.transportadora = t;
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(450, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(7, 2, 10, 10));

        JLabel totalEntregas = new JLabel("Total de Entregas");
        JLabel totalEntregasValor = new JLabel(String.valueOf(transportadora.totalEntregas()));

        JLabel totalCargas = new JLabel("Total de Cargas");
        JLabel totalCargasValor = new JLabel(String.valueOf(transportadora.qtdCargas()));

        JLabel mediaCargas = new JLabel("Media de Cargas por Entrega");
        JLabel mediaCargasValor = new JLabel(String.valueOf(transportadora.mediaCargasEntrega()));

        JLabel valorTotalTexto = new JLabel("Valor Acumulado de Entregas:");
        JLabel valorTotal = new JLabel("R$ " + String.valueOf(transportadora.consultarValoresEntregas()));

        JLabel valorMedioTexto = new JLabel("Valor Médio das Entregas:");
        JLabel valorMedio = new JLabel("R$ " + String.valueOf(transportadora.consultarValorMedioEntregas()));

        JLabel somaDistanciaTexto = new JLabel("Distâncias a Percorrer:");
        JLabel somaDistancia = new JLabel(String.valueOf(transportadora.somaDistancia()) + " km");

        JLabel qtdVeiculosTexto = new JLabel("Quantidade de Veículos na Frota:");
        JLabel qtdVeiculos = new JLabel(String.valueOf(transportadora.consultarVeiculos().size()));

        painel.add(totalEntregas);
        painel.add(totalEntregasValor);

        painel.add(totalCargas);
        painel.add(totalCargasValor);

        painel.add(mediaCargas);
        painel.add(mediaCargasValor);

        painel.add(valorTotalTexto);
        painel.add(valorTotal);

        painel.add(valorMedioTexto);
        painel.add(valorMedio);

        painel.add(somaDistanciaTexto);
        painel.add(somaDistancia);

        painel.add(qtdVeiculosTexto);
        painel.add(qtdVeiculos);

        add(painel, BorderLayout.CENTER);

        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> dispose());
        add(fechar, BorderLayout.SOUTH);
    }
}
