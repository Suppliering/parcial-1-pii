package Implementaciones.Estaticas;

import MiApi.ColaTDA;

public class Cola implements ColaTDA {
	
	private int[] vector;
	private int tam;

	@Override
	public void inicializarCola() {
		vector = new int[100];
		tam = 0;
	}

	@Override
	public void acolar(int x) {
		vector[tam] = x;
		tam++;
	}

	@Override
	public void desacolar() {
		for(int i = 0; i < tam-1; i++) {
			vector[i] = vector[i+1];
		}
		tam--;
	}

	@Override
	public int primero() {
		return vector[0];
	}

	@Override
	public boolean colaVacia() {
		return (tam==0);
	}

}
