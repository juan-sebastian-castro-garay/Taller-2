package Taller2_Hamburguesas;

public class ProductoMenu implements Producto{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre del producto del menu.
	 */
	private String nombre;

	/**
	 * Precio base del producto del menu.
	 */
	private int precioBase;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------


	/**
	 * Metodo constructor.
	 * Agrega un productoMenu con su nombre y su costo
	 * @param pNombre Nombre del productoMenu
	 * @param pPrecioBase costo del productoMenu. valor entero no Null
	 */
	public ProductoMenu(String pNombre, int pPrecioBase)
	{
		nombre = pNombre;
		precioBase = pPrecioBase;
	}

	/**
	 * Retorna el nombre del productoMenu
	 * @return String con el nombre del productoMenu
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna el precio Base
	 * @return Int con el precio Base
	 */
	public int getPrecio() {
		return precioBase;
	}

	/**
	 * Genera un String con el costo y nombre del producto para la facturacion
	 * @return String para la facturacion, formato: Nombre --------------------- PrecioBase
	 */
	public String generarTextoFactura()
	{
		String aRetornar = nombre + " --------------------- " + precioBase;
		return aRetornar;
	}
}
