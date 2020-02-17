package Implementaciones.Dinamicas;

import MiApi.ArbolABBTDA;

public class ArbolABB implements ArbolABBTDA {

	class NodoABB {
		int valor;
		ArbolABBTDA hijoIzq;
		ArbolABBTDA hijoDer;
	}
	NodoABB raiz;

	@Override
	public void inicializarArbol() {
		raiz = null;
	}

	@Override
	public int raiz() {
		// TODO Auto-generated method stub
		return raiz.valor;
	}

	@Override
	public ArbolABBTDA hijoIzq() {
		// TODO Auto-generated method stub
		return raiz.hijoIzq;
	}

	@Override
	public ArbolABBTDA hijoDer() {
		// TODO Auto-generated method stub
		return raiz.hijoDer;
	}

	@Override
	public boolean arbolVacio() {
		// TODO Auto-generated method stub
		return raiz == null;
	}

	@Override
	public void agregarElem(int x) {
		if(raiz == null) {
			raiz = new NodoABB() ;
			raiz.valor = x;
			raiz.hijoIzq = new ArbolABB();
			raiz.hijoIzq.inicializarArbol();
			raiz.hijoDer = new ArbolABB();
			raiz.hijoDer.inicializarArbol();
		}
		else if(raiz.valor > x)
			raiz.hijoIzq.agregarElem(x);
		else if(raiz.valor < x)
			raiz.hijoDer.agregarElem(x);
	}

	@Override
	public void eliminarElem(int x) {
		if(raiz != null) {
			if(raiz.valor == x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()) {
				raiz = null;
			}
			else if(raiz.valor == x && ! raiz.hijoIzq.arbolVacio()) {
				raiz.valor = mayor(raiz.hijoIzq);
				raiz.hijoIzq.eliminarElem(raiz.valor);
			}
			else if(raiz.valor == x && raiz.hijoIzq.arbolVacio())
			{
				raiz.valor = menor(raiz.hijoDer);
				raiz.hijoDer.eliminarElem(raiz.valor);
			}
			else if(raiz.valor < x){
				raiz.hijoDer.eliminarElem(x) ;
			}
			else {
				raiz.hijoIzq.eliminarElem(x) ;
			}
		}

	}

	private int mayor(ArbolABBTDA a) {
		if(a.hijoDer().arbolVacio())
			return a.raiz() ;
		else
			return mayor(a.hijoDer());
	}
	
	private int menor(ArbolABBTDA a) {
		if(a.hijoIzq().arbolVacio())
			return a.raiz() ;
		else
			return menor(a.hijoIzq());
	}
}
