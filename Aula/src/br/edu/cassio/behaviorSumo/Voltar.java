package br.edu.cassio.behaviorSumo;

import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 *
 * @author cassioseffrin
 */
public class Voltar extends Mover {

 
    public Voltar(int distance, DifferentialPilot pilot, LightSensor luz,UltrasonicSensor us) {
        super(distance, pilot, luz, us);
    }

    /*
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {
        
        
      
        
       boolean retorno ;
       System.out.println("luz Voltar: "+luz.getLightValue());
        if (luz.getLightValue() < 40) {
            retorno = false;
       
        }else{
            retorno =  (ultrasonic.getDistance()  < 18);
        }
        return retorno;
        
    }

    /**
     * Move o robo pra tras enquanto condicao de controle for true.
     */
    @Override
    public void action() {
       
        pilot.backward();
    }

}
