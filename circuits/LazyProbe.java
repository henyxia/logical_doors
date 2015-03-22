package circuits;

public class LazyProbe extends Sonde
{
	private static final long serialVersionUID = 7526471155422776147L;

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
