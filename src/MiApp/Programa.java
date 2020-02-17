package MiApp;

import Herramientas.Entradas;
import Herramientas.MetodosColaPrioridad;
import Implementaciones.Estaticas.ColaPrioridad;
import MiApi.ColaPrioridadTDA;
import MiApi.ConjuntoTDA;



public class Programa {

	public static void main(String[] args) {

		Entradas.obtenerEstacionesPorLinea();
		ConjuntoTDA claves = Entradas.lineaEstaciones.claves();
		
		ColaPrioridad nroEstacionesPorLinea = new ColaPrioridad();
		nroEstacionesPorLinea.inicializarCola();
		
		while(!claves.conjuntoVacio()) {
			
			int tam = 0;
			int cl = claves.elegir();
			ConjuntoTDA estaciones = Entradas.lineaEstaciones.recuperar(cl);
			while(!estaciones.conjuntoVacio()) {
				estaciones.sacar(estaciones.elegir());
				tam++;
			}
			
			String linea = Entradas.obtenerNombreLinea(cl);
			nroEstacionesPorLinea.acolarPrioridad(tam, cl);
			System.out.println("Linea " + linea + ": " + tam + " estaciones");
			claves.sacar(cl);
		}
		
		ColaPrioridadTDA colaPrioridad = new ColaPrioridad();
		colaPrioridad.inicializarCola();
		
		ConjuntoTDA estacionesTransferencias = Entradas.estacionesTransferencia.claves();
		
		System.out.println("Estacion - Linea - Cant. de posibilidades");
		while(!estacionesTransferencias.conjuntoVacio()) {
			
			int tam = 0;
			int cl = estacionesTransferencias.elegir();
			ConjuntoTDA lineasTransferencias = Entradas.estacionesTransferencia.recuperar(cl);
			while(!lineasTransferencias.conjuntoVacio()) {
				lineasTransferencias.sacar(lineasTransferencias.elegir());
				tam++;
			}
			
			colaPrioridad.acolarPrioridad(cl, tam);		

			estacionesTransferencias.sacar(cl);
		}
		
		ColaPrioridad aux = new ColaPrioridad();
		aux.inicializarCola();
		MetodosColaPrioridad.copiarCola(colaPrioridad, aux);
		
		while(!aux.colaVacia()) {
			
			int lineaDeEstacion = Entradas.obtenerLineaDeEstacion(aux.primero());
			String linea = Entradas.obtenerNombreLinea(lineaDeEstacion);
			String estacionTransferencia = Entradas.obtenerNombreEstacion(aux.primero());

			System.out.println(estacionTransferencia + " - " + linea + " - " + aux.prioridad());
			aux.desacolar();
		}
	}
}