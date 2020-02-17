package Implementaciones.Dinamicas;

import MiApi.ConjuntoTDA;

public class ConjuntoV2 implements ConjuntoTDA {
	
	class Nodo {
		int val;
		Nodo sig;
	}
	Nodo c;

	@Override
	public void inicializarConjunto() {
		c = null;
	}

	@Override
	public void agregar(int x) {
		
		if(!pertenece(x)) {
			Nodo aux = new Nodo();
			aux.val = x;
			
			aux.sig = c;
			c = aux;
		}
	}

	@Override
	public void sacar(int x) {

		if(!conjuntoVacio()) {
			
			if(c.val == x) {
				c = c.sig;
			}
			else {
				Nodo aux = c;
				while(aux.sig != null && aux.sig.val != x) {
					aux = aux.sig;
				}
				
				if(aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
			}
		}
	}

	@Override
	public int elegir() {
		// TODO Auto-generated method stub
		return c.val;
	}

	@Override
	public boolean conjuntoVacio() {
		// TODO Auto-generated method stub
		return c==null;
	}

	@Override
	public boolean pertenece(int x) {
		
		Nodo aux = c;
		while(aux != null && aux.val != x) {
			aux = aux.sig;
		}
		
		return (aux != null);
	}

}
