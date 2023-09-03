package Taller2_Hamburguesas;

public interface Producto {

	/**
	 * Metodo abstracto que retorna el precio de los productos
	 * @return int con el precio del producto
	 */
	public abstract int getPrecio();

	/**
	 * Metodo abstracto que retorna el nombre del producto
	 * @return String con el nombre del producto
	 */
	public abstract String getNombre();

	/**
	 * Metodo abstracto que genera el texto de la factura 
	 * @return String con el texto de la factura
	 */
	public abstract String generarTextoFactura();
}
