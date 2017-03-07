import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class LegoRunner
{
	public void move()
	{
		TouchSensor bump = new TouchSensor(SensorPort.S2);
		UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
		LightSensor lightSensor = new LightSensor(SensorPort.S4);
		DifferentialPilot pilot = new DifferentialPilot(5.6, 11, Motor.C,
				Motor.B);
		
		LCD.drawString(ultrasonicSensor.getUnits(), 8, 7);
		
		//behavors
		Behavior moveForward = new MoveForward(pilot, lightSensor,
				ultrasonicSensor);
		Behavior changeDirection = new ChangeDirection(pilot, lightSensor);
		Behavior reverseRight = new ReverseRight(pilot, bump);
		Behavior[] behaviorzz = { moveForward, changeDirection, reverseRight };

		Arbitrator arbitrator = new Arbitrator(behaviorzz);
		arbitrator.start();

		// while (true)
		// {
		// LCD.drawInt(lightSensor.getLightValue(), 8, 1);
		// LCD.drawInt(lightSensor.getHigh(), 8, 2);
		// LCD.drawInt(lightSensor.getLow(), 8, 3);
		//
		// pilot.forward();
		//
		// int lightValue = lightSensor.getLightValue();
		// if(lightValue < 30 )
		// {
		// pilot.steer(30, 20);
		// }
		// else if(lightValue >= 30 )
		// {
		// pilot.steer(-20, -20);
		// }
		//
		// if (bump.isPressed())
		// {
		// pilot.travel(-5);
		// pilot.rotate(-90);
		// }
		// }
	}

	public static void main(String[] args)
	{
		LegoRunner runner = new LegoRunner();
		runner.move();
	}

}
