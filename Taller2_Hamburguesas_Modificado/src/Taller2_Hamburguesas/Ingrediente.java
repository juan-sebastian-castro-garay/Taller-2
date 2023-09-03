package Taller2_Hamburguesas;

public class Ingrediente {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre del ingrediente.
	 */
	private String nombre;

	/**
	 * Costo adicional del ingrediente.
	 */
	private int costoAdicional;
	
	/**
	 * Calorias del producto
	 */
	private int calorias;


	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Metodo constructor.
	 * Agrega un ingrediente con su nombre y su costo
	 * @param pNombre Nombre del ingrediente
	 * @param pCostoAdicional costo adicional del ingrediente. valor entero no Null
	 * @param pCalorias calorias de la bebida
	 */
	public Ingrediente(String pNombre, int pCostoAdicional, int pCalorias)
	{
		nombre = pNombre;
		costoAdicional = pCostoAdicional;
		calorias = pCalorias;
	}

	/**
	 * Retorna el nombre del ingrediente
	 * @return String con el nombre del ingrediente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retorna el costo adicional
	 * @return Int con el costo adicional
	 */
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
	/**
	 * Retorna el las calorias del producto
	 * @return int con las calorias del producto
	 */
	public int getCalorias() {
		return calorias;
	}

}
