import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class MoveForward implements Behavior
{
	private boolean				suppressed	= false;

	private DifferentialPilot	pilot;
	private LightSensor			lightSensor;
	private UltrasonicSensor	ultrasonicSensor;

	// /**
	// * Constructor to set the left and right motor position
	// */
	// public MoveForward(final DifferentialPilot pilot)
	// {
	// this.pilot = pilot;
	// }

	/**
	 * Constructor to set the left and right motor position
	 */
	public MoveForward(final DifferentialPilot pilot,
			final LightSensor lightSensor,
			final UltrasonicSensor ultrasonicSensor)
	{
		this.pilot = pilot;
		this.lightSensor = lightSensor;
		this.ultrasonicSensor = ultrasonicSensor;
	}

	@Override
	public boolean takeControl()
	{
		/*
		 * always true if we want to keep the bot moving when no obstacle are
		 * present atm - lowest priority
		 */
		return true;
	}

	@Override
	public void action()
	{
		suppressed = false;
		LCD.drawInt(lightSensor.getLightValue(), 8, 1);
		LCD.drawInt(ultrasonicSensor.getDistance(), 8, 2);

		// move forward
		pilot.forward();

		while (!suppressed)
		{
			Thread.yield();
		}

		pilot.stop();
	}

	@Override
	public void suppress()
	{
		suppressed = true;
	}

}
