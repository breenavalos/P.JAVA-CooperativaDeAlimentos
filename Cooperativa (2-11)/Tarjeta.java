import utilidades.Fecha;
import java.util.Scanner;

public class Tarjeta extends Compra{
	private String tipo;
	private double num;
	private static float puntAdic;
	
	public Tarjeta(Fecha fec, float imp, Socio soc, String tip, double nu) {
		super(fec, imp, soc);
		tipo=tip;
		num=nu;
	}
	
	public float asignarPuntaje(){
		float tot=0;
		float adi=0;
		tot = /*(float)*/super.asignarPuntaje();
		adi = tot + (tot * /*(float)*/ (Tarjeta.puntAdicional() / 100));
		super.asignarPuntaje(adi);
		return adi;
	}

	
	public static float puntAdicional(){
		if(puntAdic==0){
			Scanner in = new Scanner(System.in);			
			System.out.print("Ingrese Porcentaje a Adicionar por Compra con Tarjeta: ");
			puntAdic = in.nextFloat(); 
		}
		return puntAdic;
	}

}
