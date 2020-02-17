package Implementaciones.Dinamicas;

import MiApi.ColaPrioridadTDA;

public class ColaPrioridadV3 implements ColaPrioridadTDA {
	
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
		
		if(mayorPrioridad == null || prior > mayorPrioridad.prior) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}
		else {
			
			NodoPrioridad aux = mayorPrioridad;
			while(aux.sig != null && aux.sig.prior >= prior) {
				aux = aux.sig;
			}
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}	
	}

	@Override
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
	}

	@Override
	public int primero() {
		// TODO Auto-generated method stub
		return mayorPrioridad.valor;
	}

	@Override
	public int prioridad() {
		// TODO Auto-generated method stub
		return mayorPrioridad.prior;
	}

	@Override
	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return mayorPrioridad==null;
	}

}
