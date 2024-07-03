import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletarEntrega extends JFrame {
    private Transportadora transportadora;
    private JTextField entregaIdField;
    private JButton deletarButton;
    private JButton cancelarButton;

    public DeletarEntrega(Transportadora transportadora) {
        this.transportadora = transportadora;
        initUI();
    }

    private void initUI() {
        setTitle("Deletar Entrega");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel entregaIdLabel = new JLabel("ID da Entrega:");
        entregaIdField = new JTextField();

        deletarButton = new JButton("Deletar");
        cancelarButton = new JButton("Cancelar");

        add(entregaIdLabel);
        add(entregaIdField);
        add(deletarButton);
        add(cancelarButton);

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int entregaId = Integer.parseInt(entregaIdField.getText());
                    boolean sucesso = transportadora.deletarEntrega(entregaId);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Nao foi possivel deletar a tela.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Entrega Deletada com Sucesso.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.");
                } catch (ExcessaoPersonalizada ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar entrega: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    //pra testar a tela , nao executando o App
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Transportadora transportadora = new Transportadora();
                DeletarEntrega ex = new DeletarEntrega(transportadora);
                ex.setVisible(true);
            }
        });
    }
}