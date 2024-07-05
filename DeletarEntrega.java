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
        this.setTitle("Deletar Entrega");
        this.setSize(300, 175);
        this.setLayout(new GridLayout(3, 2, 10, 10));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

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
                    if (entregaIdField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um ID.");
                        return;
                    }

                    int entregaId = Integer.parseInt(entregaIdField.getText());
                    boolean sucesso = transportadora.deletarEntrega(entregaId);

                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Entrega deletada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID da entrega não encontrado.");
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
}
