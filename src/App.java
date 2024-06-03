import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class App extends JFrame {

    private Set<String> bodegasOcultas = new HashSet<>();

    public App() {
        // Configurar el Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Configurar el marco de la ventana
        setTitle("PantallaImportacionActualizaciones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear la pantalla inicial
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
        startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        startPanel.setBackground(new Color(60, 63, 65));

        // Cargar la imagen
        ImageIcon imageIcon = new ImageIcon("./src/img/portada.PNG");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton importButton = new JButton("Importar actualización de vinos de bodega");
        importButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        importButton.setBackground(new Color(75, 110, 175));
        importButton.setForeground(Color.WHITE);
        importButton.setFocusPainted(false);

        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPantallaPrincipal();
            }
        });

        startPanel.add(Box.createVerticalGlue()); // Añadir espacio flexible antes
        startPanel.add(imageLabel);
        startPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añadir espacio entre imagen y botón
        startPanel.add(importButton);
        startPanel.add(Box.createVerticalGlue()); // Añadir espacio flexible después

        // Añadir la pantalla inicial al marco de la ventana
        add(startPanel);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void mostrarPantallaPrincipal() {
        // Limpiar el contenido de la ventana
        getContentPane().removeAll();

        // Crear el panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        mainPanel.setBackground(new Color(60, 63, 65));

        // Crear componentes
        JLabel titulo = new JLabel("Seleccione la bodega para actualizar");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBorder(new EmptyBorder(20, 0, 10, 0)); // Añadir margen superior

        mainPanel.add(titulo);
        mainPanel.add(Box.createVerticalGlue()); // Añadir espacio flexible antes

        // Verificar si todas las bodegas están ocultas
        if (bodegasOcultas.contains("Bodega 1") && bodegasOcultas.contains("Bodega 2") && bodegasOcultas.contains("Bodega 3")) {
            JLabel noBodegasLabel = new JLabel("No hay bodegas para actualizar");
            noBodegasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            noBodegasLabel.setForeground(Color.WHITE);
            noBodegasLabel.setFont(new Font("Arial", Font.BOLD, 14));
            mainPanel.add(noBodegasLabel);
        } else {
            // Crear componentes para bodega 1
            if (!bodegasOcultas.contains("Bodega 1")) {
                JLabel label1 = new JLabel("Bodega 1");
                label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                label1.setForeground(Color.WHITE);
                JButton button1 = new JButton("Seleccionar");
                button1.setAlignmentX(Component.CENTER_ALIGNMENT);
                button1.setBackground(new Color(75, 110, 175));
                button1.setForeground(Color.WHITE);
                button1.setFocusPainted(false);

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bodegasOcultas.add("Bodega 1");
                        mostrarVinosEnNuevaVentana("Bodega 1");
                    }
                });

                mainPanel.add(label1);
                mainPanel.add(button1);
                mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añadir espacio entre componentes
            }

            // Crear componentes para bodega 2
            if (!bodegasOcultas.contains("Bodega 2")) {
                JLabel label2 = new JLabel("Bodega 2");
                label2.setAlignmentX(Component.CENTER_ALIGNMENT);
                label2.setForeground(Color.WHITE);
                JButton button2 = new JButton("Seleccionar");
                button2.setAlignmentX(Component.CENTER_ALIGNMENT);
                button2.setBackground(new Color(75, 110, 175));
                button2.setForeground(Color.WHITE);
                button2.setFocusPainted(false);

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bodegasOcultas.add("Bodega 2");
                        mostrarVinosEnNuevaVentana("Bodega 2");
                    }
                });

                mainPanel.add(label2);
                mainPanel.add(button2);
                mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añadir espacio entre componentes
            }

            // Crear componentes para bodega 3
            if (!bodegasOcultas.contains("Bodega 3")) {
                JLabel label3 = new JLabel("Bodega 3");
                label3.setAlignmentX(Component.CENTER_ALIGNMENT);
                label3.setForeground(Color.WHITE);
                JButton button3 = new JButton("Seleccionar");
                button3.setAlignmentX(Component.CENTER_ALIGNMENT);
                button3.setBackground(new Color(75, 110, 175));
                button3.setForeground(Color.WHITE);
                button3.setFocusPainted(false);

                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bodegasOcultas.add("Bodega 3");
                        mostrarVinosEnNuevaVentana("Bodega 3");
                    }
                });

                mainPanel.add(label3);
                mainPanel.add(button3);
                mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añadir espacio entre componentes
            }
        }

        mainPanel.add(Box.createVerticalGlue()); // Añadir espacio flexible después

        // Añadir panel principal al marco de la ventana
        add(mainPanel);

        // Refrescar la ventana
        revalidate();
        repaint();
    }

    private void mostrarVinosEnNuevaVentana(String bodega) {
        JFrame wineFrame = new JFrame("PantallaImportacionActualizaciones");
        wineFrame.setSize(600, 400);
        wineFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wineFrame.setLocationRelativeTo(null);

        JPanel winePanel = new JPanel();
        winePanel.setLayout(new BoxLayout(winePanel, BoxLayout.Y_AXIS));
        winePanel.setBackground(new Color(60, 63, 65));

        JLabel titleLabel = new JLabel("Vinos actualizados de la " + bodega);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(new EmptyBorder(20, 0, 10, 0)); // Añadir margen superior

        // Panel para el botón de volver
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new BoxLayout(backButtonPanel, BoxLayout.X_AXIS));
        backButtonPanel.setBackground(new Color(60, 63, 65));

        // Botón para volver atrás
        JButton backButton = new JButton("← Volver");
        backButton.setBackground(new Color(75, 110, 175));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wineFrame.dispose();
                mostrarPantallaPrincipal();
            }
        });

        backButtonPanel.add(backButton);
        backButtonPanel.add(Box.createHorizontalGlue());

        String[] columnNames = {"Añada", "Nombre", "Nota de Cata", "Precio (ARS)"};
        Object[][] data = getVinoData(bodega);

        JTable table = new JTable(data, columnNames);
        table.setBackground(new Color(43, 43, 43));
        table.setForeground(Color.WHITE);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(43, 43, 43));

        winePanel.add(backButtonPanel);
        winePanel.add(titleLabel);
        winePanel.add(Box.createRigidArea(new Dimension(0, 10))); // Añadir espacio entre título y tabla
        winePanel.add(scrollPane);

        wineFrame.add(winePanel);
        wineFrame.setVisible(true);
    }

    private Object[][] getVinoData(String bodega) {
        if (bodega.equals("Bodega 1")) {
            return new Object[][] {
                {"2018", "Vino Tinto A", "Aroma a frutos rojos", 500},
                {"2019", "Vino Blanco B", "Notas cítricas y frescas", 450},
                {"2020", "Vino Tinto C", "Intenso y con cuerpo", 550},
                {"2021", "Vino Blanco D", "Ligero y refrescante", 470}
            };
        } else if (bodega.equals("Bodega 2")) {
            return new Object[][] {
                {"2017", "Vino Rosado A", "Suave y afrutado", 480},
                {"2018", "Vino Tinto B", "Robusto y especiado", 520},
                {"2019", "Vino Rosado C", "Dulce y equilibrado", 490},
                {"2020", "Vino Tinto D", "Complejo y elegante", 530}
            };
        } else if (bodega.equals("Bodega 3")) {
            return new Object[][] {
                {"2016", "Vino Espumoso A", "Burbujeante y fresco", 600},
                {"2017", "Vino Tinto B", "Rico y profundo", 580},
                {"2018", "Vino Espumoso C", "Delicado y vivaz", 620},
                {"2019", "Vino Tinto D", "Con toques de roble", 590}
            };
        }
        return new Object[][] {};
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
