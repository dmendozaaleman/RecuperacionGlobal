package mx.edu.dmendoza.adapter;

public class BoletoAutobus extends Boleto{

	public void venderBoleto() {
		System.out.println("Boleto vendido");
	} 
	
	public void cobrarBoleto() {	
		System.out.println("Boleto pagado");
	} 
}
