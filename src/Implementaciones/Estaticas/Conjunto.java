package Implementaciones.Estaticas;

import MiApi.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	
	private int[] vector;
	private int tam;

	@Override
	public void inicializarConjunto() {
		vector = new int[100];
		tam = 0;
	}

	@Override
	public void agregar(int x) {
		
		//-- Si no pertenece lo agrego
		if(!pertenece(x)) {
			vector[tam] = x;
			tam++;
		}
	}

	@Override
	public void sacar(int x) { // es dos veces lineal
		
		//-- Si pertenece lo saco
		if(pertenece(x)) {
			int indice = recuperarIndice(x);
			if(vector[indice] == x) {
				vector[indice] = vector[tam-1];
				tam--;
			}	
		}
	}

	@Override
	public int elegir() {
		return vector[tam-1];
	}

	@Override
	public boolean conjuntoVacio() {
		return (tam==0);
	}

	@Override
	public boolean pertenece(int x) {
		
		int i = 0;
		boolean pertenece = false;
		while(i <= tam-1 && !pertenece) {
			pertenece = (vector[i] == x);
			i++;
		}
		
		return pertenece;
	}
	
	public int recuperarIndice(int valor) {
		
		int i = 0;
		while(i <= tam-1 && vector[i] != valor) {
			i++;
		}
				
		return (i > tam-1) ? -1 : i;
	}

}
