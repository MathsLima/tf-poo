import java.util.List;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class janelaVeiculo extends JDialog {

    public janelaVeiculo(Veiculo veiculo) {
        super();
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        // Creates a panel to display the vehicle texto
        JPanel panel = new JPanel();
        List<String>  lista = veiculo.toJanela();
        panel.setLayout(new GridLayout(lista.size(), 1, 10, 10));
        for (String s : lista) {
            panel.add(new JLabel(s));
        }
        add(panel, BorderLayout.CENTER);



        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> dispose());
        add(fechar, BorderLayout.SOUTH);
    }
}
