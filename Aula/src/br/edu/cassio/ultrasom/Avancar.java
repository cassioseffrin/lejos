package br.edu.cassio.ultrasom;

import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author cassioseffrin
 */
public class Avancar extends Mover {

    public Avancar(int distance, DifferentialPilot pilot, UltrasonicSensor ultrasonic) {
        super(distance, pilot, ultrasonic);
    }

    /**
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {
        return (ultrasonic.getDistance() + LIMITE_ERRO > distance)
                ? true
                : false;
    }

    /**
     * Move o robo pra frente enquanto condicao de controle for true.
     */
    @Override
    public void action() {
        pilot.forward();
    }
}
