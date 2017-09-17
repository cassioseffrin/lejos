package br.edu.cassio.ultrasom;

import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 *
 * @author cassioseffrin
 */
public class Voltar extends Mover {

 
    public Voltar(int distance, DifferentialPilot pilot, UltrasonicSensor us) {
        super(distance, pilot, us);
    }

    /*
     * define o comportamento de controle
     */
    @Override
    public boolean takeControl() {
        return (ultrasonic.getDistance() - LIMITE_ERRO < distance)
                ? true
                : false;
    }

    /**
     * Move o robo pra tras enquanto condicao de controle for true.
     */
    @Override
    public void action() {
        pilot.backward();
    }

}
