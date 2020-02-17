package Implementaciones.Estaticas;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioSimpleTDA;

public class DiccionarioSimpleV2 implements DiccionarioSimpleTDA {
	
	class Elemento {
		int cl;
		int val;
	}
	
	Elemento[] elementos;
	int tam;

	@Override
	public void inicializarDiccionario() {
		elementos = new Elemento[100];
		tam = 0;
	}

	@Override
	public void agregar(int cl, int val) {
		
		//-- Si no existe lo agrego en la ultima posicion del vector
		int indiceClave = recuperarIndice(cl);
		if(indiceClave == -1) { // si no existe la clave en el diccionario...
			Elemento nuevo = new Elemento();
			nuevo.cl = cl;
			elementos[tam] = nuevo;
			tam++;
		}
		
		//-- Si existe o no, siempre piso el valor
		elementos[tam-1].val = val;
	}

	@Override
	public void eliminar(int cl) {
		
		int indiceClave = recuperarIndice(cl);
		if(indiceClave != -1) {
			elementos[indiceClave] = elementos[tam-1];
			tam--;
		}
	}

	@Override
	/**
	 * devuelve -1 si no se encuentra la clave
	 */
	public int recuperar(int cl) {
		int indiceClave = recuperarIndice(cl);
		
		return (indiceClave != -1) ? elementos[indiceClave].val : -1;
	}
	
	/**
	 * @poscondicion: devuelve -1 si no se encuentra la clave
	 * @param cl
	 * @return
	 */
	private int recuperarIndice(int cl) {

		int i = 0;
		while(i < tam && elementos[i].cl != cl) {
			i++;
		}
		
		return (i >= tam) ? -1 : i;
	}

	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA claves = new Conjunto();
		claves.inicializarConjunto();
		
		for(int i = 0; i < tam; i++) {
			claves.agregar(elementos[i].cl);
		}

		return claves;
	}

}
