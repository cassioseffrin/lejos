package br.edu.cassio.ultrasom;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import util.ConstantesRobo;


/**
 * 
 * @author cassioseffrin
 */
public class RoboDistancia {

 
    public static void main(String [] args) {
        DifferentialPilot pilot = new DifferentialPilot(ConstantesRobo.DIAMETRO_RODA,
                                     ConstantesRobo.LARGURA_ENTRE_RODAS, Motor.B,
                                     Motor.A, true);
        UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S1);
        int distance = 20;
       // pilot.setMoveSpeed(720);

        //para fechar
        Button.ENTER.addButtonListener(new ButtonListener() {
            public void buttonPressed(Button button) { System.exit(0); }
            public void buttonReleased(Button button) {}
        });

        // cria os comportamentos e adiciona ao array
        Mover forward = new Avancar(distance, pilot, ultrasonic);
        Mover backward = new Voltar(distance, pilot, ultrasonic);
        Mover still = new CalculaDistancia(distance, pilot, ultrasonic);
        Behavior[] moves = {forward, backward, still};

        // inicia o arbitrator com array de comporatamento 
        // ciclos de comportamento 
        Arbitrator arb = new Arbitrator(moves);
        arb.start();
    }
}