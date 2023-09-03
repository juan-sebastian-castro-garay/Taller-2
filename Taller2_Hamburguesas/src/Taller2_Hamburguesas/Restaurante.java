package Taller2_Hamburguesas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Restaurante {

	// -----------------------------------------------------------------
	// Cpnstantes
	// -----------------------------------------------------------------
	/**
	 * Constante numeroPedidos =.
	 */
	private int numeroPedidos = 0;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * El nombre del cliente
	 */
	private String nombreCliente = "";

	/**
	 * La direccion del cliente
	 */
	private String direccionCliente = "";


	/**
	 * Productos en el restaurante.
	 */
	private ArrayList<Ingrediente> ingredientes;

	/**
	 * Productos en el menu.
	 */
	private ArrayList<ProductoMenu> menuBase;

	/**
	 * Productos en el restaurante.
	 */
	private ArrayList<Combo> combos;

	/**
	 * pedido en curso
	 */
	private Pedido pedidoEnCurso;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Metodo constructor.
	 * @throws IOException 
	 */

	public Restaurante() throws IOException
	{
		ingredientes = new ArrayList<Ingrediente>();
		menuBase = new ArrayList<ProductoMenu>();
		combos = new ArrayList<Combo>();
		File rutaArchivoRestaurante = new File("./archivos/data/informacion Restaurante.txt");
		cargarArchivoRestaurante(rutaArchivoRestaurante);

	}

	/**
	 * Inicia el pedido y carga los archivos del restuarante
	 * @param pNombreCliente El nombre del cliente
	 * @param pDireccionCliente La dirreccion del cliente
	 * @throws Exception 
	 */
	public void iniciarPedido(String pNombreCliente, String pDireccionCliente) throws Exception
	{
		nombreCliente = pNombreCliente;
		direccionCliente = pDireccionCliente;
		File rutaIngredientes = new File("./archivos/data/ingredientes.txt");
		File rutaMenu = new File("./archivos/data/menu.txt");
		File rutaCombos = new File("./archivos/data/combos.txt");
		cargarInformacionRestaurante(rutaIngredientes, rutaMenu, rutaCombos);
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente, numeroPedidos + 1);
	}

	/**
	 * crea y guarda el pedido en la carpeta factura pedidos
	 * @throws IOException
	 */
	public void crearYGuardarPedido() throws IOException
	{
		String ruta = ("./archivos/facturas pedidos/"+ pedidoEnCurso.getIdPedido()+".txt");

		File archivo = new File(ruta);
		pedidoEnCurso.guardarFactura(archivo);

	}

	/**
	 * Retorna el pedido en curso
	 * @return El pedido en curso
	 */
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}

	/**
	 * Retorna un arraylist con los productos del restaurante
	 * @return arraylist con los productos del restaurante
	 */
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
	}

	/**
	 * Retorna un arraylist con los ingredientes del restaurante
	 * @return arraylist con los ingredientes del restaurante
	 */
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}

	/**
	 * Retorna un arraylist con los combos del restaurante
	 * @return arraylist con los combos del restaurante
	 */
	public ArrayList<Combo> getCombos()
	{
		return combos;
	}
	/**
	 * Retorna un arraylist con los productos del menu del restaurante
	 * @return arraylist con los combos del restaurante
	 */
	public ArrayList<ProductoMenu> getProductoMenu()
	{
		return menuBase;
	}

	/**
	 * Carga la información del restaurante.
	 * @param pArchivoIngredientes 
	 * @param pArchivoMenu
	 * @param pArchivoCombos
	 */ 
	public void cargarInformacionRestaurante(File pArchivoIngredientes, File pArchivoMenu, File pArchivoCombos)throws Exception
	{
		cargarIngredientes(pArchivoIngredientes);
		cargarMenu(pArchivoMenu);
		cargarCombos(pArchivoCombos);

	}

	/**
	 * Lee el archivo que entra por parametro y agrega los ingredientes
	 * @param pArchivoIngredientes el archivo de donde se cargaroan los ingredientes
	 * @throws IOException
	 */
	private void cargarIngredientes(File pArchivoIngredientes) throws IOException
	{
		FileReader fileReader = new FileReader(pArchivoIngredientes);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String [] datos = line.split(";");
			Ingrediente nuevo = new Ingrediente( datos[0], Integer.parseInt( datos[1]));
			ingredientes.add(nuevo);

		}

		bufferedReader.close();
		fileReader.close();
	}

	/**
	 * Lee el archivo que entra por parametro y agrega los productos menu
	 * @param pArchivoMenu el archivo de donde se cargaroan los ingredientes
	 * @throws IOException
	 */
	private void cargarMenu(File pArchivoMenu) throws IOException
	{
		FileReader fileReader = new FileReader(pArchivoMenu);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String [] datos = line.split(";");
			ProductoMenu nuevo = new ProductoMenu( datos[0], Integer.parseInt( datos[1]));
			menuBase.add(nuevo);
		}


		bufferedReader.close();
		fileReader.close();
	}

	/**
	 * Lee el archivo que entra por parametro y agrega los combos
	 * @param pArchivoCombos el archivo de donde se cargaroan los combos
	 * @throws IOException
	 */
	private void cargarCombos(File pArchivoCombos) throws IOException
	{
		FileReader fileReader = new FileReader(pArchivoCombos);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String [] datos = line.split(";");
			Combo nuevo = new Combo( datos[0], Integer.parseInt( datos[1].replace("%","")));
			combos.add(nuevo);
			nuevo.agregarItemACombo(encontrarIngredientePorNombre(datos[2]));
			nuevo.agregarItemACombo(encontrarIngredientePorNombre(datos[3]));
			nuevo.agregarItemACombo(encontrarIngredientePorNombre(datos[4]));
		}

		bufferedReader.close();
		fileReader.close();
	}

	/**
	 * Recive un nombre por parametro y retorna el ingrediente con ese nombre
	 * @param pNombreIngrediente el nmbre del ingrediente
	 * @return El productoMenu cuyo nombre es el mismo que el ingresado por parametro 
	 */
	public ProductoMenu encontrarIngredientePorNombre(String pNombreIngrediente)
	{
		for (ProductoMenu producto : menuBase) {
			if (producto.getNombre().equals(pNombreIngrediente)) {
				return producto;
			}
		}
		return null;
	}

	/**
	 * Carga los datos inportantes del menu
	 * @param pArchivoRestaurante el Archivo del cual se leeran los datos 
	 * @throws IOException
	 */
	public void cargarArchivoRestaurante(File pArchivoRestaurante) throws IOException
	{
		FileReader fileReader = new FileReader(pArchivoRestaurante);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		line = bufferedReader.readLine();
		String [] datos = line.split(":");
		setNumeroPedidos(Integer.parseInt( datos[1]));
		bufferedReader.close();
		fileReader.close();
	}

	/**
	 * retonra el numero de pedidos
	 * @return el numero de pedidos
	 */
	public int getNumeroPedidos() {
		return numeroPedidos;
	}

	/**
	 * asigna un numero de pedidos
	 * @param numeroPedidos la cantidad de pedidos
	 */
	public void setNumeroPedidos(int numeroPedidos) {
		this.numeroPedidos = numeroPedidos;
	}

	/**
	 * Agrega un combo al pedido
	 * @param pComboAAgregar el combo que se desea agregar
	 */
	public void agregarComboAPedido(int pComboAAgregar)
	{
		Combo deseado= combos.get(pComboAAgregar );
		pedidoEnCurso.agregarProducto(deseado);
	}

	/**
	 * Agrega un producto al pedido
	 * @param pProductoAAgregar el producto que se desea agregar
	 */
	public void agregarProductoMenuAPedido(int pProductoAAgregar)
	{
		ProductoMenu deseado= menuBase.get(pProductoAAgregar );
		pedidoEnCurso.agregarProducto(deseado);		
	}
	/**
	 * Agrega un producto al pedido
	 * @param ProductoAjustado el producto que se desea agregar
	 */
	public void agregarProductoAjustado(ProductoAjustado pProductoAAgregar)
	{
		pedidoEnCurso.agregarProducto(pProductoAAgregar);		
	}

	/**
	 * Suma 1 al contador de pedidos y lo escribe en el archivo informacion restaurante
	 */
	public void agregarPedidoAContador()
	{
		String ruta = ("./archivos/data/informacion Restaurante.txt");

		String nuevoContenido = "Numero Historico de pedidos:" + (getNumeroPedidos()+1);

		try {
			File archivo = new File(ruta);
			FileWriter escritorArchivo = new FileWriter(archivo);
			BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

			bufferEscritura.write(nuevoContenido);

			bufferEscritura.close();
		} catch (IOException e) {
			System.err.println("Error al actualizar el contenido del archivo: " + e.getMessage());
		}
	}

	/**
	 * Lee el archivo que se desea consultar
	 * @param pNumero int con el numero de pedido que se quiere consultar
	 * @return String con la factura que se desea consultar
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public String cargarFacturaPedido(int pNumero) throws NumberFormatException, IOException
	{

		String aRetornar = "";
		String ruta = "./archivos/facturas pedidos/"+ pNumero +".txt";
		FileReader fileReader = new FileReader(ruta);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) 
		{
			aRetornar = aRetornar + "\n"+line;
		}
		bufferedReader.close();
		fileReader.close();
		return aRetornar;
	}
}
