package br.edu.cassio.ultrasom;

import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
 

/**
 * Calcula a distancia e para
 * 
 
 * @author cassioseffrin
 */
public class CalculaDistancia extends Mover {

 
    public CalculaDistancia(int distance, DifferentialPilot pilot, UltrasonicSensor ultrasonic) {
        super(distance, pilot, ultrasonic);
    }

    /**
     * decide se o  behavior deve pegar o controle
     */
    @Override
    public boolean takeControl() {
        
        System.out.println("distancia: "+ultrasonic.getDistance());
        return ultrasonic.getDistance() < distance + LIMITE_ERRO && ultrasonic.
                getDistance() > distance - LIMITE_ERRO;

    }

     
    @Override
    public void action() {
        pilot.stop();
    }
}