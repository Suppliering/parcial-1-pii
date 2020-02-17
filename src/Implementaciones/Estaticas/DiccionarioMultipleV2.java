package Implementaciones.Estaticas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;

public class DiccionarioMultipleV2 implements DiccionarioMultipleTDA {
	
	
	class Elementos {
		int cl;
		ConjuntoTDA valores;
	}
	
	Elementos[] elementos;
	int tam;

	@Override
	public void inicializarDiccionario() { 
		elementos = new Elementos[100];
		tam = 0;
	}

	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA claves = new Conjunto();
		claves.inicializarConjunto();
		
		int i = 0;
		while(i < tam) {
			claves.agregar(elementos[i].cl);
			i++;
		}
		
		return claves;
	}

	/**
	 * este metodo me va a devolver la posicion indice de la clave.. devuelve -1 si no existe
	 */
	private int posClave(int cl) {
		
		int i = 0;
		while(i < tam && elementos[i].cl != cl) {
			i++;
		}
		
		return (i >= tam) ? -1 : i;
	}

	/**
	 * devuelve cjto vacio si no existe
	 */
	@Override
	public ConjuntoTDA recuperar(int cl) {
		
		int posClave = posClave(cl);
		return elementos[posClave].valores;
	}

	/**
	 * agrega la clave y el valor si no existe la clave. si la clave ya existe, suma el valor al cjto
	 */
	@Override
	public void agregar(int cl, int val) {
		
		int indiceClave = posClave(cl);
		if(indiceClave != -1) { // si existe la clave, agrego el valor respetando el cjto...
			elementos[indiceClave].valores.agregar(val);
		}
		else { // si no existe la clave, tengo que agregar primero la clave, y luego el valor a la misma 
			//respetando el cjto
			
			ConjuntoTDA valores = new Conjunto();
			valores.inicializarConjunto();
			valores.agregar(val);
			
			Elementos nuevo = new Elementos();
			nuevo.cl = cl;
			nuevo.valores = valores;
			
			elementos[tam] = nuevo;
			tam++;
		}
	}
	
	/**
	 * si no existe la clase no pasa nada
	 */
	@Override
	public void eliminar(int cl) {
		
		int indiceClave = posClave(cl);
		if(indiceClave != -1) { // la encontre...
			elementos[indiceClave] = elementos[tam-1];
			tam--;
		}
	}

	/*
	 * si la clave no tiene mas valores, es decir es cjto vacio, debe eliminarse la clave
	 * puede utilizarse el metodo eliminar(c)
	 * (non-Javadoc)
	 * @see MiApi.DiccionarioMultipleTDA#eliminarValor(int, int)
	 */
	@Override
	public void eliminarValor(int cl, int val) {
		
		int indiceClave = posClave(cl);
		if(indiceClave != -1) {
			
			elementos[indiceClave].valores.sacar(val);
			
			if(elementos[indiceClave].valores.conjuntoVacio()) {
				eliminar(cl);
			}
		}	
	}
}
