package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloProducto;
import clase.Producto;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class v1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtcod;
	private JTextField txtPrecio;
	private JTextField txtNomb;
	private JTextField txtStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 frame = new v1();
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
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnNewButton = new JButton("Reportar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(20, 94, 84, 20);
			contentPane.add(btnNewButton);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(20, 121, 406, 145);
			contentPane.add(txtS);
		}
		{
			lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(32, 10, 44, 12);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(225, 10, 44, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setBounds(32, 48, 44, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Stock:");
			lblNewLabel_3.setBounds(225, 48, 44, 12);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtcod = new JTextField();
			txtcod.setBounds(78, 7, 96, 18);
			contentPane.add(txtcod);
			txtcod.setColumns(10);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(78, 45, 96, 18);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtNomb = new JTextField();
			txtNomb.setBounds(285, 7, 96, 18);
			contentPane.add(txtNomb);
			txtNomb.setColumns(10);
		}
		{
			txtStock = new JTextField();
			txtStock.setBounds(285, 45, 96, 18);
			contentPane.add(txtStock);
			txtStock.setColumns(10);
		}
		Listado();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	ArregloProducto ap = new ArregloProducto();
	
	//Reportar
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
	}
	
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	
	void Listado() {
		Imprimir("Código\tNombre\tPrecio\tStock");
		for (int i = 0; i < ap.Tamaño(); i++) {
			Imprimir(""+ap.Obtener(i).getCodigo()+"\t"+ap.Obtener(i).getNombre()
			+"\t"+ap.Obtener(i).getPrecio()+"\t"+ap.Obtener(i).getStock());
		}
	}
}
