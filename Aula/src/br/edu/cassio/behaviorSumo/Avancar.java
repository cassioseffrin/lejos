package br.edu.cassio.behaviorSumo;

import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author cassioseffrin
 */
public class Avancar extends Mover {

    public Avancar(int distance, DifferentialPilot pilot, LightSensor luz, UltrasonicSensor ultrasonic) {
        super(distance, pilot, luz, ultrasonic);
    }

    /**
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {
        boolean  retorno;
        System.out.println("luz Avancar:"+luz.getLightValue());
        if (luz.getLightValue() < 40) {
            retorno = false;
            
        }else{
           retorno = (us.getDistance()  > 12); 
        }
        return retorno;

    }

    /**
     * Move o robo pra frente enquanto condicao de controle for true.
     */
    @Override
    public void action() {
    
        piloto.forward();
    }
}
