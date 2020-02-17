package Implementaciones.Dinamicas;

import MiApi.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	class nodo {
		int d;
		int prior;
		nodo sig;
	}
	nodo inicio;

	@Override
	public void inicializarCola() {
		inicio = null;
	}

	@Override
	public void acolarPrioridad(int valor, int prior) {
		nodo nuevo = new nodo();
		nuevo.d = valor;
		nuevo.prior = prior;
		
		//-- insertar en orden
		nodo actual = null;
		nodo ant = null;
		
		if(actual==inicio || inicio.prior < nuevo.prior) {
			nuevo.sig = inicio;
			inicio = nuevo;
			actual = nuevo;
		}
		else { // recorro...
			while(actual != null && actual.prior >= nuevo.prior) {
				ant = actual;
				actual = actual.sig;
			}
			
			nuevo.sig = actual;
			ant.sig = nuevo;
		}
	}

	@Override
	public void desacolar() {
		inicio = inicio.sig;
	}

	@Override
	public int primero() {
		return inicio.d;
	}

	@Override
	public int prioridad() {
		return inicio.prior;
	}

	@Override
	public boolean colaVacia() {
		return (inicio==null);
	}

}
