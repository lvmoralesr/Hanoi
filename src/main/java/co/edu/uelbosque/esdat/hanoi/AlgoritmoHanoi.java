package co.edu.uelbosque.esdat.hanoi;

import java.util.Observable;

public class AlgoritmoHanoi extends Observable {

	private int nm;
    private Disco[] discos;
    private int posicionx;
    private int posiciony;
    
    public AlgoritmoHanoi(Disco[] movimientos) {
    	this.nm=0;
    	this.discos=movimientos;
	    
	}
    
	public Disco[] algoritmoHanoi(int n, int origen, int temporal, int destino) {
        if (n == 0) {
            return null;
        }
        algoritmoHanoi(n - 1, origen, destino, temporal);        
        nm++;
        discos[nm] = new Disco(n, origen, destino, posicionx, posiciony);
        algoritmoHanoi(n - 1, temporal, origen, destino);
        return discos;
    }
	
	public Disco[] algoritmoHanoi2(int n, int origen, int temporal, int destino) {
        if (n == 0) {
            return null;
        }
        algoritmoHanoi2(n - 1, origen, destino, temporal);
        this.setChanged();
        Disco movimientoTMP = new Disco(n, origen, destino, posicionx, posiciony);
        this.notifyObservers(movimientoTMP);
        algoritmoHanoi2(n - 1, temporal, origen, destino);
        return discos;
    }
	
}
