package co.edu.uelbosque.esdat.hanoi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.Timer;

public class AnimacionMovimiento extends Timer implements ActionListener {

	public AnimacionMovimiento(int delay, ActionListener listener) {
		super(delay, listener);       
	}

	private int paso;
    Disco discoActual;
    private int numeroDisco;
    private Disco[] discos;
    private boolean movimientoCompletado;
    
    private static final int VELOCIDAD = 1;
    private static final int LIMITE_TORRES = 3;
    private static final int LIMITE_FICHAS = 8;
    private int nroFichas;
    Timer timer;

	private Stack<Disco> pila1;
	private Stack<Disco> pila2;
	private Stack<Disco> pila3;
    
    public void setAnimacionMovimiento(Disco discoActual,int nroFichas) {
    	
    	this.setDelay(1);
    	this.addActionListener(this);
    	this.nroFichas=nroFichas;
    	this.discoActual=discoActual;
    	
    	inicializarComponentesDeAnimacion();
    	
	}
    
     
	private void inicializarComponentesDeAnimacion() {
	        
	        setPila1(new Stack<Disco>());
	        setPila2(new Stack<Disco>());
	        setPila3(new Stack<Disco>());
	       
	        numeroDisco = 1;
	        discos = new Disco[(int) Math.pow(2, nroFichas)];
	        for (int i = 1; i <= nroFichas; i++) {
	            int w = nroFichas - i + 1;
	            discoActual.setPosicionX(posicionXFicha(i, 1));
	            discoActual.setPosicionY(posicionYFicha(w));
	        }

	        movimientoCompletado = false;
	        paso = 1;
	    }
	 
	public void actionPerformed(ActionEvent e) {
        switch (paso) {
            case 1: // mover hacia arriba
                if (y > 30) { // 30 es el maximo a elevar la ficha
                    y--;
                    posiciones[ficha].setY(y);
                } else {
                    if (discoActual.getTorreOrigen() < discoActual.getTorreDestino()) {
                        paso = 2; // mover a la derecha
                    } else {
                        paso = 3; // mover a la izquierda
                    }
                }
                break;
            case 2: // mover hacia derecha
                if (x < posicionXFicha(ficha, discoActual.getTorreDestino())) { // recorre hasta la torre destino
                    x++;
                    posiciones[ficha].setX(x);
                } else {
                    paso = 4;
                }
                break;
            case 3: // mover hacia izquierda
                if (x > posicionXFicha(ficha, discoActual.getTorreDestino())) { // recorre hasta la torre destino
                    x--;
                    posiciones[ficha].setX(x);
                } else {
                    paso = 4;
                }
                break;
            case 4: // mover hacia abajo
                int nivel = pila[discoActual.getTorreDestino()] + 1;
                if (y < posicionYFicha(nivel)) {
                    y++;
                    posiciones[ficha].setY(y);
                } else {
                    movimientoCompletado = true;
                    this.stop();
                }
                break;
        }
        if (movimientoCompletado) {
            paso = 1;
            topes[discoActual.getTorreDestino()]++;
            topes[discoActual.getTorreOrigen()]--;
            if (discoActual.getFicha() == (int) Math.pow(2, nroFichas)) {                
              //  nucleo.resolucionCompletada();
            } else {
                //movimientoCompletado = false;
                ficha = discoActual.getFicha();
                x = posiciones[ficha].getX();
                y = posiciones[ficha].getY();
            }
        }
        
    }
	
	public void pausarAnimacion() {
       
    }

    public static int posicionXFicha(int ficha, int torre) {
        int k = (torre - 1) * 200;
        switch (ficha) {
            case 1:
                return 110 + k;
            case 2:
                return 100 + k;
            case 3:
                return 90 + k;
            case 4:
                return 80 + k;
            case 5:
                return 70 + k;
            case 6:
                return 60 + k;
            case 7:
                return 50 + k;
            case 8:
                return 40 + k;
        }
        return 0;
    }

    public static int posicionYFicha(int nivel) {
        switch (nivel) {
            case 1:
                return 260;
            case 2:
                return 233;
            case 3:
                return 206;
            case 4:
                return 179;
            case 5:
                return 152;
            case 6:
                return 125;
            case 7:
                return 98;
            case 8:
                return 71;
        }
        return 0;
    }

	public Stack<Disco> getPila3() {
		return pila3;
	}

	public void setPila3(Stack<Disco> pila3) {
		this.pila3 = pila3;
	}

	public Stack<Disco> getPila2() {
		return pila2;
	}

	public void setPila2(Stack<Disco> pila2) {
		this.pila2 = pila2;
	}

	public Stack<Disco> getPila1() {
		return pila1;
	}

	public void setPila1(Stack<Disco> pila1) {
		this.pila1 = pila1;
	}
}
