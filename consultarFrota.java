
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class consultarFrota extends JFrame {
    public consultarFrota(Transportadora transportadora) {
        super();
        this.setTitle("transPOOrtes java ltda");
        this.setSize(525, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));


        // bloco texto inicial
        JLabel bemvindo = new JLabel("Consulta de Veiculos", SwingConstants.CENTER);
        bemvindo.setFont(new Font("Serif", Font.BOLD, 20));
        add(bemvindo, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(10, 10));

        // label texto medio
        JLabel textoOpcoes = new JLabel("Selecione o Veículo", SwingConstants.CENTER);
        textoOpcoes.setFont(new Font("Serif", Font.PLAIN, 16));
        centerPanel.add(textoOpcoes, BorderLayout.NORTH);

        // bloco de botoes
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5,5,10,10));
        // Cria um botão para cada veículo
        for (Veiculo veiculo : transportadora.consultarVeiculos()) {
            JButton botao = new JButton(veiculo.getPlaca());
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new janelaVeiculo(veiculo).setVisible(true);
                }
            });
            painel.add(botao);
        }

        centerPanel.add(painel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}

