package Herramientas;

import java.io.BufferedReader;
import java.io.FileReader;

import Implementaciones.Estaticas.DiccionarioMultiple;
import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;

public class Entradas {

	private static class InfoLineas {
		public int nroLinea;
		public String linea;
	}

	private static class InfoEstaciones {
		public int nroEstacion;
		public String estacion;
	}
	
	private static InfoLineas[] infoLineas = new InfoLineas[20];
	private static InfoEstaciones[] infoEstaciones = new InfoEstaciones[250];
	
	public static DiccionarioMultipleTDA lineaEstaciones = new DiccionarioMultiple();
	public static DiccionarioMultipleTDA estacionesTransferencia = new DiccionarioMultiple();

	public static void setearInfoLineas() {
		
		if(infoLineas[0] != null)
			return;

		int tam = 0;
		try {
			String reg;
			FileReader arch = new FileReader("C:\\Users\\SUPPLIER\\eclipse-workspace\\PII\\src\\Herramientas\\@datos.csv");
			BufferedReader buffer = new BufferedReader(arch);

			while((reg = buffer.readLine()) != null) {
				String [] campos = reg.split(";", 10);
				
				boolean process = true;
				if("".equals(campos[2])) {
					process = false;
				}

				if (process && buscarlinea(infoLineas, campos[0], tam) == tam) {
					infoLineas[tam] = new InfoLineas();
					infoLineas[tam].nroLinea = tam + 1;
					infoLineas[tam].linea = campos[0];
					tam++;
				}
			}
			arch.close();		      
		} catch(Exception e) {
			System.out.println("Excepcion leyendo archivo " + "@datos.csv" + ": " + e);
		}	
	}

	public static void setearInfoEstaciones() {
		
		if(infoEstaciones[0] != null)
			return;

		int tam = 0;
		try {
			String reg;
			FileReader arch = new FileReader("C:\\Users\\SUPPLIER\\eclipse-workspace\\PII\\src\\Herramientas\\@datos.csv");
			BufferedReader buffer = new BufferedReader(arch);

			while((reg = buffer.readLine()) != null) {
				String [] campos = reg.split(";", 10);
				boolean process = true;
				if("".equals(campos[2])) {
					process = false;
				}

				if (process && buscarEstacion(infoEstaciones, campos[3], tam) == tam) {
					infoEstaciones[tam] = new InfoEstaciones();
					infoEstaciones[tam].nroEstacion = tam + 1;
					infoEstaciones[tam].estacion = campos[3];
					tam++;
				}
			}
			arch.close();		      
		} catch(Exception e) {
			System.out.println("Excepcion leyendo archivo " + "@datos.csv" + ": " + e);
		}	
	}

	private static int buscarlinea(InfoLineas[] lineas, String buscado, int tam) {
		int i = 0;
		while (i < tam && lineas[i].linea.compareTo(buscado) != 0)
			i++;
		return i;
	}

	private static int buscarEstacion(InfoEstaciones[] estaciones, String buscado, int tam) {
		int i = 0;
		while (i < tam && estaciones[i].estacion.compareTo(buscado) != 0)
			i++;
		return i;
	}

	public static void obtenerEstacionesPorLinea() {
		
		setearInfoLineas();
		setearInfoEstaciones();
		
		estacionesTransferencia.inicializarDiccionario();
		lineaEstaciones.inicializarDiccionario();
		try {
			String register;
			FileReader arch = new FileReader("C:\\Users\\SUPPLIER\\eclipse-workspace\\PII\\src\\Herramientas\\@datos.csv");
			BufferedReader buffer = new BufferedReader(arch);

			while((register = buffer.readLine()) != null) {
				String [] campos = register.split(";", 10);
			
				//-- Si no es taller o deposito, esta habilitada, etc.
				if(!"".equals(campos[2])) {
					
					int linea = obtenerNumeroLinea(campos[0]);
					int estacion = obtenerNumeroEstacion(campos[3]);
					
					lineaEstaciones.agregar(linea, estacion);
				
					//-- Si es estacion de transferencia
					if(!"".equals(campos[4])) {
						int lineaTransferencia = obtenerNumeroLinea(campos[4]);
						estacionesTransferencia.agregar(estacion, lineaTransferencia);
					}
				}
			}
			arch.close();		      
		} catch(Exception e) {
			System.out.println("Excepcion leyendo archivo " + "@datos.csv" + ": " + e);
		}	
	}
	
	public static String obtenerNombreLinea(int nroLinea) {

		int i = 0;
		while(infoLineas[i] != null 
				&& infoLineas[i].nroLinea != nroLinea) {
			i++;
		}
		
		return infoLineas[i].linea;
	}
	
	public static String obtenerNombreEstacion(int nroEstacion) {

		int i = 0;
		while(infoEstaciones[i] != null 
				&& infoEstaciones[i].nroEstacion != nroEstacion) {
			i++;
		}
		
		return infoEstaciones[i].estacion;
	}

	public static int obtenerNumeroLinea(String linea) {

		int i = 0;
		while(infoLineas[i] != null 
				&& !infoLineas[i].linea.equals(linea)) {
			i++;
		}
		
		return infoLineas[i].nroLinea;
	}
	
	public static int obtenerNumeroEstacion(String estacion) {

		int i = 0;
		while(infoEstaciones[i] != null 
				&& !infoEstaciones[i].estacion.equals(estacion)) {
			i++;
		}
		
		return infoEstaciones[i].nroEstacion;
	}
	
	public static int obtenerLineaDeEstacion(int estacion) {
		
		int linea = -1;
		ConjuntoTDA claves = lineaEstaciones.claves();
		
		while(!claves.conjuntoVacio() 
				&& linea == -1) {
		
			int cl = claves.elegir();
			ConjuntoTDA estaciones = Entradas.lineaEstaciones.recuperar(cl);
			
			if(estaciones.pertenece(estacion)) {
				linea = cl;
			}
			
			claves.sacar(cl);
		}
		
		return linea;
	}
}