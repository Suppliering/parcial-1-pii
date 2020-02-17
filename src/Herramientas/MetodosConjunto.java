package Herramientas;

import Implementaciones.Estaticas.Conjunto;
import MiApi.ConjuntoTDA;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class MetodosConjunto {
	
	/**
	 * @Tarea: cuenta la cantidad de valores en el conjunto sin destruirlo
	 * @Parametros: conjunto al cual contar la cantidad de valores
	 * @Devuelve: cantidad numerica de valores presentes en el conjunto
	 * @Precondicion: el conjunto debe estar inicializado
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static int contarValores(ConjuntoTDA conjunto) {
		
		int tam = 0;
		ConjuntoTDA aux = new Conjunto();
		aux.inicializarConjunto();
		copiarConjunto(conjunto, aux);
		
		while(!aux.conjuntoVacio()) {
			tam++;
			aux.sacar(aux.elegir());
		}
		
		return tam;
	}

	/**
	 * @Tarea: copia un conjunto origen en un destino sin destruirlo en el proceso
	 * @Parametros: conjunto irgen y conjunto destino
	 * @Devuelve: N/A
	 * @Precondicion: los conjuntos deben estar inicializados
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static void copiarConjunto(ConjuntoTDA orig, ConjuntoTDA dest) {
		
		ConjuntoTDA aux = new Conjunto();
		aux.inicializarConjunto();
		while(!orig.conjuntoVacio()) {
			int x = orig.elegir();
			aux.agregar(x);
			orig.sacar(x);
		}
		
		while(!aux.conjuntoVacio()) {
			int x = aux.elegir();
			
			orig.agregar(x);
			dest.agregar(x);
			aux.sacar(x);
		}
	}
}