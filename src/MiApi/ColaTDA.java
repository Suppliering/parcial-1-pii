package MiApi;

/**
 * (*) Deben estar inicializadas
 * (**) No deben estar vacias
 * @author alu602
 *
 */
public interface ColaTDA {
	
	void inicializarCola();
	void acolar(int x); //-- (*)
	void desacolar(); //-- (**)
	int primero(); //-- (**)
	boolean colaVacia(); //-- (*)
}
