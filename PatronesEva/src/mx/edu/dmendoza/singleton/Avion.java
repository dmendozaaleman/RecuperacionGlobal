package mx.edu.dmendoza.singleton;

/**
 *  
 * @author Daniel Mendoza Arredondo GITI7083-s
 * @version 1.0
 * @Date 
 */
public class Avion implements Cloneable{
	
	private static Avion av;
	private String nombre;
	private String serial;
	private String piloto;
	
	
	
	public Avion(){
		this.nombre = "Concord";
		this.serial = "4555-sds44";
		this.piloto = "Juan Perez";
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public static Avion getBd() {
		//Nos aseguramos que se crea un solo objeto de tipo BaseDatos 
		if(av == null){
			av = new Avion();
		}
		return av;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

}		