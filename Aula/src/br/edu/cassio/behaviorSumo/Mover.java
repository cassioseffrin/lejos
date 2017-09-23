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
    protected int distancia;

    /**
     * Construtor
     *
     * @param distance a manter
     * @param pilot piloto
     * @param luz sensor luz
     * @param ultrasonic sensor distancia
     */
    public Mover(int distancia, DifferentialPilot piloto, LightSensor luz, UltrasonicSensor ultrasonic) {
        this.piloto = piloto;
        this.us = ultrasonic;
        this.distancia = distancia;
        this.luz=luz;
    }

    /**
     * parar
     */
    @Override
    public void suppress() {
        piloto.stop();
    }

}
