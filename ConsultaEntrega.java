import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

public class ConsultaEntrega extends JDialog {
    private JTable entregaTable;
    private DefaultTableModel tabelaModelo; //interface com tabela de modelo padrao;
    private JTextArea textAreaDetalhes;  //mostra varias linhas

    public ConsultaEntrega(Frame parent, Transportadora transportadora) {
        super(parent, "Consultar Entregas", true);
        setLayout(new BorderLayout(10, 10));
        setSize(800, 400);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID", "Distância", "Cidade", "Placa Caminhão", "Modelo Caminhão", "Quantidade de Cargas", "Valor Total"}; //colunas da tabela
        tabelaModelo = new DefaultTableModel(columnNames, 0);
        entregaTable = new JTable(tabelaModelo);
        entregaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        entregaTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = entregaTable.getSelectedRow();
                if (selectedRow != -1) {
                    Entrega selectedEntrega = transportadora.consultarEntregas().get(selectedRow);
                    mostrarDetalhesEntrega(selectedEntrega);
                }
            }
        });

        // Preenche tabela com dados percorrendo o vetor
        for (Entrega entrega : transportadora.consultarEntregas()) {
            Object[] rowData = {
                    entrega.getId(),
                    entrega.getDistancia(),
                    entrega.getCidade(),
                    entrega.getCaminhao().getPlaca(),
                    entrega.getCaminhao().getModelo(),
                    entrega.getCargas().size(),
                    entrega.calcularValorTotal()
            };
            tabelaModelo.addRow(rowData);
        }

        JScrollPane tableScrollPane = new JScrollPane(entregaTable);
        add(tableScrollPane, BorderLayout.CENTER);

        textAreaDetalhes = new JTextArea();
        textAreaDetalhes.setEditable(false);
        add(new JScrollPane(textAreaDetalhes), BorderLayout.SOUTH);

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }

    private void mostrarDetalhesEntrega(Entrega entrega) {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("ID: ").append(entrega.getId()).append("\n");
        detalhes.append("Cidade: ").append(entrega.getCidade()).append("\n");
        detalhes.append("Distância: ").append(entrega.getDistancia()).append("\n");
        detalhes.append("Caminhão: ").append(entrega.getCaminhao().getPlaca()).append(" - ").append(entrega.getCaminhao().getModelo()).append("\n");
        detalhes.append("Cargas:\n");

        for (Carga carga : entrega.getCargas()) {
            detalhes.append("  - ").append(carga.getValor()).append("\n");
        }

        detalhes.append("Valor Total: ").append(entrega.calcularValorTotal()).append("\n");

        textAreaDetalhes.setText(detalhes.toString());
    }
}
