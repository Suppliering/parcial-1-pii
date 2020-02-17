package MiApp;

import Herramientas.MetodosABB;
import Herramientas.MetodosCola;
import Herramientas.MetodosColaPrioridad;
import Herramientas.MetodosPila;
import Implementaciones.Dinamicas.ArbolABB;
import Implementaciones.Dinamicas.ColaPrioridadV4;
import Implementaciones.Dinamicas.ColaV2;
import Implementaciones.Dinamicas.ConjuntoV2;
import Implementaciones.Dinamicas.DiccionarioMultipleV3;
import Implementaciones.Dinamicas.DiccionarioSimpleV2;
import Implementaciones.Dinamicas.PilaV2;
import MiApi.ArbolABBTDA;
import MiApi.ColaPrioridadTDA;
import MiApi.ColaTDA;
import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;
import MiApi.DiccionarioSimpleTDA;
import MiApi.PilaTDA;

public class Pruebas {

	public static void main(String[] args) {	
	  //pruebaPila();
	  //pruebaCola();
	  //pruebaColaPrioridad();
	  //pruebaConjunto();
		//pruebaDS();
		//pruebaDM();
		pruebaABB();
	}
	
	private static void pruebaABB() {
		ArbolABBTDA a = new ArbolABB();
		a.inicializarArbol();
		
		a.agregarElem(1);

		
	
		boolean exists = MetodosABB.existeIter(a, 3);
		boolean esHoja = MetodosABB.esHojaIter(a, 1);
		System.out.println();
	}

	public static void pruebaDM() {
		
		DiccionarioMultipleTDA dict = new DiccionarioMultipleV3();
		dict.inicializarDiccionario();
		
		dict.agregar(1, 1);
		
		ConjuntoTDA claves = dict.claves();
		System.out.println(claves.conjuntoVacio());
		
		dict.eliminar(1);
		
		claves = dict.claves();
		System.out.println(claves.conjuntoVacio());
		
		dict.agregar(1, 1);
		dict.agregar(1, 2);
		
		ConjuntoTDA valores = dict.recuperar(1);
		System.out.println(valores.conjuntoVacio());
		
		System.out.println();
		
	}
	
	public static void pruebaDS() {
		
		DiccionarioSimpleTDA dict = new DiccionarioSimpleV2();
		dict.inicializarDiccionario();
		
		dict.agregar(1, 1);
		dict.agregar(2, 2);
		dict.agregar(3, 2);
		dict.agregar(4, 99);
		dict.agregar(5, 2);
		dict.agregar(6, 2);
		dict.eliminar(1);
		
		int valor = dict.recuperar(4);
		
		ConjuntoTDA claves = dict.claves();
		
		System.out.println();
		
		
	}
	
	public static void pruebaConjunto() {
		
		ConjuntoTDA conjunto = new ConjuntoV2();
		conjunto.inicializarConjunto();
		
		conjunto.agregar(2);
		conjunto.agregar(3);
		conjunto.sacar(2);
		int x = conjunto.elegir();

		System.out.println(conjunto.pertenece(2));
		System.out.println(conjunto.pertenece(x));
		System.out.println();
	}

	public static void pruebaColaPrioridad() {
		
		ColaPrioridadTDA cola = new ColaPrioridadV4();
		cola.inicializarCola();
		cola.acolarPrioridad(2, 1);
		cola.acolarPrioridad(1, 1);
		cola.acolarPrioridad(2, 3);
		
		ColaPrioridadTDA dest = new ColaPrioridadV4();
		dest.inicializarCola(); 
		
		MetodosColaPrioridad.copiarCola(cola, dest);
		MetodosColaPrioridad.mostrarCola(cola);
		MetodosColaPrioridad.mostrarCola(dest);
		
		
		System.out.println("");
	}

	public static void pruebaCola() {
		ColaTDA orig = new ColaV2();
		orig.inicializarCola();
		
		orig.acolar(1);
		orig.acolar(2);
		orig.acolar(3);
		
		while(!orig.colaVacia()) {
			System.out.println("Valor que sale: ".concat(String.valueOf(orig.primero())));
			orig.desacolar();
		}
		System.out.println("Cola vacia: " + orig.colaVacia());
		
		orig.acolar(1);
		orig.acolar(2);
		orig.acolar(3);
		
		ColaTDA dest = new ColaV2();
		dest.inicializarCola();
		
		MetodosCola.copiarCola(orig, dest);
		MetodosCola.mostrarCola(orig);
		MetodosCola.mostrarCola(dest);
		System.out.println("Suma Origen: ".concat(String.valueOf(MetodosCola.sumarValores(orig))));
		System.out.println("Suma Destino: ".concat(String.valueOf(MetodosCola.sumarValores(dest))));
		
		System.out.println("fin");
	}
	
	
	public static void pruebaPila() {
		
		PilaTDA orig = new PilaV2();
		orig.inicializarPila();
		
		orig.apilar(1);
		orig.apilar(2);
		orig.apilar(3);
		
		PilaTDA dest = new PilaV2();
		dest.inicializarPila();
		

		MetodosPila.copiarPila(orig, dest);
		MetodosPila.mostrarPila(orig);
		MetodosPila.mostrarPila(dest);
		System.out.println("Suma Origen: ".concat(String.valueOf(MetodosPila.sumaValores(orig))));
		System.out.println("Suma Destino: ".concat(String.valueOf(MetodosPila.sumaValores(dest))));
	}
}
