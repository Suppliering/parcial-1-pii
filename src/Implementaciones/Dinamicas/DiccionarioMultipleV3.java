package Implementaciones.Dinamicas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;

public class DiccionarioMultipleV3 implements DiccionarioMultipleTDA {
	
	class NodoClave {
		int cl;
		NodoValor valores;
		NodoClave sigClave;
	}
	
	class NodoValor {
		int valor;
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
		
		NodoClave aux = inicio;
		while(aux != null) {
			claves.agregar(aux.cl);
			aux = aux.sigClave;
		}
	
		return claves;
	}

	@Override
	public ConjuntoTDA recuperar(int c) {
		
		ConjuntoTDA valores = new Conjunto();
		valores.inicializarConjunto();
		
		NodoClave cl = getNodoClave(c);
		NodoValor v = cl.valores;
		while(v != null) {
			valores.agregar(v.valor);
			v = v.sigValor;
		}
		
		return valores;
	}
	
	private NodoClave getNodoClave(int c) {
		
		NodoClave aux = inicio;
		while(aux != null && aux.cl != c) {
			aux = aux.sigClave;
		}
		
		return aux;
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
		
		NodoValor aux = cl.valores;
		while(aux != null && aux.valor != x) {
			aux = aux.sigValor;
		}
		
		if(aux == null) { // solo si no existe ya en el cjto 
			NodoValor nv = new NodoValor();
			nv.valor = x;
			nv.sigValor = cl.valores;
			cl.valores = nv;
		}
	}

	@Override
	public void eliminar(int c) {
		
		if(inicio != null) {
			
			if(inicio.cl == c) {
				inicio = inicio.sigClave;
			}
			else {
				
				NodoClave aux = inicio;
				while(aux.sigClave != null && aux.sigClave.cl != c) {
					aux = aux.sigClave;
				}
				
				if(aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}	
			}
		}
	}

	@Override
	public void eliminarValor(int c, int x) {
		
		if(inicio != null) {
			
			if(inicio.cl == c) {
				eliminarValorDeNodo(inicio, x);
				
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
					eliminarValorDeNodo(aux.sigClave, x);
					
					if(aux.sigClave.valores == null) {
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
				
			}
			
		}
	}
	
	private void eliminarValorDeNodo(NodoClave nc, int x) {
		
		NodoValor nv = nc.valores;
		if(nv != null) {
			
			if(nv.valor == x) {
				nv = nv.sigValor;
			}
			else {
				
				while(nv.sigValor != null && nv.sigValor.valor != x) {
					nv = nv.sigValor;
				}
				
				if(nv.sigValor != null) {
					nv.sigValor = nv.sigValor.sigValor;
				}
			}
		}
	}
}