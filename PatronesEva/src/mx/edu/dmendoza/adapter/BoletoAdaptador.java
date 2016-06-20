package mx.edu.dmendoza.adapter;

public class BoletoAdaptador extends Boleto{
	
	BoletoAvion bole = new BoletoAvion();
	
	public void venderBoleto()
	{
		bole.venderBoleto();
	}
	
	public void cobrarBoleto() {
		bole.cobrarBoleto();
	}
}



