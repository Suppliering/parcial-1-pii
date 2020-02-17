package Implementaciones.Dinamicas;

import Implementaciones.Estaticas.Conjunto;
import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
	
	class NCl {
		int cl;
		NV iV;
		NCl sigC;
	}
	
	class NV {
		int v;
		NV sigV;
	}
	NCl inicioCl;

	@Override
	public void inicializarDiccionario() {
		inicioCl = null;
	}

	@Override
	public ConjuntoTDA claves() {
		
		NCl actC = inicioCl;
		ConjuntoTDA r = new Conjunto();
		r.inicializarConjunto();
		
		while(actC != null) {
			r.agregar(actC.cl);
			actC = actC.sigC;
		}
		
		return r;
	}
	
	private NCl buscarClave(int cl) {
		
		NCl actC = inicioCl;
		while(actC != null && actC.cl != cl) {
			actC = actC.sigC;
		}
	
		return actC;
	}

	@Override
	public ConjuntoTDA recuperar(int c) {
		NCl n =  buscarClave(c);
		
		ConjuntoTDA cjto = new Conjunto();
		cjto.inicializarConjunto();
		if(n != null) {
			NV aux = n.iV;
			while(aux != null) {
				cjto.agregar(aux.v);
				aux = aux.sigV;
			}
		}
		return cjto;
	}

	@Override
	public void agregar(int c, int x) {
		NCl actCl = buscarClave(c);
		
		if(actCl == null) {
			NCl nueCl = new NCl();
			nueCl.cl = c;
			nueCl.iV = null;
			nueCl.sigC = inicioCl;
			inicioCl = nueCl;
			actCl = inicioCl; // importante hay que entender que hace pero simplifica las cosas
		}
		
		NV actV = actCl.iV;
		while(actV != null && actV.v != x) {
			actV = actV.sigV;
		}
		
		if(actV == null) {
			NV nueV = new NV();
			nueV.v = x;
			nueV.sigV = actCl.iV;
			actCl.iV = nueV;
		}
	}

	@Override
	public void eliminar(int c) {
		NCl antC = null, actC = inicioCl;
		while(actC != null && actC.cl != c) {
			antC = actC;
			actC = actC.sigC;
		}
		
		if(actC != null) {
			if(antC == null) {
				inicioCl = inicioCl.sigC;
			}
			else {
				antC.sigC = actC.sigC;
			}
		}
	}

	@Override
	public void eliminarValor(int c, int x) {
		NCl actC = buscarClave(c);
		if(actC != null) {
			//recorro la lista para eliminar un valor de la clave
			NV antV = null, actV = actC.iV; // busco valor
			while(actV != null && actV.v != x) {
				antV = actV;
				actV = actV.sigV;
			}
			
			if(actV != null) {
				if(antV == null) {
					actC.iV = actC.iV.sigV;
				}
				else {
					antV.sigV = actV.sigV;
				}
				
				if(actC.iV==null) { // no hay mas valores
					eliminar(c);
				}
			}
			
		}
	}

}
