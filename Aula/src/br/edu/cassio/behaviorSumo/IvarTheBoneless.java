package br.edu.cassio.behaviorSumo;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LightSensor;
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

    public static void main(String[] args) {
        DifferentialPilot piloto = new DifferentialPilot(ConstantesRobo.DIAMETRO_RODA,
                ConstantesRobo.LARGURA_ENTRE_RODAS, ConstantesRobo.motorDireito,
                ConstantesRobo.motorEsquerdo, true);
        UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S1);
        LightSensor luz = new LightSensor(SensorPort.S2);
        int distancia = 15;

        piloto.setTravelSpeed(400);
        //para fechar
        Button.ENTER.addButtonListener(new ButtonListener() {
            public void buttonPressed(Button button) {
                System.exit(0);
            }

            public void buttonReleased(Button button) {
            }
        });

        // cria os comportamentos e adiciona ao array
        Mover avanca = new Avancar(distancia, piloto, luz, ultrasonic);
        Mover volta = new Voltar(distancia, piloto, luz, ultrasonic);
        Mover para = new Parar(distancia, piloto, luz, ultrasonic);
        Behavior[] moves = {avanca, volta, para};

        // inicia o arbitro com array de comporatamento 
        // ciclos de comportamento 
        Arbitrator arb = new Arbitrator(moves);
        arb.start();
    }
}
