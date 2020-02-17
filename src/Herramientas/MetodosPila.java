package Herramientas;

import Implementaciones.Estaticas.Pila;
import MiApi.PilaTDA;

public class MetodosPila {
	
	public static void copiarPila(PilaTDA orig, PilaTDA dest) {
		
		Pila aux = new Pila();
		aux.inicializarPila();
		
		reapilar(orig, aux, null);
		reapilar(aux, orig, dest);
	}

	public static void mostrarPila(PilaTDA pila) {
	
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		while(!pila.pilaVacia()) {
			
			int x = pila.tope();
			aux.apilar(x);
			System.out.println(x);
			pila.desapilar();
		}
		
		reapilar(aux, pila, null);
	}

	public static int sumaValores(PilaTDA pila) {
		
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		int suma = 0;
		while(!pila.pilaVacia()) {
			int x = pila.tope();
			suma += x;
			aux.apilar(pila.tope());
			pila.desapilar();
		}
		
		return suma;
	}
	
	private static void reapilar(PilaTDA orig, PilaTDA dest, PilaTDA opcional) {
		
		while(!orig.pilaVacia()) {
			int x = orig.tope();
			
			if(opcional != null)
				opcional.apilar(x);
			
			dest.apilar(x);
			orig.desapilar();
		}
	}
}
