package Implementaciones.Dinamicas;

import MiApi.ColaTDA;

public class Cola implements ColaTDA {
	
	class nodo {
		int d;
		nodo sig;
	}
	nodo inicio, fin;

	public void inicializarCola() {
		inicio=fin=null;
	}

	public void acolar(int x) {
		nodo nuevo = new nodo();
		nuevo.d = x;
		nuevo.sig = null;
		if(colaVacia()) {
			inicio = fin = nuevo;
		}
		else {
			fin.sig = nuevo;
			fin = nuevo;
		}
	}

	public void desacolar() {
		inicio = inicio.sig;
		if(inicio == null) {
			fin = null;
		}
	}

	public int primero() {
		return inicio.d; 
	}

	public boolean colaVacia() {
		return (inicio==null); //-- inicio==fin funcionaria solo si tiene 1 o ningun elemento
	}

}
