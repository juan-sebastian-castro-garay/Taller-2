package Taller2_Hamburguesas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * El numero del pedido
	 */
	private int idPedido = 0;

	/**
	 * El nombre del cliente
	 */
	private String nombreCliente = "";

	/**
	 * La direccion del cliente
	 */
	private String direccionCliente = "";

	/**
	 * Arraylist con los productos del pedido
	 */
	private ArrayList<Producto> itemsPedido;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------


	/**
	 * Metodo constructor
	 * @param pNombreCliente Nombre del cliente
	 * @param pDireccionCliente Direccion del cliente
	 */
	public Pedido(String pNombreCliente,String pDireccionCliente, int pIdPedido)
	{
		nombreCliente = pNombreCliente;
		direccionCliente = pDireccionCliente;
		idPedido = pIdPedido;
		itemsPedido = new ArrayList<Producto>();
	}

	/**
	 * Retorna el id del pedido
	 * @return El id del pedido, no null, valor entero.
	 */
	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * Agrega un producto a los items del pedido
	 * @param pNuevoItem Producto a agregar
	 */
	public void agregarProducto(Producto pNuevoItem){
		itemsPedido.add(pNuevoItem);
	}

	/**
	 * Retorna el precio neto del pedido (sin iva)
	 * @return Int con el precio neto del pedido 
	 */
	public int getPrecioNetoPedido()
	{
		int aRetornar = 0;
		for (Producto producto : itemsPedido) {
			aRetornar = aRetornar + producto.getPrecio();
		}
		return aRetornar;
	}

	/**
	 * Retorna el precio total del pedido. (con iva)
	 * @return Int con el precio total del pedido
	 */
	public int getPrecioTotalPedido()
	{
		int aRetornar = 0;
		for (Producto producto : itemsPedido) {
			aRetornar = aRetornar + producto.getPrecio();
		}
		aRetornar = (int)(aRetornar * 1.19);
		return aRetornar;
	}

	/**
	 * Retorna Iva del pedido
	 * @return Int iva del pedido
	 */
	public int getPrecioIvaPedido()
	{
		int aRetornar = getPrecioTotalPedido() - getPrecioNetoPedido();
		return aRetornar;
	}

	/**
	 * genera el texto de la factura de compra
	 * @return String con la factura de compra del pedido
	 */
	public String generarTextoFactura()
	{
		String aRetornar = "------------------------------------------------\r\n"
				+ "          FACTURA DE COMPRA";
		aRetornar = aRetornar + "\n\nID del Pedido: " + getIdPedido();
		aRetornar = aRetornar + "\nNombre del Cliente: " + getNombreCliente();
		aRetornar = aRetornar + "\nDireccion del Cliente: " + getDireccionCliente();
		aRetornar = aRetornar + "\n\nProductos: ";

		for (Producto producto : itemsPedido) {
			String factura = producto.generarTextoFactura();
			aRetornar = aRetornar + "\n"+ factura;
		}
		aRetornar = aRetornar + "\n\n\nCosto Neto"+ " --------------------- " + getPrecioNetoPedido();
		aRetornar = aRetornar + "\nIVA (19%)"+ " --------------------- " + getPrecioIvaPedido();
		aRetornar = aRetornar +" \n------------------------------------------ " ;
		aRetornar = aRetornar + "\nCosto Total"+ " --------------------- " + getPrecioTotalPedido();
		aRetornar = aRetornar + "\n\n¡Gracias por su compra!\r\n";
		aRetornar = aRetornar +" \n------------------------------------------ " ;
		return aRetornar;
	}

	/**
	 * Guarda la factura en el archivo que entra por parametro
	 * @param archivo El archivo donde se guardara la factura
	 * @throws IOException
	 */
	public void guardarFactura(File archivo) throws IOException
	{
		String contenido = generarTextoFactura();

		FileWriter escritorArchivo = new FileWriter(archivo);
		BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

		bufferEscritura.write(contenido);

		bufferEscritura.close();
	}

	/**
	 * Retorna el nombre del cliente
	 * @return String con el nombre del cliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Retorna la direccion del cliente
	 * @return String con la direccion del cliente
	 */
	public String getDireccionCliente() {
		return direccionCliente;
	}


}
