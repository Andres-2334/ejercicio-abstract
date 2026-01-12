package es.fplumara.dam1.restaurante;

public class Hamburguesa extends ProductoMenu implements Personalizable{
	private String tipoCarne;
public Hamburguesa(String id, String nombre, double precioBase, String tipocarne) {
	super (id, nombre, precioBase);
	this.tipoCarne = tipoCarne;
	
	if (tipoCarne == null || tipoCarne.isBlank()) {
		throw new IllegalArgumentException("no puede estar vacío");
	}
}	

@Override
public void anadirExtra(String nombreExtra, double coste) {
	if (nombreExtra == null || nombreExtra.isBlank()) {
		throw new IllegalArgumentException("no puede estar vacío");
	}
	else if (coste < 0) {
			throw new IllegalArgumentException("el coste no puede ser menor que 0");
		}
	
	}
}



