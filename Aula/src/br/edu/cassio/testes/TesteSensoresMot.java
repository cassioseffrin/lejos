package br.edu.cassio.testes;

 
import lejos.nxt.*;
 import lejos.robotics.navigation.LegacyPilot;
public class TesteSensoresMot {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("sula sabados");
                 
                //LightSensor luz =new LightSensor(SensorPort.S1);
               UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
                
                while(!Button.ESCAPE.isPressed()){
//                    if (luz.readValue()>40){
//                             gira45Direita();
//                    }
                    System.out.println("Distancia "+us.getDistance());
                    Thread.sleep(500);
                }
               
		Button.waitForPress();
	}
        
        
        public static void gira45Direita(){
                Motor.A.forward();
                Motor.C.backward();
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException ex) {
                   
                }
                Motor.C.stop();
                Motor.A.stop();
            
        }
        
}
