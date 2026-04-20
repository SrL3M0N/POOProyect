package arreglo;

import java.util.ArrayList;
import clase.CategoriaProducto;

public class ArregloCategoriaProducto {
	
	private ArrayList<CategoriaProducto>categoriaProducts;
	
	private ArrayList<CategoriaProducto>list;

	public ArregloCategoriaProducto() {
		categoriaProducts = new ArrayList<CategoriaProducto>();
		Adicionar(new CategoriaProducto(1, "Doble filo", 1));
		
	}
	//Metodo Adicionar
	public void Adicionar(CategoriaProducto x) {
		categoriaProducts.add(x);
	}
	//Metodo tamaño
	public int Tamaño() {
		return categoriaProducts.size();
	}
	//Metodo Obtener
	public CategoriaProducto Obtener(int x) {
		return categoriaProducts.get(x);
	}
	//Metodo Buscar
	public CategoriaProducto Buscar(int cod) {
		for (int i = 0; i < Tamaño(); i++) {
			if(Obtener(i).getCodigoCategoria() == cod) return Obtener(i);
		}
		return null;
	}
	//Metodo Eliminar
	public void Eliminar(int Codigo){
		for (int i = 0; i < Tamaño(); i++) {
			if(Obtener(i).getCodigoCategoria() == Codigo) {
				categoriaProducts.remove(i);
				return;
			}
		}
	}
	

}
