package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import arreglo.ArregloCategoriaProducto;
import clase.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoriaProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnombCatagoria;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriaProducto frame = new CategoriaProducto();
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
	public CategoriaProducto() {
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(28, 59, 67, 14);
		contentPane.add(lblNewLabel);
		
		txtnombCatagoria = new JTextField();
		txtnombCatagoria.setBounds(117, 56, 86, 20);
		contentPane.add(txtnombCatagoria);
		txtnombCatagoria.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setToolTipText("");
		cboEstado.setBounds(300, 55, 86, 22);
		contentPane.add(cboEstado);
		
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(227, 59, 67, 14);
		contentPane.add(lblEstado);
		
		txtS = new JTextArea();
		txtS.setBounds(28, 129, 396, 121);
		contentPane.add(txtS);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			//BTN MODIFICAR
			public void actionPerformed(ActionEvent e) {
				clase.CategoriaProducto c = cp.Buscar(LeerCodigo());
				if(c != null) {
					c.setNombreCategoriaProduct(LeerNombre());
					c.setEstado(LeerEstado());
					txtS.setText(""); 
			        Listado();
			        Mensaje("Registro modificado correctamente");
				}
				else Mensaje("El código no existe");
			}
		});
		btnModificar.setBounds(297, 96, 89, 23);
		contentPane.add(btnModificar);
		
		txtcodCategoria = new JTextField();
		txtcodCategoria.setColumns(10);
		txtcodCategoria.setBounds(117, 25, 86, 20);
		contentPane.add(txtcodCategoria);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(28, 28, 67, 14);
		contentPane.add(lblCodigo);
		
		JButton btnNewButton = new JButton("Reportar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtS.setText("");
				Listado();
			}
		});
		btnNewButton.setBounds(28, 99, 84, 20);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
				try {
		            // Validación básica
		            if (txtcodCategoria.getText().isEmpty() || txtnombCatagoria.getText().isEmpty()) {
		                Mensaje("Completa todos los campos");
		                return;
		            }
		            // Evitar duplicados
		            if (cp.Buscar(LeerCodigo()) != null) {
		                Mensaje("El código ya existe");
		                return;
		            }
		            // Crear objeto correcto
		            clase.CategoriaProducto C = new clase.CategoriaProducto(LeerCodigo(),LeerNombre(),LeerEstado());
		            // Agregar
		            cp.Adicionar(C);		                       
		            Mensaje("Registro agregado correctamente");

		        } catch (Exception ex) {
		            Mensaje("Error: datos inválidos");
		        }
		    }
		});
		btnNewButton_1.setBounds(165, 99, 84, 20);
		contentPane.add(btnNewButton_1);
		Listado();
	}
	
	ArregloCategoriaProducto cp = new ArregloCategoriaProducto();
	private JTextField txtcodCategoria;
	private JComboBox cboEstado;
	private JButton btnNewButton_1;
	
	void Mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	//Impimir 
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	
	//Listar Producto
	void Listado() {
		Imprimir("Codigo\tNombre\tEstado");
		
		for (int i = 0; i <cp.Tamaño() ; i++) {
			String estadoTexto = (cp.Obtener(i).getEstado() == 0) ? "Activo" : "Inactivo";
			Imprimir(cp.Obtener(i).getCodigoCategoria() + "\t" + 
		             cp.Obtener(i).getNombreCategoriaProduct() + "\t" + 
		             estadoTexto);
		}
	}
	//Convertidor
	int LeerCodigo() {
		return Integer.parseInt(txtcodCategoria.getText());
	}
	String LeerNombre() {
		return txtnombCatagoria.getText();
	}
	int LeerEstado() {
	    // getSelectedIndex() devuelve 0 para la primera opción, 1 para la segunda, etc.
	    return cboEstado.getSelectedIndex(); 
	}
}
