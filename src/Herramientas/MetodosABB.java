package Herramientas;

import MiApi.ArbolABBTDA;

public class MetodosABB {
	
	
	public static boolean existeRecur(ArbolABBTDA a, int x) {
		
		if(a.arbolVacio()) {
			return false;
		}
	    else if(a.raiz() == x) {
			return true;
		}
		else if (x > a.raiz()) {
			return existeRecur(a.hijoDer(), x);
		}
		else if(x < a.raiz()) {
			return existeRecur(a.hijoIzq(), x);
		}
		
		return false;
	}
	
	
	public static boolean existeIter(ArbolABBTDA a, int x) {
		
		boolean found = false;
		ArbolABBTDA aux = a;
		while(aux!= null && !aux.arbolVacio() && found == false) {
			if(aux.raiz() == x) {
				found = true;
			}
			else if(x < aux.raiz()) {
				aux = aux.hijoIzq();
			}
			else {
				aux = aux.hijoDer();
			}
		}
		
		return found;
	}
	
	public static boolean esHojaRecur(ArbolABBTDA a, int x) {
		
		boolean esHoja = false;
		if(!a.arbolVacio()) {
			
			if(a.raiz() == x && a.hijoDer().arbolVacio() && a.hijoIzq().arbolVacio()) {
				esHoja = true;
			}
			else if (x < a.raiz()) {
				return esHojaRecur(a.hijoIzq(), x);
			}
			else {
				return esHojaRecur(a.hijoDer(), x);
			}
			
		}
		
		return esHoja;
	}
	
	public static boolean esHojaIter(ArbolABBTDA a, int x) {
		
		ArbolABBTDA aux = a;
		boolean esHoja = false;
		while(!aux.arbolVacio() && !esHoja) {
			
			if(aux.raiz() == x && aux.hijoDer().arbolVacio() && aux.hijoIzq().arbolVacio()) {
				esHoja = true;
			}
			if(x < aux.raiz()) {
				aux = aux.hijoIzq();
			}
			else {
				aux = aux.hijoDer();
			}
		}
		
		return esHoja;
	}
}
