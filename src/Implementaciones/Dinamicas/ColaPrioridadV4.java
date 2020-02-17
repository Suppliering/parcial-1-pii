package Implementaciones.Dinamicas;

import MiApi.ColaPrioridadTDA;

public class ColaPrioridadV4 implements ColaPrioridadTDA {
	
	
	class NodoPrioridad { 
		int val;
		int prior;
		NodoPrioridad sig;
	}
	NodoPrioridad mayorPrioridad;

	@Override
	public void inicializarCola() {
		// TODO Auto-generated method stub
		mayorPrioridad = null;
	}

	@Override
	public void acolarPrioridad(int valor, int prior) {
		
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.val = valor;
		nuevo.prior = prior;
		if(colaVacia() || prior > mayorPrioridad.prior) {
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
		// TODO Auto-generated method stub
		mayorPrioridad = mayorPrioridad.sig;
	}

	@Override
	public int primero() {
		// TODO Auto-generated method stub
		return mayorPrioridad.val;
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
