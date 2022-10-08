import java.util.ArrayList;
import java.util.Hashtable;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Hashtable<String, ArrayList<Double>> listaProductos = crearListaDeProductos();
		
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
