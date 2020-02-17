package Implementaciones.Estaticas;

import MiApi.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	class Info {
		int prior;
		int d;
	}
	
	Info[] vector;
	int tam;

	@Override
	public void inicializarCola() {
		vector = new Info[100];
		tam = 0;
	}

	@Override
	public void acolarPrioridad(int valor, int prior) {
		
		//-- si esta vacia inserto primer registro
		if(colaVacia() || prior > vector[tam-1].prior) {
			
			Info info = new Info();
			info.prior = prior;
			info.d = valor;
			
			vector[tam] = info;
			tam++;
			
			return;
		}
		
		int i = tam;
		while(i > 0 && vector[i-1].prior >= prior) {
			i--;
		}

		for(int j = tam; j > i; j--) {
			vector[j] = vector[j-1];
		}
		
		vector[i] = new Info();
		vector[i].prior = prior;
		vector[i].d = valor;
		tam++;
	}

	@Override
	public void desacolar() {
		tam--;
	}

	@Override
	public int primero() {
		return vector[tam-1].d;
	}

	@Override
	public int prioridad() {
		return vector[tam-1].prior;
	}

	@Override
	public boolean colaVacia() {
		return (tam==0);
	}

}
