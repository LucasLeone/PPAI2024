import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaImportarActualizaciones extends JFrame {
    private static final long serialVersionUID = 1L;
    private GestorImportarActualizaciones gestor;
    private JPanel contentPane;
    private JButton showOptionsButton;
    private JTextPane textPane;
    private JPanel panelIzquierdo;

    public PantallaImportarActualizaciones(GestorImportarActualizaciones gestor) {
        this.gestor = gestor;

        setTitle("Registrar Respuesta de Operador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        contentPane.add(panelIzquierdo, BorderLayout.WEST);

        textPane = new JTextPane();
        textPane.setEditable(false);
        contentPane.add(new JScrollPane(textPane), BorderLayout.CENTER);

        showOptionsButton = new JButton("Importar actualización de vinos");
        showOptionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestor.buscarBodegasConActualizacionDisponible();
            }
        });

        contentPane.add(showOptionsButton, BorderLayout.NORTH);
    }

    public void mostrarBodegasConActualizacionDisponible(ArrayList<Bodega> bodegas) {
        panelIzquierdo.removeAll(); // Elimina todos los componentes anteriores

        for (Bodega bodega : bodegas) {
            JButton button = new JButton(bodega.getNombre());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textPane.setText("Buscando actualizaciones para la bodega seleccionada: " + bodega.getNombre());
                    tomarSeleccionBodega(bodega);
                }
            });
            panelIzquierdo.add(button);
        }

        panelIzquierdo.revalidate();
        panelIzquierdo.repaint();
    }
    
    public void tomarSeleccionBodega(Bodega bodega) {
        gestor.tomarSeleccionBodega(bodega);
    }

    public void mostrarVinosCreadosOActualizados(ArrayList<Vino> vinos) {
        StringBuilder sb = new StringBuilder(textPane.getText());
        sb.append("\n\nVinos creados/actualizados:\n");

        for (Vino vino : vinos) {
            sb.append(vino.toString()).append("\n");
        }

        textPane.setText(sb.toString());
    }
}
