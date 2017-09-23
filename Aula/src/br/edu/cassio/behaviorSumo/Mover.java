package br.edu.cassio.behaviorSumo;

import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/*
 * @author cassioseffrin
 */
public abstract class Mover implements Behavior {

    /**
     * Compensar a sujeira do sensor de ultrasom.
     */
    public final static int LIMITE_ERRO = 3;

    /**
     * Piloto usado para mover o robo
     */
    protected DifferentialPilot piloto;

    protected UltrasonicSensor us;
    
    protected LightSensor luz;

    /**
     * Distancia mantria +/- limite erro
     */
    protected int distance;

    /**
     * Construtor
     *
     * @param distance a manter
     * @param pilot piloto
     * @param luz sensor luz
     * @param ultrasonic sensor distancia
     */
    public Mover(int distance, DifferentialPilot pilot, LightSensor luz, UltrasonicSensor ultrasonic) {
        this.piloto = pilot;
        this.us = ultrasonic;
        this.distance = distance;
        this.luz=luz;
    }

    /**
     * parar
     */
    public void suppress() {
        piloto.stop();
    }

}
