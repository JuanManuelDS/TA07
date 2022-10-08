import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio3 {

	public static void main(String[] args) {

		Hashtable<String, ArrayList<Double>> listaProductos = crearListaDeProductos();
		boolean esOpcion = false;

		do {
			int opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"Ingrese la opción que desea realizar: \n1 - Agregar producto\n2 - Buscar un artículo\n3 - Listar todos los artículos"));

			switch (opcion) {
			case 1:
				listaProductos = agregarArticulo(listaProductos);
				esOpcion = true;
				break;
			case 2:
				imprimirArticulo(listaProductos);
				esOpcion = true;
				break;
			case 3:
				imprimirLista(listaProductos);
				esOpcion = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "La opción ingresada no es correcta. Vuelva a intentarlo");
			}
		} while (!esOpcion);

	}
	
	public static void imprimirLista(Hashtable<String, ArrayList<Double>> listaProductos) {
		String lista = listaProductos.toString();
		lista = lista.replace("],", "]\n");
		lista = lista.replace("{", " ");
		lista = lista.replace("}", " ");
		lista = lista.replace("=[","\n");
		lista = lista.replace(",", "€");
		lista = lista.replace("€ ", "€ ==>");
		lista = lista.replace("]", "uds");
		JOptionPane.showMessageDialog(null,lista);
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
		productos.put("bufanda",  (ArrayList<Double>) precioCantidad.clone());
		
		precioCantidad.clear();
		precioCantidad.add(5.0);
		precioCantidad.add(10.0);
		productos.put("cinturón", (ArrayList<Double>) precioCantidad.clone());
		
		
		return productos;
	};

}
