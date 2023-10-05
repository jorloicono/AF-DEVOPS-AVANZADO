package modelo;

import java.util.HashMap;
import java.util.Map;

public class Parking {

	final Map<String, Coche> parking;

	public Parking() {
		parking = new HashMap<>();
	}

	/**
	 * Metodo que comprueba si existe un coche en el sistema
	 * 
	 * @param matricula
	 * @return
	 */
	public  boolean existeCoche( String matricula) {
		return parking.containsKey(matricula);
	}

	/**
	 * Metodo que obtiene un coche del sistema
	 * 
	 * @param matricula
	 * @return
	 */
	public Coche getCoche( String matricula) {
		return parking.get(matricula);
	}

	/**
	 * Metodo que añade un coche al sistema
	 * 
	 * @param matricula
	 * @param coche
	 */
	public void putCoche( String matricula, Coche coche) {
		parking.put(matricula, coche);
	}

	/**
	 * Metodo que imprime todos los coches del sistema, tanto los que estan dentro del parking como los que no.
	 * @return 
	 */
	public void imprimirCochesSistema() {
		try {
			parking.forEach((k, v) -> {
				System.out.println("Matricula: " + k + " Datos del " + v);
			});
		} catch (Exception ex) {
			System.out.println("Error al imprimir coches en el sistema");
		}
	}

	/**
	 * Metodo que imprime los coches que estan dentro del parking (horaSalida = null)
	 */
	public void imprimirCochesParking() {
		try {
			parking.forEach((k, v) -> {
				if (v.getHoraSalida() == null) {
					System.out.println("Matricula: " + k + " Datos del " + v);
				}
			});
		} catch (Exception ex) {
			System.out.println("Error al imprimir coches en el parking");
		}
	}

	/**
	 * Método que calcula la cantidad a pagar por un coche según el tiempo que ha estado dentro del parking
	 * @param matricula
	 */
	public void cantidadAPagar( String matricula) {
		if (matricula != null) {
			System.out.println("Cantidad a pagar " + parking.get(matricula).cantidadAPagar());
		}
	}


}
