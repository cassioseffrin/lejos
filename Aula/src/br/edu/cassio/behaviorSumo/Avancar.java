package br.edu.cassio.behaviorSumo;
 
import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author cassioseffrin
 */
public class Avancar extends Mover {

    public Avancar(int distance, DifferentialPilot pilot, ColorSensor luz, UltrasonicSensor ultrasonic) {
        super(distance, pilot, luz, ultrasonic);
    }

    /**
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {
        boolean  retorno;
        retorno = (ultrasonic.getDistance()  <= 15); 
        return retorno ;

    }

    /**
     * Move o robo pra frente enquanto condicao de controle for true.
     */
    @Override
    public void action() {
    System.out.println("AVANCAR");
        pilot.setTravelSpeed(200);
        pilot.forward();
//        while (pilot.isMoving())
//            Thread.yield();
  
    }
}
