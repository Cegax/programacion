package diario.dominio;

public class Alimento{
	private String nombre;
	private int calorias;
	private int carbohidratos;
	
	public Alimento(String nombre, int calorias, int carbohidratos){
		this.nombre = nombre;
		this.calorias = calorias;
		this.carbohidratos = carbohidratos;
	}
	

	public String toString(){
		String resultado = "Nombre del alimento: " + nombre + ", Calor�as: " + calorias + ", Carbohidratos: " + carbohidratos;
		return resultado;
	}
}

