package mx.edu.dmendoza.estrategy;
import com.example.patroneseva.MainActivity;

public class PruebaEstrategy {
	MainActivity actividadPrincipal = new MainActivity();
	
	public void main(String[] args)
	{	
		AvionComercial avionComercial = new AvionComercial();
		AvionRapido avionRapido = new AvionRapido();
		
		avionComercial.setAlgoritmo(new EnTierra());
		avionComercial.mover();
		avionComercial.setAlgoritmo(new EnAire());
		avionComercial.mover();
		
		
		avionRapido.setAlgoritmo(new EnTierra());
		avionRapido.mover();
		avionRapido.setAlgoritmo(new EnAireVeloz());
		avionRapido.mover();
		
		
		avionRapido.setAlgoritmo(new EnAireVeloz());
		avionRapido.mover();
	}
}
