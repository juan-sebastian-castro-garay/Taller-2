package Taller2_Hamburguesas;

public class Bebida implements Producto{

	/**
	 * Nombre de la bebida
	 */
	private String nombre;

	/**
	 * Precio de la bebida
	 */
	private int precio;

	/**
	 * Calorias del producto
	 */
	private int calorias;

	/**
	 * metodo constructor
	 * @param pNombre nombre de la bebida
	 * @param pPrecio precio de la bebida
	 * @param pCalorias calorias de la bebida
	 */
	public Bebida(String pNombre, int pPrecio, int pCalorias)
	{
		nombre = pNombre;
		precio = pPrecio;
		calorias = pCalorias;
	}
	/**
	 * Retorna el precio 
	 * @return Int con el precio 
	 */
	@Override
	public int getPrecio() 
	{
		return precio;
	}

	/**
	 * Retorna el nombre de la bebida
	 * @return String con el nombre de la bebida
	 */
	@Override
	public String getNombre() {
		return nombre;
	}

	/**
	 * Genera un String con el costo, nombre y calorias de la bebida
	 * @return String para la facturacion, formato: Nombre --------------------- PrecioBase
	 * ----------- calorias
	 */
	@Override
	public String generarTextoFactura() {
		String aRetornar = getNombre() + " --------------------- " + getPrecio();
		aRetornar = aRetornar + "\n-----------" + getCalorias() + " calorias";
		return aRetornar;

	}

	/**
	 * Retorna el las calorias del producto
	 * @return int con las calorias del producto
	 */
	@Override
	public int getCalorias() {
		return calorias;
	}

}
