import lejos.nxt.LightSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/**
 * Currently change direction to the left
 * 
 * @author BhuONE
 */
public class ChangeDirection implements Behavior
{
	private DifferentialPilot	pilot;
	private LightSensor			lightSensor;
	private UltrasonicSensor	ultrasonicSensor;

	private boolean				suppressed	= false;

	public ChangeDirection(final DifferentialPilot pilot,
			final LightSensor lightSensor)
	{
		this.pilot = pilot;
		this.lightSensor = lightSensor;
	}

//	public ChangeDirection(final DifferentialPilot pilot,
//			final LightSensor lightSensor,
//			final UltrasonicSensor ultrasonicSensor)
//	{
//		this.pilot = pilot;
//		this.lightSensor = lightSensor;
//		this.ultrasonicSensor = ultrasonicSensor;
//	}

	@Override
	public boolean takeControl()
	{
		return lightSensor.getLightValue() < 26;
	}

	@Override
	public void action()
	{
		suppressed = false;

		// steer left
		// pilot.steer(30, 20);
		pilot.rotate(25);

	}

	@Override
	public void suppress()
	{
		suppressed = true;
	}

}
