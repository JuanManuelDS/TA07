import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio4 {

	public static void main(String[] args) {

		Hashtable<String, ArrayList<Double>> listaProductos = crearListaDeProductos();
		boolean terminarPrograma = false;
		do {
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"Bienvenido al gestor de ventas y stock. Por favor, ingrese la opción que desee realizar"
							+ "\n1. Ver lista de productos \n2. Ingresar venta \n3. Buscar un artículo \n4. Agregar un artículo \n9. Salir del programa"));
			switch (opcion) {
			case 1:
				imprimirLista(listaProductos);
				break;
			case 2:
				listaProductos = ingresarVenta(listaProductos);
				break;
			case 3:
				imprimirArticulo(listaProductos);
				break;
			case 4:
				listaProductos = agregarArticulo(listaProductos);
				break;
			case 9:
				terminarPrograma = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "La opción ingresada no es válida, por favor vuelva a intentarlo");
				break;
			}
		} while (!terminarPrograma);

	}
	
	public static Hashtable<String, ArrayList<Double>> agregarArticulo(Hashtable<String, ArrayList<Double>> listaProductos){
		ArrayList<Double> precioCantidad = new ArrayList<>();
		String nombreArticulo = JOptionPane.showInputDialog("Ingrese el nombre del artículo por favor");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio"));
		precioCantidad.add(precio);
		double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad unidades disponibles"));
		precioCantidad.add(cantidad);
		listaProductos.put(nombreArticulo, precioCantidad);
		return listaProductos;
	}
	
	public static void imprimirArticulo (Hashtable<String, ArrayList<Double>> listaProductos) {
		String nombreArticulo = JOptionPane.showInputDialog("Por favor, ingrese el nombre del artículo");
		if(listaProductos.containsKey(nombreArticulo)) {
			ArrayList<Double> precioCantidad = listaProductos.get(nombreArticulo);
			JOptionPane.showMessageDialog(null, "Artículo: " + nombreArticulo + "\nPrecio: " + precioCantidad.get(0) + "€\nStock: " + precioCantidad.get(1).intValue() );
		} else {
			JOptionPane.showMessageDialog(null, "No existe un artículo con ese nombre en nuestra base de datos");
		}
	}

	public static Hashtable<String, ArrayList<Double>> ingresarVenta(Hashtable<String, ArrayList<Double>> listaProductos) {

		int cantidad;
		double totalBruto = 0;

		String inputCantidad = JOptionPane.showInputDialog("Por favor, ingrese la cantidad de productos vendidos");

		if (esEntero(inputCantidad)) {
			cantidad = Integer.parseInt(inputCantidad);
		} else {
			JOptionPane.showMessageDialog(null, "Vuelva a intentarlo ingresando un número la próxima");
			return listaProductos;
		}

		for (int i = 1; i <= cantidad; i++) {
			boolean esProducto = false;
			String nombreProducto = "";
			// Mientras no ingrese un nombre de producto correcto volveré a pedirle que lo
			// ingrese
			do {
				nombreProducto = JOptionPane.showInputDialog("Por favor, ingrese el nombre del producto");
				esProducto = listaProductos.containsKey(nombreProducto);

				if (!esProducto)
					JOptionPane.showMessageDialog(null,
							"Lo lamento, ese producto no existe, vuelve a ingresar un nombre");
			} while (!esProducto);

			ArrayList<Double> precioCantidad = listaProductos.get(nombreProducto);
			//Verifico el stock del producto
			if(precioCantidad.get(1)>0) {
				double stock = precioCantidad.get(1);
				stock -= 1;
				precioCantidad.set(1, stock);
				listaProductos.put(nombreProducto, precioCantidad);
				
				totalBruto += precioCantidad.get(0);
			} else {
				JOptionPane.showMessageDialog(null, "No queda más stock del producto, lo siento.");
				return listaProductos;
			}
			

		}

		ArrayList<Double> factura = getResults(totalBruto);

		JOptionPane.showMessageDialog(null, "El total a pagar es " + factura.get(3));
		double pagoCliente = Double
				.parseDouble(JOptionPane.showInputDialog("Ingrese el monto con el cual paga el cliente"));
		double vuelto = Math.round((pagoCliente - factura.get(3)) * 100.0) / 100.0;
		factura.add(pagoCliente);
		factura.add(vuelto);

		imprimirFactura(factura);
		
		return listaProductos;
	}

	public static void imprimirFactura(ArrayList<Double> factura) {
		JOptionPane.showMessageDialog(null,
				"IVA: " + factura.get(0) * 100 + "%" + "\nTotal a pagar bruto: " + factura.get(1) + "€"
						+ "\nIVA total: " + factura.get(2) + "€" + "\nTotal a pagar: " + factura.get(3) + "€"
						+ "\nMonto recibido: " + factura.get(4) + "€" + "\nVuelto del cliente: " + factura.get(5) + "€");
	}

	public static ArrayList<Double> getResults(double totalBruto) {
		ArrayList<Double> resultados = new ArrayList<>();

		totalBruto = Math.round(totalBruto * 100.0) / 100.0;
		final double IVA = 0.21;
		resultados.add(IVA);

		resultados.add(totalBruto);

		double totalIVA = Math.round((totalBruto * IVA) * 100.0) / 100.0;

		resultados.add(totalIVA);

		double totalMasIVA = totalBruto;
		totalMasIVA += totalBruto * IVA;
		totalMasIVA = Math.round(totalMasIVA * 100.0) / 100.0;
		resultados.add(totalMasIVA);

		return resultados;
	}

	public static void imprimirLista(Hashtable<String, ArrayList<Double>> listaProductos) {
		String lista = listaProductos.toString();
		lista = lista.replace("],", "]\n");
		lista = lista.replace("{", " ");
		lista = lista.replace("}", " ");
		lista = lista.replace("=[", "\n");
		lista = lista.replace(",", "€");
		lista = lista.replace("€ ", "€ ==>");
		lista = lista.replace("]", "uds");
		JOptionPane.showMessageDialog(null, lista);
	}

	public static boolean esEntero(String cadena) {

		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isDigit(cadena.charAt(i)))
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static Hashtable<String, ArrayList<Double>> crearListaDeProductos() {

		Hashtable<String, ArrayList<Double>> productos = new Hashtable<String, ArrayList<Double>>();
		ArrayList<Double> precioCantidad = new ArrayList<>();

		// Sí, un dolor de ojos ver este intento de base de datos hardcodeado...

		precioCantidad.add(15.0);
		precioCantidad.add(3.0);
		productos.put("camiseta", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(25.0);
		precioCantidad.add(6.0);
		productos.put("jean", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(5.49);
		precioCantidad.add(7.0);
		productos.put("gorra", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(25.0);
		precioCantidad.add(6.0);
		productos.put("camisa", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(3.99);
		precioCantidad.add(50.0);
		productos.put("calcetines", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(35.0);
		precioCantidad.add(10.0);
		productos.put("pantalón", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(19.99);
		precioCantidad.add(5.0);
		productos.put("pantalón corto", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(3.99);
		precioCantidad.add(15.0);
		productos.put("guantes", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(5.0);
		precioCantidad.add(16.0);
		productos.put("bufanda", (ArrayList<Double>) precioCantidad.clone());

		precioCantidad.clear();
		precioCantidad.add(5.0);
		precioCantidad.add(10.0);
		productos.put("cinturón", (ArrayList<Double>) precioCantidad.clone());

		return productos;
	};

}
