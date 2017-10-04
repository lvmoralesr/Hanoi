package co.edu.uelbosque.esdat.hanoi;

/**
 * Clase Movimiento
 * @author Daniel Alvarez
 */
public class Disco {

    private int numeroDisco;
    private int torreOrigen;
    private int torreDestino;
    private int posicionX;
    private int posicionY;

    public Disco(int numeroDisco, int torreOrigen, int torreDestino, int posicionX, int posicionY) {
        this.numeroDisco = numeroDisco;
        this.torreOrigen = torreOrigen;
        this.torreDestino = torreDestino;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
    }

    public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public int getNumeroDisco() {
		return numeroDisco;
	}

	public void setNumeroDisco(int numeroDisco) {
		this.numeroDisco = numeroDisco;
	}

	public int getTorreDestino() {
        return torreDestino;
    }

    public void setTorreDestino(int torreDestino) {
        this.torreDestino = torreDestino;
    }

    public int getTorreOrigen() {
        return torreOrigen;
    }

    public void setTorreOrigen(int torreOrigen) {
        this.torreOrigen = torreOrigen;
    }
}
