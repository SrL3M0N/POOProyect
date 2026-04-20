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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

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
		setBounds(100, 100, 529, 321);
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
			lblNewLabel_1.setBounds(191, 10, 44, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setBounds(32, 48, 44, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Stock:");
			lblNewLabel_3.setBounds(191, 48, 44, 12);
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
			txtNomb.setBounds(245, 7, 96, 18);
			contentPane.add(txtNomb);
			txtNomb.setColumns(10);
		}
		{
			txtStock = new JTextField();
			txtStock.setBounds(245, 45, 96, 18);
			contentPane.add(txtStock);
			txtStock.setColumns(10);
		}
		
		JButton bt_limpiar = new JButton("Limpiar");
		bt_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStock.setText("");
				txtNomb.setText("");
				txtPrecio.setText("");
				txtcod.setText("");
			}
		});
		bt_limpiar.setBounds(374, 26, 75, 20);
		contentPane.add(bt_limpiar);
		{
			bt_eliminar = new JButton("Eliminar");
			bt_eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 if (txtcod.getText().isEmpty()) {
				            Mensaje("Ingrese un código");
				            return;
				        }

				        int codigo = LeerCodigo();
				        Producto p = ap.Buscar(codigo);

				        if (p != null) {
				            ap.Eliminar(codigo);
				            Mensaje("Producto eliminado correctamente");

				            // Limpiar campos
				            txtcod.setText("");
				            txtNomb.setText("");
				            txtPrecio.setText("");
				            txtStock.setText("");

				            // Actualizar listado
				            txtS.setText("");
				            Listado();

				        } else {
				            Mensaje("El código no existe");
				        }
				    }
				
			});
			bt_eliminar.setBounds(201, 94, 84, 20);
			contentPane.add(bt_eliminar);
		}
		// Boton adicionar
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto p = new Producto(LeerCodigo(),LeerNombre(),LeerPrecio(),LeerStock());
				ap.Adicionar(p);		
			}
		});
		btnAdicionar.setBounds(114, 94, 84, 20);
		contentPane.add(btnAdicionar);
		
		//Botón buscar:
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtS.setText("");		
				Producto pr= ap.Buscar(Integer.parseInt(txtcod.getText()));
				if(pr!=null) {
				Imprimir("Código\tNombre\tPrecio\tStock");
				Imprimir(pr.getCodigo()+"\t"+pr.getNombre()+"\t"+pr.getPrecio()+"\t"+pr.getStock());
				
				}
				else {
					JOptionPane.showMessageDialog(null,"No existe código");
				}
			}
		});
		btnNewButton_1.setBounds(288, 94, 84, 20);
		contentPane.add(btnNewButton_1);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(374, 93, 84, 20);
		contentPane.add(btnModificar);
		Listado();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	ArregloProducto ap = new ArregloProducto();
	private JButton bt_eliminar;
	private JButton btnModificar;
	
	//Boton de Reportar Producto
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado();
	}
	
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	
	//Listar Producto
	void Listado() {
		Imprimir("Código\tNombre\tPrecio\tStock");
		for (int i = 0; i < ap.Tamaño(); i++) {
			Imprimir(""+ap.Obtener(i).getCodigo()+"\t"+ap.Obtener(i).getNombre()
			+"\t"+ap.Obtener(i).getPrecio()+"\t"+ap.Obtener(i).getStock());
		}
	}
	
		void  Mensaje(String s) {
			JOptionPane.showMessageDialog(this, s);
		}
	//Convertidor 
		int LeerCodigo() {
			return Integer.parseInt(txtcod.getText());		
		}
		String LeerNombre() {
			return txtNomb.getText();
		}
		double LeerPrecio() {
			return Double.parseDouble(txtPrecio.getText());
		}
		int LeerStock() {
			return Integer.parseInt(txtStock.getText());		
		}
		
	//boton Modificar	
		
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		Producto p=ap.Buscar(LeerCodigo());
		if(p!=null) {
			p.setNombre(LeerNombre());
			p.setPrecio(LeerPrecio());
			p.setStock(LeerStock());
			txtS.setText(""); 
			Listado();
	        Mensaje("Registro modificado correctamente");
		}
		else Mensaje ("El código no existe");
	}
} 
