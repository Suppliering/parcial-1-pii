package Implementaciones.Dinamicas;

import MiApi.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	
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
			Nodo nuevo = new Nodo();
			nuevo.val = x;
			
			nuevo.sig = c;
			c = nuevo;
		}
	}

	@Override
	public void sacar(int x) {
		if(c!= null) {
			if(c.val == x) { // si es el primer elemento de la lista
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
		
		//-- tengo que recorrer todos los nodos y chequear si alguno tiene valor = x
		// sino el aux va a ser null y eso es mi condicion de retorno booleana
		
		Nodo aux = c;
		
		while(aux != null && aux.val != x) {
			aux = aux.sig;
		}
		
		
		return aux != null;
	}
}
