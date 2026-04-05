package arreglo;

import java.util.ArrayList;

import clase.Producto;


public class ArregloProducto {
	
	private ArrayList<Producto> product;
	
	//Metodo Constructor ArregloProducto 
	public ArregloProducto() {
		product = new ArrayList<Producto>();
		Adicionar(new Producto(1020, "Ventilador", 50.00, 10));
	}
	// Metodo adicionar
	public void Adicionar(Producto x) {
		product.add(x); 
	}
	
	public int Tamaño() {
		return product.size();
	}
	
	public Producto Obtener(int x) {
		return product.get(x);
	}
	//Método buscar 
	public Producto Buscar(int cod) {
		for (int i = 0; i <Tamaño(); i++) {
			if(Obtener(i).getCodigo()==cod)return Obtener(i);
		}
		return null;
	}
	

}
