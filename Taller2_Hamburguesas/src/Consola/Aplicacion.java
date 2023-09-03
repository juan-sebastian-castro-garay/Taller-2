
package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Taller2_Hamburguesas.Combo;
import Taller2_Hamburguesas.Ingrediente;
import Taller2_Hamburguesas.Producto;
import Taller2_Hamburguesas.ProductoAjustado;
import Taller2_Hamburguesas.ProductoMenu;
import Taller2_Hamburguesas.Restaurante;

public class Aplicacion {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * El restaurante
	 */
	private Restaurante restaurante;

	/**
	 * Atributo que indica si la aplicacion debe seguir corriendo
	 */
	private boolean salir;

	/*
	 * Metodo constructor de la aplicacion
	 */
	public Aplicacion() throws IOException
	{
		restaurante = new Restaurante();
		salir = false;
	}

	/**
	 * Meodo main, inicia la aplicacion
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Aplicacion app = new Aplicacion();
		app.iniciarAplicacion();
	}

	/**
	 * Le muestra el menú al usuario y la pide que ingrese
	 * una opción, y ejecuta la opción seleccionada por el usuario. Este proceso se
	 * repite hasta que el usuario seleccione la opción de abandonar la aplicación.
	 * @throws Exception 
	 */
	public void mostrarMenu() throws Exception 
	{
		System.out.println("                                                                                                  \r\n"
				+ "MMMMMMMM               MMMMMMMMEEEEEEEEEEEEEEEEEEEEEENNNNNNNN        NNNNNNNNUUUUUUUU     UUUUUUUU\r\n"
				+ "M:::::::M             M:::::::ME::::::::::::::::::::EN:::::::N       N::::::NU::::::U     U::::::U\r\n"
				+ "M::::::::M           M::::::::ME::::::::::::::::::::EN::::::::N      N::::::NU::::::U     U::::::U\r\n"
				+ "M:::::::::M         M:::::::::MEE::::::EEEEEEEEE::::EN:::::::::N     N::::::NUU:::::U     U:::::UU\r\n"
				+ "M::::::::::M       M::::::::::M  E:::::E       EEEEEEN::::::::::N    N::::::N U:::::U     U:::::U \r\n"
				+ "M:::::::::::M     M:::::::::::M  E:::::E             N:::::::::::N   N::::::N U:::::U     U:::::U \r\n"
				+ "M:::::::M::::M   M::::M:::::::M  E::::::EEEEEEEEEE   N:::::::N::::N  N::::::N U:::::U     U:::::U \r\n"
				+ "M::::::M M::::M M::::M M::::::M  E:::::::::::::::E   N::::::N N::::N N::::::N U:::::U     U:::::U \r\n"
				+ "M::::::M  M::::M::::M  M::::::M  E:::::::::::::::E   N::::::N  N::::N:::::::N U:::::U     U:::::U \r\n"
				+ "M::::::M   M:::::::M   M::::::M  E::::::EEEEEEEEEE   N::::::N   N:::::::::::N U:::::U     U:::::U \r\n"
				+ "M::::::M    M:::::M    M::::::M  E:::::E             N::::::N    N::::::::::N U:::::U     U:::::U \r\n"
				+ "M::::::M     MMMMM     M::::::M  E:::::E       EEEEEEN::::::N     N:::::::::N U::::::U   U::::::U \r\n"
				+ "M::::::M               M::::::MEE::::::EEEEEEEE:::::EN::::::N      N::::::::N U:::::::UUU:::::::U \r\n"
				+ "M::::::M               M::::::ME::::::::::::::::::::EN::::::N       N:::::::N  UU:::::::::::::UU  \r\n"
				+ "M::::::M               M::::::ME::::::::::::::::::::EN::::::N        N::::::N    UU:::::::::UU    \r\n"
				+ "MMMMMMMM               MMMMMMMMEEEEEEEEEEEEEEEEEEEEEENNNNNNNN         NNNNNNN      UUUUUUUUU      \r\n");

		System.out.println("--------------------- Combos ---------------------\n");
		imprimirCombos();
		System.out.println("-------------- Productos Individuales -------------\n");
		imprimirProductos();
		System.out.println("\n\n-------------- Adiciones Disponibles --------------\n");
		imprimirAdicionesConPrecio();
	}

	/**
	 * Metodo que ejecuta la ocion entrada por parametro. crear orden y revisar pedido
	 * @param pOpcionSeleccionada numero =1 || 2 || 3 que determina el camino a ejecutar
	 * @throws Exception 
	 */
	public void ejecutarOpcionInicio(int pOpcionSeleccionada) throws Exception 
	{
		if(pOpcionSeleccionada== 1)
		{
			System.out.println("\nIniciando pedido....");
			String nombreCliente = input("Ingrese su Nombre");
			String direccionCliente = input("Ingrese su Direccion");
			restaurante.iniciarPedido(nombreCliente, direccionCliente);
			mostrarMenu();
			System.out.println("\nSeleccione una opcion:");
			System.out.println("1) Agregar combo a la orden.");
			System.out.println("2) Agregar producto a la orden.");
			System.out.println("3) Salir.\n");
			int opccionSeleccionada2 = -1;
			while (opccionSeleccionada2 != 1 &&opccionSeleccionada2 != 2 &&opccionSeleccionada2 != 3)
			{				
				try {

					opccionSeleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
				} catch (Exception e) 
				{
					System.out.println("Seleccione una opcion valida.");
				}
			}
			ejecutarOpcionMenu(opccionSeleccionada2);
		}
		else if(pOpcionSeleccionada== 2)
		{
			if(restaurante.getNumeroPedidos() == 0)
			{
				System.out.println("No se tienen pedidos para consultar, cree un pedido.");
			}
			else
			{	
				System.out.println("Hay "+restaurante.getNumeroPedidos()+" pedidos qué pueden consultar");
				int numeroArchivoACargar = Integer.parseInt(input("Por favor seleccione una opción"));
				try {
					System.out.println("La factura con id: "+numeroArchivoACargar+"\n");
					System.out.println( restaurante.cargarFacturaPedido(numeroArchivoACargar));
				} catch (Exception e) {
					System.out.println("Ingrese un valor entero entre: 1 y " + restaurante.getNumeroPedidos()+".");
				}
			}

		}
		else if(pOpcionSeleccionada== 3)
		{			
			System.out.println("\n------------------------------------------------------\n");
			System.out.println("Gracias por usar DPO BurgerCraftsmanship: Castro's Edition app");
			System.out.println("\n------------------------------------------------------\n");
			salir = true;
		}
		else
		{
			System.out.println("Opción no válida.2");
		}
	}

	/**
	 * Muestra el mensaje de bienvenida y dirigue al usuario al camino que desee tomar. 
	 * @throws Exception
	 */
	public void iniciarAplicacion() throws Exception
	{
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("Bienvenido a DPO BurgerCraftsmanship: Castro's Edition");
		System.out.println("\n------------------------------------------------------\n");
		while (salir == false)
		{

			int opccionSeleccionada = 0;
			boolean funciono = false;
			while (funciono == false)
			{
				try
				{
					System.out.println("\nSeleccione una opcion para continuar");
					System.out.println("1. Iniciar nuevo pedido");
					System.out.println("2. Consultar pedido");
					System.out.println("3. Salir\n");

					opccionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
				if(opccionSeleccionada ==1 || opccionSeleccionada==2|| opccionSeleccionada==3)
				{				
					funciono = true;
				}
			}
			ejecutarOpcionInicio(opccionSeleccionada);
		}
	}

	/**
	 * Metodo que ejecuta la ocion entrada por parametro. Agregar combo, agregar pedido. o terminar orden.
	 * @param pOpcionSeleccionada int con numero == 1||2||3
	 * @throws IOException
	 */
	public void ejecutarOpcionMenu(int pOpcionSeleccionada) throws IOException
	{
		if(pOpcionSeleccionada== 1)
		{
			imprimirCombos();
			boolean numeroCorrecto = false;
			while (numeroCorrecto == false)
			{
				try {

					int comboAAgregar = (Integer.parseInt(input("Seleccione el combo a agregar.") )-1);
					if ((comboAAgregar < restaurante.getCombos().size()) && (comboAAgregar > -1))
					{			
						numeroCorrecto = true;
						restaurante.agregarComboAPedido(comboAAgregar);
						System.out.println("\nSeleccione una opcion:");
						System.out.println("1) Agregar combo a la orden.");
						System.out.println("2) Agregar producto a la orden.");
						System.out.println("3) Terminar pedido\n");
						int opccionSeleccionada2 = -1;
						while (opccionSeleccionada2 != 1 &&opccionSeleccionada2 != 2 &&opccionSeleccionada2 != 3)
						{	
							try {
								opccionSeleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
								ejecutarOpcionMenu(opccionSeleccionada2);

							} catch (Exception e) {
								System.out.println("Seleccione una opcion valida.");
								opccionSeleccionada2 = 0;
							}
						}
					}
					else
					{
						System.out.println("Opcion incorrecta, porfvor seleccione otra opcion.");
					}
				}

				catch (Exception e) {
					System.out.println("Seleccione una opcion valida.");
				}
			}
		}
		else if(pOpcionSeleccionada== 2)
		{
			imprimirProductos();
			boolean numeroCorrecto = false;
			while (numeroCorrecto == false)
			{
				int nProcudtoAAgregar = (Integer.parseInt(input("Seleccione el producto a agregar.") )-1);
				if ((nProcudtoAAgregar < restaurante.getMenuBase().size()) && (nProcudtoAAgregar > -1))
				{			
					numeroCorrecto = true;
					ProductoMenu deseado= restaurante.getMenuBase().get(nProcudtoAAgregar );
					ProductoAjustado procudtoAAgregarAjustado = new ProductoAjustado(deseado);
					int oAgregarIngredientes = -1;
					while (oAgregarIngredientes != 1 &&oAgregarIngredientes != 2 &&oAgregarIngredientes != 3)
					{
						System.out.println("\n¿Desea modificar el producto?");
						System.out.println("1) Agregar Ingredientes.");
						System.out.println("2) Eliminar ingredientes.");
						System.out.println("3) Agregar producto sin modificaciones.");
						oAgregarIngredientes = (Integer.parseInt(input("Seleccione opcion.") ));
					}

					boolean editando = true;
					if(oAgregarIngredientes == 3)
					{
						restaurante.agregarProductoMenuAPedido(nProcudtoAAgregar);
						editando = false;
						System.out.println("Seleccione una opcion:");
						System.out.println("1) Agregar combo a la orden.");
						System.out.println("2) Agregar producto a la orden.");
						System.out.println("3) Terminar pedido\n");
						int opccionSeleccionada2 = -1;
						while (opccionSeleccionada2 != 1 &&opccionSeleccionada2 != 2 &&opccionSeleccionada2 != 3)
						{	
							try {
								opccionSeleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
								ejecutarOpcionMenu(opccionSeleccionada2);

							} catch (Exception e) {
								System.out.println("Seleccione una opcion valida.");
								opccionSeleccionada2 = 0;
							}
						}

					}
					while (editando == true)
					{
						if(oAgregarIngredientes== 1)
						{
							System.out.println("\nLos ingredientes adiccionados generan un costo extra.");
							System.out.println("0. No deseo agregar mas ingredientes");
							imprimirAdicionesConPrecio();
							int ingredienteAAgregar = (Integer.parseInt(input("Seleccione el ingrediente a agregar.") )-1);
							if(ingredienteAAgregar == -1)
							{
								System.out.println("\n¿Desea eliminar ingredientes?");
								System.out.println("1) Si");
								System.out.println("2) No");
								int deseaEliminar = (Integer.parseInt(input("") ));
								if(deseaEliminar == 1)
								{
									oAgregarIngredientes = 2;
								}
								else if(deseaEliminar == 2)
								{
									editando = false;
									restaurante.agregarProductoAjustado(procudtoAAgregarAjustado);
									System.out.println("Seleccione una opcion:");
									System.out.println("1) Agregar combo a la orden.");
									System.out.println("2) Agregar producto a la orden.");
									System.out.println("3) Terminar pedido\n");
									int opccionSeleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
									ejecutarOpcionMenu(opccionSeleccionada2);
								}

							}
							else if ((ingredienteAAgregar < restaurante.getIngredientes().size()) && (ingredienteAAgregar > -1))
							{
								Ingrediente ingr = restaurante.getIngredientes().get(ingredienteAAgregar);
								procudtoAAgregarAjustado.agregarIngrediente(ingr);
							}
							else
							{
								System.out.println("Opcion incorrecta, porfvor seleccione otra opcion.");
							}

						}
						else if(oAgregarIngredientes== 2)
						{
							System.out.println("\nEliminar ingredientes no genera una reduccion en el costo cotal.");
							System.out.println("\n-------------- sustracciones Disponibles --------------\n");
							System.out.println("0. No deseo eliminar mas ingredientes");
							imprimirAdicionesSinPrecio();
							int ingredienteAEliminar = (Integer.parseInt(input("Seleccione el ingrediente a eliminar.") )-1);
							if(ingredienteAEliminar == -1)
							{
								System.out.println("¿Desea agregar ingredientes?");
								System.out.println("1) Si");
								System.out.println("2) No");
								int deseaEliminar = (Integer.parseInt(input("") ));
								if(deseaEliminar == 1)
								{
									oAgregarIngredientes = 1;
								}
								else if(deseaEliminar == 2)
								{
									editando = false;
									restaurante.agregarProductoAjustado(procudtoAAgregarAjustado);
									System.out.println("Seleccione una opcion:");
									System.out.println("1) Agregar combo a la orden.");
									System.out.println("2) Agregar producto a la orden.");
									System.out.println("3) Terminar pedido\n");
									int opccionSeleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
									ejecutarOpcionMenu(opccionSeleccionada2);
								}

							}
							else if ((ingredienteAEliminar < restaurante.getIngredientes().size()) && (ingredienteAEliminar > -1))
							{
								Ingrediente ingr = restaurante.getIngredientes().get(ingredienteAEliminar);
								procudtoAAgregarAjustado.eliminarIngrediente(ingr);
							}
							else
							{
								System.out.println("Opcion incorrecta, porfvor seleccione otra opcion.");
							}
						}
						else
						{
							throw new IllegalArgumentException("Unexpected value: " + oAgregarIngredientes);
						}
					}

				}
				else
				{
					System.out.println("Opcion incorrecta, porfvor seleccione otra opcion.");
				}
			}
		}
		else if(pOpcionSeleccionada== 3)
		{
			restaurante.crearYGuardarPedido();
			restaurante.agregarPedidoAContador();
			System.out.println("----------------------------------------------\r\n"
					+ "   ¡Pedido Finalizado con Éxito!\r\n"
					+ "\r\n"
					+ "   Puede consultar su pedido con el ID número " + ((int)restaurante.getNumeroPedidos()+ (int)1)+".\r\n"
					+ "\r\n"
					+ "   ¡Gracias por comprar en DPO BurgerCraftsmanship: Castro's Edition!\r\n"
					+ "----------------------------------------------");

			System.out.println(restaurante.getPedidoEnCurso().generarTextoFactura());
			salir = true;

		}
		else
		{
			System.out.println("Opción no válida.1");
		}
	}

	/**;
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public void imprimirCombos()
	{
		int contador = 1;
		for (Combo combos : restaurante.getCombos()) {
			System.out.println(contador+". "+ combos.getNombre());
			String productos = "";
			for (Producto productosCombo : combos.getItemsCombo()) {	
				productos = productos + productosCombo.getNombre() + ",";
			}
			System.out.println("   Productos:"+ productos+". ");
			System.out.println("   Precio: "+ combos.getPrecio());
			System.out.println("   Descuento: "+ combos.getDescuento()+"%\n");

			contador = contador +1;
		}
	}
	
	/**
	 * Imprime en consola los productos del menu base
	 */
	public void imprimirProductos()
	{
		int contador = 1;
		for (ProductoMenu producto : restaurante.getMenuBase()) {

			System.out.println(contador+". "+producto.getNombre()+" $" + producto.getPrecio()+". ");
			contador = contador +1;
		}

	}
	
	/**
	 * Imprime en consola los ingredientes con su precio adicional
	 */
	public void imprimirAdicionesConPrecio()
	{
		int contador = 1;
		for (Ingrediente ingrediente : restaurante.getIngredientes()) {

			System.out.println(contador+". "+ingrediente.getNombre()+" $" + ingrediente.getCostoAdicional());
			contador = contador +1;
		}
	}

	/**
	 * Imprime en consola los ingredientes sin su precio adicional
	 */
	public void imprimirAdicionesSinPrecio()
	{
		int contador = 1;

		for (Ingrediente ingrediente : restaurante.getIngredientes()) {

			System.out.println(contador+". "+ingrediente.getNombre());
			contador = contador +1;
		}
	}

}
