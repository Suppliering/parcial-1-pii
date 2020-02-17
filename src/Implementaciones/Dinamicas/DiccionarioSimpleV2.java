package Implementaciones.Dinamicas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioSimpleTDA;

public class DiccionarioSimpleV2 implements DiccionarioSimpleTDA {
	
	class NodoClave {
		int cl;
		int val;
		NodoClave sigClave;
	}
	NodoClave inicio;

	@Override
	public void inicializarDiccionario() {
		inicio = null;
	}

	@Override
	public void agregar(int c, int x) {
		
		NodoClave cl = getNodoClave(c);
		if(cl == null) {
			cl = new NodoClave();
			cl.cl = c;
			cl.sigClave = inicio;
			inicio = cl;
		}
		cl.val = x;
	}

	@Override
	public void eliminar(int c) {

		if(inicio != null) {
		
			if(inicio.cl == c) {
				inicio = inicio.sigClave;
			}
			else {
				NodoClave aux = inicio;
				while(aux.sigClave != null & aux.sigClave.cl != c) {
					aux = aux.sigClave;
				}
				
				if(aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}

	@Override
	public int recuperar(int c) {
		
		NodoClave nc = getNodoClave(c);
		
		return nc.val;
	}
	
	private NodoClave getNodoClave(int cl) {
		
		NodoClave c = inicio;
		while(c != null && c.cl != cl) {
			c = c.sigClave;
		}
		
		return c;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA claves = new Conjunto();
		claves.inicializarConjunto();
		
		NodoClave c = inicio;
		while(c != null) {
			claves.agregar(c.cl);
			c = c.sigClave;
		}
		
		return claves;
	}

}
