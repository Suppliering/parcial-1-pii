package MiApi;

/**
 * (*) Deben estar inicializadas
 * (**) No deben estar vacias
 * @author alu602
 *
 */
public interface PilaTDA {	
	
	void inicializarPila();
	
	void apilar(int x); // (*)
	void desapilar(); // (**)
	
	int tope(); // (**)
	boolean pilaVacia(); // (*)
}
