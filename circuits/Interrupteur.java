package circuits;

public class Interrupteur extends Composant
{
	private static final long serialVersionUID = 7526471055622776147L;
	protected Composant in;
	protected boolean etat;

	public void on()
	{
		etat = true;
	}

	public void off()
	{
		etat = false;
	}

	public boolean getEtat() throws NonConnecteException
	{
		return etat;
	}

	public void setIn(Composant cp)
	{
		in = cp;
	}
}
