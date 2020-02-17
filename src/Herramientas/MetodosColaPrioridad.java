package Herramientas;

import Implementaciones.Estaticas.ColaPrioridad;
import MiApi.ColaPrioridadTDA;

public class MetodosColaPrioridad {

	public static void copiarCola(ColaPrioridadTDA orig, ColaPrioridadTDA dest) {
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarCola();
		
		while(!orig.colaVacia()) {
			int val = orig.primero();
			int prior = orig.prioridad();
			aux.acolarPrioridad(val, prior);
			orig.desacolar();
		}
		
		reacolar(aux, orig, dest);
	}

	public static void mostrarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarCola();
		while(!cola.colaVacia()) {
			int x = cola.primero();
			int prior = cola.prioridad();
			System.out.println("Valor: "+x+", Prioridad: "+prior);
			aux.acolarPrioridad(x, prior);
			cola.desacolar();
		}
		
		reacolar(aux, cola, null);
	}
	
	public static int sumarValores(ColaPrioridadTDA cola) {

		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarCola();
		
		int suma = 0;
		while(!cola.colaVacia()) {
			int x = cola.primero();
			int prior = cola.prioridad();
			aux.acolarPrioridad(x, prior);
			cola.desacolar();
			suma += x;
		}
		
		reacolar(aux, cola, null);
		
		return suma;
	}
	
	private static void reacolar(ColaPrioridadTDA orig, ColaPrioridadTDA dest, ColaPrioridadTDA opcional) {
		
		while(!orig.colaVacia()) {
			int x = orig.primero();
			int prior = orig.prioridad();
			dest.acolarPrioridad(x, prior);
			
			if(opcional != null)
				opcional.acolarPrioridad(x, prior);
			
			orig.desacolar();
		}
	}
}
