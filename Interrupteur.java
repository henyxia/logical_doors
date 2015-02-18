public class Interrupteur extends Composant
{
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
