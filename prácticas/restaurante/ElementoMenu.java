package restaurante;
public class ElementoMenu{
	private String nombre;
	private double costo;
	//Relaci�n agregaci�n 2
	private Menu[] menu;

	public ElementoMenu(String nombre, double costo){
		this.nombre = nombre;
		this.costo = costo;
	}
}