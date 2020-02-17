package Herramientas;

import Implementaciones.Estaticas.Cola;
import MiApi.ColaTDA;

public class MetodosCola {

	public static void copiarCola(ColaTDA orig, ColaTDA dest) {
		
		ColaTDA aux = new Cola();
		aux.inicializarCola();
		
		while(!orig.colaVacia()) {
			int x = orig.primero();
			aux.acolar(x);
			orig.desacolar();
		}
		
		reacolar(aux, orig, dest);
	}

	public static void mostrarCola(ColaTDA cola) {
		
		ColaTDA aux = new Cola();
		aux.inicializarCola();
		while(!cola.colaVacia()) {
			int x = cola.primero();
			System.out.println(x);
			aux.acolar(x);
			cola.desacolar();
		}
		
		reacolar(aux, cola, null);
	}
	
	public static int sumarValores(ColaTDA cola) {

		ColaTDA aux = new Cola();
		aux.inicializarCola();
		
		int suma = 0;
		while(!cola.colaVacia()) {
			int x = cola.primero();
			aux.acolar(x);
			cola.desacolar();
			suma += x;
		}
		
		reacolar(aux, cola, null);
		
		return suma;
	}
	
	private static void reacolar(ColaTDA orig, ColaTDA dest, ColaTDA opcional) {
		
		while(!orig.colaVacia()) {
			int x = orig.primero();
			dest.acolar(x);
			
			if(opcional != null)
				opcional.acolar(x);
			
			orig.desacolar();
		}
	}
}
