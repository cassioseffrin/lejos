package br.edu.cassio.SegueLinha;

import lejos.nxt.Motor;


/**
 * 
 * @author cassioseffrin
 */
public class NXBoot {
    
    public static void avanca(int ms) throws InterruptedException{
        
        Motor.A.forward();
        Motor.C.forward();
        Thread.sleep(ms);
    }
    
    
    public static void voltar(int ms) throws InterruptedException{
        
        Motor.A.backward();
        Motor.C.backward();
        Thread.sleep(ms);
    }
    public static void esquerda(int ms) throws InterruptedException{
        
        Motor.A.forward();
        Motor.C.stop();
        Thread.sleep(ms);
    }
    
    public static void direita(int ms) throws InterruptedException{
        
        Motor.A.stop();
        Motor.C.forward();
        Thread.sleep(ms);
    }
    
    public static void parar() throws InterruptedException{
        Motor.A.stop();
        Motor.C.stop();
    }
}
