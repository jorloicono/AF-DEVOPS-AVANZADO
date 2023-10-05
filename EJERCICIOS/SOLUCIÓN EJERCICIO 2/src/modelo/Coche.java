package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Coche {

	private String marca;
	private String modelo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSalida;
	private final static float PRECIO_MINUTO = 0.15f;

	public Coche(final String marca, final String modelo, final LocalDateTime horaEntrada,
			final LocalDateTime horaSalida) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}

	/**
	 * Metodo que calcula la cantidad a pagar, obteniendo los minutos que hay entre la fecha de entrada y la de salida.
	 * 
	 * @return
	 */
	public float cantidadAPagar() {
		long minutos = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);

		return minutos * PRECIO_MINUTO;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca( String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida( LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coche [marca=");
		builder.append(marca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", horaEntrada=");
		builder.append(horaEntrada);
		builder.append(", horaSalida=");
		builder.append(horaSalida);
		builder.append("]");
		return builder.toString();
	}

}
