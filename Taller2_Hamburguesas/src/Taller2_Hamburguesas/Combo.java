package Taller2_Hamburguesas;

import java.util.ArrayList;

public class Combo implements Producto
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Descuento del Combo.
	 */
	private double descuento;

	/**
	 * Nombre del combo.
	 */
	private String nombreCombo;

	/**
	 * Productos en el restaurante.
	 */
	private ArrayList<Producto> itemsCombo;


	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Metodo constructor.
	 * Agrega un combo con su descuento y nombre
	 * @param pNombreCombo Nombre del combo 
	 * @param pDescuento Descuento del combo
	 */
	public Combo( String pNombreCombo, double pDescuento)
	{
		nombreCombo = pNombreCombo;
		descuento = pDescuento;
		itemsCombo = new ArrayList<Producto>();
	}

	/**
	 * Agrega un producto menu a itemsCombo
	 * @param pItemCombo el producto menu a agregar
	 */
	public void agregarItemACombo(ProductoMenu pItemCombo)
	{
		itemsCombo.add(pItemCombo);
	}

	/**
	 * Retorna el precio final del combo luego de la reduccion del descuento
	 * @return precio total del combo
	 */
	public int getPrecio()
	{
		int suma = 0;
		double porcentaje = (100 - descuento)/100;
		double precio = 0;
		for (Producto productoMenu : itemsCombo) {
			suma = suma + productoMenu.getPrecio();
		}
		precio = suma * porcentaje;
		return (int)precio;
	}

	/**
	 * Genera un String con el costo y nombre del producto para la facturacion
	 * @return String para la facturacion, formato: Nombre --------------------- PrecioBase
	 */
	public String generarTextoFactura()
	{
		String aRetornar = getNombre() + " --------------------- " + getPrecio();
		return aRetornar;
	}

	/**
	 * Retorna el nombre del combo
	 * @return String con el nombre del combo
	 */
	public String getNombre() {
		return nombreCombo;
	}

	/**
	 * Retorna arraylist con los productos del combo 
	 * @return Arraylist con los productos del combo
	 */
	public ArrayList<Producto> getItemsCombo()
	{
		return itemsCombo;
	}

	/**
	 * Retorna el descuento del combo
	 * @return double con el descuento del combo
	 */
	public double getDescuento()
	{
		return descuento;
	}
}


