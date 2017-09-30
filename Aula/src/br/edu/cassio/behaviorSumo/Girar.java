package br.edu.cassio.behaviorSumo;

import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 *
 * @author cassioseffrin
 */
public class Girar extends Mover {

 
    public Girar(int distance, DifferentialPilot pilot, ColorSensor luz,UltrasonicSensor us) {
        super(distance, pilot, luz, us);
    }

    /*
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {

       //  System.out.println("Di: "+ultrasonic.getDistance());
       boolean retorno=false ;
       retorno =  (ultrasonic.getDistance()  > 16);
     
        return retorno;
        
    }

    /**
     * Move o robo pra tras enquanto condicao de controle for true.
     */
    @Override
    public void action() {
        System.out.println("360");
        pilot.setTravelSpeed(720);
        pilot.rotate(30);
//        while(pilot.isMoving())
//            Thread.yield();
 
    }

}
