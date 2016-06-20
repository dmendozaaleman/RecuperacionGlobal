package com.example.patroneseva;
import mx.edu.dmendoza.adapter.Boleto;
import mx.edu.dmendoza.adapter.BoletoAdaptador;
import mx.edu.dmendoza.adapter.BoletoAvion;
import mx.edu.dmendoza.estrategy.AvionComercial;
import mx.edu.dmendoza.estrategy.AvionRapido;
import mx.edu.dmendoza.estrategy.EnAire;
import mx.edu.dmendoza.estrategy.EnAireVeloz;
import mx.edu.dmendoza.estrategy.EnTierra;
import mx.edu.dmendoza.estrategy.PruebaEstrategy;
import mx.edu.dmendoza.prototype.PrototipoAvion;
import mx.edu.dmendoza.singleton.Avion;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{

	private EditText edtNombre;
	private EditText edtSerial;
	private EditText edtPiloto;
	private Button crearEstrategy;
	private Button btnCrear;
	private Button btnPrototipo;
	private Button btnVender;
	private Avion av = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iniciarComponentes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	private void iniciarComponentes()
	{
		edtNombre = (EditText)findViewById(R.id.edt_name);
		edtSerial = (EditText)findViewById(R.id.edt_Serial);
		edtPiloto = (EditText)findViewById(R.id.edt_Piloto);
		crearEstrategy = (Button)findViewById(R.id.btn_botonEstra);
		btnCrear = (Button)findViewById(R.id.btn_botonCrear);
		btnPrototipo = (Button)findViewById(R.id.btn_prototipo);
		btnVender = (Button)findViewById(R.id.btn_venderBoleto);
		
		crearEstrategy.setOnClickListener(new OnClickListener() {
			//Ejecución del patron estrategy
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "dsdsd", Toast.LENGTH_SHORT).show();
				AvionComercial avionComercial = new AvionComercial();
				AvionRapido avionRapido = new AvionRapido();
				Toast.makeText(MainActivity.this, "Primero el avión comercial...", Toast.LENGTH_SHORT).show();
				avionComercial.setAlgoritmo(new EnTierra());
				avionComercial.mover();
				avionComercial.setAlgoritmo(new EnAire());
				avionComercial.mover();
				
				Toast.makeText(MainActivity.this, "Ahora el avión rápido...", Toast.LENGTH_SHORT).show();
				avionRapido.setAlgoritmo(new EnTierra());
				avionRapido.mover();
				avionRapido.setAlgoritmo(new EnAireVeloz());
				avionRapido.mover();
				
				Toast.makeText(MainActivity.this, "Avión Comerial es veloz...", Toast.LENGTH_SHORT).show();
				avionRapido.setAlgoritmo(new EnAireVeloz());
				avionRapido.mover();
			}
		});
		
		
		btnCrear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(av == null){
					av = Avion.getBd();
					av.setNombre(edtNombre.getText().toString());
					av.setSerial(edtSerial.getText().toString());
					av.setPiloto(edtPiloto.getText().toString());
					
					
				}else{
					Toast.makeText(MainActivity.this, "Avión ya se ha creado" +
							", no puedes crearlo nuevamente ", Toast.LENGTH_SHORT).show();
				}
				
				
				Toast.makeText(MainActivity.this, "Avión: " +av.getNombre()+"\n"+
						"Host: " +av.getSerial()+"\n"+
						"Puerto: " + av.getPiloto(), Toast.LENGTH_SHORT).show();
				
				
			}
		});	
		
		btnPrototipo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PrototipoAvion proto = new PrototipoAvion();
				
				proto.setNombre("Clonado");
				proto.setPiloto("Piloto clonado");
				proto.setSerial("Serial Clonado");
				proto.clonar();
				Toast.makeText(MainActivity.this, "Se ha clonado un Avion Nombre="+proto.getNombre()+"," +
						" Piloto= "+proto.getPiloto()+", Serial= "+proto.getSerial()+"", Toast.LENGTH_SHORT).show();
			}
		});
		
		
		btnVender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Boleto boletoAvion = new BoletoAvion();
				boletoAvion.venderBoleto();
				boletoAvion.cobrarBoleto();
				
				Boleto boletoAdaptado = new BoletoAdaptador();
				boletoAdaptado.venderBoleto();
				boletoAdaptado.cobrarBoleto();
				Toast.makeText(MainActivity.this, "Se ha vendido un boleto de avión y uno adaptado.", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}
