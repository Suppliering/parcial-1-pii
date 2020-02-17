package Implementaciones.Dinamicas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;

public class DiccionarioMultipleV2 implements DiccionarioMultipleTDA {
	
	class NodoClave {
		int cl;
		NodoValor valores;
		NodoClave sigClave;
	}
	
	class NodoValor {
		int val;
		NodoValor sigValor;
	}
	NodoClave inicio;
	
	@Override
	public void inicializarDiccionario() {
		inicio = null;
	}

	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA claves = new Conjunto();
		claves.inicializarConjunto();
		
		NodoClave nc = inicio;
		while(nc != null) {
			claves.agregar(nc.cl);
			nc = nc.sigClave;
		}
		
		return claves;
	}

	private NodoClave getNodoClave(int c) {
		
		NodoClave aux = inicio;
		while(aux != null && aux.cl != c) {
			aux = aux.sigClave;
		}
		
		return aux;
	}
	
	@Override
	public ConjuntoTDA recuperar(int c) {
		
		ConjuntoTDA valores = new Conjunto();
		valores.inicializarConjunto();
		
		NodoClave aux = getNodoClave(c);
		if(aux != null) {
			
			NodoValor nV = aux.valores;
			while(nV != null) {
				valores.agregar(nV.val);
				nV = nV.sigValor;
			}
		}
		
		return valores;
	}

	@Override
	public void agregar(int c, int x) {

		//-- obtengo la clave primero, si no existe la creo.
		NodoClave nc = getNodoClave(c);
		if(nc == null) {
			nc = new NodoClave();
			nc.cl = c;
			nc.sigClave = inicio;
			inicio = nc;
		}
		
		//-- recorro los valores de la clave
		NodoValor nv = nc.valores;
		while(nv != null && nv.val != x) {
			nv = nc.valores.sigValor;
		}
		
		//-- solo si no existe, ya que es un conjunto, lo agrego.
		if(nv == null) {
			
			NodoValor nuevoValor = new NodoValor();
			nuevoValor.val = x;
			nuevoValor.sigValor = nc.valores;
			nc.valores = nuevoValor;	
		}	
	}

	@Override
	public void eliminar(int c) {
		
		if(inicio != null) {

			if(inicio.cl == c) {
				inicio = inicio.sigClave;
			}
			else {
				
				NodoClave cl = inicio;
				while(cl.sigClave != null && cl.sigClave.cl != c) {
					cl = inicio.sigClave;
				}
				
				if(cl.sigClave != null) {
					cl.sigClave = cl.sigClave.sigClave;
				}
			}
		}
	}

	@Override
	public void eliminarValor(int c, int x) {
		
		if(inicio != null) {
			if(inicio.cl == c) {
				eliminarValorEnNodo(inicio, x);
				if(inicio.valores == null) {
					inicio = inicio.sigClave;
				}
					
			}
			else {
				NodoClave aux = inicio;
				while(aux.sigClave != null && aux.sigClave.cl != c) {
					aux = aux.sigClave;
				}	
				
				if(aux.sigClave != null) {
					eliminarValorEnNodo(aux.sigClave, x);
					if(aux.sigClave.valores == null) {
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}
	}
	
	private void eliminarValorEnNodo(NodoClave nC, int v) {
		
		if(nC.valores != null) {
			
			if(nC.valores.val == v) {
				nC.valores = nC.valores.sigValor;
			}
			else {
				
				NodoValor nV = nC.valores;
				while(nV.sigValor != null && nV.sigValor.val != v) {
					nV = nV.sigValor;
				}
				
				if(nV.sigValor != null) {
					nV.sigValor = nV.sigValor.sigValor;
				}
			}
			
		}
	}
}
