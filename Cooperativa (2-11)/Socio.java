

import java.util.ArrayList;
import java.util.Scanner;

public class Socio {
	
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	private ArrayList<Compra>compras;
	
	public Socio(int doc, String nom, String dir, int tel){
		dni = doc;
		nombre = nom;
		direccion = dir;
		telefono = tel;
		compras = new ArrayList<Compra>(); 
	}
	
	public void agregarCompra(Compra com){
		compras.add(com);
	}
	
	public boolean sosDni(int doc){
		return dni==doc;
	}
	
	public String darDatos(){
		return (" Socio: "+nombre+" Dni: "+dni);
	}
	
	public String darNombre(){
		return nombre;
		}
	
	public float darPuntaje(){
		float total=0;
		
		for(Compra com : compras)
			{
				total= total + com.mostrarPuntaje();
			}
		return total;
	}
	
}
