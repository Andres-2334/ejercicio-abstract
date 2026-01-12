package es.fplumara.dam1.restaurante;

public abstract class ProductoMenu {
	private String id;
	private String nombre;
	private double precioBase;
	protected ProductoMenu(String id, String nombre, double preciobase) {
	
		if (id == null || id.isBlank()) {
			throw new IllegalArgumentException("El id no puede ser nulo ni vacio");
		}
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
		}
		if (precioBase < 0) {
			throw new IllegalArgumentException("el precio no puede ser menor que 0");
		}
		
	}
	public double precioFinal() {
		return precioBase;
	}
	
	public String ticketLine() {
		return id;
		
	}
	
	
}
