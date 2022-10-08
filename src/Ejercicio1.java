import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Guardo en notasAlumnos el nombre de cada alumno con sus correspondientes
		// notas para luego calcular el promedio
		Hashtable<String, ArrayList<Double>> notasAlumnos = new Hashtable<String, ArrayList<Double>>();

		System.out.println("Bienvenido a la calculadora de notas promedio");
		System.out.print("Ingrese la cantidad de alumnos de los que quiere ingresar notas: ");
		int cantidadAlumnos = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= cantidadAlumnos; i++) {
			ArrayList<Double> notas = new ArrayList<>();

			System.out.print("Ingrese el nombre del " + i + "° alumno: ");
			String nombre = sc.nextLine();

			System.out.print("Ingrese la nota en desarrollo frontend: ");
			double notaFrontend = Double.parseDouble(sc.nextLine());
			notas.add(notaFrontend);
			System.out.print("Ingrese la nota en desarrollo backend: ");
			double notaBackend = Double.parseDouble(sc.nextLine());
			notas.add(notaBackend);
			System.out.print("Ingrese la nota en manejo de bases de datos: ");
			double notaBasesDeDatos = Double.parseDouble(sc.nextLine());
			notas.add(notaBasesDeDatos);

			notasAlumnos.put(nombre, notas);
		}

		sc.close();

		imprimirNotasMedias(notasAlumnos);

	}

	public static void imprimirNotasMedias(Hashtable<String, ArrayList<Double>> notasAlumnos) {
		notasAlumnos.forEach((alumno, notas) -> {

			double total = 0;
			for (Double nota : notas) {
				total += nota;
			}
			// Aquí etoy limitando la cantidad de decimales a 2 (equivalente a la cantidad
			// de 00 por los que multiplico y divido luego el promedio
			double notaPromedio = Math.round((total / notas.size()) * 100.0) / 100.0;
			System.out.println("La nota promedio de " + alumno + " es " + notaPromedio);
		});
	}

}
