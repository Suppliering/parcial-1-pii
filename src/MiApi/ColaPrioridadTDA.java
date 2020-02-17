package MiApi;

/**
 * (*) Deben estar inicializadas
 * (**) No deben estar vacias
 * @author alu602
 *
 */
public interface ColaPrioridadTDA {
	
	void inicializarCola();
	void acolarPrioridad(int valor, int prior); //-- (*)
	void desacolar(); //-- (**)
	int primero(); //-- (**)
	int prioridad(); //-- (**)
	boolean colaVacia(); //-- (*)
}
