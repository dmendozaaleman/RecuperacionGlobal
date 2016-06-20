package mx.edu.dmendoza.prototype;
import mx.edu.dmendoza.singleton.Avion;


public class PrototipoAvion extends Avion implements Clon{
	
	@Override
	public Object clonar()
	{
		Avion avi = new Avion();
		
		avi.setNombre(this.getNombre());
		avi.setPiloto(this.getPiloto());
		avi.setSerial(this.getSerial());
		return avi;	
	}
}
