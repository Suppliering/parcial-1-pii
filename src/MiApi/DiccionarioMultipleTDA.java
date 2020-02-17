package MiApi;

public interface DiccionarioMultipleTDA {
	
	public void inicializarDiccionario();
	
	public ConjuntoTDA claves();
	
	public ConjuntoTDA recuperar(int c);
	
	public void agregar(int c, int x);
	
	public void eliminar(int c);
	
	
	public void eliminarValor(int c, int x);
}
