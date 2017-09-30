package br.edu.cassio.behaviorSumo;

import lejos.nxt.ColorSensor;
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
    protected DifferentialPilot pilot;

    protected UltrasonicSensor ultrasonic;
    
    protected ColorSensor luz;

    /**
     * Distancia mantria +/- limite erro
     */
    protected int distance;

    /**
     * Construtor
     *
     * @param distance a manter
     * @param pilot piloto
     * @param ultrasonic sensor distancia
     */
    public Mover(int distance, DifferentialPilot pilot, ColorSensor luz, UltrasonicSensor ultrasonic) {
        this.pilot = pilot;
        this.ultrasonic = ultrasonic;
        this.distance = distance;
        this.luz=luz;

    }

    /**
     * parar
     */
    public void suppress() {
        System.out.println("SUPPRESS");
        pilot.stop();
        Thread.yield();
    }

}
