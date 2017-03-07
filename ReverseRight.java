import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

/**
 * If bumps into wall, reverse and turn right
 * 
 * @author BhuONE
 */
public class ReverseRight implements Behavior
{
	private boolean				suppressed	= false;

	private TouchSensor			bumper;
	private DifferentialPilot	pilot;
//	private LightSensor			lightSensor;

	public ReverseRight(final DifferentialPilot pilot, final TouchSensor bumper)
	{
		this.bumper = bumper;
		this.pilot = pilot;
	}

//	public ReverseRight(final DifferentialPilot pilot,
//			final LightSensor lightSensor)
//	{
//		this.pilot = pilot;
//		this.lightSensor = lightSensor;
//	}

	@Override
	public boolean takeControl()
	{
		return bumper.isPressed();
	}

	@Override
	public void action()
	{
		suppressed = false;

		pilot.travel(-5);
		pilot.rotate(-90);
	}

	@Override
	public void suppress()
	{
		suppressed = true;
	}

}
