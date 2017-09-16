package br.edu.cassio.sensorTato;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 *
 * @author Cassio Seffrin
 */
public class DesviaParede {

    /**
     * move o robo ateh achar a parede, quando o sensor toca-la, o robo vota um
     * pouco e gira 90 graus e segue em frente novamente
     *
     * @param args
     */
    public static void main(String[] args) {
        TouchSensor touch = new TouchSensor(SensorPort.S4);
        DifferentialPilot pilot = new DifferentialPilot(30f, 70f, Motor.A, Motor.C);

        while (true) {
            if (touch.isPressed()) {
                pilot.travel(-100);
                pilot.rotate(90);
            } else {
                Motor.A.forward();
                Motor.C.forward();
               // Thread.yield();
            }
        }
    }
}