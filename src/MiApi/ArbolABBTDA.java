 package MiApi;

public interface ArbolABBTDA {
	
	void inicializarArbol();
	int raiz(); //(*) y (**)
	ArbolABBTDA hijoIzq(); //(*) y (**)
	ArbolABBTDA hijoDer(); //(*) y (**) inicializado y no vacio
	boolean arbolVacio(); //(*)
	void agregarElem(int x); //(*)
	void eliminarElem(int x); //(*) inicializado
}
