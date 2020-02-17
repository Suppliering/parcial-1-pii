package Implementaciones.Dinamicas;

import MiApi.ColaTDA;

public class ColaV2 implements ColaTDA {
	
	class Nodo {
		int val;
		Nodo sig;
	}
	Nodo primero;
	Nodo ultimo;

	@Override
	public void inicializarCola() {
		primero = ultimo = null;
	}

	@Override
	public void acolar(int x) {
		
		//-- Genero nuevo nodo como siempre, como es cola, este no tiene nodo sig. ya que será el ultimo
		Nodo nuevo = new Nodo();
		nuevo.val = x;
		nuevo.sig = null;
		
		//-- si no está vacia, necesito que el anterior nodo que era el ultimo previamente, apunte a este como sig.
		if(!colaVacia()) {
			ultimo.sig = nuevo;
		}
		//-- ahora nuestro nodo nuevo es el ultimo
		ultimo = nuevo;
		
		//-- si es el primer nodo en agregarse, el primero es el ultimo
		if(primero == null) {
			primero = ultimo;
		}
		
	}

	@Override
	public void desacolar() {
		
		//-- si quiero desacolar, el previamente primero, ahora deberia de ser su siguiente
		primero = primero.sig; //-- si no hay siguiente este sera null
		
		//-- hay que actualizar, que si no hay siguiente, el ultimo tambien es null
		if(primero == null) {
			ultimo = null;
		}
	}

	@Override
	public int primero() {
		return primero.val;
	}

	@Override
	public boolean colaVacia() {
		return (ultimo == null);
	}
}