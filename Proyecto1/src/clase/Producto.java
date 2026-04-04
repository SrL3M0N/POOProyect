package clase;

public class Producto {
	
	private int  codigo;
	private String Nombre;
	private double precio;
	private int stock;
	
	public Producto(int codigo, String nombre, double precio, int stock) {
		super();
		this.codigo = codigo;
		Nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	

}

