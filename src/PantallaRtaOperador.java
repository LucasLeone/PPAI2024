import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;

public class PantallaRtaOperador extends JFrame {
	private static final long serialVersionUID = 1L;
	private GestorRtaOperador gestor;
	private JPanel contentPane,panelValidacion;
	private JTextField textFieldDatosCategoria;
	private JTextField textFieldDatosOpcion;
	private JTextField textFieldDatosSubOpcion;
	private JTextField textField;
	private JLabel lblDatosLlamada;
	private JLabel datosCategorialbl;
	private JLabel datosOpcionlbl;
	private JLabel datosSubOpcionlbl;
	private JLabel lblNombre;
	private JLabel lblValidacion;
	private JTextField inputFieldNameValidator;
	private JPanel panelDatosLlamada;
	private JButton btnNewButton;
	private JLabel lblSolicitarAccionRequerida;
	private JTextField inputDescripcion;
	private JPanel panelAccionRequerida;
	private JComboBox comboBox;
	private JButton btnAccionSiguiente;
	private JButton btnAccionCancelar;
	//private JButton btnValidar;
	public PantallaRtaOperador(GestorRtaOperador gestor) {
		
		this.gestor = gestor;
		setForeground(new Color(255, 255, 255));
		setTitle("Registrar Respuesta de Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel Datos Llamada
		
		panelDatosLlamada = new JPanel();
		panelDatosLlamada.setBounds(12, 12, 414, 191);
		panelDatosLlamada.setLayout(null);

		// Label de Datos de la Llamada

		lblDatosLlamada = new JLabel("Datos de la Llamada");
		lblDatosLlamada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosLlamada.setBounds(14, 3, 160, 22);
		panelDatosLlamada.add(lblDatosLlamada);
		// Label de Nombre de Categoria seleccionada

		datosCategorialbl = new JLabel("Categoria seleccionada:");
		datosCategorialbl.setBounds(12, 82, 137, 16);
		panelDatosLlamada.add(datosCategorialbl);

		// Label de Nombre de Opcion

		datosOpcionlbl = new JLabel("Opcion:");
		datosOpcionlbl.setBounds(12, 110, 43, 16);
		panelDatosLlamada.add(datosOpcionlbl);

		textFieldDatosCategoria = new JTextField();
		textFieldDatosCategoria.setEditable(false);
		textFieldDatosCategoria.setBounds(174, 76, 114, 20);
		panelDatosLlamada.add(textFieldDatosCategoria);
		textFieldDatosCategoria.setColumns(10);

		textFieldDatosOpcion = new JTextField();
		textFieldDatosOpcion.setEditable(false);

		textFieldDatosOpcion.setColumns(10);
		textFieldDatosOpcion.setBounds(174, 108, 114, 20);
		panelDatosLlamada.add(textFieldDatosOpcion);

		// Label de Nombre de SubOpcion

		datosSubOpcionlbl = new JLabel("SubOpcion:");
		datosSubOpcionlbl.setBounds(14, 142, 65, 16);
		panelDatosLlamada.add(datosSubOpcionlbl);

		// Label de Nombre de Datos a Validar
		// Label de Nombre completo

		lblNombre = new JLabel("Nombre cliente completo: ");
		lblNombre.setBounds(14, 46, 148, 16);
		panelDatosLlamada.add(lblNombre);
		
		textFieldDatosSubOpcion = new JTextField();
		textFieldDatosSubOpcion.setEditable(false);

		textFieldDatosSubOpcion.setColumns(10);
		textFieldDatosSubOpcion.setBounds(174, 140, 114, 20);
		panelDatosLlamada.add(textFieldDatosSubOpcion);

		textField = new JTextField();
		textField.setEditable(false);

		textField.setColumns(10);
		textField.setBounds(174, 44, 114, 20);
		panelDatosLlamada.add(textField);
		
		// Panel de Accion Requerida
		
		panelAccionRequerida = new JPanel();
		panelAccionRequerida.setBounds(12, 215, 414, 185);
		panelAccionRequerida.setLayout(null);
		lblSolicitarAccionRequerida = new JLabel("Solicitar Accion Requerida");
		lblSolicitarAccionRequerida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSolicitarAccionRequerida.setBounds(12, 12, 210, 22);
		panelAccionRequerida.add(lblSolicitarAccionRequerida);
		
		
		inputDescripcion = new JTextField();
		inputDescripcion.setBounds(12, 113, 176, 63);
		panelAccionRequerida.add(inputDescripcion);
		inputDescripcion.setColumns(10);
		
		JLabel lblIngresaDescripcion = new JLabel("Ingresa Descripcion");
		lblIngresaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngresaDescripcion.setBounds(25, 84, 129, 17);
		panelAccionRequerida.add(lblIngresaDescripcion);
		
		btnAccionCancelar = new JButton("Cancelar");
		btnAccionCancelar.setBounds(202, 150, 98, 26);
		panelAccionRequerida.add(btnAccionCancelar);
		
		 
		btnAccionSiguiente = new JButton("Siguiente");
		btnAccionSiguiente.setBounds(312, 150, 98, 26);
		panelAccionRequerida.add(btnAccionSiguiente);
		
		/**
		mostrarDatosLlamada(null, null, null, null);
		solicitarAccionRequerida(null);
		solicitarValidacionRequerida(getName(), null);
		**/

		this.setVisible(true);
	}

	public void mostrarDatosLlamada(Cliente cliente, Categoria cat, SubOpcion subOp,
		Opcion opcion) {
		contentPane.add(panelDatosLlamada);	
		textFieldDatosCategoria.setText(cat.getNombre());
		textFieldDatosOpcion.setText(opcion.getNombre());
		textFieldDatosSubOpcion.setText(subOp.getNombre());
		textField.setText(cliente.getNombreCompleto());
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void solicitarValidacionRequerida(String key, Validacion val) {
		// Panel Validacion
		
		JPanel panelValidacion = new JPanel();
		panelValidacion.setBounds(12, 215, 414, 187);
		panelValidacion.setLayout(null);
		
		JLabel lblValidacion = new JLabel();
		lblValidacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidacion.setBounds(12, 46, 129, 17);
		panelValidacion.add(lblValidacion);

		// Input para realizar la validacion

		inputFieldNameValidator = new JTextField();
		//inputFieldNameValidator.setVisible(false);
		inputFieldNameValidator.setBounds(12, 76, 119, 20);
		panelValidacion.add(inputFieldNameValidator);
		
		
		JLabel lblDatosValidacion = new JLabel("Datos Validacion");
		lblDatosValidacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosValidacion.setBounds(12, 12, 160, 22);
		panelValidacion.add(lblDatosValidacion);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setBounds(304, 149, 98, 26);
		panelValidacion.add(btnValidar);
		lblValidacion.setText(key);
		lblValidacion.setVisible(true);
		inputFieldNameValidator.setVisible(true);

		JButton btnValidarCancelar = new JButton("Cancelar");
		btnValidarCancelar.setBounds(192, 149, 98, 26);
		panelValidacion.add(btnValidarCancelar);
		contentPane.add(panelValidacion);

		contentPane.revalidate();
		contentPane.repaint();

		btnValidar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Boolean bool=gestor.tomarDatoValidacion(inputFieldNameValidator.getText(), val);
				if(bool){
					JOptionPane.showMessageDialog(null, "El dato ingresado es correcto");
					contentPane.remove(panelValidacion);
					contentPane.revalidate();
					contentPane.repaint();
				}else{
					JOptionPane.showMessageDialog(null, "El dato ingresado no es correcto");
				}

				
			}
		});
		btnValidarCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				gestor.cancelarLlamada();
				dispose();


			}
		});
	};

	public void solicitarAccionDescripcionRequerida(HashMap<String, Accion> acciones) {
		System.out.println(acciones);
		comboBox = new JComboBox(acciones.keySet().toArray());		
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(22, 46, 132, 25);
		panelAccionRequerida.add(comboBox);
		contentPane.add(panelAccionRequerida);
		contentPane.revalidate();
		contentPane.repaint();

		btnAccionSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				gestor.tomarAccionDescripcionRequerida(acciones.get(comboBox.getSelectedItem()), inputDescripcion.getText());

			}
		
		});
		btnAccionCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				gestor.cancelarLlamada();
				dispose();
			}
		});

	}
	
	public void solicitarConfirmacion() {
		int input = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la Accion?");
		if (input == 0){
				gestor.tomarConfirmacion(true);
				contentPane.remove(panelAccionRequerida);
				contentPane.revalidate();
				contentPane.repaint();
		}
	}

	public void informarAccionRegistrada() {
		JOptionPane.showMessageDialog(null, "La accion fue registrada correctamente");
		dispose();
	}
	


	
}
