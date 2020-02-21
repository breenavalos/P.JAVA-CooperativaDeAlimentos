import java.util.ArrayList;
import java.util.Scanner;
import utilidades.Fecha;


public class Cooperativa {
	
	
	private String nombre;
	private String direccion;
	private ArrayList<Socio>socios;
	private ArrayList<Compra>compras;
	
	public Cooperativa(String nom, String dir){
		nombre=nom;
		direccion=dir;
		compras = new ArrayList<Compra>();
		socios = new ArrayList<Socio>();
	}
	
	public void agregarSocio(){
		Scanner in = new Scanner(System.in);
		in.useDelimiter(System.getProperty("line.separator"));
		
		System.out.print("Ingrese dni del Socio: ");
		int dni = in.nextInt();
		
		Socio s= this.verificarSocio(dni);
		
		if (s != null)
			{
				System.out.println("El socio ya esta registrado");
				System.out.println("");
			}
		else 
			{	System.out.print("Ingrese Nombre del socio: ");
				String nom=in.next();
				System.out.print("Ingrese Direccion del socio: ");
				String dir=in.next();
				System.out.print("Ingrese Telefono del socio: ");
				int tel=in.nextInt();
			
				Socio soc=new Socio(dni,nom,dir,tel);
				socios.add(soc);
			 }
			
	}
	
	public void agregarCompra(){
		Scanner in = new Scanner(System.in);
		in.useDelimiter(System.getProperty("line.separator"));
		
		int op=0;
		int dni=0;
		float imp;
		String tip;
		double num;
		Fecha fCompra;
		
		System.out.print("Ingrese DNI del Socio: ");
		dni=in.nextInt();
		
		Socio s= this.verificarSocio(dni);
		
		if (s != null)
			{
				fCompra = Fecha.hoy();
				System.out.println("Ingrese Importe: ");
				imp=in.nextFloat();
			
				do{
					System.out.println("Ingrese forma de pago: ");
					System.out.print("1-> Tarjeta\t2-> Efectivo");
					op=in.nextInt();
				  }while(op!=1&&op!=2);	
			
					if(op==1)
						{   System.out.println("Ingrese Marca Tarjeta: ");
							tip=in.next();
							System.out.println("Ingrese Numero Tarjeta: ");
							num =in.nextDouble();
							Tarjeta com = new Tarjeta(fCompra,imp, s, tip, num);
							com.asignarPuntaje();
							compras.add(com);
							s.agregarCompra(com);	
							System.out.println("El puntaje de la compra es: ");
							System.out.println(com.mostrarPuntaje());
						}
					else
						{
							Efectivo com = new Efectivo(fCompra,imp, s);
							com.asignarPuntaje();
							compras.add(com);
							s.agregarCompra(com);
							System.out.println("El puntaje de la compra es: ");
							System.out.println(com.mostrarPuntaje());
						}
			} 
		else	{
					System.out.println("No existe el Socio !!!");
				}
	}
	
	public void listarSocios(){
		int i=0;
		while(i<socios.size()){
			System.out.println(socios.get(i).darDatos());
			i++;
		}
	}
	
	public void mostrarPje(){
		Scanner in=new Scanner(System.in);
		in.useDelimiter(System.getProperty("line.separator"));
		
		int dni=0;
		
		System.out.println("Ingrese DNI del Socio: ");
		dni=in.nextInt();
		
		Socio s= this.verificarSocio(dni);
		
		if (s != null)
			{
				System.out.println("El puntaje del"+s.darDatos()+" es: "+s.darPuntaje());
			
			}
		else 
			{	
				System.out.println("No es Socio !!!");
			}
		
	}
	public void mostrarPuntajeCompras(){
		
		Scanner in= new Scanner (System.in);
		
		System.out.println("Ingrese Fecha Desde");
				
		Fecha fechaIni = Fecha.nuevaFecha();
		
		System.out.println("\nIngrese Fecha Hasta");
				
		Fecha fechaFin = Fecha.nuevaFecha();
		
		System.out.println("\nMuestro puntaje Compras -> ");
			for(Compra com : compras)
			{
				if(com.darFecha().compareTo(fechaIni)>0&& com.darFecha().compareTo(fechaFin)<0)
				{
					System.out.print(com.darSocio()+" Puntaje: ");
					System.out.println(com.mostrarPuntaje());
				}
				
			}
		}
	
	public Socio verificarSocio(int nro){
		int i = 0;
		while (i<socios.size()&& !socios.get(i).sosDni(nro))
			i++;
		if(i<socios.size())
			{
			return socios.get(i);}
		else
			{return null;}
		}
}
