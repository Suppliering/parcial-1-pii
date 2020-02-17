package MiApi;

public interface DiccionarioSimpleTDA {
	
	public void inicializarDiccionario();
	
	public void agregar(int c, int x);
	
	public void eliminar(int c);
	public int recuperar(int c); // debe existir la clave
	
	public ConjuntoTDA claves();

}
