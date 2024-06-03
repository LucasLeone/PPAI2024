import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaImportarActualizaciones extends JFrame {
    private static final long serialVersionUID = 1L;
    private GestorImportarActualizaciones gestor;
    private JPanel startPanel;
    private JButton importButton;
    
    public PantallaImportarActualizaciones(GestorImportarActualizaciones gestor) {
        this.gestor = gestor;

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setTitle("Importar actualizaciones de vinos de bodega");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startPanel = new JPanel();
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
        startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        startPanel.setBackground(new Color(60, 63, 65));

        ImageIcon imageIcon = new ImageIcon("./img/portada.PNG");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        importButton = new JButton("Importar actualización de vinos de bodega");
        importButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        importButton.setBackground(new Color(75, 110, 175));
        importButton.setForeground(Color.WHITE);
        importButton.setFocusPainted(false);

        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	gestor.importarActualizacionVinos();
            }
        });

        startPanel.add(Box.createVerticalGlue());
        startPanel.add(imageLabel);
        startPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        startPanel.add(importButton);
        startPanel.add(Box.createVerticalGlue());

        getContentPane().add(startPanel);

        setVisible(true);
    }

    public void mostrarBodegasConActualizacionDisponible(ArrayList<Bodega> bodegas) {
        getContentPane().removeAll();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        mainPanel.setBackground(new Color(60, 63, 65));

        JLabel titulo = new JLabel("Seleccione la bodega para actualizar");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBorder(new EmptyBorder(20, 0, 10, 0));

        mainPanel.add(titulo);
        mainPanel.add(Box.createVerticalGlue());

        // Verificar si hay bodegas para mostrar
        if (bodegas.isEmpty()) {
            JLabel noBodegasLabel = new JLabel("No hay bodegas para actualizar");
            noBodegasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            noBodegasLabel.setForeground(Color.WHITE);
            noBodegasLabel.setFont(new Font("Arial", Font.BOLD, 14));
            mainPanel.add(noBodegasLabel);
        } else {
            for (Bodega bodega : bodegas) {
                JLabel label = new JLabel(bodega.getNombre());
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                label.setForeground(Color.WHITE);

                JButton button = new JButton("Seleccionar");
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.setBackground(new Color(75, 110, 175));
                button.setForeground(Color.WHITE);
                button.setFocusPainted(false);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        tomarSeleccionBodega(bodega);
                    }
                });

                mainPanel.add(label);
                mainPanel.add(button);
                mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel);

        revalidate();
        repaint();
    }

    public void tomarSeleccionBodega(Bodega bodega) {
        gestor.tomarSeleccionBodega(bodega);
    }

    public void mostrarVinosCreadosOActualizados(ArrayList<Vino> vinos) {
        JFrame wineFrame = new JFrame("Vinos creados/actualizados");
        wineFrame.setSize(600, 400);
        wineFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wineFrame.setLocationRelativeTo(null);

        JPanel winePanel = new JPanel();
        winePanel.setLayout(new BoxLayout(winePanel, BoxLayout.Y_AXIS));
        winePanel.setBackground(new Color(60, 63, 65));

        JLabel titleLabel = new JLabel("Vinos creados/actualizados");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(20, 0, 10, 0));

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new BoxLayout(backButtonPanel, BoxLayout.X_AXIS));
        backButtonPanel.setBackground(new Color(60, 63, 65));

        String[] columnNames = {"Añada", "Nombre", "Fecha de Actualizacion", "Precio (ARS)"};
        Object[][] data = new Object[vinos.size()][4];

        for (int i = 0; i < vinos.size(); i++) {
            Vino vino = vinos.get(i);
            data[i][0] = vino.getAñada();
            data[i][1] = vino.getNombre();
            data[i][2] = vino.getFechaActualizacion();
            data[i][3] = "$" + vino.getPrecioARS();
        }

        JTable table = new JTable(data, columnNames);
        table.setBackground(new Color(43, 43, 43));
        table.setForeground(Color.WHITE);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(43, 43, 43));

        winePanel.add(backButtonPanel);
        winePanel.add(titleLabel);
        winePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        winePanel.add(scrollPane);

        wineFrame.add(winePanel);
        wineFrame.setVisible(true);
    }

}
