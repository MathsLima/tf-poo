import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addEntrega extends JDialog {
    private JTextField textFieldDistancia;
    private JComboBox<Veiculo> comboBoxVeiculo;
    private JTextField textFieldQuantidaCargas;
    private JTextField textFieldCidade;

    public addEntrega(Frame parent, Transportadora transportadora) {
        super(parent, "Adicionar Entrega", true);
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(700, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));

        // botao cidade
        JLabel cidadeLabel = new JLabel("Cidade Destino:"); // Adicionado
        textFieldCidade = new JTextField();
        painel.add(cidadeLabel);
        painel.add(textFieldCidade);

        // botao distancia
        painel.add(new JLabel("Distância(km):"));
        textFieldDistancia = new JTextField();
        painel.add(textFieldDistancia);

        // botao quantidade de cargas
        painel.add(new JLabel("Quantidade de Cargas:"));
        textFieldQuantidaCargas = new JTextField();
        painel.add(textFieldQuantidaCargas);

        // botao veiculo
        painel.add(new JLabel("Vaículo:"));
        comboBoxVeiculo = new JComboBox<>();
        for (Veiculo veiculo : transportadora.consultarVeiculos()) {
            comboBoxVeiculo.addItem(veiculo);
        }
        painel.add(comboBoxVeiculo);

        // botao adicionar com evento
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double distancia = Double.parseDouble(textFieldDistancia.getText());
                    Veiculo veiculo = (Veiculo) comboBoxVeiculo.getSelectedItem();
                    int quantidadeargas = Integer.parseInt(textFieldQuantidaCargas.getText());
                    String cidade = textFieldCidade.getText();

                    Entrega entrega = new Entrega(distancia, veiculo, cidade);

                    // add arga na entrega
                    Random random = new Random();
                    for (int i = 0; i < quantidadeargas; i++) {
                        int numeroVolumes = random.nextInt(50) + 1; // Número de volumes entre 1 e 50
                        double peso = 10 + (100 - 10) * random.nextDouble(); // Peso entre 10 e 100 kg
                        double valor = 100 + (1000 - 100) * random.nextDouble(); // Valor entre 100 e 1000
                        Carga carga = new Carga(numeroVolumes, peso, valor);
                        entrega.adicionarCarga(carga);
                    }

                    transportadora.adicionarEntrega(entrega);
                    JOptionPane.showMessageDialog(addEntrega.this, "Entrega adicionada com sucesso!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(addEntrega.this, "Insira apenas valores numéricos nos campos.",
                            "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                } catch (ExcessaoPersonalizada ex) {
                    JOptionPane.showMessageDialog(addEntrega.this,
                            "Ocorreu um erro ao adicionar a entrega: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // adiciona o painel
        add(painel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }
}
