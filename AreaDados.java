import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AreaDados extends JDialog{
    private Transportadora transportadora;

    public AreaDados(Frame parent, Transportadora transportadora) {
        super(parent, "Area de Dados", true);
        this.transportadora = transportadora;
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6,2,10,10));

        JLabel totalEntregas = new JLabel("Media de Cargas por Entrega");
        JLabel totalEntregasValor = new JLabel(String.valueOf(transportadora.totalEntregas()));

        JLabel valorTotalTexto = new JLabel("Valor Acumulado de Entregas:");
        JLabel valorTotal = new JLabel(String.valueOf(transportadora.consultarValoresEntregas()));

        JLabel qtdCargasTexto = new JLabel("Quantidade de Cargas a Entregar:");
        JLabel qtdCargas = new JLabel(String.valueOf(transportadora.qtdCargas()));

        JLabel somaDistanciaTexto = new JLabel("Distâncias a Percorrer:");
        JLabel somaDistancia = new JLabel(String.valueOf(transportadora.somaDistancia()));

        JLabel qtdCaminhoesTexto = new JLabel("Quantidade de Caminhões na Frota:");
        JLabel qtdCaminhoes = new JLabel(String.valueOf(transportadora.consultarCaminhaoes().size()));

        JLabel mediaCargas = new JLabel("Media de Cargas por Entrega");
        JLabel mediaCargasValor = new JLabel(String.valueOf(transportadora.mediaCargasEntrega()));


        painel.add(totalEntregas);
        painel.add(totalEntregasValor);
        
        painel.add(valorTotalTexto);
        painel.add(valorTotal);

        painel.add(qtdCargasTexto);
        painel.add(qtdCargas);

        painel.add(somaDistanciaTexto);
        painel.add(somaDistancia);

        painel.add(mediaCargas);
        painel.add(mediaCargasValor);

        painel.add(qtdCaminhoesTexto);
        painel.add(qtdCaminhoes);

        add(painel, BorderLayout.CENTER);

        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> dispose());
        add(fechar, BorderLayout.SOUTH);
    }
}