package Implementaciones.Dinamicas;

import MiApi.ColaPrioridadTDA;

public class ColaPrioridadV2 implements ColaPrioridadTDA {
	
	class NodoPrioridad {
		int valor;
		int prior;
		NodoPrioridad sig;
	}
	NodoPrioridad mayorPrioridad;

	@Override
	public void inicializarCola() {
		mayorPrioridad = null;
	}

	@Override
	public void acolarPrioridad(int valor, int prior) {
		
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.prior = prior;
		nuevo.valor = valor;
	
		//-- primera condicion: el que estoy insertando es el primero (mayorPrioridad = null), o es el de mayor prioridad
		//-- es decir, mayorPrioridad.prior < prior
		if(mayorPrioridad == null || mayorPrioridad.prior < prior) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}
		else { // ya sabemos que mayorPrioridad existe, iteramos y desplazamos los de menor prioridad a la derecha
			NodoPrioridad auxiliar = mayorPrioridad;
			while(auxiliar.sig != null && auxiliar.sig.prior >= nuevo.prior) {
				auxiliar = auxiliar.sig;
			}
			nuevo.sig = auxiliar.sig;
			auxiliar.sig = nuevo;
		}
	}

	@Override
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
	}

	@Override
	public int primero() {
		return mayorPrioridad.valor;
	}

	@Override
	public int prioridad() {
		return mayorPrioridad.prior;
	}

	@Override
	public boolean colaVacia() {
		return (mayorPrioridad == null);
	}

}
