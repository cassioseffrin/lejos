package br.edu.cassio.behaviorSumo;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
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
public class IvarTheBoneless {

 
    public static void main(String [] args) {
        DifferentialPilot piloto = new DifferentialPilot(ConstantesRobo.DIAMETRO_RODA,
                                     ConstantesRobo.LARGURA_ENTRE_RODAS, Motor.B,
                                     Motor.A, true);
        UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S3);
        ColorSensor luz = new ColorSensor(SensorPort.S2);
        int distance = 15;
       
piloto.setTravelSpeed(400);
        //para fechar
        Button.ENTER.addButtonListener(new ButtonListener() {
            public void buttonPressed(Button button) { System.exit(0); }
            public void buttonReleased(Button button) {}
        });

        // cria os comportamentos e adiciona ao array
        Mover avanca = new Avancar(distance, piloto, luz, ultrasonic);
        Mover girar = new Girar(distance, piloto, luz, ultrasonic);
        Mover volta = new Voltar(distance, piloto, luz, ultrasonic);
        Mover para = new Parar(distance, piloto, luz, ultrasonic);
        Behavior[] moves = {avanca, girar, para};//cia o arbitrator com array de comporatamento 
        // ciclos de comportamento 
        Arbitrator arb = new Arbitrator(moves);
        arb.start();
    }
}