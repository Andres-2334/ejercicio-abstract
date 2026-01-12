
package es.fplumara.dam1.restaurante;

public class Hamburguesa extends ProductoMenu implements Personalizable{
	private String tipoCarne;
public Hamburguesa(String id, String nombre, double precioBase, String tipocarne) {
	super (id, nombre, precioBase);
	this.tipoCarne = tipoCarne;
}	


}
