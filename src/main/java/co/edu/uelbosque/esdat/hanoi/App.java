package co.edu.uelbosque.esdat.hanoi;

import java.util.Observable;
import java.util.Observer;

/**
 * Hello world!
 *
 */
public class App implements Observer
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App app=new App();
        Disco discos[] = new Disco[(int) Math.pow(2, 3)];
        AlgoritmoHanoi ah=new AlgoritmoHanoi(discos);
        ah.addObserver(app);
        discos=ah.algoritmoHanoi2(3, 1, 2, 3);
        
    }

	public void update(Observable o, Object arg) {
		Disco tmp=(Disco)arg;
		System.out.println("Moviendo de torre:"+tmp.getTorreOrigen()+
				" a torre: "+tmp.getTorreDestino()+
				" disco: "+tmp.getFicha());
	}
}
