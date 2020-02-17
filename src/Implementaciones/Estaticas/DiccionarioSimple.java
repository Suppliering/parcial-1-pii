package Implementaciones.Estaticas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	
	class Dato {
		int cl, d;
	}
	Dato[] vector;
	int tam;
	
	public void inicializarDiccionario() {
		vector = new Dato[100];
		tam = 0;
	}
	
	public ConjuntoTDA claves() {
		ConjuntoTDA r = new Conjunto();
		r.inicializarConjunto();
		for(int i = 0; i <tam; i++)
			r.agregar(vector[i].cl);
		return r;
	}
	
	public int recuperar(int c) {
		
		int indice = recuperarIndice(c);
		
		return (indice > tam-1) ? -1 : vector[indice].d;
	}
	
	private int recuperarIndice(int c) {

		int i = 0;
		while(i <= tam-1 && vector[i].cl != c) {
			i++;
		}
		
		return i;
	}

	public void eliminar(int c) { // igual a conjunto
		int i = 0;
		for(i=0; i<tam && vector[i].cl != c; i++);
		
		if(i<tam) { // lo encontro
			vector[i] = vector[tam-1];
			tam--;
			
		}
	}
	
	public void agregar(int c, int x) {
		int i;
		for(i=0; i < tam && vector[i].cl != c; i++);
		
		if(i == tam) { // no existe
			vector[i] = new Dato();
			vector[i].cl = c;
			tam++;
		}
		
		vector[i].d = x;
	}
}