package MiApi;

/**
 * (*) Deben estar inicializadas
 * (**) No deben estar vacias
 * @author alu602
 *
 */
public interface ConjuntoTDA {
	
	void inicializarConjunto();
	void agregar(int x); //-- (*)
	void sacar(int x); //-- (*)
	int elegir(); //-- (**)
	boolean conjuntoVacio(); //-- (*)
	boolean pertenece(int x); //-- (*)
}
