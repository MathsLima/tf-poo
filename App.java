import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private Transportadora transportadora;
    private JTextArea textArea;
    JButton button;
    JLabel label;

    public App() {
        super();
        this.setTitle("transPOOrtes java ltda");
        this.setSize(525,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));

        //inicializa a transportadora
        transportadora = new Transportadora();

        //bloco texto inicial
        JLabel bemvindo = new JLabel("Sistema de Transportadora de Cargas", SwingConstants.CENTER);
        bemvindo.setFont(new Font("Serif", Font.BOLD, 20));
        add(bemvindo, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(10, 10));

        //label texto medio
        JLabel textoOpcoes = new JLabel("Clique nos botões para realizar uma operação!", SwingConstants.CENTER);
        textoOpcoes.setFont(new Font("Serif", Font.PLAIN, 16));
        centerPanel.add(textoOpcoes, BorderLayout.NORTH);

        //bloco de botoes
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5,1, 10,10));

        JButton addEntrega = new JButton("Adicionar Entrega");
        JButton deletarEntrega = new JButton("Deletar Entrega");
        JButton consultarEntrega = new JButton("Consultar Entrega");
        JButton consultarFrota  = new JButton("Consultar Frota de Caminhoes");
        JButton consultarValores = new JButton("Consultar Valores de Entregas");

        painel.add(addEntrega);
        painel.add(deletarEntrega);
        painel.add(consultarEntrega);
        painel.add(consultarFrota);
        painel.add(consultarValores);
        painel.add(consultarValores);
        centerPanel.add(painel, BorderLayout.CENTER);

        //bloco texto inferior
        JLabel textoNomes = new JLabel("Lucas Lorenzi  -  Matheus Melo  -  Matheus Lima  -  Rafael Brum", SwingConstants.CENTER);
        textoNomes.setFont(new Font("Serif", Font.PLAIN, 16));
        centerPanel.add(textoNomes, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        addEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEntrega dialog = new addEntrega(App.this, transportadora);
                dialog.setVisible(true);
            }
        });

        consultarEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaEntrega dialog = new ConsultaEntrega(App.this, transportadora);
                dialog.setVisible(true);
            }
        });

        deletarEntrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletarEntrega delet = new DeletarEntrega(transportadora);
                delet.setVisible(true);
                
            }
        });



        this.setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}