import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Hashtable<String, Double> productos = crearListaDeProductos();
		boolean esNumero = false;
		int cantidad = 0;
		double totalBruto = 0;

		System.out.println("--- Bienvenido al gestor de ventas 1.0 ---");
		// Mientras el usuario no ingrese un número voy a volver a pedirle que ingrese
		// la cantidad de productos
		do {
			System.out.print("Ingrese la cantidad de productos: ");
			if (sc.hasNextInt()) {
				cantidad = Integer.parseInt(sc.nextLine());
				esNumero = true;
			} else {
				System.out.println("Por favor, ingrese la cantidad en números");
				sc.nextLine();
			}

		} while (!esNumero);

		for (int i = 1; i <= cantidad; i++) {
			boolean esProducto = false;
			String nombreProducto = "";
			// Mientras no ingrese un nombre de producto correcto volveré a pedirle que lo
			// ingrese
			do {
				System.out.print("Por favor, ingrese el nombre del producto: ");
				nombreProducto = sc.nextLine();
				esProducto = productos.containsKey(nombreProducto);

				if (!esProducto)
					System.out.println("Lo lamento, ese producto no existe, vuelve a ingresar un nombre");

			} while (!esProducto);

			totalBruto += productos.get(nombreProducto);

		}

		
		
		ArrayList<Double> factura = getResults(totalBruto);

		System.out.println("El total a pagar es " + factura.get(3));
		System.out.println("Ingrese el monto con el cual paga el cliente: ");
		double pago = Double.parseDouble(sc.nextLine());
		double vuelto = Math.round((pago - factura.get(3))*100.0)/100.0;
		factura.add(pago);
		factura.add(vuelto);

		imprimirFactura(factura);
		sc.close();

	}

	public static void imprimirFactura(ArrayList<Double> factura) {
		System.out.println("Factura: ");
		System.out.println("IVA: " + factura.get(0) * 100 + "%");
		System.out.println("Total a pagar bruto: " + factura.get(1) + "€");
		System.out.println("IVA total: " + factura.get(2) + "€");
		System.out.println("Total a pagar: " + factura.get(3) + "€");
		System.out.println("\nMonto recibido: " + factura.get(4) + "€");
		System.out.println("Vuelto del cliente: " + factura.get(5) + "€");
	}

	public static ArrayList<Double> getResults(double totalBruto) {
		ArrayList<Double> resultados = new ArrayList<>();
		
		totalBruto = Math.round(totalBruto*100.0)/100.0;
		final double IVA = 0.21;
		resultados.add(IVA);
		
		resultados.add(totalBruto);

		double totalIVA = Math.round((totalBruto * IVA)*100.0)/100.0;
				
		resultados.add(totalIVA);

		double totalMasIVA = totalBruto;
		totalMasIVA += totalBruto * IVA;
		totalMasIVA = Math.round(totalMasIVA*100.0)/100.0;
		resultados.add(totalMasIVA);

		return resultados;
	}

	public static Hashtable<String, Double> crearListaDeProductos() {
		Hashtable<String, Double> productos = new Hashtable<String, Double>();
		productos.put("camiseta", 15.0);
		productos.put("jean", 25.0);
		productos.put("gorra", 5.49);
		productos.put("camisa", 19.99);
		productos.put("calcetines", 2.99);
		productos.put("pantalón", 19.99);
		productos.put("pantalón corto", 15.99);
		productos.put("guantes", 10.0);
		productos.put("bufanda", 5.99);
		productos.put("cinturón", 15.0);

		return productos;
	};

}
