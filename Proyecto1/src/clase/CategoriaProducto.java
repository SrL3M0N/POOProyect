package clase;

public class CategoriaProducto {
	
	private int codigoCategoria;
	private String nombreCategoriaProduct; 
	private int estado;
	public CategoriaProducto(int codigoCategoria, String nombreCategoriaProduct, int estado) {
		super();
		this.codigoCategoria = codigoCategoria;
		this.nombreCategoriaProduct = nombreCategoriaProduct;
		this.estado = estado;
	}
	public int getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getNombreCategoriaProduct() {
		return nombreCategoriaProduct;
	}
	public void setNombreCategoriaProduct(String nombreCategoriaProduct) {
		this.nombreCategoriaProduct = nombreCategoriaProduct;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	


	

	

	
	
	
	
}
