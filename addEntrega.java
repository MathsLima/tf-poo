import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addEntrega extends JDialog {
    private static final double valorFixo = 100.0;
    private JTextField textFieldDistancia;
    private JComboBox<Caminhao> comboBoxCaminhao;
    private JTextField textFieldQuantidaCargas;

    public addEntrega(Frame parent, Transportadora transportadora) {
        super(parent, "Adicionar Entrega", true);
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(700, 300);
        this.setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));

        //botao distancia
        painel.add(new JLabel("Distância:"));
        textFieldDistancia = new JTextField();
        painel.add(textFieldDistancia);

        //botao quantidade de cargas
        painel.add(new JLabel("Quantidade de Cargas:"));
        textFieldQuantidaCargas = new JTextField();
        painel.add(textFieldQuantidaCargas);

        //botao caminhao
        painel.add(new JLabel("Caminhão:"));
        comboBoxCaminhao = new JComboBox<>();
        for (Caminhao caminhao : transportadora.consultarCaminhaoes()) {
            comboBoxCaminhao.addItem(caminhao);
        }
        painel.add(comboBoxCaminhao);

        //botao adicionar com evento
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double distancia = Double.parseDouble(textFieldDistancia.getText());
                    Caminhao caminhao = (Caminhao) comboBoxCaminhao.getSelectedItem();
                    int quantidadeargas = Integer.parseInt(textFieldQuantidaCargas.getText());

                    Entrega entrega = new Entrega(distancia, caminhao);

                    //add arga na entrega
                    for(int i = 0; i < quantidadeargas; i++) {
                        Carga carga = new Carga(valorFixo);
                        entrega.adicionarCarga(carga);
                    }

                    transportadora.adicionarEntrega(entrega);
                    JOptionPane.showMessageDialog(addEntrega.this, "Entrega adicionada com sucesso!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(addEntrega.this, "Insira apenas valores numéricos nos campos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                } catch (ExcessaoPersonalizada ex) {
                    JOptionPane.showMessageDialog(addEntrega.this, "Ocorreu um erro ao adicionar a entrega: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //adiciona o painel
        add(painel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }
}
