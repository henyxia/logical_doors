package circuits;

public class LazyProbe extends Sonde
{
	private boolean isSet = false;
	private boolean status = false;

	public LazyProbe(Composant c, String con)
	{
		super(c, con);
	}

	public void reset()
	{
		isSet = false;
	}

	public boolean getEtat()
	{
		if(!isSet)
		{
			isSet = true;
			status = super.getEtat();
		}
		return status;
	}
}
