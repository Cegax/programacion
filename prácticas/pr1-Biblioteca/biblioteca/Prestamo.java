public class Prestamo{
	private String fechaSolicitud;
	private String fechaDevolucion;

	//Asociaciones
	private Copia copias[] = new Copia[3];
	private Socio socio;
	private Trabajador trabajador;
	private Amonestacion amonestacion;

	public void setFechaSolicitud(String fechaSolicitud){
		this.fechaSolicitud = fechaSolicitud;
	}


	public String getFechaSolicitud(){
		return fechaSolicitud;
	}

	public void setFechaDevolucion(String fechaDevolucion){
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getFechaDevolucion(){
		return fechaDevolucion;
	}

	public void asociarAmonestacion(Amonestacion amonestacion){
		this.amonestacion = amonestacion;
	}

	public void desasociarAmonestacion(){
		amonestacion = null;
	}


	public void asociarSocio(Socio socio){
		this.socio = socio;
	}

	public void desasociarSocio(){
		this.socio = null;
	}

	public void asociarTrabajador(Trabajador trabajador){
		this.trabajador = trabajador;
	}

	public void desasociarTrabajador(){
		this.trabajador = null;
	}

	public void asociarCopia(Copia copia){
		for (int i = 0; i < copias.length; i++){
			if (copias[i] == null){
				copias[i] = copia;
				break;
			}
		}
	}

	public void desasociarCopia(Copia copia){
		for (int i = 0; i < copias.length; i++){
			if (copias[i] == copia){
				copias[i] = null;
				break;
			}
		}
	}

}
