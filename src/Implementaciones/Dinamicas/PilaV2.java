package Implementaciones.Dinamicas;

import MiApi.PilaTDA;

public class PilaV2 implements PilaTDA {
	
	class Nodo { 
		int val;
		Nodo sig;
	}
	Nodo tope;

	@Override
	public void inicializarPila() {
		tope = null;
	}

	@Override
	public void apilar(int x) {
		
		Nodo nuevo = new Nodo();
		nuevo.val = x;
		nuevo.sig = null;
		
		nuevo.sig = tope;
		tope = nuevo;
	}

	@Override
	public void desapilar() {
		tope = tope.sig;
	}

	@Override
	public int tope() {
		return tope.val;
	}

	@Override
	public boolean pilaVacia() {
		return (tope == null);
	}

}
