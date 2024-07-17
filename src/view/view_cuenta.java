package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_GenData;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class view_cuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_CEDULA;
	public JButton btn_buscar;
	public JTextField txt_Cuenta;
	public JTextField txt_tipo;
	public JTextField txt_saldo;
	public JTextField txt_valo;
	public JButton btn_EJECUTAR;
	public JRadioButton rdbtn_retiro;
	public JRadioButton rdbtn_deposito;
	public ButtonGroup operacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_cuenta frame = new view_cuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_cuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 352, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 15, 77, 13);
		panel.add(lblNewLabel);
		
		txt_CEDULA = new JTextField();
		txt_CEDULA.setBounds(92, 12, 148, 19);
		panel.add(txt_CEDULA);
		txt_CEDULA.setColumns(10);
		
		btn_buscar = new JButton("Search");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_buscar.setBounds(257, 12, 85, 21);
		panel.add(btn_buscar);
		
		JLabel lblCuenta = new JLabel("Number Count:");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCuenta.setBounds(57, 55, 112, 13);
		panel.add(lblCuenta);
		
		JLabel lblTipo = new JLabel("Type Count:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(57, 96, 112, 13);
		panel.add(lblTipo);
		
		JLabel lblSaldo = new JLabel("Currency Total:");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSaldo.setBounds(57, 136, 112, 13);
		panel.add(lblSaldo);
		
		txt_Cuenta = new JTextField();
		txt_Cuenta.setColumns(10);
		txt_Cuenta.setBounds(179, 52, 163, 19);
		panel.add(txt_Cuenta);
		
		txt_tipo = new JTextField();
		txt_tipo.setColumns(10);
		txt_tipo.setBounds(179, 93, 163, 19);
		panel.add(txt_tipo);
		
		txt_saldo = new JTextField();
		txt_saldo.setColumns(10);
		txt_saldo.setBounds(179, 133, 163, 19);
		panel.add(txt_saldo);
		
		txt_valo = new JTextField();
		txt_valo.setColumns(10);
		txt_valo.setBounds(113, 235, 110, 19);
		panel.add(txt_valo);
		
		JLabel lblOperacion = new JLabel("Operations:");
		lblOperacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOperacion.setBounds(26, 238, 77, 13);
		panel.add(lblOperacion);
		
		btn_EJECUTAR = new JButton("Accept");
		btn_EJECUTAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_EJECUTAR.setBounds(233, 234, 85, 21);
		panel.add(btn_EJECUTAR);
		
		rdbtn_retiro = new JRadioButton("Withdraw");
		rdbtn_retiro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtn_retiro.setBounds(48, 176, 121, 24);
		panel.add(rdbtn_retiro);
		
		rdbtn_deposito = new JRadioButton("Deposit");
		rdbtn_deposito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtn_deposito.setBounds(179, 177, 121, 24);
		panel.add(rdbtn_deposito);
		
		operacion=new ButtonGroup();
		operacion.add(rdbtn_deposito);
		operacion.add(rdbtn_retiro);
		new Logic_GenData(this);
	}
}
