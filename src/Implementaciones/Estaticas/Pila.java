package Implementaciones.Estaticas;



import MiApi.PilaTDA;

public class Pila implements PilaTDA {
	
	private int tam;
	private int[] vector;

	@Override
	public void inicializarPila() {
		vector = new int[100];
		tam = 0;
	}

	@Override
	public void apilar(int x) {
		vector[tam] = x;
		tam++;
	}

	@Override
	public void desapilar() {
		tam--;
	}

	@Override
	public int tope() {
		return vector[tam-1];
	}

	@Override
	public boolean pilaVacia() {
		return (tam==0);
	}
}