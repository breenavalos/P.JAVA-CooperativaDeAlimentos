

import java.util.Scanner;

public class Ejecutora {
	
	public static void main (String args[]){
		Cooperativa c = new Cooperativa("La Coperativa","Cabildo 134");
		Scanner entrada = new Scanner(System.in);
		byte opc = 0;
		do {
			System.out.println("\n\tMenu");
			System.out.println("\n1: Agregar Socio: ");
			System.out.println("2: Agregar Compra: ");
			System.out.println("3: Listar Socios: ");
			System.out.println("4: Mostrar puntaje de Socio:");
			System.out.println("5: Mostrar puntaje de Compras entre Fechas:");
			System.out.println("0: Salir");
			System.out.print("Ingrese opc:");
			opc = entrada.nextByte();
			System.out.println("");
			switch (opc) {
				case 1: {
					c.agregarSocio();
					}break;
				case 2: {
					c.agregarCompra();
					}break;
				case 3:{
					c.listarSocios();
					}break;
				case 4:{
					c.mostrarPje();
					}break;
				case 5:{
					c.mostrarPuntajeCompras() ;
					}break;
			}
		}while (opc !=0);
	}
	
}
