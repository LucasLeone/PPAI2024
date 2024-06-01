import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PantallaImportarActualizaciones extends JFrame {
    private static final long serialVersionUID = 1L;
    private GestorImportarActualizaciones gestor;
    private JPanel contentPane;
    private JButton showOptionsButton;
    private JTextPane textPane;
    private JComboBox<String> comboBoxBodegas;

    public PantallaImportarActualizaciones(GestorImportarActualizaciones gestor, ArrayList<Bodega> bodegas) {
        this.gestor = gestor;

        setTitle("Registrar Respuesta de Operador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        contentPane.add(panelIzquierdo, BorderLayout.WEST);

        textPane = new JTextPane();
        textPane.setEditable(false);
        contentPane.add(new JScrollPane(textPane), BorderLayout.CENTER);

        showOptionsButton = new JButton("Importar actualización de vinos");
        showOptionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarBodegasConActualizacionDisponible(bodegas, panelIzquierdo);
            }
        });
        contentPane.add(showOptionsButton, BorderLayout.NORTH);
    }

    public void mostrarBodegasConActualizacionDisponible(ArrayList<Bodega> bodegas, JPanel panelIzquierdo) {
        panelIzquierdo.removeAll(); // Limpiar cualquier opción previa

        comboBoxBodegas = new JComboBox<>();
        for (Bodega bodega : bodegas) {
            comboBoxBodegas.addItem(bodega.getNombre());
        }

        comboBoxBodegas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = comboBoxBodegas.getSelectedIndex();
                if (selectedIndex != -1) {
                    Bodega selectedBodega = bodegas.get(selectedIndex);
                    textPane.setText("Buscando actualizaciones para la bodega seleccionada: " + selectedBodega.getNombre());
                    gestor.buscarActualizacionesBodegaSeleccionada(selectedBodega);
                }
            }
        });

        panelIzquierdo.add(comboBoxBodegas);
        panelIzquierdo.revalidate();
        panelIzquierdo.repaint();
    }

    public void mostrarInformacionVinos(String bodegaNombre, List<String> vinosActualizados) {
        StringBuilder info = new StringBuilder();
        info.append("Se encontró una actualización en la bodega seleccionada: ").append(bodegaNombre).append("\n\n");
        info.append("Vinos creados/actualizados:\n");

        for (String vinoInfo : vinosActualizados) {
            info.append(vinoInfo).append("\n");
        }

        textPane.setText(info.toString());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DB db = new DB();
                    DBAPI dbAPI = new DBAPI();
                    SistemaDeBodega sistemaDeBodega = new SistemaDeBodegaImpl(dbAPI);
                    GestorImportarActualizaciones gestor = new GestorImportarActualizaciones(db, sistemaDeBodega);
                    gestor.importarActualizacionVinos();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
