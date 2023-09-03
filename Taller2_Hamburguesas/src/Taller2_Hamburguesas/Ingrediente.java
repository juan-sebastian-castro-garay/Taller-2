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


	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Metodo constructor.
	 * Agrega un ingrediente con su nombre y su costo
	 * @param pNombre Nombre del ingrediente
	 * @param pCostoAdicional costo adicional del ingrediente. valor entero no Null
	 */
	public Ingrediente(String pNombre, int pCostoAdicional)
	{
		nombre = pNombre;
		costoAdicional = pCostoAdicional;
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

}
