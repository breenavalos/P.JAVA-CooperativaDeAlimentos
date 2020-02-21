import java.util.Scanner;
import utilidades.Fecha;

public abstract class Compra {
	
	private Fecha fecha;
	private float importe;
	private float puntaje;
	private Socio socio;
	private static float Coeficiente ;
	
	public Compra(Fecha fec, float imp, Socio soc){
		fecha = fec;
		importe = imp;
		puntaje = 0;
		socio = soc;
	}
	
	public Fecha darFecha() {
		return fecha;
	}
	
	public float darImporte() {
		return importe;
	}
	
	public String darSocio() {
		return (socio.darDatos());
	}
	
	public float asignarPuntaje(){
		puntaje = /*(float)*/importe/Compra.darCoeficiente();
		return puntaje;
	}
	
	public void asignarPuntaje(float adi){
		puntaje = adi;
	}
	
	public float mostrarPuntaje(){
		return puntaje;
	}
	
	public static float darCoeficiente(){
		if(Coeficiente==0){
			Scanner in = new Scanner(System.in);			
			System.out.print("Ingrese Importe para Otorgamiento de Puntaje Compra: ");
			Coeficiente = in.nextFloat(); 
		}
		return Coeficiente;
	}
	
}
