package Implementaciones.Estaticas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
	
	class Dato {
		int cl;
		int valores[];
		int tval; // tamanio val
	}
	
	Dato[] vector;
	int qClaves;

	public void inicializarDiccionario() {
		vector = new Dato[100];
		qClaves = 0;
	}
	
	public ConjuntoTDA claves() {
		
		ConjuntoTDA r = new Conjunto();
		r.inicializarConjunto();
		for(int i = 0; i < qClaves; i++) {
			r.agregar(vector[i].cl);
		}
		return r;
	}
	
	public int posClave(int c) {
		
		int pos = 0;
		while(pos < qClaves && vector[pos].cl != c) {
			pos++;
		}
		return pos;
	}
	
	public ConjuntoTDA recuperar(int c) {

		int pos = posClave(c);
		ConjuntoTDA r = new Conjunto();
		r.inicializarConjunto();
		
		if(pos < qClaves) {
			int i = 0;
			while(i < vector[pos].tval) {
				r.agregar(vector[pos].valores[i]);
				i++;
			}
		}
		
		return r;
	}
	
	public void agregar(int c, int x) {
		
		int pos = posClave(c);
		if(pos==qClaves) { // no existe
			vector[pos] = new Dato();
			qClaves++;
			vector[pos].cl = c;
			
			vector[pos].valores = new int[100];
			vector[pos].valores[0] = x;
			vector[pos].tval = 1;
		}
		else {
			
			int i = 0;
			while(i < vector[pos].tval 
					&& vector[pos].valores[i] != x) { 
				i++;
			}
			
			if(i == vector[pos].tval) { // no lo encontre
				vector[pos].valores[i] = x;
				vector[pos].tval++;
			}
		}
	}
	
	public void eliminar(int c) {
		
		int pos = posClave(c);
		if(pos < qClaves) {
			vector[pos] = vector[qClaves-1];
			qClaves--;
		}
	}
	
	public void eliminarValor(int c, int x) {
		
		int pos = posClave(c);
		if(pos < qClaves) { // encontre clave
			
			int i = 0;
			while(i < vector[pos].tval 
					&& vector[pos].valores[i] != x) {
				i++;
			}
			
			if(i < vector[pos].tval) {
				vector[pos].valores[i] = vector[pos].valores[vector[pos].tval-1];
				vector[pos].tval--;
				if(vector[pos].tval == 0) {
					eliminar(c); //  si el conjunto de valores esta vacio elimino la clave
					// para que exista la clave tiene que haber al menos un valor
				}
			}
		}
	}
}
