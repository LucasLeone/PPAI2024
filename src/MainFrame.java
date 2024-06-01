package PPAI.asdasd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JButton importButton;
    private JTextArea outputTextArea;
    private JPanel bodegasPanel;
    private GestorImportarActualizaciones gestor;
    private List<JCheckBox> bodegaCheckBoxes;
    private ButtonGroup bodegaButtonGroup;

    public MainFrame() {
        gestor = new GestorImportarActualizaciones();

        setTitle("BonVino - Importación de Actualizaciones de Vinos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        importButton = new JButton("Importar Actualización de Vinos");
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importarActualizacionVinos();
            }
        });

        outputTextArea = new JTextArea(20, 50);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        bodegasPanel = new JPanel();
        bodegasPanel.setLayout(new BoxLayout(bodegasPanel, BoxLayout.Y_AXIS));
        bodegaCheckBoxes = new ArrayList<>();
        bodegaButtonGroup = new ButtonGroup();
        populateBodegasPanel();

        JPanel panel = new JPanel();
        panel.add(importButton);

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(bodegasPanel, BorderLayout.WEST);

        // Redirigir la salida estándar a JTextArea
        PrintStream printStream = new PrintStream(new CustomOutputStream(outputTextArea));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    private void populateBodegasPanel() {
        List<Bodega> bodegas = gestor.getSistemaDeBodegas().buscarBodegasConActualizacionDisponible();
        for (Bodega bodega : bodegas) {
            JCheckBox checkBox = new JCheckBox(bodega.getNombreBodega());
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JCheckBox box : bodegaCheckBoxes) {
                        if (box != checkBox) {
                            box.setSelected(false);
                        }
                    }
                }
            });
            bodegaCheckBoxes.add(checkBox);
            bodegasPanel.add(checkBox);
            bodegaButtonGroup.add(checkBox);
        }
    }

    private void importarActualizacionVinos() {
        List<Bodega> selectedBodegas = new ArrayList<>();
        List<Bodega> bodegas = gestor.getSistemaDeBodegas().buscarBodegasConActualizacionDisponible();
        for (int i = 0; i < bodegaCheckBoxes.size(); i++) {
            if (bodegaCheckBoxes.get(i).isSelected()) {
                selectedBodegas.add(bodegas.get(i));
            }
        }
        gestor.importarActualizacionVinos(selectedBodegas);
    }

    private class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    // End of variables declaration
}
