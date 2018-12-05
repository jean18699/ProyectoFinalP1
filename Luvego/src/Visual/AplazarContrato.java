package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Contrato;
import Logico.Proyecto;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AplazarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFechaAnterior;
	private String patron = "dd/MM/yyyy";
	private JSpinner spnFecha;
	
	private Contrato contrato;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AplazarContrato dialog = new AplazarContrato(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AplazarContrato(Contrato contrato) {
		this.contrato = contrato;
		setResizable(false);
		setType(Type.UTILITY);
		setBounds(100, 100, 356, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 0, 174, 89);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblIngresarNuevaFecha = new JLabel("Ingresar nueva fecha");
				lblIngresarNuevaFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblIngresarNuevaFecha.setHorizontalAlignment(SwingConstants.CENTER);
				lblIngresarNuevaFecha.setBounds(0, 11, 174, 14);
				panel.add(lblIngresarNuevaFecha);
			}
			{
				Date date = new Date();
				SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
	
				spnFecha = new JSpinner(sdm);
				spnFecha.setBounds(32, 42, 108, 20);
				panel.add(spnFecha);
				
				JSpinner.DateEditor DateEdit = new JSpinner.DateEditor(spnFecha, patron);
				DateEdit.getTextField().setEditable(true);
				
				spnFecha.setEditor(DateEdit);
				
				
			}
		}
		
		
		
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(170, 0, 180, 90);
			contentPanel.add(panel);
			panel.setLayout(null);
					{
						txtFechaAnterior = new JTextField();
						txtFechaAnterior.setBounds(31, 42, 115, 20);
						panel.add(txtFechaAnterior);
						txtFechaAnterior.setEditable(false);
						txtFechaAnterior.setColumns(10);
						txtFechaAnterior.setText(contrato.getFechaEntrega().toString());
					}
					{
						JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega anterior");
						lblFechaDeEntrega.setHorizontalAlignment(SwingConstants.CENTER);
						lblFechaDeEntrega.setBounds(0, 11, 180, 20);
						panel.add(lblFechaDeEntrega);
						lblFechaDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
					}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contrato.aplazar((Date)spnFecha.getValue());
						dispose();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}