import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class JanelaPrincipal extends JFrame {
    private Transportadora transportadora;
    private JTextArea textArea;
    // JButton button;
    // JLabel label;

    public JanelaPrincipal() {
        super();
        this.setTitle("transPOOrtes java ltda");
        this.setSize(525, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));

        // inicializa a transportadora
        transportadora = new Transportadora();

        // bloco texto inicial
        JLabel bemvindo = new JLabel("Sistema de Transportadora de Cargas", SwingConstants.CENTER);
        bemvindo.setFont(new Font("Serif", Font.BOLD, 20));
        add(bemvindo, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(10, 10));

        // label texto medio
        JLabel textoOpcoes = new JLabel("Clique nos botões para realizar uma operação!", SwingConstants.CENTER);
        textoOpcoes.setFont(new Font("Serif", Font.PLAIN, 16));
        centerPanel.add(textoOpcoes, BorderLayout.NORTH);

        // bloco de botoes
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addEntrega = new JButton("Adicionar Entrega");
        JButton deletarEntrega = new JButton("Deletar Entrega");
        JButton consultarEntrega = new JButton("Consultar Entrega");
        JButton areaDados = new JButton("Area de Dados");
        JButton consultarValores = new JButton("Consultar Frota de Veículos");

        painel.add(addEntrega);
        painel.add(deletarEntrega);
        painel.add(consultarEntrega);
        painel.add(areaDados);
        painel.add(consultarValores);
        centerPanel.add(painel, BorderLayout.CENTER);

        // bloco texto inferior
        JLabel textoNomes = new JLabel("Lucas Lorenzi  -  Matheus Melo  -  Matheus Lima  -  Rafael Brum",
                SwingConstants.CENTER);
        textoNomes.setFont(new Font("Serif", Font.PLAIN, 16));
        centerPanel.add(textoNomes, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        addEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEntrega adicionar = new addEntrega(JanelaPrincipal.this, transportadora);
                adicionar.setVisible(true);
            }
        });

        consultarEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaEntrega consulta = new ConsultaEntrega(JanelaPrincipal.this, transportadora);
                consulta.setVisible(true);
            }
        });

        deletarEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletarEntrega delet = new DeletarEntrega(transportadora);
                delet.setVisible(true);

            }
        });

        areaDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaDados dados = new AreaDados(JanelaPrincipal.this, transportadora);
                dados.setVisible(true);
            }
        });

        this.setVisible(true);
    }
}