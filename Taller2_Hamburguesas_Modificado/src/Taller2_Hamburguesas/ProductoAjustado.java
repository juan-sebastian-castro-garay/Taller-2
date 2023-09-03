package Taller2_Hamburguesas;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{

	/**
	 * Producto base 
	 */
	private ProductoMenu base;

	/**
	 * Arraylist con los ingredientes agregados al producto
	 */
	private ArrayList<Ingrediente> agregados;

	/**
	 * Arraylist con los ingredientes eliminados al producto
	 */
	private ArrayList<Ingrediente> eliminados;

	/**
	 * Metodo constructor.
	 * @param pBase representa un producto que se ajustó cuando se agregó a un pedido
	 * @param pCalorias calorias de la bebida
	 */
	public ProductoAjustado(ProductoMenu pBase)
	{
		base = pBase;
		agregados = new ArrayList<Ingrediente>();
		eliminados = new ArrayList<Ingrediente>();
	}


	/**
	 * Metodo que genera el texto de la factura 
	 * @return String con el texto de la factura
	 */
	@Override
	public String getNombre() {
		String aRetornar = ""+base.getNombre();
		for (Ingrediente ingrediente : eliminados) {
			aRetornar = aRetornar + " ,sin " + ingrediente.getNombre();
		}

		for (Ingrediente ingrediente : agregados) {
			aRetornar = aRetornar + " ,con " + ingrediente.getNombre();
		}
		return aRetornar;
	}

	@Override
	/**
	 * Metodo que retorna el nombre del producto
	 * @return String con el nombre del producto
	 */
	public int getPrecio() {
		int aRetornar = base.getPrecio();
		for (Ingrediente ingrediente : agregados) {
			aRetornar = aRetornar +  ingrediente.getCostoAdicional();
		}
		return aRetornar;
	}

	/**
	 * Metodo abstracto que genera el texto de la factura 
	 * @return String con el texto de la factura
	 * ----------- calorias
	 */
	@Override
	public String generarTextoFactura() {
		String aRetornar = getNombre() + " --------------------- " + getPrecio();
		aRetornar = aRetornar + "\n-----------" + getCalorias() + " calorias";
		return aRetornar;
	}

	/**
	 * Agrega un prodcuto al arraylist agregados
	 * @param pAgregar ingrediente a agregar
	 */
	public void agregarIngrediente(Ingrediente pAgregar)
	{
		agregados.add(pAgregar);
	}

	/**
	 * Agrega un prodcuto al arraylist eliminados
	 * @param pEliminar ingrediente a eliminar
	 */
	public void eliminarIngrediente(Ingrediente pEliminar)
	{
		eliminados.add(pEliminar);
	}

	/**
	 * Retorna el las calorias del producto
	 * @return int con las calorias del producto
	 */
	@Override
	public int getCalorias() {
		int aRetornar = base.getCalorias();
		for (Ingrediente ingrediente : agregados) {
			aRetornar = aRetornar +  ingrediente.getCalorias();
		}
		return aRetornar;
	}
}
