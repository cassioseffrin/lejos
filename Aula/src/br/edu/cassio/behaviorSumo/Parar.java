package br.edu.cassio.behaviorSumo;

import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
 

/**
 * Calcula a distancia e para
 * 
 
 * @author cassioseffrin
 */
public class Parar extends Mover {

 
    public Parar(int distance, DifferentialPilot pilot, LightSensor luz,UltrasonicSensor ultrasonic) {
        super(distance, pilot, luz, ultrasonic);
    }

    /**
     * decide se o  behavior deve pegar o controle
     */
    @Override
    public boolean takeControl() {
        
        System.out.println("distancia: "+ultrasonic.getDistance());
        return (ultrasonic.getDistance() < 18 && ultrasonic.
                getDistance() > 12);

    }

     
    @Override
    public void action() {
        pilot.stop();
    }
}