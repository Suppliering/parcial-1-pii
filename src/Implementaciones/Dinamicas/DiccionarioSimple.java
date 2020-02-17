
package Implementaciones.Dinamicas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioSimpleTDA;
import Implementaciones.Estaticas.Conjunto;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	
	class nodo {
		int cl, v;
		nodo sig;
	}
	nodo inicio;

	@Override
	public void inicializarDiccionario() { // costo constante
		inicio = null;
	}

	@Override
	public void agregar(int c, int x) { // costo lineal
		
		nodo act = busquedaClave(c);
		if(act != null) {
			act.v = x;
		}
		else {
			nodo nuevo = new nodo();
			nuevo.cl = c;
			nuevo.v = x;
			nuevo.sig = inicio;
			inicio = nuevo;
		}
	}

	@Override
	public void eliminar(int c) { // costo lineal
		
		nodo ant = null, act = inicio;
		while(act != null && act.cl != c) {
			ant = act;
			act = act.sig;
		}
		
		if(act != null) {
			if(ant == null) { // es el primero (inicio)
				inicio = inicio.sig;
			}
			else {
				ant.sig = act.sig;
			}
		}
	}

	@Override
	public int recuperar(int c) { // precondicion, la clave existe. // costo lineal
		
		nodo act = busquedaClave(c);
		return act.v;
	}

	@Override
	public ConjuntoTDA claves() { // costo lineal
		nodo act = inicio; // actual pq si muevo el inicio avanzo la lista
		ConjuntoTDA r = new Conjunto();
		r.inicializarConjunto();
		
		while(act != null) {
			r.agregar(act.cl);
			act = act.sig;
		}
		return r;
	}
	
	private nodo busquedaClave(int c) { // costo lineal
		
		nodo act = inicio;
		while(act != null && act.cl != c) { // si act es nulo ya recorri y me quede sin referencia, ci act.cl == c, la encontre
			act = act.sig;
		}
		
		return act;
	}

}
